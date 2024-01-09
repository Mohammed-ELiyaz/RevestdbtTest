package com.mohammedeliyaz.dogbreed.breed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.json.JSONObject

class BreedDetailsViewModel : ViewModel() {
    private val _breedName = MutableLiveData<String>()
    val breedName: LiveData<String> = _breedName

    private val _imageUrl = MutableLiveData<String>()
    val imageUrl: LiveData<String> = _imageUrl

    fun setBreedDetails(jsonBreedData: String) {
        val jsonObject = JSONObject(jsonBreedData)
        val breedName = jsonObject.getString("breedName")
        _breedName.value = breedName

        val imageUrl = "https://dog.ceo/api/breed/$breedName/images/random"
        _imageUrl.value = imageUrl
    }

    /////////////////////////////////////


}
