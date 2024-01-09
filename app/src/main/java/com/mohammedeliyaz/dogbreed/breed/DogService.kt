package com.mohammedeliyaz.dogbreed.breed

import retrofit2.Call
import retrofit2.http.GET

interface DogService {
    @GET("breeds/list/all")
    fun getAllBreeds(): Call<DogResponse>
}

data class DogResponse(val message: Map<String, List<String>>, val status: String)
