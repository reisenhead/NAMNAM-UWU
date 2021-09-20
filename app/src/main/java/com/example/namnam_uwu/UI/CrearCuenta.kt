package com.example.namnam_uwu.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.namnam_uwu.databinding.ActivityCrearCuentaBinding

class CrearCuenta : AppCompatActivity() {

    private lateinit var binding : ActivityCrearCuentaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearCuentaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCrearC.setOnClickListener {
            crearCuenta()
        }

        binding.btnVolver.setOnClickListener{
            startActivity(Intent(this, LoginScreen::class.java))
        }
    }

    private fun crearCuenta() {
        val correo: String = binding.teCorreo.getText().toString()
        val pass: String = binding.tePass.getText().toString()
        val nombre: String = binding.teNombre.getText().toString()
        val telefono: String = binding.teTelefono.getText().toString()

        when {
            correo.length == 0 && pass.length == 0 && nombre.length == 0 && telefono.length == 0 -> {
                Toast.makeText(this, "Los campos no pueden estar vacios", Toast.LENGTH_LONG).show()
            }
            pass.length == 0 -> {
                Toast.makeText(this, "Debes ingresar una contraseña", Toast.LENGTH_LONG).show()
            }
            correo.length == 0 -> {
                Toast.makeText(this, "Debes ingresar un correo", Toast.LENGTH_LONG).show()
            }
            nombre.length == 0 -> {
                Toast.makeText(this, "Debes ingresar una nombre", Toast.LENGTH_LONG).show()
            }
            telefono.length == 0 -> {
                Toast.makeText(this, "Debes ingresar un telefono", Toast.LENGTH_LONG).show()
            }
            correo.length != 0 || pass.length != 0 || nombre.length != 0 || telefono.length == 0 -> {
                Toast.makeText(
                    this,
                    "Te enviamos un correo para que puedas acceder",
                    Toast.LENGTH_LONG
                ).show()
                startActivity(Intent(this, LoginScreen::class.java))
            }


        }
    }
}