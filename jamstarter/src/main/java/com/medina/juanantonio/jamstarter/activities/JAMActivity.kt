package com.medina.juanantonio.jamstarter.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.medina.juanantonio.jamstarter.common.Constants.Logs.SETUP_LOG
import com.medina.juanantonio.jamstarter.common.Constants.SharedPreferences.BOOLEAN_PREFS
import com.medina.juanantonio.jamstarter.common.Constants.SharedPreferences.FLOAT_PREFS
import com.medina.juanantonio.jamstarter.common.Constants.SharedPreferences.INT_PREFS
import com.medina.juanantonio.jamstarter.common.Constants.SharedPreferences.LONG_PREFS
import com.medina.juanantonio.jamstarter.common.Constants.SharedPreferences.STRING_PREFS
import com.medina.juanantonio.jamstarter.common.getAppKey

open class JAMActivity : AppCompatActivity() {
    private lateinit var sharedPrefs: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    var transitioning: Boolean = false
    var activityOwner: Context? = null

    var stringPrefs = STRING_PREFS
    var floatPrefs = FLOAT_PREFS
    var booleanPrefs = BOOLEAN_PREFS
    var longPrefs = LONG_PREFS
    var intPrefs = INT_PREFS

    @SuppressLint("CommitPrefEdits")
    override fun onResume() {
        super.onResume()
        transitioning = false

        activityOwner?.run {
            if (::sharedPrefs.isInitialized) return
            sharedPrefs = getSharedPreferences(getAppKey(), 0)
            editor = sharedPrefs.edit()
            Log.d(SETUP_LOG, "${getAppKey()} SharedPreferences created.")
        }
    }

    fun getString(key: String) = sharedPrefs.getString(key, "") ?: ""

    fun getFloat(key: String) = sharedPrefs.getFloat(key, 0f)

    fun getBoolean(key: String) = sharedPrefs.getBoolean(key, false)

    fun getLong(key: String) = sharedPrefs.getLong(key, 0)

    fun getInt(key: String) = sharedPrefs.getInt(key, 0)

    fun String.save(key: String? = null) {
        val sharedKey = key ?: stringPrefs
        editor.putString(sharedKey, this)
        editor.apply()
    }

    fun Float.save(key: String? = null) {
        val sharedKey = key ?: floatPrefs
        editor.putFloat(sharedKey, this)
        editor.apply()
    }

    fun Boolean.save(key: String? = null) {
        val sharedKey = key ?: booleanPrefs
        editor.putBoolean(sharedKey, this)
        editor.apply()
    }

    fun Long.save(key: String? = null) {
        val sharedKey = key ?: longPrefs
        editor.putLong(sharedKey, this)
        editor.apply()
    }

    fun Int.save(key: String? = null) {
        val sharedKey = key ?: intPrefs
        editor.putInt(sharedKey, this)
        editor.apply()
    }
}