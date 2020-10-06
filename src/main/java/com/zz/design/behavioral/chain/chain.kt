package com.zz.design.behavioral.chain

interface Handler {

    fun support(): Boolean

    fun handleRequest(params: String)

    fun setNextHandler(handler: Handler)
}

abstract class AbstractHandler : Handler {
    private var handler: Handler? = null

    override fun handleRequest(params: String) {
        getNextHandler()?.handleRequest(params)
    }

    private fun getNextHandler(): Handler? {
        return handler
    }

    override fun setNextHandler(handler: Handler) {
        this.handler = handler
    }
}


class Handler1(private val role: Int) : AbstractHandler() {

    override fun support(): Boolean {
        return role == 1
    }

    override fun handleRequest(params: String) {
        if (support()) {
            println("$role handle request:$params")
        } else {
            super.handleRequest(params)
        }
    }
}

class Handler2(private val role: Int) : AbstractHandler() {

    override fun support(): Boolean {
        return role == 2
    }

    override fun handleRequest(params: String) {
        if (support()) {
            println("$role handle request:$params")
        } else {
            super.handleRequest(params)
        }
    }
}

class Handler3(private val role: Int) : AbstractHandler() {

    override fun support(): Boolean {
        return role == 3
    }

    override fun handleRequest(params: String) {
        if (support()) {
            println("$role handle request:$params")
        } else {
            super.handleRequest(params)
        }
    }
}

class Chain {
    private val handlers = mutableListOf<Handler>()

    fun addLast(handler: Handler): Chain {
        if (handlers.isNotEmpty()) {
            handlers.last().setNextHandler(handler)
        }
        handlers.add(handler)
        return this
    }

    fun firstHandleRequest(params: String) {
        if (handlers.isNotEmpty()) {
            handlers.first().handleRequest(params)
        }
    }
}

fun main() {
    val role = 1
    val chain = Chain()
            .addLast(Handler1(role))
            .addLast(Handler2(role))
            .addLast(Handler3(role))
    chain.firstHandleRequest("处理参数")
}