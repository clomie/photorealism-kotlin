package net.clomie.photorealism.chapter2

class Aggregate {
    var spheres: List<Sphere> = emptyList()

    fun add(sphere: Sphere) {
        spheres += sphere
    }

    fun intersect(ray: Ray) = spheres.mapNotNull { it.intersect(ray) }.minBy { it.t }
}