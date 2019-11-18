package com.medina.juanantonio.jamstarterapp

import android.os.Bundle
import com.medina.juanantonio.jamstarter.activities.JAMActivity
import com.medina.juanantonio.jamstarter.common.feedback.toast

class MainActivity : JAMActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testObject = TestObject().apply {
            string = "TEST STRING"
            array = arrayListOf("NICE", "WOW", "AMAZING")
        }

        activityOwner = this
        testObject.toJson().save()
    }

    override fun onSharedPreferenceChanged(key: String?, value: String?) {
        super.onSharedPreferenceChanged(key, value)
        toast("$key changed!")
    }
}
