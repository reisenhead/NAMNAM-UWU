package com.example.namnam_uwu.UI

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.namnam_uwu.Data.AddData
import com.example.namnam_uwu.R
import com.example.namnam_uwu.databinding.ActivityLoginScreenBinding
import com.example.namnam_uwu.utils.Utility
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginScreen : AppCompatActivity() {

    private lateinit var binding: ActivityLoginScreenBinding

    private val callbackManager = CallbackManager.Factory.create()

    private lateinit var boton: Button
    private lateinit var boton2: Button
    private lateinit var boton3: Button
    private lateinit var usuario: EditText
    private lateinit var contrasenia: EditText
    private lateinit var googleSignInClient: GoogleSignInClient

    //private val auth = Firebase.auth
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        FirebaseApp.initializeApp(this)


        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        auth = Firebase.auth

        boton = binding.btnInicio
        boton2 = binding.btnCrearC
        usuario = binding.teCorreo
        contrasenia = binding.tePass

        binding.btnGoogle.setOnClickListener {
            val signInIntent = googleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }

        binding.btnPhone.setOnClickListener {
            startActivity(Intent(this, PhoneActivity::class.java))
        }

        binding.btnFacebook.setOnClickListener {

            LoginManager.getInstance().logInWithReadPermissions(this, listOf("email"))

            LoginManager.getInstance().registerCallback(callbackManager,
            object : FacebookCallback<LoginResult>{
                override fun onSuccess(result: LoginResult?) {

                    result?.let {
                        val token : AccessToken = it.accessToken
                        val credential : AuthCredential = FacebookAuthProvider.getCredential(token.token)
                        FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener {
                            if (it.isSuccessful){
                                showHome(it.result?.user?.email?: "",ProvidertType.FACEBOOK)
                            }else{
                                showAlert()
                            }
                        }
                    }


                }
                override fun onCancel() {

                }
                override fun onError(error: FacebookException?) {
                    showAlert()
                }
            })
        }


        boton.setOnClickListener {
            login()
        }

        boton2.setOnClickListener {
            startActivity(Intent(this, CrearCuenta::class.java))
        }


    }

    private fun login() {
        val correo: String = binding.teCorreo.getText().toString()
        val pass: String = binding.tePass.getText().toString()

        when {
            correo.length == 0 && pass.length == 0 -> {
                Toast.makeText(this, "Los campos no pueden estar vacios", Toast.LENGTH_SHORT).show()
            }
            pass.length == 0 -> {
                Toast.makeText(this, "Debes ingresar una contraseña", Toast.LENGTH_SHORT).show()
            }
            correo.length == 0 -> {
                Toast.makeText(this, "Debes ingresar un correo", Toast.LENGTH_SHORT).show()
            }
            correo != "usuario@gmail.com" || pass != "1234" -> {
                if (binding.teCorreo.text != null && binding.tePass.text != null) {
                    val correo = binding.teCorreo.text.toString()
                    val pass = binding.tePass.text.toString()


                    if (correo == "admin" && pass == "admin") {
                        startActivity(Intent(this, AddData::class.java))
                    }

                    auth.signInWithEmailAndPassword(correo, pass).addOnCompleteListener(this) {
                        if (it.isSuccessful) {
                            showHome(it.result?.user?.email ?: "", ProvidertType.BASIC)
                        } else {
                            //Log.e("login", "Los datos de usuario son $correo y  $pass ")
                            showAlert()
                        }
                    }
                } else {
                    Toast.makeText(this, "Los campos no pueden estar vacios", Toast.LENGTH_LONG)
                        .show()

                }
                Toast.makeText(this, "Bienvenido a UWU", Toast.LENGTH_LONG).show()
            }
            correo == "usuario@gmail.com" && pass == "1234" -> {
                Toast.makeText(this, "Bienvenido de nuevo!!", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, HomeActivity::class.java))

            }

        }

    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome(email: String, provider: ProvidertType) {
        val homeIntent = Intent(this, HomeActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)

        }
        startActivity(homeIntent)
    }

    // Funciones nuevas
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        callbackManager.onActivityResult(requestCode,resultCode,data)
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e)
                Utility.displaySnackBar(binding.root, "Google sign in failed", this, R.color.red)
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")
                    val user = auth.currentUser
                    updateUI(user, null)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    updateUI(null, task.exception)
                }
            }
    }

    private fun updateUI(user: FirebaseUser?, exception: Exception?) {
        binding.btnGoogle.visibility = View.VISIBLE
        if (exception != null) {
            binding.loading.visibility = View.GONE
            binding.btnGoogle.visibility = View.VISIBLE
            Utility.displaySnackBar(binding.root, exception.message.toString(), this, R.color.red)
        } else {
            Utility.displaySnackBar(binding.root, "Login was successful: ", this, R.color.green)
            binding.loading.visibility = View.GONE
            binding.btnGoogle.visibility = View.VISIBLE
            //startActivity(Intent(this, HomeActivity::class.java))
            showHome(user!!.email ?: "", ProvidertType.GOOGLE)
            Toast.makeText(this, "Bienvenido a UWU", Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        private const val TAG = "GoogleActivity"
        private const val RC_SIGN_IN = 9001
    }

}