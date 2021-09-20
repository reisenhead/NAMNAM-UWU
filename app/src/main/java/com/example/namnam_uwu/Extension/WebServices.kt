package com.example.namnam_uwu.Extension

import com.example.namnam_uwu.Fragments.Pokemon
import com.example.namnam_uwu.Models.Type
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WebServices {
    // Request method and URL specified in the annotation

    @GET("pokemon/{pokemon}")
    fun getPokemon(@Path("pokemon") pokemon: String): Call<Pokemon>

    @GET("type/{id}")
    fun getType(@Path("id") id: Int): Call<List<Type>>

}