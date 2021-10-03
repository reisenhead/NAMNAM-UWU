package com.example.namnam_uwu.Fragments

import android.graphics.Color
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
import com.example.namnam_uwu.Controller.*
import com.example.namnam_uwu.R
import com.example.namnam_uwu.Adapters.CustomAdapter2
import com.example.namnam_uwu.Adapters.GridDecoration
import com.example.namnam_uwu.UI.*
import kotlinx.android.synthetic.main.card_layout.*
import kotlinx.android.synthetic.main.card_layout.view.*
import kotlinx.android.synthetic.main.fragment_product.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProductFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var  productFragmentTittle : TextView


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
        val view = inflater.inflate(R.layout.fragment_product, container, false)

        productFragmentTittle = view.productsFragment
        productFragmentTittle.text = titles[positionE]

        val recyclerView2 = view.findViewById<RecyclerView>(R.id.recyclerView2)
        val adapter = CustomAdapter2()


        view.recyclerView2.layoutManager = LinearLayoutManager(activity)
        recyclerView2.adapter = adapter
        val largePadding = resources.getDimensionPixelSize(R.dimen.product_grid_spacing)
        val smallPadding = resources.getDimensionPixelSize(R.dimen.product_grid_spacing_small)
        recyclerView2.addItemDecoration(GridDecoration(largePadding, smallPadding))

        var boolStar = true

        adapter.setOnItemClickListener(object : CustomAdapter2.onItemClickListener{
            override fun onItemClick(position: Int) {

            }

            override fun onImageAddClick(position: Int, button: ImageView, text: TextView, precioText: TextView) {
                var aux1  = text.text.toString().toInt()
                aux1 += 1
                text.text = "$aux1"
                precioText.setText("${aux1.toFloat() * products.myProducts[position + num].price}" )
            }

            override fun onImageDeleteClick(position: Int, button: ImageView, text: TextView, precioText: TextView) {
                var aux1  = text.text.toString().toInt()
                if(aux1 > 0)
                    aux1 -= 1
                text.text = "$aux1"
                precioText.setText("${aux1.toFloat() * products.myProducts[position + num].price}" )
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
                        if(products.myProducts[position + num].id == favorite.id){
                            products.myFavorites.removeAt(i)
                            Toast.makeText(activity, "Se ha desagregado de favoritos", Toast.LENGTH_SHORT).show()
                        }
                        i+=1
                    }


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
                        if(products.myProducts[position + num].id.toString().toInt() == favorite.id.toString().toInt()){
                            aux2 = true
                        }
                    }
                    if(!aux2){
                        val aux3 = products.myProducts[position + num]
                        products.myFavorites.add(aux3)
                        Toast.makeText(activity, "Se ha agregado a favoritos", Toast.LENGTH_SHORT).show()
                    }


                    boolStar = false
                }
            }

            override fun onButtonSelected(position: Int, text: TextView, precioText: TextView) {
                var aux1 = text.text.toString().toInt()
                var aux2 = products.myProducts[position + num]
                aux2.quantity += aux1
                products.addProduct(aux2)
                text.text = "1"
                precioText.setText("${products.myProducts[position + num].price}")
            }


        })



        return view
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProductFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProductFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}