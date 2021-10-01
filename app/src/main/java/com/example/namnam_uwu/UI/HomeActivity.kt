package com.example.namnam_uwu.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.namnam_uwu.Fragments.CardsFragment
import com.example.namnam_uwu.API.MainActivityApi
import com.example.namnam_uwu.R
import com.example.namnam_uwu.Fragments.*


import kotlinx.android.synthetic.main.activity_home.*

enum class ProvidertType{
    BASIC
}

var email = String()
var provider = String()

class HomeActivity : AppCompatActivity() {

    private lateinit var boton: Button
    private lateinit var botontwo: Button
    private lateinit var input: EditText
    private val homeFragment = CardsFragment()
    private val profileFragment = ProfileFragment()
    private val shoppingCartFragment = ShoppingCartFragment()
    private val starFragment = StarFragment()
    private val mapGoogle = MapFragment()

    override fun onBackPressed() {
        replaceFragment(homeFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        //Recuperando los datos del usuario
        val bundle = intent.extras
        email = bundle?.getString("email").toString()
        provider = bundle?.getString("provider").toString()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        replaceFragment(homeFragment)

        botontwo = findViewById(R.id.buttonlist)
        botontwo.setOnClickListener {

            replaceFragment(homeFragment)
        }
        boton = findViewById(R.id.buttonworld)
        boton.setOnClickListener {

            replaceFragment(mapGoogle)
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
//                    startActivity(Intent(this, MainActivityApi::class.java))
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
