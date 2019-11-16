package com.medina.juanantonio.jamstarter.activities

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.medina.juanantonio.jamstarter.common.getAppKey

open class JAMActivity : AppCompatActivity() {
    private lateinit var sharedPrefs: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    var transitioning: Boolean = false

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPrefs = getSharedPreferences(getAppKey(), 0)
        editor = sharedPrefs.edit()
    }

    override fun onResume() {
        super.onResume()
        transitioning = false
    }

    fun getString(key: String) = sharedPrefs.getString(key, "") ?: ""

    fun getFloat(key: String) = sharedPrefs.getFloat(key, 0f)

    fun getBoolean(key: String) = sharedPrefs.getBoolean(key, false)

    fun getLong(key: String) = sharedPrefs.getLong(key, 0)

    fun getInt(key: String) = sharedPrefs.getInt(key, 0)

    fun String.saveString(key: String) {
        editor.putString(key, this)
        editor.apply()
    }

    fun Float.saveFloat(key: String) {
        editor.putFloat(key, this)
        editor.apply()
    }

    fun Boolean.saveBoolean(key: String) {
        editor.putBoolean(key, this)
        editor.apply()
    }

    fun Long.saveLong(key: String) {
        editor.putLong(key, this)
        editor.apply()
    }

    fun Int.saveInt(key: String) {
        editor.putInt(key, this)
        editor.apply()
    }
}