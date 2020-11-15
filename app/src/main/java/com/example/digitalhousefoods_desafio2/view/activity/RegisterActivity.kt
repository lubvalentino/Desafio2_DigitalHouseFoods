package com.example.digitalhousefoods_desafio2.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.digitalhousefoods_desafio2.R
import com.example.digitalhousefoods_desafio2.utils.MaskWatcher

@Suppress("DEPRECATION")
class RegisterActivity : AppCompatActivity() {
    private lateinit var etname : EditText
    private lateinit var etemailRegister : EditText
    private lateinit var etpasswordRegister : EditText
    private lateinit var etconfirmpassword : EditText
    private val SPLASH_TIME_OUT: Long = 1500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar?.title = "Register"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        initItems()

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        finish()
        return true
    }

    private fun validateEmailFormat(): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(etemailRegister.text).matches()
    }

    private fun validatePassword(): Boolean{
        return etpasswordRegister.text.toString().equals(etconfirmpassword.text.toString())
    }

    private fun clearEditText(){
        etname.text.clear()
        etemailRegister.text.clear()
        etpasswordRegister.text.clear()
        etconfirmpassword.text.clear()
    }

    private fun initItems (){
        etpasswordRegister = findViewById(R.id.etPassword2)
        etemailRegister = findViewById(R.id.etEmail2)
        etname = findViewById(R.id.etName)
        etconfirmpassword = findViewById(R.id.etRepeatPassword)

        etpasswordRegister.addTextChangedListener(MaskWatcher(etpasswordRegister,"######"))
        etconfirmpassword.addTextChangedListener(MaskWatcher(etconfirmpassword,"######"))

        findViewById<AppCompatButton>(R.id.btRegister2).setOnClickListener {
            if (etname.text.isNullOrEmpty() || etpasswordRegister.text.isNullOrEmpty() || etemailRegister.text.isNullOrEmpty() || etconfirmpassword.text.isNullOrEmpty()){
                Toast.makeText(this, "Obrigatótio o preenchimento de todos os campos", Toast.LENGTH_LONG).show()
            }else{if (!(etpasswordRegister.length() == 6)){
                Toast.makeText(this, "Password deve ter 6 caracteres", Toast.LENGTH_LONG).show()
            }else{
            if (!validatePassword()){
                Toast.makeText(this, "Pasword e Repeat password devem ser iguais", Toast.LENGTH_LONG).show()
            }else{
            if (etpasswordRegister.length() == 6 && validateEmailFormat()&& etname.length()>0 && validatePassword()){
                Toast.makeText(this, "Cadastro realizado", Toast.LENGTH_LONG).show()
                clearEditText()
                Handler().postDelayed({
                    startActivity(Intent(this, RestaurantsActivity::class.java))
                    finish()}, SPLASH_TIME_OUT)
            } else {Toast.makeText(this, "Obrigatótio o preenchimento correto de todos os campos", Toast.LENGTH_LONG).show()
            }}
        }}
    }}
}