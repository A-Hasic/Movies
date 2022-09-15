package com.example.movies

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_nav)
        val inputText = findViewById<TextInputLayout>(R.id.inputext)

        val viewpager = findViewById<ViewPager2>(R.id.viewpager).apply {
            val fragmentList = arrayListOf(
                HomeFragment(),
                FavouriteFragment(),
            )
            adapter = ViewPagerAdapter(
                fragmentList,
                supportFragmentManager,
                lifecycle
            )
            isUserInputEnabled = false
        }

        bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeitem -> {
                    viewpager.currentItem = 0

                    true
                }
                R.id.favoriteitem -> {
                    viewpager.currentItem = 1

                    true
                }
                else -> false
            }
        }




    }


}













