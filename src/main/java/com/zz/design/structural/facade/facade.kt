package com.zz.design.structural.facade

class SubSystemA {

    fun methodA() {
        println("method a")
    }
}

class SubSystemB {

    fun methodB() {
        println("method b")
    }
}

class SubSystemC {

    fun methodC() {
        println("method c")
    }
}

class Facade {
    private val a = SubSystemA()
    private val b = SubSystemB()
    private val c = SubSystemC()

    fun method() {
        a.methodA()
        b.methodB()
        c.methodC()
    }
}

fun main() {
    val facade = Facade()
    facade.method()
}