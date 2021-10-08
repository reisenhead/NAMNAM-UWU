package com.example.namnam_uwu.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.namnam_uwu.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PaymentMethodsFragment : Fragment() {
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
    private lateinit var buttonaddcard: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_metodosde_pago, container, false)
        //funcionalidad del boton agregar tarjeta
        buttonaddcard = view.findViewById<Button>(R.id.buttonadd1)
        buttonaddcard.setOnClickListener {
            val fr = fragmentManager?.beginTransaction()
            fr!!.setCustomAnimations(R.anim.left_in,0,0, R.anim.left_out)
            fr?.replace(R.id.fragment_container, AddCarFragment())
            fr?.commit()
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
         * @return A new instance of fragment MetodosdePagoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PaymentMethodsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}