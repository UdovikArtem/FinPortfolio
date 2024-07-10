package com.example.finportfolio.entity

open class Asset(
    open val id: Int,
    open val name: String,
    open val price: Double
)

class Cash(
    override val id: Int,
    override val name: String,
    override val price: Double,
    val currency: String
) : Asset(id, name, price)

data class Stock(
    override val id: Int,
    override val name: String,
    override val price: Double,
    val ticker: String
) : Asset(id, name, price)
