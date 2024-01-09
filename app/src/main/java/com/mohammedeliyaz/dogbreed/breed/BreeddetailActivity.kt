package com.mohammedeliyaz.dogbreed.breed

import android.annotation.SuppressLint
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.mohammedeliyaz.dogbreed.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL




class BreeddetailActivity : AppCompatActivity() {


    private lateinit var breedDetailsViewModel: BreedDetailsViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breeddetail)
        breedDetailsViewModel = ViewModelProvider(this).get(BreedDetailsViewModel::class.java)

        val breedTextView = findViewById<TextView>(R.id.breed_text_view_detailed)
        val breedImageView = findViewById<ImageView>(R.id.breed_image_view_detailed)

        val jsonBreedData = intent.getStringExtra("selectedBreedJson")

        jsonBreedData?.let { breedDetailsViewModel.setBreedDetails(it) }

        breedDetailsViewModel.breedName.observe(this) { breedName ->
            breedTextView.text = breedName
        }

        val imageUrl = "https://dog.ceo/api/breed/$jsonBreedData/images/random"

        Picasso.get().load(imageUrl).into(breedImageView, object : Callback {
            override fun onSuccess() {
                // Image loaded successfully

            }

            override fun onError(e: Exception?) {
                // Handle error while loading image
                e?.printStackTrace()
            }
        })
    }}