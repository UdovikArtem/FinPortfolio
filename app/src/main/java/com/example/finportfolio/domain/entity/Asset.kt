package com.example.finportfolio.domain.entity

open class Asset(
    open val id: Int,
    open val name: String
)

class Cash(
    override val id: Int,
    override val name: String,
    val currency: Currency
) : Asset(id, name)

data class Stock(
    override val id: Int,
    override val name: String,
    val ticker: String
) : Asset(id, name)
