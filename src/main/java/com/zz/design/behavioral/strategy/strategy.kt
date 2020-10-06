package com.zz.design.behavioral.strategy

interface Strategy {
    fun operation(num1: Int, num2: Int): Int
}

class Add : Strategy {
    override fun operation(num1: Int, num2: Int): Int {
        return num1 + num2
    }

}

class Subtract : Strategy {
    override fun operation(num1: Int, num2: Int): Int {
        return num1 - num2
    }

}

class Multiply : Strategy {
    override fun operation(num1: Int, num2: Int): Int {
        return num1 * num2
    }

}

class Context(private val strategy: Strategy) {

    fun execute(num1: Int, num2: Int): Int {
        return strategy.operation(num1, num2)
    }
}

fun main() {
    val num1 = 10
    val num2 = 5

    var context = Context(Add())
    println(context.execute(num1, num2))

    context = Context(Subtract())
    println(context.execute(num1, num2))

    context = Context(Multiply())
    println(context.execute(num1, num2))
}
