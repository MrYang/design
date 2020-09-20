package com.zz.design.structural.decorator

interface Subject {
    fun operate()
}

class RealSubject : Subject {
    override fun operate() {
        println("real subject")
    }

}

class SubjectDecorator(private val subject: Subject) : Subject {
    override fun operate() {
        println("before decorator")
        subject.operate()
        println("after decorator")
    }

}

fun main() {
    val subject = SubjectDecorator(RealSubject())
    subject.operate()
}