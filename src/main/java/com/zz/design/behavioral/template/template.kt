package com.zz.design.behavioral.template


abstract class Game {
    abstract fun init()

    abstract fun start()

    abstract fun end()

    fun play() {
        init()
        start()
        end()
    }
}

class Basketball : Game() {
    override fun init() {
        println("init basketball")
    }

    override fun start() {
        println("start basketball")
    }

    override fun end() {
        println("end basketball")
    }

}

class Football : Game() {
    override fun init() {
        println("init football")
    }

    override fun start() {
        println("start football")
    }

    override fun end() {
        println("end football")
    }

}

fun main() {
    var game: Game = Basketball()
    game.play()

    game = Football()
    game.play()
}