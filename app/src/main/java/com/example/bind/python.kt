package com.example.bind

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class python : AppCompatActivity() {
    var c = 0
    var w = false
    var x = false
    var y = false
    var z = false
    var an = 0
    var bn = 0
    lateinit var dialog:Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_python)
        val btn1 = findViewById<Button>(R.id.pybtn1)
        val btn2 = findViewById<Button>(R.id.pybtn2)
        dialog = Dialog(this)
        dialog.setContentView(R.layout.activity_dia)
        val btdia = dialog.findViewById<Button>(R.id.btid)
        val tex = dialog.findViewById<TextView>(R.id.txt)
        val na = intent.getStringExtra(MainActivity.KEY)
        tex.text = na.toString()
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.diaback))
        btn1.setOnClickListener {
            val options = arrayOf("not","programing language","Nothing")
            val alt = AlertDialog.Builder(this)
            alt.setTitle("Python is a-")
            alt.setSingleChoiceItems(options,0,DialogInterface.OnClickListener { dialog, which ->
                c = which
            })
            alt.setPositiveButton("Finish",DialogInterface.OnClickListener{dialogInterface,i->
                finish()
            })
            alt.setNegativeButton("Submit",DialogInterface.OnClickListener{dialogInterface,i->
                if(c == 1){
                    Toast.makeText(this,"Correct answer",Toast.LENGTH_SHORT).show()
                    if(bn >=1){
                        dialog.show()
                        btdia.setOnClickListener {
                            dialog.dismiss()
                        }
                    }
                    an += 1
                    c =0
                }
                else{
                    Toast.makeText(this,"Wrong answer",Toast.LENGTH_SHORT).show()
                }
            })
            alt.show()
        }
        c = 0
        btn2.setOnClickListener {
            val options = arrayOf("app dev","web dev","machine learning","programe")
            val build = AlertDialog.Builder(this)
            build.setTitle("Python is use for")
            build.setMultiChoiceItems(options,null,DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                if(which == 0){
                    w = true
                }
                else if(which == 1){
                    x = true
                }
                else if(which == 2){
                    y = true
                }
                else if(which == 3){
                    z = true
                }
            })
            build.setPositiveButton("Finish",DialogInterface.OnClickListener{dialogInterface,i->
               //Finish from dialog
            })
            build.setNegativeButton("Submit",DialogInterface.OnClickListener{dialogInterface,i->
                if(!w && x && y && z){
                    Toast.makeText(this,"Correct answer",Toast.LENGTH_SHORT).show()
                    if(an >=1){
                        dialog.show()
                        btdia.setOnClickListener {
                            dialog.dismiss()
                        }
                    }
                    bn += 1
                    x = false
                    y = false
                    z = false
                }
                else if(!x && !y && !z && !w){
                    Toast.makeText(this,"Please Select the option",Toast.LENGTH_SHORT).show()

                }
                else{
                    Toast.makeText(this,"Wrong answer",Toast.LENGTH_SHORT).show()
                    w = false
                    x = false
                    y = false
                    z = false
                }
            })
            build.show()
        }
    }
}