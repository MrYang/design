package com.zz.design.creational.singleton

class SingletonInnerClass private constructor() {
    companion object {
        val instance = SingletonHandler.holder
    }

    private object SingletonHandler {
        var holder = SingletonInnerClass()
    }
}

fun main() {
}