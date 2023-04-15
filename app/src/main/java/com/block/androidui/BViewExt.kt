package com.block.androidui

import android.view.View

private const val CLICK_WAIT_TIME = 1000L

private val map = mutableMapOf<Int, Long>()

infix fun View.clickWait(clickAction: () -> Unit) {
    this.setOnClickListener {
        val curTime = System.currentTimeMillis()
        val lastTime = map[hashCode()] ?: 0L
        if (lastTime == 0L) {
            clickAction()
            map[hashCode()] = curTime
        } else {
            if (curTime - lastTime > CLICK_WAIT_TIME) {
                clickAction()
                map[hashCode()] = curTime
            }
        }
    }
}