package com.example.digitalhousefoods_desafio2.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalhousefoods_desafio2.utils.OnClickListener
import com.example.digitalhousefoods_desafio2.R
import com.example.digitalhousefoods_desafio2.model.Food
import com.squareup.picasso.Picasso

class FoodsAdapter (private val listFood : List<Food>, private val onClickListener: OnClickListener) : RecyclerView.Adapter<FoodsAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_single_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        Picasso.get().load(listFood[position].image).into(holder.image)
        holder.txtfoodName.text = listFood[position].foodName

        holder.itemView.setOnClickListener {
            if (position == 0){
            onClickListener.onItemClicked(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return listFood.size
    }

    class FoodViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        var image : ImageView = itemView.findViewById(R.id.ivRecyclerViewFood)
        var txtfoodName : TextView = itemView.findViewById(R.id.tvFoodName)

    }
}