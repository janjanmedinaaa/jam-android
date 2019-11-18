package com.medina.juanantonio.jamstarter.common.feedback

import android.content.Context
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.LENGTH_SHORT

fun Context.showToast(string: String, long: Boolean = false) {
    Toast.makeText(
        this,
        string,
        if (long) LENGTH_LONG else LENGTH_SHORT
    ).show()
}