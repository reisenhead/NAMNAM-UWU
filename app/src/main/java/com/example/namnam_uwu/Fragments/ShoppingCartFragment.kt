package com.example.namnam_uwu.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ccom.example.namnam_uwu.Adapters.CustomAdapter3
import com.example.namnam_uwu.R
import com.example.namnam_uwu.Controller.RegisterProduct
import com.example.namnam_uwu.Controller.Product
import com.example.namnam_uwu.UI.products
import kotlinx.android.synthetic.main.card_layout.view.*
import kotlinx.android.synthetic.main.fragment_product.view.*
import kotlinx.android.synthetic.main.fragment_shopping_cart.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShoppingCartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoppingCartFragment : Fragment() {
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_shopping_cart, container, false)

        var totalPrice = view.precio
        totalPrice.setText("${products.getTotalPrice()}")

        var buttonComprar = view.buttonComprar

        buttonComprar.setOnClickListener {
            products.myShippings.addAll(products.myShoppingCart)
            products.myShoppingCart.clear()
            changeFragment(ShoppingCartFragment())
            Toast.makeText(activity, "Se ha hecho la compra con exito", Toast.LENGTH_SHORT).show()
        }

        if(products.myShoppingCart.size > 0){
            val recyclerView3 = view.findViewById<RecyclerView>(R.id.recyclerView3)
            val adapter = CustomAdapter3()

            view.recyclerView3.layoutManager = LinearLayoutManager(activity)

            recyclerView3.adapter = adapter

            var boolStar = true

            adapter.setOnItemClickListener(object : CustomAdapter3.onItemClickListener{
                override fun onItemClick(position: Int) {

                }

                override fun onImageAddClick(position: Int, button: ImageView, text: TextView, precioText: TextView) {
                    var aux1  = text.text.toString().toInt()
                    aux1 += 1

                    text.text = "$aux1"
                    products.myShoppingCart[position].quantity = aux1
                    precioText.setText("${aux1.toFloat() * products.myShoppingCart[position].price}" )
                    totalPrice.setText("${products.getTotalPrice()}")
                }

                override fun onImageDeleteClick(position: Int, button: ImageView, text: TextView, precioText: TextView) {
                    var aux1  = text.text.toString().toInt()
                    if(aux1 > 0)
                        aux1 -= 1
                    products.myShoppingCart[position].quantity = aux1
                    text.text = "$aux1"

                    precioText.setText("${aux1.toFloat() * products.myShoppingCart[position].price}" )
                    totalPrice.setText("${products.getTotalPrice()}")
                }

                override fun onStarSelected(position: Int, button: ImageView) {
                    if(!boolStar){
                        getContext()?.getResources()?.getColor(R.color.auxiliarColor1)?.let {
                            button.setColorFilter(
                                it
                            )
                        };

                        var i = 0
                        for(favorite in products.myFavorites){
                            if(products.myShoppingCart[position].id == favorite.id){
                                products.myFavorites.removeAt(i)
                            }
                            i+=1
                        }

                        Toast.makeText(activity, "Se ha desagregado de favoritos", Toast.LENGTH_SHORT).show()
                        boolStar = true
                    }
                    else{
                        getContext()?.getResources()?.getColor(R.color.auxiliarColor2)?.let {
                            button.setColorFilter(
                                it
                            )
                        };

                        var aux2 = false
                        for(favorite in products.myFavorites){
                            if(products.myShoppingCart[position].id.toString().toInt() == favorite.id.toString().toInt()){
                                aux2 = true
                            }
                        }
                        if(!aux2){
                            val aux3 = products.myShoppingCart[position]
                            products.myFavorites.add(aux3)
                        }

                        Toast.makeText(activity, "Se ha agregado a favoritos", Toast.LENGTH_SHORT).show()
                        boolStar = false
                    }
                }

                override fun onButtonSelected(position: Int, text: TextView) {
                    products.myShoppingCart.removeAt(position)
                    changeFragment(ShoppingCartFragment())
                }


            })
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
         * @return A new instance of fragment ShoppingCartFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShoppingCartFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}