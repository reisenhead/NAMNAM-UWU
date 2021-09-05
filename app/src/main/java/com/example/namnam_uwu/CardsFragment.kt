package com.example.namnam_uwu

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_home.view.*


class CardsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        // seteando el appbar como action bar
        //val appBar = view.findViewById<Toolbar>(R.id.app_bar)


        setUpRecyclerView(view)
        return view
    }



    private fun getProducts(): MutableList<Product>{
        var products:MutableList<Product> = ArrayList()

        products.add(Product("Jugo buena digestión", "Amamba", "2",4.6f,R.drawable.amamba1))
        products.add(Product("Coctel de Frutas", "Amamba", "2",4.6f,R.drawable.amamba2))
        products.add(Product("Paquete Coctel", "Amamba", "2",4.6f,R.drawable.amamba3))
        products.add(Product("Paquet Fruta", "Amamba", "2",4.6f,R.drawable.amamba4))
        products.add(Product("Molletes", "Amamba", "2",4.6f,R.drawable.amamba5))
        products.add(Product("Jugo buena digestión", "Amamba", "2",4.6f,R.drawable.cachito1))
        products.add(Product("Coctel de Frutas", "Amamba", "2",4.6f,R.drawable.cachito2))
        products.add(Product("Paquete Coctel", "Amamba", "2",4.6f,R.drawable.cachito3))
        products.add(Product("Paquet Fruta", "Amamba", "2",4.6f,R.drawable.cachito4))
        products.add(Product("Molletes", "Amamba", "2",4.6f,R.drawable.cachito5))
        products.add(Product("Jugo buena digestión", "Amamba", "2",4.6f,R.drawable.docena1))
        products.add(Product("Coctel de Frutas", "Amamba", "2",4.6f,R.drawable.docena2))
        products.add(Product("Paquete Coctel", "Amamba", "2",4.6f,R.drawable.docena3))
        products.add(Product("Paquet Fruta", "Amamba", "2",4.6f,R.drawable.docena4))
        products.add(Product("Molletes", "Amamba", "2",4.6f,R.drawable.docena5))
        products.add(Product("Jugo buena digestión", "Amamba", "2",4.6f,R.drawable.forever1))
        products.add(Product("Coctel de Frutas", "Amamba", "2",4.6f,R.drawable.forever2))
        products.add(Product("Paquete Coctel", "Amamba", "2",4.6f,R.drawable.forever3))
        products.add(Product("Paquet Fruta", "Amamba", "2",4.6f,R.drawable.forever4))
        products.add(Product("Molletes", "Amamba", "2",4.6f,R.drawable.forever5))
        products.add(Product("Jugo buena digestión", "Amamba", "2",4.6f,R.drawable.forte1))
        products.add(Product("Coctel de Frutas", "Amamba", "2",4.6f,R.drawable.forte2))
        products.add(Product("Paquete Coctel", "Amamba", "2",4.6f,R.drawable.forte3))
        products.add(Product("Paquet Fruta", "Amamba", "2",4.6f,R.drawable.forte4))
        products.add(Product("Molletes", "Amamba", "2",4.6f,R.drawable.forte5))
        products.add(Product("Molletes", "Amamba", "2",4.6f,R.drawable.forte6))
        products.add(Product("Jugo buena digestión", "Amamba", "2",4.6f,R.drawable.greeng1))
        products.add(Product("Coctel de Frutas", "Amamba", "2",4.6f,R.drawable.greeng2))
        products.add(Product("Paquete Coctel", "Amamba", "2",4.6f,R.drawable.greeng3))
        products.add(Product("Paquet Fruta", "Amamba", "2",4.6f,R.drawable.greeng4))
        products.add(Product("Molletes", "Amamba", "2",4.6f,R.drawable.greeng5))
        products.add(Product("Jugo buena digestión", "Amamba", "2",4.6f,R.drawable.loosers1))
        products.add(Product("Coctel de Frutas", "Amamba", "2",4.6f,R.drawable.loosers2))
        products.add(Product("Paquete Coctel", "Amamba", "2",4.6f,R.drawable.loosers3))
        products.add(Product("Paquet Fruta", "Amamba", "2",4.6f,R.drawable.loosers4))
        products.add(Product("Molletes", "Amamba", "2",4.6f,R.drawable.loosers5))
        products.add(Product("Jugo buena digestión", "Amamba", "2",4.6f,R.drawable.pitahaya1))
        products.add(Product("Coctel de Frutas", "Amamba", "2",4.6f,R.drawable.pitahaya2))
        products.add(Product("Paquete Coctel", "Amamba", "2",4.6f,R.drawable.pitahaya3))
        products.add(Product("Paquet Fruta", "Amamba", "2",4.6f,R.drawable.pitahaya4))
        products.add(Product("Molletes", "Amamba", "2",4.6f,R.drawable.pitahaya5))
        products.add(Product("Jugo buena digestión", "Amamba", "2",4.6f,R.drawable.ramen1))
        products.add(Product("Coctel de Frutas", "Amamba", "2",4.6f,R.drawable.ramen2))
        products.add(Product("Paquete Coctel", "Amamba", "2",4.6f,R.drawable.ramen3))
        products.add(Product("Paquet Fruta", "Amamba", "2",4.6f,R.drawable.ramen4))
        products.add(Product("Molletes", "Amamba", "2",4.6f,R.drawable.ramen5))
        products.add(Product("Jugo buena digestión", "Amamba", "2",4.6f,R.drawable.soul1))
        products.add(Product("Coctel de Frutas", "Amamba", "2",4.6f,R.drawable.soul2))
        products.add(Product("Paquete Coctel", "Amamba", "2",4.6f,R.drawable.soul3))
        products.add(Product("Paquet Fruta", "Amamba", "2",4.6f,R.drawable.soul4))
        products.add(Product("Molletes", "Amamba", "2",4.6f,R.drawable.soul5))
        products.add(Product("Manzanas", "10ma Generación", "12",4.4f,R.drawable.breakfast))
        products.add(Product("Platillo de Brochetas", "Disponible Prime", "1",3.8f,R.drawable.brochetas))
        products.add(Product("Coctel de Frutas", "Noise Cancelling", "5",4.8f,R.drawable.macarrones))
        products.add(Product("Verduras y Frutas", "Noise Cancelling", "5",4.8f,R.drawable.postre))
        products.add(Product("Verduras y Frutas", "Noise Cancelling", "5",4.8f,R.drawable.espaguetigi))
        return products
    }

    private fun setUpRecyclerView(view: View){
        val recyclerProducts = view.recyclerProducts
        recyclerProducts.setHasFixedSize(true)
        recyclerProducts.layoutManager = GridLayoutManager(
            activity,
            1,
            GridLayoutManager.VERTICAL,
            false
        )

        val largePadding = resources.getDimensionPixelSize(R.dimen.product_grid_spacing)
        val smallPadding = resources.getDimensionPixelSize(R.dimen.product_grid_spacing_small)
        recyclerProducts.addItemDecoration(GridDecoration(largePadding, smallPadding))

        //seteando el Adapter
        recyclerProducts.adapter = RecyclerAdapter( requireActivity(), getProducts(),clickListener = {

        })
    }

}