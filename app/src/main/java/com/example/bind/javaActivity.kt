package com.example.bind

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.bind.databinding.ActivityJavaBinding

class javaActivity : AppCompatActivity() {
    lateinit var bind : ActivityJavaBinding
   // lateinit var dialog:Dialog
    companion object{
        const val KEY1 ="com.example.bind.KEY"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityJavaBinding.inflate(layoutInflater)
        setContentView(bind.root)
        val pre = intent.getStringExtra(MainActivity.KEY)

       bind.jav.setOnClickListener {
           val it1 = Intent(this,java::class.java)
           it1.putExtra(KEY1,pre)
           startActivity(it1)
       }
        bind.c.setOnClickListener {
            val it2 = Intent(this,cplus::class.java)
            it2.putExtra(KEY1,pre)
            startActivity(it2)

        }
        bind.pyt.setOnClickListener {
            val it3 = Intent(this,python::class.java)
            it3.putExtra(KEY1,pre)
            startActivity(it3)
        }
        bind.kot.setOnClickListener {
            val it4 = Intent(this,kotlin::class.java)
            it4.putExtra(KEY1,pre)
            startActivity(it4)
        }
        bind.exit.setOnClickListener {
            val alt = AlertDialog.Builder(this)
            alt.setTitle("Are you sure!")
            alt.setMessage("Do you want to exit")
            alt.setPositiveButton("yes",DialogInterface.OnClickListener { dialogInterface, i ->
                finish()
            })
            alt.setNegativeButton("No",DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this,"ok",Toast.LENGTH_SHORT)
            })
      alt.show()
        }
        bind.back.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    bind.fed.setOnClickListener {
        val it5 = Intent(this,feed::class.java)
        it5.putExtra(KEY1,pre)
        startActivity(it5)
    }

    }
}