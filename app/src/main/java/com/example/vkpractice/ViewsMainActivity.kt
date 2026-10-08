package com.example.vkpractice

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
//import androidx.compose.ui.text.input.KeyboardType.Companion.Uri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ViewsMainActivity : AppCompatActivity() {

    lateinit var callButton: Button
    lateinit var sendButton: Button
    lateinit var dataInput: EditText

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

        callButton.setOnClickListener({
            val data = dataInput.text.toString()
            if (validate(data)) {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + data))
                startActivity(intent)
            } else {
                Toast.makeText(this, getString(R.string.msg_invalid_number), Toast.LENGTH_SHORT).show()
            }
        })

        sendButton.setOnClickListener({
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, dataInput.text.toString())
            startActivity(intent)
        })
    }
    private fun validate(data: String) : Boolean {
        val allowedLetters = "+-1234567890"
        for (i in 0..< data.length) {
            val c = data[i]
            if (c !in allowedLetters || c == '+' && i != 0) {
                return false
            }
        }
        return true
    }
}