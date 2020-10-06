package com.zz.design.behavioral.command

interface Command {
    fun execute()
}

class Receiver {
    fun action() {
        println("command received")
    }
}

class ConcreteCommand(private val receiver: Receiver) : Command {

    override fun execute() {
        receiver.action()
    }

}

class Invoker(private val command: Command) {

    fun action() {
        command.execute()
    }
}

fun main() {
    val receiver = Receiver()
    val command = ConcreteCommand(receiver)
    val invoker = Invoker(command)
    invoker.action()
}