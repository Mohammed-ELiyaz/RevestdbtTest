package com.mohammedeliyaz.dogbreed.breed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BreedViewModel : ViewModel() {

    private val _breedList = MutableLiveData<List<DogBreed>>()
    val breedList: LiveData<List<DogBreed>> = _breedList

    init {
        fetchDogBreeds()
    }

    private fun fetchDogBreeds() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(DogService::class.java)
        val call = service.getAllBreeds()

        call.enqueue(object : Callback<DogResponse> {
            override fun onResponse(call: Call<DogResponse>, response: Response<DogResponse>) {
                if (response.isSuccessful) {
                    val breeds = response.body()?.message?.keys?.toList() ?: emptyList()
                    val dogBreeds = breeds.map { DogBreed(it) }
                    _breedList.postValue(dogBreeds)
                }
            }

            override fun onFailure(call: Call<DogResponse>, t: Throwable) {
                // Handle failure/error
            }
        })
    }
}
