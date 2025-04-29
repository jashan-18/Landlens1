package com.example.etp

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val mainLayout = findViewById< ConstraintLayout>(R.id.main)
        val colorSpinner = findViewById<Spinner>(R.id.spinner)
        val colorsArray = arrayOf("Black", "Red")


        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, colorsArray)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        colorSpinner.adapter = adapter

        colorSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                when (position) {
                    0 -> mainLayout?.setBackgroundColor(Color.BLACK)
                    1 -> mainLayout?.setBackgroundColor(Color.RED)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }
}


