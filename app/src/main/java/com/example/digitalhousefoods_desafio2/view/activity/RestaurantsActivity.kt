package com.example.digitalhousefoods_desafio2.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalhousefoods_desafio2.R
import com.example.digitalhousefoods_desafio2.model.Restaurant
import com.example.digitalhousefoods_desafio2.utils.OnClickListener
import com.example.digitalhousefoods_desafio2.view.adapter.RestaurantsAdapter

class RestaurantsActivity : AppCompatActivity(), OnClickListener {
    private var listRestaurant = mutableListOf<Restaurant>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurants)

        supportActionBar?.title = "Digital House Foods"

        addRestaurantList()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewRestaurants)

        val restaurantsAdapter = RestaurantsAdapter(listRestaurant, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = restaurantsAdapter
        restaurantsAdapter.notifyDataSetChanged()


    }

    private fun addRestaurantList(){
        listRestaurant.clear()
        listRestaurant.add(Restaurant("https://images.freeimages.com/images/large-previews/747/plate-of-shrimp-mexican-food-1318835.jpg","Tony Roma's","Av Lavandisca, 717 - Indianápolis, São Paulo","22:00"))
        listRestaurant.add(Restaurant("https://get.pxhere.com/photo/dish-food-salad-produce-vegetable-healthy-eat-cuisine-vitamins-salad-plate-lamb's-lettuce-caesar-salad-hors-d-oeuvre-greek-salad-leaf-vegetable-spinach-salad-845073.jpg","Aoyama - Moema","Alameda dos Arapanés, 532 - Moema","00:00"))
        listRestaurant.add(Restaurant("http://imgsapp.df.divirtasemais.com.br/app/noticia_133890394703/2015/08/07/154843/20150806141150218833a.jpg","Outback - Moema", "Av Moaci, 187, 187 - Moema, São Paulo", "00:00"))
        listRestaurant.add(Restaurant("https://media-cdn.tripadvisor.com/media/photo-s/10/5f/2d/c9/crunch-tacos.jpg","Sí Señor","Alameda Jauperi, 626 - Moema","01:00"))
    }

    override fun onItemClicked(position: Int) {
        if(position == 0){
        val intent = Intent(this, FoodActivity::class.java)
        intent.putExtra("Foto",listRestaurant[position].image)
        intent.putExtra("RestaurantName",listRestaurant[position].nome)
        startActivity(intent)}
    }
}