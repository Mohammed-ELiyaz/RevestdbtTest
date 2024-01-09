package com.mohammedeliyaz.dogbreed.breed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mohammedeliyaz.dogbreed.R

class BreedActivity : AppCompatActivity() {

    private lateinit var breedViewModel: BreedViewModel
    private lateinit var breedRecyclerView: RecyclerView
    private lateinit var breedAdapter: BreedAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breed)

        breedViewModel = ViewModelProvider(this).get(BreedViewModel::class.java)

        breedRecyclerView = findViewById(R.id.recyclerview)
        breedRecyclerView.layoutManager = LinearLayoutManager(this)
        breedAdapter = BreedAdapter(emptyList())
        breedRecyclerView.adapter = breedAdapter

        breedViewModel.breedList.observe(this) { breeds ->
            breedAdapter = BreedAdapter(breeds)
            breedRecyclerView.adapter = breedAdapter
        }
    }
}