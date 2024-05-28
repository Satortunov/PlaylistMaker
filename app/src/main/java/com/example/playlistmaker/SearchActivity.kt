package com.example.playlistmaker

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.internal.ViewUtils.hideKeyboard

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

       val imageViewSearch = findViewById<ImageView>(R.id.aseSearch)
        imageViewSearch.setOnClickListener {
            finish()
        }

        val linearLayout = findViewById<LinearLayout>(R.id.container)
        val inputEditText = findViewById<EditText>(R.id.enterEditText)
        val clearButton = findViewById<ImageView>(R.id.clearIcon)
        inputEditText.requestFocus()
        //inputEditText.focusable

        clearButton.setOnClickListener {
            inputEditText.setText("")

            val view: View? = this.currentFocus

            if (view != null) {

                val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0)

            }
        }

        val simpleTextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // empty
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                clearButton.visibility = clearButtonVisibility(s)
            }

            override fun afterTextChanged(s: Editable?) {
                //
            }
        }

        inputEditText.addTextChangedListener(simpleTextWatcher)

    }
    private fun clearButtonVisibility(s: CharSequence?): Int {
        return if (s.isNullOrEmpty()) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }
}