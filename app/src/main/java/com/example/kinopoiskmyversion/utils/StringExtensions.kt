package com.example.kinopoiskmyversion.utils

inline fun <reified T: Enum<T>> String.toEnum(): T? =
    enumValues<T>().firstOrNull {this.uppercase() == it.name}