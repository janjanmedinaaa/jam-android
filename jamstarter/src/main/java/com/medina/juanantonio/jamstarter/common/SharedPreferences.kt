package com.medina.juanantonio.jamstarter.common

import android.content.Context
import com.medina.juanantonio.jamstarter.common.extensions.upperCase

fun Context.getAppKey(): String {
    return packageName
        .replace(".", "_", false)
        .upperCase()
}