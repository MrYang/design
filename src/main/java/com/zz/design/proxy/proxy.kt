package com.zz.design.proxy

interface Subject {
    fun operate()
}

class RealSubject : Subject {
    override fun operate() {
        println("real subject")
    }

}

class ProxySubject : Subject {

    private val subject = RealSubject()

    override fun operate() {
        println("before proxy")
        subject.operate()
        println("after proxy")
    }

}

fun main() {
    val subject = ProxySubject()
    subject.operate()
}