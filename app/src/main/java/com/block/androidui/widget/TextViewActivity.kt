package com.block.androidui.widget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.block.androidui.R

class TextViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_view)
        supportActionBar?.title = "TextView"
    }
}