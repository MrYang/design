package com.zz.design.factory

interface Product {
    fun use()
}

interface Factory {
    fun create(): Product
}

abstract class ProductFactory : Factory {

    fun getProduct(): Product {
        return create()
    }
}

class BreadProduct : Product {
    override fun use() {
        println("bread")
    }
}

class BreadProductFactory : ProductFactory() {
    override fun create(): Product {
        return BreadProduct()
    }
}

class MilkProduct : Product {
    override fun use() {
        println("milk")
    }
}

class MilkProductFactory : ProductFactory() {
    override fun create(): Product {
        return MilkProduct()
    }
}

fun main() {
    val bread = BreadProductFactory().getProduct()
    bread.use()

    val milk = MilkProductFactory().getProduct()
    milk.use()
}