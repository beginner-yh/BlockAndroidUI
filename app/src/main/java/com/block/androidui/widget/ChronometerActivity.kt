package com.block.androidui.widget

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.Chronometer
import androidx.annotation.RequiresApi
import com.block.androidui.R

class ChronometerActivity : AppCompatActivity() {

    private lateinit var btnStart: Button
    private lateinit var btnStop: Button
    private lateinit var btnContinue: Button
    private lateinit var btnFinish: Button
    private lateinit var ctTimer: Chronometer
    private lateinit var clTimerFormat: Chronometer


    private lateinit var btnStartCountDown: Button
    private lateinit var btnStopCountDown: Button
    private lateinit var btnContinueCountDown: Button
    private lateinit var btnFinishCountDown: Button
    private lateinit var ctCountDown: Chronometer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chronometer)
        supportActionBar?.title = "Chronometer"
        btnStart = findViewById(R.id.btn_start_timer)
        btnStop = findViewById(R.id.btn_stop_timer)
        btnContinue = findViewById(R.id.btn_continue_timer)
        btnFinish = findViewById(R.id.btn_finish_timer)
        ctTimer = findViewById(R.id.ct_timer)
        clTimerFormat = findViewById(R.id.ct_timer_format)

        btnStartCountDown = findViewById(R.id.btn_start_count_down)
        btnStopCountDown = findViewById(R.id.btn_stop_count_down)
        btnContinueCountDown = findViewById(R.id.btn_continue_count_down)
        btnFinishCountDown = findViewById(R.id.btn_finish_count_down)
        ctCountDown = findViewById(R.id.ct_count_down)


        clTimerFormat.setOnChronometerTickListener {
            setFormat(it)
        }
        btnStart.setOnClickListener {
            //clTimerFormat.base = SystemClock.elapsedRealtime()-59*60*1000L-50*1000L;
            ctTimer.start()
            clTimerFormat.start()
        }

        btnStop.setOnClickListener {
            //不会影响实际上的时间，只会影响 base 属性
            ctTimer.stop()
            clTimerFormat.stop()
        }
        btnContinue.setOnClickListener {
            ctTimer.start()
            clTimerFormat.start()
        }
        btnFinish.setOnClickListener {
            ctTimer.stop()
            clTimerFormat.stop()
            ctTimer.base = SystemClock.elapsedRealtime()
            clTimerFormat.base = SystemClock.elapsedRealtime()
        }

        ctCountDown.base = SystemClock.elapsedRealtime() - 30 * 1000L

        btnStartCountDown.setOnClickListener {
            ctCountDown.base = SystemClock.elapsedRealtime() + 30 * 1000L
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                ctCountDown.isCountDown = true
            }
            ctCountDown.setOnChronometerTickListener {
                if ((SystemClock.elapsedRealtime() - it.base) >= 0L) {
                    it.stop()
                }
            }
            ctCountDown.start()
        }
        btnStopCountDown.setOnClickListener {
            ctCountDown.stop()
        }
        btnContinueCountDown.setOnClickListener {
            ctCountDown.start()
        }
        btnFinishCountDown.setOnClickListener {
            ctCountDown.stop()
            ctCountDown.base = SystemClock.elapsedRealtime()
        }
    }

    private fun setFormat(chronometer: Chronometer) {
        val hour = (SystemClock.elapsedRealtime() - chronometer.base) / (1000 * 60 * 60)
        val minute = ((SystemClock.elapsedRealtime() - chronometer.base) / (1000 * 60)) % 60
        val second = ((SystemClock.elapsedRealtime() - chronometer.base) / 1000) % 60
        if (hour < 1) {
            //59:59到1:00:00的时候，需要提前处理。因为这里是监听后格式化的，所以会慢一步。
            if (minute.toInt() == 59 && second.toInt() == 59) {
                chronometer.format = "0:%s"
            } else {
                chronometer.format = "0$hour:%s"
            }
        } else if (hour < 10) {
            chronometer.format = "0%s"
        } else {
            chronometer.format = "%s"
        }
    }
}