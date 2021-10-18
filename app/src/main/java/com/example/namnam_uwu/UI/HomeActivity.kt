package com.example.namnam_uwu.UI


import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import com.example.namnam_uwu.Controller.RegisterProduct
import com.example.namnam_uwu.Fragments.*
import com.example.namnam_uwu.R
import kotlinx.android.synthetic.main.activity_home.*


enum class ProvidertType{
    BASIC,
    GOOGLE,
    FACEBOOK
}

var email = String()
var provider = String()

var num = 0
var positionE = 0
var titles = mutableListOf("Amamba", "Cachito Mío", "Forever", "Forte", "Green Grass", "La Docena", "La Pitahaya Vegana", "Los Loosers", "Ramen Bar", "Soul La Roma")
var tittle = titles[0]
var sizeOfProducts = 5

var products = RegisterProduct()

class HomeActivity : AppCompatActivity() {


    companion object{
        //el nombre de la acción a ejecutar por el botón en la notificación
        const val CHANNEL_ID = "Ejemplo"
    }

    private lateinit var boton: Button
    private lateinit var botontwo: Button
    private lateinit var btnNotify : Button
    private lateinit var input: EditText
    private val cardFragment = CardsFragment()
    private val profileFragment = ProfileFragment()
    private val shoppingCartFragment = ShoppingCartFragment()
    private val starFragment = StarFragment()
    private val homeFragment = HomeFragment()

    private val mapGoogle = MapFragment()

    override fun onBackPressed() {
        replaceFragment(homeFragment)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {

        //Recuperando los datos del usuario
        val bundle = intent.extras
        email = bundle?.getString("email").toString()
        provider = bundle?.getString("provider").toString()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        replaceFragment(homeFragment)


        //Para android Oreo en adelante, s obligatorio registrar el canal de notificación
        //Para android Oreo en adelante, s obligatorio registrar el canal de notificación
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            setNotificationChannel()
        }
//        btnNotify = findViewById(R.id.btnNotify)
//        btnNotify.setOnClickListener{
//            simpleNotification()
//        }

        botontwo = findViewById(R.id.buttonlist)
        botontwo.setOnClickListener {
            simpleNotification()
            replaceFragment(cardFragment)
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




    @RequiresApi(Build.VERSION_CODES.M)
    private fun simpleNotification(){

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.logo_uwu) //seteamos el ícono de la push notification
            .setColor(getColor(R.color.accent1)) //definimos el color del ícono y el título de la notificación
            .setContentTitle(getString(R.string.simple_title)) //seteamos el título de la notificación
            .setContentText(getString(R.string.simple_body)) //seteamos el cuerpo de la notificación
            .setPriority(NotificationCompat.PRIORITY_DEFAULT) //Ponemos una prioridad por defecto

        //lanzamos la notificación
        with(NotificationManagerCompat.from(this)) {
            notify(20, builder.build()) //en este caso pusimos un id genérico
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun setNotificationChannel(){
        val name = getString(R.string.channel_courses)
        val descriptionText = getString(R.string.courses_description)
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
            description = descriptionText
        }

        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.createNotificationChannel(channel)
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
