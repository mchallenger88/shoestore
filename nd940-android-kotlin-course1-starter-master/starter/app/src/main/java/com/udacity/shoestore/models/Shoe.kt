package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    var name: String,
    var size: Double,
    var company: String,
    var description: String,
    val images: List<String> = mutableListOf()
) : Parcelable

val shoeList: ArrayList<Shoe> = arrayListOf(
        Shoe(name = "Snow Queen Princess Birthday Sandals",
                size = 7.0, company = "GUGUYeah", description = "The Blue princess shoes inspired by Frozon, " +
                "the Gold princess shoes inspired by Belle of Beauty and the Beast, " +
                "the White princess shoes inspired by Snow White. Not Disney products. ", images = listOf("guguyeah.jpg") ),
        Shoe(name = "ON Princess Girls Queen Jelly Shoes",
                size = 7.0, company = "ON", description = "Princess girls queen dress up cosplay jelly shoes for kids " +
                "toddler dance party sandals mary janes", images = listOf("on.jpg")),
        Shoe(name = "Mowoii Girls Glitter Mary Janes",
                size = 7.0, company = "Mowoii", description = "Dress shoes use design with sequins and bows, " +
                "the sequins are glued with strong glue, which is not easy to fall off easily", images = listOf("mowoii.jpg")),
        Shoe(name = "Vokamara Princess Girls Sandals",
                size = 7.0, company = "Vokamara", description = "Look very beautiful for cosplay, Adjustable buckle", images = listOf("vokomara.jpg"))
)

