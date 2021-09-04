package com.example.namnam_uwu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.namnam_uwu.fragments.HomeFragment
import com.example.namnam_uwu.fragments.ProfileFragment
import com.example.namnam_uwu.fragments.ShoppingCartFragment
import com.example.namnam_uwu.fragments.StarFragment

import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private lateinit var boton: Button
    private lateinit var input: EditText
    private val homeFragment = HomeFragment()
    private val profileFragment = ProfileFragment()
    private val shoppingCartFragment = ShoppingCartFragment()
    private val starFragment = StarFragment()

    override fun onBackPressed() {
        replaceFragment(homeFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        replaceFragment(homeFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> replaceFragment(homeFragment)
                R.id.ic_profile -> replaceFragment(profileFragment)
                R.id.ic_shopping_cart -> replaceFragment(shoppingCartFragment)
                R.id.ic_star -> replaceFragment(starFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
}