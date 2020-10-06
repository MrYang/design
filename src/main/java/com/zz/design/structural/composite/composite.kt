package com.zz.design.structural.composite

abstract class File(val name: String) {
    abstract fun display()
}

class Folder(name: String) : File(name) {
    private val files = mutableListOf<File>()

    override fun display() {
        println("文件夹:${name}")
        files.forEach { f -> f.display() }
    }

    fun add(file: File): Folder {
        files.add(file)
        return this
    }

    fun remove(file: File): Folder {
        files.remove(file)
        return this
    }
}

class TextFile(name: String) : File(name) {
    override fun display() {
        println("text file:${name}")
    }
}

class ImageFile(name: String) : File(name) {
    override fun display() {
        println("image file:${name}")
    }
}

class ZipFile(name: String) : File(name) {
    override fun display() {
        println("zip file:${name}")
    }
}

fun main() {
    val folder = Folder("文件夹")
    folder.add(TextFile("a.txt"))
            .add(ImageFile("b.mp3"))
            .add(Folder("子文件夹")
                    .add(TextFile("c.txt"))
                    .add(ZipFile("d.zip")))

    folder.display()
}