package com.example.playlistmaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_search = findViewById<Button>(R.id.am_search)

        val button_searchClickListener: View.OnClickListener = object : View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(this@MainActivity, "Нажали на кнопку Поиск!", Toast.LENGTH_SHORT).show()
            }
        }
        button_search.setOnClickListener(button_searchClickListener)

        val button_mediatec = findViewById<Button>(R.id.am_mediatec)
        button_mediatec.setOnClickListener {
            Toast.makeText(this@MainActivity, "Нажали на кнопку Медиатека", Toast.LENGTH_SHORT).show() }

        val button_settings = findViewById<Button>(R.id.am_settings)
        button_settings.setOnClickListener {
            Toast.makeText(this@MainActivity, "Нажали на кнопку НАстройки", Toast.LENGTH_SHORT).show() }

    }

}