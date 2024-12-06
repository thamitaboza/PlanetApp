
package com.example.planetapp.models

import com.example.planetapp.R

data class Planet(
    val id: Int,
    val name: String,
    val type: String,
    val galaxy: String,
    val distanceFromSun: String,
    val diameter: String,
    val characteristics: String,
    val imageRes: Int,
    var isFavorite: Boolean = false
)


private const val GALAXY_MILKY_WAY = "Milky Way"
private const val TYPE_TERRESTRIAL = "Terrestrial"
private const val TYPE_GAS_GIANT = "Gas Giant"
private const val TYPE_ICE_GIANT = "Ice Giant"


val planetList = listOf(
    createPlanet(
        id = 1,
        name = "Earth",
        type = TYPE_TERRESTRIAL,
        distanceFromSun = "149.6 million km",
        diameter = "12,742 km",
        characteristics = "Supports life, has water and atmosphere.",
        imageRes = R.drawable.terra
    ),
    createPlanet(
        id = 2,
        name = "Mercury",
        type = TYPE_TERRESTRIAL,
        distanceFromSun = "57.9 million km",
        diameter = "4,879 km",
        characteristics = "Smallest planet, closest to the Sun, no atmosphere.",
        imageRes = R.drawable.mercurio
    ),
    createPlanet(
        id = 3,
        name = "Venus",
        type = TYPE_TERRESTRIAL,
        distanceFromSun = "108.2 million km",
        diameter = "12,104 km",
        characteristics = "Thick toxic atmosphere, hottest planet, similar size to Earth.",
        imageRes = R.drawable.venus
    ),
    createPlanet(
        id = 4,
        name = "Mars",
        type = TYPE_TERRESTRIAL,
        distanceFromSun = "227.9 million km",
        diameter = "6,779 km",
        characteristics = "Known as the Red Planet, has the largest volcano in the solar system.",
        imageRes = R.drawable.marte
    ),
    createPlanet(
        id = 5,
        name = "Jupiter",
        type = TYPE_GAS_GIANT,
        distanceFromSun = "778.5 million km",
        diameter = "139,820 km",
        characteristics = "Largest planet, known for its Great Red Spot and many moons.",
        imageRes = R.drawable.jupiter
    ),
    createPlanet(
        id = 6,
        name = "Saturn",
        type = TYPE_GAS_GIANT,
        distanceFromSun = "1.4 billion km",
        diameter = "116,460 km",
        characteristics = "Famous for its extensive ring system, second-largest planet.",
        imageRes = R.drawable.saturno
    ),
    createPlanet(
        id = 7,
        name = "Uranus",
        type = TYPE_ICE_GIANT,
        distanceFromSun = "2.9 billion km",
        diameter = "50,724 km",
        characteristics = "Rotates on its side, has a bluish-green color due to methane in its atmosphere.",
        imageRes = R.drawable.urano
    ),
    createPlanet(
        id = 8,
        name = "Neptune",
        type = TYPE_ICE_GIANT,
        distanceFromSun = "4.5 billion km",
        diameter = "49,244 km",
        characteristics = "Farthest planet from the Sun, known for its deep blue color and strong winds.",
        imageRes = R.drawable.netuno
    )
)


private fun createPlanet(
    id: Int,
    name: String,
    type: String,
    distanceFromSun: String,
    diameter: String,
    characteristics: String,
    imageRes: Int
): Planet {
    return Planet(
        id = id,
        name = name,
        type = type,
        galaxy = GALAXY_MILKY_WAY,
        distanceFromSun = distanceFromSun,
        diameter = diameter,
        characteristics = characteristics,
        imageRes = imageRes
    )
}
