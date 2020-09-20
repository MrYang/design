package com.zz.design.behavioral.chain

interface Handler {

    fun support(): Boolean

    fun handleRequest(params: String)

    fun setNextHandler(handler: Handler)
}

abstract class AbstractHandler : Handler {
    private var handler: Handler? = null

    override fun handleRequest(params: String) {
        if (support()) {
            doHandleRequest(params)
        } else {
            getNextHandler()?.handleRequest(params)
        }
    }

    abstract fun doHandleRequest(params: String)

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

    override fun doHandleRequest(params: String) {
        println("$role handle request:$params")
    }
}

class Handler2(private val role: Int) : AbstractHandler() {

    override fun support(): Boolean {
        return role == 2
    }

    override fun doHandleRequest(params: String) {
        println("$role handle request:$params")
    }
}

class Handler3(private val role: Int) : AbstractHandler() {

    override fun support(): Boolean {
        return role == 3
    }

    override fun doHandleRequest(params: String) {
        println("$role handle request:$params")
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

    fun handleRequest(params: String) {
        handlers.forEach { h -> h.handleRequest(params) }
    }

    fun firstHandleRequest(params: String) {
        if (handlers.isNotEmpty()) {
            handlers.first().handleRequest(params)
        }
    }
}

fun main() {
    val chain = Chain()
            .addLast(Handler1(1))
            .addLast(Handler2(2))
            .addLast(Handler3(3))
    chain.handleRequest("处理参数")

    chain.firstHandleRequest("处理参数")
}