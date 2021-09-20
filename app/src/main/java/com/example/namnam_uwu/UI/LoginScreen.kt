package com.example.namnam_uwu.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.namnam_uwu.R
import kotlinx.android.synthetic.main.activity_login_screen.*


class LoginScreen : AppCompatActivity() {

    private lateinit var boton: Button
    private lateinit var boton2: Button
    private lateinit var usuario: EditText
    private lateinit var contrasenia: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)



        boton = findViewById(R.id.btnInicio)
        boton2 = findViewById(R.id.btnCrearC)
        usuario = findViewById(R.id.teCorreo)
        contrasenia = findViewById(R.id.tePass)


        boton.setOnClickListener{
            iniciarSesion()
        }
        boton2.setOnClickListener{
            startActivity(Intent(this, CrearCuenta::class.java))
        }




        /*boton.setOnClickListener {
            if(usuario.text != null && contrasenia.text != null){
                val usuarioText = usuario.text.toString()
                val contraseniaText = contrasenia.text.toString()

                val intent = Intent(this, HomeActivity::class.java )
                startActivity(intent)
                //overridePendingTransition(R.anim.from_left,R.anim.from_rigth)

                *//*
                Esto es para trabajar en bases de datos

                if( positionUser >= 0){
                    val intent = Intent(this, HomeActivity::class.java )
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "Usuario y/o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                }

                 *//*
            }
            else{
                Toast.makeText(this, "Rellene los campos", Toast.LENGTH_SHORT).show()
            }
        }*/


    }

    private fun iniciarSesion() {
        val correo: String = teCorreo.getText().toString()
        val pass: String = tePass.getText().toString()

        when {
            correo.length == 0 && pass.length == 0 -> {
                Toast.makeText(this,"Los campos no pueden estar vacios", Toast.LENGTH_LONG).show()
            }
            pass.length == 0 -> {
                Toast.makeText(this,"Debes ingresar una contraseña", Toast.LENGTH_LONG).show()
            }
            correo.length == 0 -> {
                Toast.makeText(this,"Debes ingresar un correo", Toast.LENGTH_LONG).show()
            }
            correo != "usuario@gmail.com" || pass != "1234" -> {
                Toast.makeText(this, "Los datos no son validos", Toast.LENGTH_LONG).show()
            }
            correo == "usuario@gmail.com" && pass == "1234" -> {
                Toast.makeText(this,"Bienvenido de nuevo!!", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, HomeActivity::class.java))

            }
        }

    }
}