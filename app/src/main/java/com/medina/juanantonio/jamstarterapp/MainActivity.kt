package com.medina.juanantonio.jamstarterapp

import android.os.Bundle
import com.medina.juanantonio.jamstarter.activities.JAMActivity

class MainActivity : JAMActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testObject = TestObject().apply {
            string = "TEST STRING"
            array = arrayListOf("NICE", "WOW", "AMAZING")
        }

        activityOwner = this

        TestObject().fromJson(testObject.toJson())
    }
}
