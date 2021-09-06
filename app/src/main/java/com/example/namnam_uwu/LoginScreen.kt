package com.example.namnam_uwu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register_screen.*


class LoginScreen : AppCompatActivity() {

    private lateinit var boton: Button
    private lateinit var usuario: EditText
    private lateinit var contrasenia: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        supportActionBar?.hide()

        boton = findViewById(R.id.iniciarSesionButton)
        usuario = findViewById(R.id.teCorreo)
        contrasenia = findViewById(R.id.tePass)


        usuario.setOnClickListener{
            usuario.setText("")
        }
        contrasenia.setOnClickListener {
            contrasenia.setText("")
        }



        boton.setOnClickListener {
            if(usuario.text != null && contrasenia.text != null){
                val usuarioText = usuario.text.toString()
                val contraseniaText = contrasenia.text.toString()

                val intent = Intent(this, HomeActivity::class.java )
                startActivity(intent)
                //overridePendingTransition(R.anim.from_left,R.anim.from_rigth)

                /*
                Esto es para trabajar en bases de datos

                if( positionUser >= 0){
                    val intent = Intent(this, HomeActivity::class.java )
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "Usuario y/o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                }

                 */
            }
            else{
                Toast.makeText(this, "Rellene los campos", Toast.LENGTH_SHORT).show()
            }
        }


    }
}