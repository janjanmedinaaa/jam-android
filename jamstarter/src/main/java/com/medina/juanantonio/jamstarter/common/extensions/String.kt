package com.medina.juanantonio.jamstarter.common.extensions

import android.annotation.SuppressLint
import java.util.Locale

fun String.lowerCase() = toLowerCase(Locale.getDefault())

fun String.upperCase() = toUpperCase(Locale.getDefault())

@SuppressLint("DefaultLocale")
fun String.capitalCase() = capitalize()

fun String.kebabCase() = lowerCase().replace(" ", "-", true)

fun String.snakeCase() = lowerCase().replace(" ", "_", true)

fun String.pascalCase() = split(" ").joinToString("") { it.capitalCase() }

fun String.camelCase() =
    "${pascalCase().substring(0, 1).lowerCase()}${pascalCase().substring(1)}"
