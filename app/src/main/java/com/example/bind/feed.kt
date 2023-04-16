package com.example.bind

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class feed : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    lateinit var database:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)
        val bt = findViewById<Button>(R.id.feedbtn)
        val ed =findViewById<TextInputEditText>(R.id.edtxt)
        val name = intent.getStringExtra(MainActivity.KEY)
        bt.setOnClickListener {
            val edittxt = ed.text.toString()
            val use = Users(name.toString(),edittxt)
            if(edittxt.isNotEmpty()) {
                database = FirebaseDatabase.getInstance().getReference("user")
                database.child(name.toString()).setValue(use).addOnSuccessListener {
                    Toast.makeText(this,"Thanks for your feeback",Toast.LENGTH_SHORT).show()
                }
                finish()
            }
            else{
                Toast.makeText(this,"Please dont go without Feeback",Toast.LENGTH_LONG).show()
            }
        }
    }

}