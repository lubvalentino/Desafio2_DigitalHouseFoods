package com.example.digitalhousefoods_desafio2.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageButton
import com.example.digitalhousefoods_desafio2.R
import com.squareup.picasso.Picasso

class FoodDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

        supportActionBar?.hide()

        val btBackFoods = findViewById<AppCompatImageButton>(R.id.ibBackFoods)

        btBackFoods.setOnClickListener {
            super.onBackPressed()
            finish()
        }

        val imageUrl = intent.getStringExtra("Foto")
        findViewById<TextView>(R.id.tvFoodDetailName).text = intent.getStringExtra("FoodName")
        Picasso.get().load(imageUrl).into(findViewById<ImageView>(R.id.ivFoodDetail1))
    }
}