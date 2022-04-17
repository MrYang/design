package com.zz.design.creational.prototype

class Prototype {
    data class Product(var name: String) {}

    var prototype = Product("product")

    var product = prototype.copy()
}

fun main() {
    val product = Prototype().product
    println(product)
}