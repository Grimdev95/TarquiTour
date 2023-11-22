package com.grimjowd.tarquitour

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager

class MainActivityLogin : AppCompatActivity() {
    private lateinit var viewPager: ViewPager
    private lateinit var navigation: LinearLayout
    private lateinit var menuItems: List<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)

        viewPager = findViewById(R.id.viewPager)
        navigation = findViewById(R.id.navmenu)

        val fragmentAdapter = FragmentAdapter(supportFragmentManager)
        viewPager.adapter = fragmentAdapter

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                updateMenuState(position)
                updateMenuAppearance(position)
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })


        menuItems = listOf(
            findViewById(R.id.textViewLogin),
            findViewById(R.id.textViewCrearCuenta),
            findViewById(R.id.textViewOlvideContrasena)
        )

        menuItems.forEachIndexed { index, menuItem ->
            menuItem.setOnClickListener {
                viewPager.currentItem = index
                updateMenuAppearance(index)
            }
        }
    }

    private fun updateMenuAppearance(selectedIndex: Int) {

        menuItems.forEachIndexed { index, item ->
            item.setTextColor(if (index == selectedIndex) Color.WHITE else Color.GRAY)

        }
    }

    private fun updateMenuState(selectedIndex: Int) {

        menuItems.forEachIndexed { index, item ->
            item.isSelected = (index == selectedIndex)
        }
    }

    private inner class FragmentAdapter(fm: FragmentManager) :
        FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        override fun getCount(): Int {
            return 3
        }

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> PrimerFragment()
                1 -> SegundoFragment()
                2 -> TercerFragment()
                else -> throw IllegalArgumentException("Invalid position: $position")
            }
        }
    }
}