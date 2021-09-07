package com.example.namnam_uwu

import com.google.gson.annotations.SerializedName

//la clase definida para sprites, sólo nos interesa la url, por lo cual ignoramos su(s) otro(s) parámetro(s).
data class Sprites(
    @SerializedName("front_default")
    val photoUrl : String? = ""
)