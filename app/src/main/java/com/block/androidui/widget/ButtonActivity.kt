package com.block.androidui.widget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.block.androidui.R
import com.block.androidui.clickWait

class ButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)
        supportActionBar?.title = "Button"
        findViewById<Button>(R.id.btn_fast_click).clickWait {
            Log.d("yhblock", "点击生效了")
        }
    }
}