package com.zz.design.behavioral.state

interface State {
    fun handle()
}

class State1 : State {
    override fun handle() {
        println("state 1")
    }

}

class State2 : State {
    override fun handle() {
        println("state 2")
    }

}

class State3 : State {
    override fun handle() {
        println("state 3")
    }

}

class Context {
    private lateinit var state: State

    fun setState(state: State) {
        println("update state")
        this.state = state
        this.state.handle()
    }

}

fun main() {
    val context = Context()
    context.setState(State1())
    context.setState(State2())
    context.setState(State3())
}