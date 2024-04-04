package com.rosyid.incrementdecrementkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var btnAdd : Button
    private lateinit var btnRemove : Button
    private lateinit var btnReset : Button
    private lateinit var tvCount : TextView
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCount = findViewById(R.id.tv_count)

        increment()
        decrement()
        reset()
    }

    fun increment() {
        btnAdd = findViewById(R.id.btn_add)
        btnAdd.setOnClickListener {
            count++
            tvCount.text = count.toString()
        }
    }

    fun decrement() {
        btnRemove = findViewById(R.id.btn_remove)
        btnRemove.setOnClickListener {
            count--
            tvCount.text = count.toString()
        }
    }

    fun reset() {
        btnReset = findViewById(R.id.btn_reset)
        btnReset.setOnClickListener {
            count = 0
            tvCount.text = count.toString()
        }
    }
}