package com.example.namnam_uwu.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.namnam_uwu.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StarFragment : Fragment() {
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
    private lateinit var buttonpedido: Button
    private lateinit var buttonbreakfast: Button
    private lateinit var buttonbreakfastone: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_star, container, false)

        //funcionalidad del boton pedido
        buttonpedido = view.findViewById<Button>(R.id.buttonpedido)
        buttonpedido.setOnClickListener {
            val fr = fragmentManager?.beginTransaction()
            fr!!.setCustomAnimations(R.anim.left_in,0,0, R.anim.left_out)
            fr?.replace(R.id.fragment_container, MyOrderFragment())
            fr?.commit()
        }

        //funcionalidad del boton pedido
        buttonbreakfast = view.findViewById<Button>(R.id.buttonbreakfast)
        buttonbreakfast.setOnClickListener {
            val fr = fragmentManager?.beginTransaction()
            fr!!.setCustomAnimations(R.anim.left_in,0,0, R.anim.left_out)
            fr?.replace(R.id.fragment_container, BreakFastFragment())
            fr?.commit()
        }
        //funcionalidad del boton carvie
        buttonbreakfastone = view.findViewById<Button>(R.id.buttonStarRest)
        buttonbreakfastone.setOnClickListener {
            val fr = fragmentManager?.beginTransaction()
            fr!!.setCustomAnimations(R.anim.left_in,0,0, R.anim.left_out)
            fr?.replace(R.id.fragment_container, MyOrderFragment())
            fr?.commit()
        }

        return view
    }

    fun changeFragment(fragment: Fragment){
        var fr = getFragmentManager()?.beginTransaction()
        fr?.replace(R.id.fragment_container, fragment)
        fr?.commit()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StarFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}