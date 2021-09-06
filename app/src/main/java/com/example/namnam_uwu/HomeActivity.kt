package com.example.namnam_uwu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.namnam_uwu.databinding.FragmentHomeBinding
import com.example.namnam_uwu.fragments.*


import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private lateinit var boton: Button
    private lateinit var input: EditText
    private val homeFragment = HomeFragment()
    private val profileFragment = ProfileFragment()
    private val shoppingCartFragment = ShoppingCartFragment()
    private val starFragment = MapFragment()



    override fun onBackPressed() {
        replaceFragment(homeFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        replaceFragment(homeFragment)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, CardsFragment())
                .commit()


        }



        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                }
                R.id.ic_profile -> {
                    replaceFragment(profileFragment)
                }
                R.id.ic_shopping_cart -> {
                    replaceFragment(shoppingCartFragment)
                }
                R.id.ic_star -> replaceFragment(starFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction().
            setCustomAnimations(R.anim.left_in,0,0, R.anim.left_out)
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }



}
