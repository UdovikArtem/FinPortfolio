package com.example.finportfolio.fragments.portfolio

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.finportfolio.R
import com.example.finportfolio.databinding.FragmentPortfolioBinding
import com.example.finportfolio.fragments.BaseFragment
import com.example.finportfolio.rv.PortfolioAdapter
import com.example.finportfolio.rv.swipecallback.SwipeDeleteCallback
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PortfolioFragment : BaseFragment<FragmentPortfolioBinding>() {

    private val viewModel by viewModels<PortfolioViewModel>()
    private var snackbar: Snackbar? = null

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentPortfolioBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = PortfolioAdapter()
        binding.portfolioRecycler.adapter = adapter
        viewModel.portfolioModel.observe(viewLifecycleOwner) { portfolioAssets ->
            adapter.submitList(portfolioAssets)
        }
        enableSwipeToDeleteAndUndo(adapter)

        viewModel.toastMessage.observe(viewLifecycleOwner) {
            if (it != null) {
                Toast.makeText(context, getString(it), Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun enableSwipeToDeleteAndUndo(adapter: PortfolioAdapter) {
        val swipeToDeleteCallback: SwipeDeleteCallback =
            object : SwipeDeleteCallback(this.context) {
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, i: Int) {
                    val position = viewHolder.adapterPosition
                    val item = adapter.currentList[position]

                    viewModel.deletePortfolioAsset(item)
                    adapter.removeItem(position)

                    snackbar = Snackbar
                        .make(
                            binding.root,
                            R.string.item_was_removed,
                            Snackbar.LENGTH_LONG
                        )
                    snackbar!!.setAction(R.string.undo) {
                        viewModel.restorePortfolioAsset()
                        adapter.restoreItem(item, position)
                        binding.portfolioRecycler.scrollToPosition(position)
                    }

                    snackbar!!.setActionTextColor(Color.RED)
                    snackbar!!.show()
                }
            }

        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(binding.portfolioRecycler)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.deletePortfolioAssetOnDestroy()
        snackbar?.dismiss()
    }
}
