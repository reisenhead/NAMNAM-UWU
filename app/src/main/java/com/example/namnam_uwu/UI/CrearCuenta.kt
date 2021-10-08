package com.example.namnam_uwu.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.namnam_uwu.databinding.ActivityCrearCuentaBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.text.isNotEmpty as isNotEmpty1


class CrearCuenta : AppCompatActivity() {

    private lateinit var binding : ActivityCrearCuentaBinding
    private val db = FirebaseFirestore.getInstance()

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
                Toast.makeText(this, "Registro completado",Toast.LENGTH_LONG).show()
                register()
            }

        }
    }


    private fun register(){
        if(binding.teCorreo.text != null && binding.tePass.text != null ){
            val correo = binding.teCorreo.text.toString()
            val pass =  binding.tePass.text.toString()
            val user = binding.teNombre.text.toString()
            val numberPhone = binding.teTelefono.text.toString()
            val description = "Usuario"

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(correo,
                pass).addOnCompleteListener{
                if(it.isSuccessful){
                    db.collection("users").document(correo).set(
                        hashMapOf("provider" to "BASIC",
                                "user" to user,
                                "phone" to numberPhone,
                                "description" to description
                            )
                    )
                    startActivity(Intent(this, LoginScreen::class.java))
                }
                else{
                    showAlert()
                }
            }
        }

    }

    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al registrar el usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog : AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome(email: String, provider: ProvidertType){
        val homeIntent = Intent(this, HomeActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }


}