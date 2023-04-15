package com.block.androidui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var tlMain: TabLayout
    private lateinit var vpMain: ViewPager2
    private lateinit var mMediator: TabLayoutMediator
    private val mTabTitle = listOf("View", "ViewGroup")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tlMain = findViewById(R.id.tl_main)
        vpMain = findViewById(R.id.vp_main)
        vpMain.adapter = object : FragmentStateAdapter(supportFragmentManager, lifecycle) {
            override fun getItemCount(): Int {
                return mTabTitle.size
            }

            override fun createFragment(position: Int): Fragment {
                return WidgetListFragment.newInstance("", "")
            }

        }
        tlMain.isTabIndicatorFullWidth = false
        mMediator = TabLayoutMediator(
            tlMain, vpMain
        ) { tab, position ->
            tab.text = mTabTitle[position]
        }
        mMediator.attach()
    }
}