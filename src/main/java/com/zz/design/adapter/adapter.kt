package com.zz.design.adapter

interface Target {

    fun charge()
}

class Adaptee {

    fun charge() {
        println("适配者的充电方法")
    }
}

class Adapter(private val adaptee: Adaptee) : Target {

    override fun charge() {
        adaptee.charge()
    }

}

fun main() {
    val target = Adapter(Adaptee())
    target.charge()
}