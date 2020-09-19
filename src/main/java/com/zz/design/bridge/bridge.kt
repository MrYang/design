package com.zz.design.bridge

interface DataCollector {
    fun collect()
}

interface Report {
    fun view()
}

abstract class AbstractReport(val dataCollector: DataCollector) : Report {

}

class DbCollector : DataCollector {
    override fun collect() {
        println("db collector")
    }
}

class RedisCollector : DataCollector {
    override fun collect() {
        println("redis collector")
    }
}

class ChartReport(dataCollector: DataCollector) : AbstractReport(dataCollector) {

    override fun view() {
        dataCollector.collect()
        println("chart report")
    }

}

class SheetReport(dataCollector: DataCollector) : AbstractReport(dataCollector) {

    override fun view() {
        dataCollector.collect()
        println("sheet report")
    }

}

fun main() {
    val report = ChartReport(DbCollector())
    report.view()

    val report2 = SheetReport(RedisCollector())
    report2.view()
}