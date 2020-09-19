package com.zz.design.observer

interface Observer {
    fun update(message: String)
}

class ConcreteObserver(private val name: String) : Observer {

    override fun update(message: String) {
        println("$name 接收到消息:$message")
    }

}

interface Subject {
    fun addObserver(observer: Observer)

    fun removeObserver(observer: Observer)

    fun notifyObservers(message: String)

    fun change(msg: String)
}

class ConcreteSubject : Subject {
    private var observers = mutableListOf<Observer>()

    override fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers(message: String) {
        observers.forEach { o -> o.update(message) }
    }

    override fun change(msg: String) {
        notifyObservers("观察者消息:$msg")
    }

}

fun main() {
    val observer1 = ConcreteObserver("observer1")
    val observer2 = ConcreteObserver("observer2")

    val subject = ConcreteSubject()
    subject.addObserver(observer1)
    subject.addObserver(observer2)

    subject.change("消息")
}