package net.clomie.photorealism.chapter2

import kotlin.math.sqrt

class Vec3(val x: Double, val y: Double, val z: Double) {
    constructor(x: Int, y: Int, z: Int) : this(x.toDouble(), y.toDouble(), z.toDouble())
    constructor(x: Double) : this(x, x, x)
    constructor(x: Int) : this(x, x, x)
    constructor() : this(0)

    fun length() = sqrt(length2())
    fun length2() = x * x + y * y + z * z

    override fun toString(): String = "($x, $y, $z)"

    operator fun plus(other: Vec3) = Vec3(this.x + other.x, this.y + other.y, this.z + other.z)
    operator fun minus(other: Vec3) = Vec3(this.x - other.x, this.y - other.y, this.z - other.z)
    operator fun times(other: Vec3) = Vec3(this.x * other.x, this.y * other.y, this.z * other.z)
    operator fun div(other: Vec3) = Vec3(this.x / other.x, this.y / other.y, this.z / other.z)

    operator fun plus(other: Double) = Vec3(this.x + other, this.y + other, this.z + other)
    operator fun minus(other: Double) = Vec3(this.x - other, this.y - other, this.z - other)
    operator fun times(other: Double) = Vec3(this.x * other, this.y * other, this.z * other)
    operator fun div(other: Double) = Vec3(this.x / other, this.y / other, this.z / other)

    operator fun plus(other: Int) = this + other.toDouble()
    operator fun minus(other: Int) = this - other.toDouble()
    operator fun times(other: Int) = this * other.toDouble()
    operator fun div(other: Int) = this / other.toDouble()
}

operator fun Double.plus(other: Vec3) = other + this
operator fun Double.minus(other: Vec3) = Vec3(this - other.x, this - other.y, this - other.z)
operator fun Double.times(other: Vec3) = other * this
operator fun Double.div(other: Vec3) = Vec3(this / other.x, this / other.y, this / other.z)

operator fun Int.plus(other: Vec3) = other + this.toDouble()
operator fun Int.minus(other: Vec3) = other - this.toDouble()
operator fun Int.times(other: Vec3) = other * this.toDouble()
operator fun Int.div(other: Vec3) = other / this.toDouble()

fun dot(a: Vec3, b: Vec3) = a.x * b.x + a.y * b.y + a.z * b.z

fun cross(a: Vec3, b: Vec3) =
    Vec3(
        a.y * b.z - a.z * b.y,
        a.z * b.x - a.x * b.z,
        a.x * b.y - a.y * b.x
    )

fun normalize(v: Vec3) = v / v.length()