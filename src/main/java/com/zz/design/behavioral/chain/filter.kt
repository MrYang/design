package com.zz.design.behavioral.chain

data class Request(var data: String)

interface Filter {
    fun doFilter(request: Request)
}

class TrimFilter : Filter {
    override fun doFilter(request: Request) {
        request.data = request.data.trim()
    }
}

class RemoveNumberFilter : Filter {
    override fun doFilter(request: Request) {
        val sb = StringBuilder()
        for (ch in request.data) {
            if (!Character.isDigit(ch)) {
                sb.append(ch)
            }
        }
        request.data = sb.toString()
    }
}

class FilterChain {
    private val filters = mutableListOf<Filter>()

    fun addFilter(filter: Filter): FilterChain {
        filters.add(filter)
        return this
    }

    fun doFilter(request: Request) {
        filters.forEach { f -> f.doFilter(request) }
    }

}

fun main() {
    val request = Request(" 239abde967 ")
    val chain = FilterChain()
    chain.addFilter(TrimFilter())
            .addFilter(RemoveNumberFilter())
            .doFilter(request)
    println(request)
}