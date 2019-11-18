package com.medina.juanantonio.jamstarter.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.medina.juanantonio.jamstarter.R
import com.medina.juanantonio.jamstarter.common.Constants.Logs.SETUP_LOG
import com.medina.juanantonio.jamstarter.common.Constants.Logs.SHARED_PREFS_CHANGED
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

    override fun onResume() {
        super.onResume()
        transitioning = false
    }

    @SuppressLint("CommitPrefEdits")
    private fun checkForSharedPreference() {
        val jamContext = applicationContext

        if (::sharedPrefs.isInitialized && activityOwner == null) return
        sharedPrefs = getSharedPreferences(activityOwner?.getAppKey(), 0)
        editor = sharedPrefs.edit()

        sharedPrefs.registerOnSharedPreferenceChangeListener { _, key ->
            onSharedPreferenceChanged(key, getString(key))
        }

        Log.d(
            SETUP_LOG,
            jamContext.getString(
                R.string.shared_prefs_created,
                getAppKey()
            )
        )
    }

    fun getString(key: String? = null): String {
        checkForSharedPreference()
        return sharedPrefs.getString(key ?: stringPrefs, "") ?: ""
    }

    fun getFloat(key: String? = null): Float {
        checkForSharedPreference()
        return sharedPrefs.getFloat(key ?: floatPrefs, 0f)
    }

    fun getBoolean(key: String? = null): Boolean {
        checkForSharedPreference()
        return sharedPrefs.getBoolean(key ?: booleanPrefs, false)
    }

    fun getLong(key: String? = null): Long {
        checkForSharedPreference()
        return sharedPrefs.getLong(key ?: longPrefs, 0)
    }

    fun getInt(key: String? = null): Int {
        checkForSharedPreference()
        return sharedPrefs.getInt(key ?: intPrefs, 0)
    }

    fun String.save(key: String? = null) {
        checkForSharedPreference()
        val sharedKey = key ?: stringPrefs
        editor.putString(sharedKey, this)
        editor.apply()
    }

    fun Float.save(key: String? = null) {
        checkForSharedPreference()
        val sharedKey = key ?: floatPrefs
        editor.putFloat(sharedKey, this)
        editor.apply()
    }

    fun Boolean.save(key: String? = null) {
        checkForSharedPreference()
        val sharedKey = key ?: booleanPrefs
        editor.putBoolean(sharedKey, this)
        editor.apply()
    }

    fun Long.save(key: String? = null) {
        checkForSharedPreference()
        val sharedKey = key ?: longPrefs
        editor.putLong(sharedKey, this)
        editor.apply()
    }

    fun Int.save(key: String? = null) {
        checkForSharedPreference()
        val sharedKey = key ?: intPrefs
        editor.putInt(sharedKey, this)
        editor.apply()
    }

    open fun onSharedPreferenceChanged(key: String?, value: String?) {
        Log.d(SHARED_PREFS_CHANGED, "$key : $value")
    }
}