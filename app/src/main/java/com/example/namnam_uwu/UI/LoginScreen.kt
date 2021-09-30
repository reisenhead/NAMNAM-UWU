package com.example.namnam_uwu.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.namnam_uwu.Data.AddData
import com.example.namnam_uwu.databinding.ActivityLoginScreenBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginScreen : AppCompatActivity() {

    private lateinit var binding : ActivityLoginScreenBinding

    private lateinit var boton: Button
    private lateinit var boton2: Button
    private lateinit var usuario: EditText
    private lateinit var contrasenia: EditText

    private val auth = Firebase.auth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        boton = binding.btnInicio
        boton2 = binding.btnCrearC
        usuario = binding.teCorreo
        contrasenia = binding.tePass


        boton.setOnClickListener{
            login()
        }
        boton2.setOnClickListener{
            startActivity(Intent(this, CrearCuenta::class.java))
        }


    }

    private fun login(){
        if(binding.teCorreo.text != null && binding.tePass.text != null){
            val correo = binding.teCorreo.text.toString()
            val pass = binding.tePass.text.toString()
            if(correo == "admin" && pass == "admin"){
                startActivity(Intent(this,AddData::class.java))
            }

            auth.signInWithEmailAndPassword(correo,pass).addOnCompleteListener(this){
                    if(it.isSuccessful){
                        showHome(it.result?.user?.email ?: "" , ProvidertType.BASIC)
                    }
                    else{
                        //Log.e("login", "Los datos de usuario son $correo y  $pass ")
                        showAlert()
                    }
            }
        }
        else{
            Toast.makeText(this,"Los campos no pueden estar vacios", Toast.LENGTH_LONG).show()
        }
    }

    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
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