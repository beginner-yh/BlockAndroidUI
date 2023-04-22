package com.block.androidui.widget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.block.androidui.R
import com.google.android.material.internal.FlowLayout

class FlowLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow_layout)
        supportActionBar?.title = "FlowLayout"
    }
}