package net.clomie.photorealism.chapter2

import kotlin.math.sqrt

class Sphere(val center: Vec3, val radius: Double) {

    fun intersect(ray: Ray): Hit? {
        val b = dot(ray.direction, ray.origin - center)
        val c = (ray.origin - center).length2() - radius * radius
        val d = b * b - c

        val t1 = -b - sqrt(d)
        val t2 = -b + sqrt(d)

        fun select(t1: Double, t2: Double): Double? = when {
            0 < t1 && t1 < 10000 -> t1
            0 < t2 && t2 < 10000 -> t2
            else -> null
        }

        val t = select(t1, t2) ?: return null
        val hitPos = ray(t)
        val hitNormal = normalize(hitPos - center)

        return Hit(t, hitPos, hitNormal, this)
    }
}
