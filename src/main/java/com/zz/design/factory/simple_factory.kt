package com.zz.design.factory

interface Shape {
    fun draw()
}

class Circle : Shape {
    override fun draw() {
        println("circle")
    }
}

class Square : Shape {
    override fun draw() {
        println("square")
    }
}

class Triangle : Shape {
    override fun draw() {
        println("triangle")
    }
}

class ShapeSimpleFactory {
    companion object {
        fun getShape(shapeType: String): Shape? {
            return when (shapeType) {
                "circle" -> {
                    Circle()
                }
                "square" -> {
                    Square()
                }
                "triangle" -> {
                    Triangle()
                }
                else -> null
            }
        }
    }
}

fun main() {
    val shape = ShapeSimpleFactory.getShape("circle")
    shape?.draw()
}