package com.example.digitalhousefoods_desafio2.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalhousefoods_desafio2.R
import com.example.digitalhousefoods_desafio2.model.Food
import com.example.digitalhousefoods_desafio2.utils.OnClickListener
import com.example.digitalhousefoods_desafio2.view.adapter.FoodsAdapter
import com.squareup.picasso.Picasso

class FoodActivity : AppCompatActivity(), OnClickListener {
    private val listFoods = mutableListOf<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        supportActionBar?.hide()

        val imageUrl = intent.getStringExtra("Foto")
        findViewById<TextView>(R.id.tvRestautantNameSelected).text = intent.getStringExtra("RestaurantName")
        Picasso.get().load(imageUrl).into(findViewById<ImageView>(R.id.ivFood1))

        foodList()

        val recyclerView2 = findViewById<RecyclerView>(R.id.recyclerViewFood1)
        val foodAdapter = FoodsAdapter(listFoods,this)
        val btBackRestaurants = findViewById<AppCompatImageButton>(R.id.ibBackRestaurants)

        recyclerView2.layoutManager = GridLayoutManager(this,2)
        recyclerView2.adapter = foodAdapter
        foodAdapter.notifyDataSetChanged()

        btBackRestaurants.setOnClickListener {
            super.onBackPressed()
            finish()
        }
    }

    private fun foodList(){
        listFoods.clear()
        listFoods.add(Food("https://www.acasaencantada.com.br/wp-content/uploads/2015/08/DSC_1937.jpg","Salada com molho Gengibre"))
        listFoods.add(Food("https://www.acasaencantada.com.br/wp-content/uploads/2015/08/DSC_1937.jpg","Salada com molho Gengibre"))
        listFoods.add(Food("https://www.acasaencantada.com.br/wp-content/uploads/2015/08/DSC_1937.jpg","Salada com molho Gengibre"))
        listFoods.add(Food("https://www.acasaencantada.com.br/wp-content/uploads/2015/08/DSC_1937.jpg","Salada com molho Gengibre"))
        listFoods.add(Food("https://www.acasaencantada.com.br/wp-content/uploads/2015/08/DSC_1937.jpg","Salada com molho Gengibre"))
        listFoods.add(Food("https://www.acasaencantada.com.br/wp-content/uploads/2015/08/DSC_1937.jpg","Salada com molho Gengibre"))
        listFoods.add(Food("https://www.acasaencantada.com.br/wp-content/uploads/2015/08/DSC_1937.jpg","Salada com molho Gengibre"))
        listFoods.add(Food("https://www.acasaencantada.com.br/wp-content/uploads/2015/08/DSC_1937.jpg","Salada com molho Gengibre"))
    }

    override fun onItemClicked(position: Int) {
        val intent = Intent(this, FoodDetailActivity::class.java)
        intent.putExtra("Foto",listFoods[position].image)
        intent.putExtra("FoodName",listFoods[position].foodName)
        startActivity(intent)
    }
}