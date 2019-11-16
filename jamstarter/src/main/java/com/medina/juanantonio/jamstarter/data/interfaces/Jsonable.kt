package com.medina.juanantonio.jamstarter.data.interfaces

import com.google.gson.Gson

interface Jsonable {
    fun toJson(): String = Gson().toJson(this)
    fun fromJson(json: String): Jsonable = Gson().fromJson(json, this::class.java)
}