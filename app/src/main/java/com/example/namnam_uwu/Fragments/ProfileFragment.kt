package com.example.namnam_uwu.Fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.media.session.PlaybackStateCompat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationSet
import android.widget.Button
import android.widget.TextView
import com.example.namnam_uwu.R
import com.example.namnam_uwu.UI.LoginScreen
import com.example.namnam_uwu.UI.email
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import de.hdodenhof.circleimageview.CircleImageView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    private lateinit var buttonone: Button
    private lateinit var buttoncupon: Button
    private lateinit var buttonterminos: Button
    private lateinit var buttonayuda: Button
    private lateinit var buttoncerrar: Button

    private lateinit var user: TextView
    private lateinit var description: TextView
    private lateinit var correo: TextView
    private lateinit var imageProfile: CircleImageView

    private val db = FirebaseFirestore.getInstance()
    private val dbGoogle = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_profile, container, false)

        buttonone = view.findViewById<Button>(R.id.button4)
        buttoncupon = view.findViewById<Button>(R.id.button5)
        buttonterminos = view.findViewById<Button>(R.id.button3)
        buttonayuda = view.findViewById<Button>(R.id.button6)
        buttoncerrar = view.findViewById<Button>(R.id.button7)
        user = view.findViewById(R.id.username)
        description = view.findViewById(R.id.tvDescription)
        correo = view.findViewById(R.id.tvCorreo)
        imageProfile = view.findViewById(R.id.profile_image)


        //Recuperamos los datos del usuario
        db.collection("users").document(email).get().addOnSuccessListener {
            user.text = it.get("user") as String?
            if(it.get("description") != null)
                description.text = it.get("description") as String?
            correo.text = email
        }

        dbGoogle.collection("users").document(email).get().addOnSuccessListener {
            user.text = it.get("user") as String?
            if(it.get("description") != null)
                description.text = it.get("description") as String?
            correo.text = email
        }

        buttonone.setOnClickListener {
            val fr = fragmentManager?.beginTransaction()
            fr!!.setCustomAnimations(R.anim.left_in,0,0, R.anim.left_out)
            fr?.replace(R.id.fragment_container, PaymentMethodsFragment())
            fr?.commit()
        }
        buttoncupon.setOnClickListener {
            val fr = fragmentManager?.beginTransaction()
            fr!!.setCustomAnimations(R.anim.left_in,0,0, R.anim.left_out)
            fr?.replace(R.id.fragment_container, CouponsFragment())
            fr?.commit()
        }
        buttonterminos.setOnClickListener {
            val fr = fragmentManager?.beginTransaction()
            fr!!.setCustomAnimations(R.anim.left_in,0,0, R.anim.left_out)
            fr?.replace(R.id.fragment_container, TermsandConditionsFragment())
            fr?.commit()
        }
        buttonayuda.setOnClickListener {
            val fr = fragmentManager?.beginTransaction()
            fr!!.setCustomAnimations(R.anim.left_in,0,0, R.anim.left_out)
            fr?.replace(R.id.fragment_container, HelpFragment())
            fr?.commit()
        }
        buttoncerrar.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(context, LoginScreen::class.java))
        }

        return view
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}