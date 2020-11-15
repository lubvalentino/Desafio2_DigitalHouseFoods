package com.example.digitalhousefoods_desafio2.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.digitalhousefoods_desafio2.R
import com.example.digitalhousefoods_desafio2.utils.MaskWatcher

class MainActivity : AppCompatActivity() {
    private lateinit var etpassword : EditText
    private lateinit var etemail : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Digital House Foods"

        initItems()

    }

    private fun validateEmailFormat(): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(etemail.text).matches()
    }

    private fun initItems (){
        etpassword = findViewById(R.id.etPassword)
        etemail = findViewById(R.id.etEmail)

        etpassword.addTextChangedListener(MaskWatcher(etpassword,"######"))

        findViewById<AppCompatButton>(R.id.btRegister).setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        findViewById<AppCompatButton>(R.id.btLogIn).setOnClickListener {
            if (etpassword.length() == 6 && validateEmailFormat()){
                startActivity(Intent(this, RestaurantsActivity::class.java))
            } else {
                if (!(etpassword.length() == 6) && validateEmailFormat()){
                    Toast.makeText(this, "Password inválido", Toast.LENGTH_LONG).show()
                }else{
                    if (etpassword.length() == 6 && !(validateEmailFormat())){
                        Toast.makeText(this, "Email inválido", Toast.LENGTH_LONG).show()
                }else {
                    if (etpassword.text.isNullOrEmpty() && etemail.text.isNullOrEmpty()){
                        Toast.makeText(this, "Preenchimento dos campos obrigatórios", Toast.LENGTH_LONG).show()
                    }else {
                        Toast.makeText(this, "Preenchimento e-mail e password inválidos", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }
    }
}