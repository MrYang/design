package com.zz.design.behavioral.visitor

abstract class Employee {
    abstract fun accept(department: Department)
}

data class ManagerEmployee(val name: String,
                           val timeSheet: Int,
                           val wage: Double,
                           val punishmentTime: Int) : Employee() {
    override fun accept(department: Department) {
        department.visit(this)
    }

}

data class GeneralEmployee(val name: String,
                           val timeSheet: Int,
                           val wage: Double,
                           val punishmentTime: Int) : Employee() {
    override fun accept(department: Department) {
        department.visit(this)
    }

}

abstract class Department {
    abstract fun visit(employee: ManagerEmployee)
    abstract fun visit(employee: GeneralEmployee)
}

class FADepartment : Department() {
    override fun visit(employee: ManagerEmployee) {
        println(employee)
    }

    override fun visit(employee: GeneralEmployee) {
        println(employee)
    }
}

class HRDepartment : Department() {
    override fun visit(employee: ManagerEmployee) {
        println(employee.timeSheet)
    }

    override fun visit(employee: GeneralEmployee) {
        println(employee.timeSheet)
    }
}

fun main() {
    val list = mutableListOf<Employee>()
    list.add(ManagerEmployee("name1", 8, 15000.0, 10))
    list.add(ManagerEmployee("name2", 8, 15000.0, 9))
    list.add(GeneralEmployee("name3", 8, 5000.0, 8))
    list.add(GeneralEmployee("name4", 8, 5000.0, 12))

    val faDepartment = FADepartment()
    list.forEach { e -> e.accept(faDepartment) }

    val hrDepartment = HRDepartment()
    list.forEach { e -> e.accept(hrDepartment) }
}