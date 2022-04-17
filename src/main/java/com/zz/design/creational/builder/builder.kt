package com.zz.design.creational.builder

class Computer private constructor(
    val cpu: String,
    val ram: String,
    val keyboard: String,
    val display: String
) {

    private constructor(builder: Builder) : this(
        builder.cpu,
        builder.ram,
        builder.keyboard,
        builder.display
    )

    class Builder {
        var cpu: String = ""
            private set
        var ram: String = ""
            private set
        var keyboard: String = ""
            private set
        var display: String = ""
            private set

        fun setCpu(inputCpu: String) = apply {
            this.cpu = inputCpu
        }

        fun setRam(inputRam: String) = apply {
            this.ram = inputRam
        }

        fun setKeyboard(inputKeyboard: String) = apply {
            this.keyboard = inputKeyboard
        }

        fun setDisplay(inputDisplay: String) = apply {
            this.display = inputDisplay
        }

        fun build() = Computer(this)
    }

    override fun toString(): String {
        return "Computer(cpu='$cpu', ram='$ram', keyboard='$keyboard', display='$display')"
    }
}

fun main() {
    val computer = Computer.Builder()
        .setCpu("因特尔")
        .setRam("金士顿")
        .build()
    println(computer)
}