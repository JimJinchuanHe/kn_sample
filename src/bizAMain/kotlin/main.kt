@file:OptIn(kotlin.experimental.ExperimentalNativeApi::class, kotlinx.cinterop.ExperimentalForeignApi::class)

import bizB.addNumbers_kotlin

fun subtractNumbers(a: Int, b: Int): Int {
    return a - b
}

@CName("bizA_times_two")
fun timesTwo(x: Int): Int {
    return addNumbers_kotlin(x, x)
}