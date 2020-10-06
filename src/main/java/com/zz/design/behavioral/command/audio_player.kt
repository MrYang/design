package com.zz.design.behavioral.command

class AudioPlayer {
    fun play() {
        println("play")
    }

    fun stop() {
        println("stop")
    }

    fun rewind() {
        println("rewind")
    }
}

interface PlayerCommand {
    fun execute()
}

interface MacroCommand : PlayerCommand {
    fun add(command: PlayerCommand)
    fun remove(command: PlayerCommand)
}

class PlayCommand(private val player: AudioPlayer) : PlayerCommand {
    override fun execute() {
        player.play()
    }

}

class StopCommand(private val player: AudioPlayer) : PlayerCommand {
    override fun execute() {
        player.stop()
    }

}

class RewindCommand(private val player: AudioPlayer) : PlayerCommand {
    override fun execute() {
        player.rewind()
    }
}

class MacroAudioCommand : MacroCommand {
    private val commands = mutableListOf<PlayerCommand>()

    override fun add(command: PlayerCommand) {
        commands.add(command)
    }

    override fun remove(command: PlayerCommand) {
        commands.remove(command)
    }

    override fun execute() {
        commands.forEach { c -> c.execute() }
    }

}

class Keypad(private val play: PlayerCommand,
             private val stop: PlayerCommand,
             private val rewind: PlayerCommand) {
    fun play() {
        play.execute()
    }

    fun stop() {
        stop.execute()
    }

    fun rewind() {
        rewind.execute()
    }
}

fun main() {
    val player = AudioPlayer()
    val playCommand: PlayerCommand = PlayCommand(player)
    val stopCommand: PlayerCommand = StopCommand(player)
    val rewindCommand: PlayerCommand = RewindCommand(player)
    val keypad = Keypad(playCommand, stopCommand, rewindCommand)

    val microCommand = MacroAudioCommand()
    microCommand.add(playCommand)
    microCommand.add(rewindCommand)
    microCommand.add(stopCommand)
    microCommand.execute()

    keypad.play()
    keypad.rewind()
    keypad.stop()
}

