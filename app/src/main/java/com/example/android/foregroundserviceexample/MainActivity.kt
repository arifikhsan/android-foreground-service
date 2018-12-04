package com.example.android.foregroundserviceexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.EditText



class MainActivity : AppCompatActivity() {

    private var editTextInput: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextInput = findViewById(R.id.edit_text_input)
    }

    fun startService(v: View) {
        val input = editTextInput?.text.toString()

        val serviceIntent = Intent(this, ExampleService::class.java)
        serviceIntent.putExtra("inputExtra", input)

        ContextCompat.startForegroundService(this, serviceIntent)
    }

    fun stopService(v: View) {
        val serviceIntent = Intent(this, ExampleService::class.java)
        stopService(serviceIntent)
    }

}
