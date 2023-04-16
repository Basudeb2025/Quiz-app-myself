package com.example.bind

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bind.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
     lateinit var binding : ActivityMainBinding
     companion object{
         const val KEY = "com.example.bind.KEY"
     }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       binding.fbtn.setOnClickListener {
           finish()
           System.exit(0)
       }
        val ttx = findViewById<TextInputEditText>(R.id.txt)
        binding.btn.setOnClickListener {
           val tx = Intent(this,javaActivity::class.java)
            val tt = ttx.text.toString()
            if(tt.isNotEmpty()){
                tx.putExtra(KEY,tt)
                startActivity(tx)
            }
            else{
                Toast.makeText(this,"Plase Enter your name",Toast.LENGTH_LONG).show()
            }

        }
        binding.about.setOnClickListener {
            startActivity(Intent(this,aboutme::class.java))
        }
    }
}