package net.clomie.photorealism.chapter2

fun <T : Comparable<T>> clamp(x: T, xMin: T, xMax: T): T {
    return when {
        x < xMin -> xMin
        x > xMax -> xMax
        else -> x
    }
}