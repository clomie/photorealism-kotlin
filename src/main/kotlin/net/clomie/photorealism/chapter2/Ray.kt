package net.clomie.photorealism.chapter2

class Ray(val origin: Vec3, val direction: Vec3) {
    operator fun invoke(t: Double): Vec3 = origin + t * direction
    operator fun invoke(t: Int): Vec3 = this(t.toDouble())

    override fun toString(): String = "origin: $origin, direction: $direction"
}