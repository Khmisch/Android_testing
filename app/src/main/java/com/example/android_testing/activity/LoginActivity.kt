package com.example.android_testing.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.android_testing.R

class LoginActivity : AppCompatActivity() {
    lateinit var et_email: EditText
    lateinit var et_password: EditText
    lateinit var b_login: Button
    lateinit var tv_message: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initViews()
    }

    private fun initViews() {
        et_email = findViewById(R.id.et_email)
        et_password = findViewById(R.id.et_password)
        b_login = findViewById(R.id.b_login)
        tv_message = findViewById(R.id.tv_message)

        et_password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                TODO("Not yet implemented")
            }

            override fun afterTextChanged(s: Editable?) {
                val email = et_email.text.toString().trim()
                if (email.isNotEmpty() && s!!.isNotEmpty()) {
                    b_login.isEnabled = true
                } else {
                    b_login.isEnabled = false
                }
            }

        })

    }
}