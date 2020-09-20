package com.zz.design.creational.factory

interface Engine {

}

interface Energy {

}

interface AbstractCarFactory {
    fun createEngine(): Engine
    fun createEnergy(): Energy
}

class GasEngine : Engine {

}

class ElectricEngine : Engine {

}

class GasEnergy : Energy {

}

class BatteryEnergy : Energy {

}

class GasCarFactory : AbstractCarFactory {
    override fun createEngine(): Engine {
        return GasEngine()
    }

    override fun createEnergy(): Energy {
        return GasEnergy()
    }

}

class ElectricCarFactory : AbstractCarFactory {
    override fun createEngine(): Engine {
        return ElectricEngine()
    }

    override fun createEnergy(): Energy {
        return BatteryEnergy()
    }

}

fun main() {
    val gasCarFactory = GasCarFactory()
    gasCarFactory.createEnergy()
    gasCarFactory.createEngine()

    val electricCarFactory = ElectricCarFactory()
    electricCarFactory.createEngine()
    electricCarFactory.createEnergy()
}