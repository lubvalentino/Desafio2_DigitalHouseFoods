package com.example.digitalhousefoods_desafio2.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalhousefoods_desafio2.utils.OnClickListener
import com.example.digitalhousefoods_desafio2.R
import com.example.digitalhousefoods_desafio2.model.Restaurant
import com.squareup.picasso.Picasso

class RestaurantsAdapter (private val listRestaurant: List<Restaurant>, private val onClickListener: OnClickListener) : RecyclerView.Adapter<RestaurantsAdapter.RestaurantViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_single_restaurant, parent, false)
        return RestaurantViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {

        Picasso.get().load(listRestaurant[position].image).into(holder.image)
        holder.nome.text = listRestaurant[position].nome
        holder.address.text = listRestaurant[position].address
        holder.hour.text = listRestaurant[position].hour

        holder.itemView.setOnClickListener {
            onClickListener.onItemClicked(position)
        }

    }


    override fun getItemCount(): Int {
        return listRestaurant.size
    }
    class RestaurantViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image : ImageView = itemView.findViewById(R.id.ivRecyclerView)
        val nome : TextView = itemView.findViewById(R.id.tvRestaurantName)
        val address : TextView = itemView.findViewById(R.id.tvRestaurantAdress)
        val hour : TextView = itemView.findViewById(R.id.tvRestaurantHour)

        }
}
