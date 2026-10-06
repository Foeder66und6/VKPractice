package com.example.vkpractice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ViewsMainActivity : AppCompatActivity() {

    lateinit var callButton: Button//L :
    lateinit var sendButton: Button
    lateinit var dataInput: EditText//;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_views_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        callButton = findViewById(R.id.btn_call)
        sendButton = findViewById(R.id.btn_send)
        dataInput = findViewById(R.id.inp_data)

        val intent = Intent(
        )
        intent.action = Intent.ACTION_DIAL//Action ()

    }
}