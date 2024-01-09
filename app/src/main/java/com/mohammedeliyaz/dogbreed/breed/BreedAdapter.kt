package com.mohammedeliyaz.dogbreed.breed

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.mohammedeliyaz.dogbreed.R
import org.json.JSONObject


class BreedAdapter(private val breedList: List<DogBreed>) :
    RecyclerView.Adapter<BreedAdapter.BreedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_breed, parent, false)
        return BreedViewHolder(view)
    }

    override fun onBindViewHolder(holder: BreedViewHolder, position: Int) {
        val breed = breedList[position]
        holder.bind(breed)


        holder.itemView.setOnClickListener {

//            val intent = Intent(holder.itemView.context, BreeddetailActivity::class.java)
//            intent.putExtra("selectedBreed", breed.breedName)
//            holder.itemView.context.startActivity(intent)

            val breedJsonString = JSONObject().put("breedName", breed.breedName).toString()
            val intent = Intent(holder.itemView.context, BreeddetailActivity::class.java)
            intent.putExtra("selectedBreedJson", breedJsonString)
            holder.itemView.context.startActivity(intent)

        }
    }



    override fun getItemCount(): Int = breedList.size

    class BreedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val breedTextView: TextView = itemView.findViewById(R.id.breed_text_view)

        fun bind(breed: DogBreed) {
            breedTextView.text = breed.breedName
        }
    }
}


