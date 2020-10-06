package com.zz.design.behavioral.memento

data class Role(var blood: Int, var magic: Int) {
    fun display() {
        println("$blood, $magic")
    }

    fun saveMemento(): Memento {
        return Memento(blood, magic)
    }

    fun restoreMemento(memento: Memento) {
        this.blood = memento.blood
        this.magic = memento.magic
    }
}

data class Memento(val blood: Int, val magic: Int)

data class Caretaker(var memento: Memento)

fun main() {
    val role = Role(100, 100)
    role.display()

    val memento = role.saveMemento()
    val caretaker = Caretaker(memento)

    role.blood = 20
    role.magic = 20
    role.display()

    role.restoreMemento(caretaker.memento)
    role.display()
}