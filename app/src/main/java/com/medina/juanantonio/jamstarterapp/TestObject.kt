package com.medina.juanantonio.jamstarterapp

import com.medina.juanantonio.jamstarter.data.interfaces.Jsonable

class TestObject : Jsonable {
    var string: String = ""
    var array: ArrayList<String>? = null

    override fun fromJson(json: String): TestObject {
        return super.fromJson(json) as TestObject
    }
}