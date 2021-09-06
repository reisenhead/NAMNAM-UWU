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

        products.add(Product("Jugo buena digestión",    "Amamba",               "10",   "9:00-18:00",       "Mañana:",  "5",    "",R.drawable.amamba1))
        products.add(Product("Coctel de Frutas",        "Amamba",               "2",    "10:00-20:00",      "5",        "9",    "",R.drawable.amamba2))
        products.add(Product("Paquete Coctel",          "Amamba",               "4",    "9:00-18:00",       "",         "2",    "",R.drawable.amamba3))
        products.add(Product("Paquet Fruta",            "Amamba",               "5",    "10:00-20:00",      "",         "4",    "3",R.drawable.amamba4))
        products.add(Product("Molletes",                "Amamba",               "3",    "10:00-20:00",      "",         "4",    "",R.drawable.amamba5))
        products.add(Product("Jugo buena digestión",    "Cachito mío",          "8",    "9:00-18:00",       "",         "3",    "",R.drawable.cachito1))
        products.add(Product("Coctel de Frutas",        "Cachito mío",          "9",    "9:00-18:00",       "",         "3",    "",R.drawable.cachito2))
        products.add(Product("Paquete Coctel",          "Cachito mío",          "4",    "9:00-18:00",       "",         "6",    "",R.drawable.cachito3))
        products.add(Product("Paquet Fruta",            "Cachito mío",          "11",   "10:00-20:00",      "",         "",     "",R.drawable.cachito4))
        products.add(Product("Molletes",                "Cachito mío",          "12",   "10:00-20:00",      "",         "",     "",R.drawable.cachito5))
        products.add(Product("Jugo buena digestión",    "La Docena",            "3",    "10:00-20:00",      "",         "",     "",R.drawable.docena1))
        products.add(Product("Coctel de Frutas",        "La Docena",            "4",    "10:00-20:00",      "",         "",     "",R.drawable.docena2))
        products.add(Product("Paquete Coctel",          "La Docena",            "2",    "10:00-20:00",      "",         "",     "",R.drawable.docena3))
        products.add(Product("Paquet Fruta",            "La Docena",            "2",    "9:00-18:00",       "",         "",     "",R.drawable.docena4))
        products.add(Product("Molletes",                "La Docena",            "2",    "10:00-20:00",      "",         "",     "",R.drawable.docena5))
        products.add(Product("Jugo buena digestión",    "Forever",              "2",    "12:00-20:00",      "",         "",     "",R.drawable.forever1))
        products.add(Product("Coctel de Frutas",        "Forever",              "2",    "9:00-18:00",       "",         "",     "",R.drawable.forever2))
        products.add(Product("Paquete Coctel",          "Forever",              "2",    "9:00-18:00",       "",         "",     "",R.drawable.forever3))
        products.add(Product("Paquet Fruta",            "Forever",              "2",    "9:00-18:00",       "",         "",     "",R.drawable.forever4))
        products.add(Product("Molletes",                "Forever",              "2",    "9:00-18:00",       "",         "",     "",R.drawable.forever5))
        products.add(Product("Jugo buena digestión",    "Forte",                "2",    "12:00-20:00",      "",         "",     "",R.drawable.forte1))
        products.add(Product("Coctel de Frutas",        "Forte",                "2",    "9:00-18:00",       "",         "",     "",R.drawable.forte2))
        products.add(Product("Paquete Coctel",          "Forte",                "2",    "9:00-18:00",       "",         "",     "",R.drawable.forte3))
        products.add(Product("Paquet Fruta",            "Forte",                "2",    "9:00-18:00",       "",         "",     "",R.drawable.forte4))
        products.add(Product("Molletes",                "Forte",                "2",    "12:00-20:00",      "",         "",     "",R.drawable.forte5))
        products.add(Product("Molletes",                "Forte",                "2",    "9:00-18:00",       "",         "",     "",R.drawable.forte6))
        products.add(Product("Jugo buena digestión",    "Green Grass",          "2",    "9:00-18:00",       "",         "",     "",R.drawable.greeng1))
        products.add(Product("Coctel de Frutas",        "Green Grass\"",        "2",    "9:00-18:00",       "",         "",     "",R.drawable.greeng2))
        products.add(Product("Paquete Coctel",          "Green Grass\"",        "2",    "9:00-18:00",       "",         "",     "",R.drawable.greeng3))
        products.add(Product("Paquet Fruta",            "Green Grass\"",        "2",    "12:00-20:00",      "",         "",     "",R.drawable.greeng4))
        products.add(Product("Molletes",                "Green Grass\"",        "2",    "9:00-18:00\"",                 "",         "",     "",R.drawable.greeng5))
        products.add(Product("Jugo buena digestión",    "Los loosers",          "2",    "9:00-18:00\"",                 "",         "",     "",R.drawable.loosers1))
        products.add(Product("Coctel de Frutas",        "Los loosers",          "2",    "9:00-18:00\"",                 "",         "",     "",R.drawable.loosers2))
        products.add(Product("Paquete Coctel",          "Los loosers",          "2",    "12:00-20:00",                 "",         "",     "",R.drawable.loosers3))
        products.add(Product("Paquet Fruta",            "Los loosers",          "2",    "9:00-18:00\"",                 "",         "",     "",R.drawable.loosers4))
        products.add(Product("Molletes",                "Los loosers",          "2",    "9:00-18:00\"",                 "",         "",     "",R.drawable.loosers5))
        products.add(Product("Jugo buena digestión",    "La Pitahaya",          "2",    "12:00-20:00",                 "",         "",     "",R.drawable.pitahaya1))
        products.add(Product("Coctel de Frutas",        "La Pitahaya",          "2",    "9:00-18:00\"",                 "",         "",     "",R.drawable.pitahaya2))
        products.add(Product("Paquete Coctel",          "La Pitahaya",          "2",    "9:00-18:00\"",                 "",         "",     "",R.drawable.pitahaya3))
        products.add(Product("Paquet Fruta",            "La Pitahaya",          "2",    "12:00-20:00",                 "",         "",     "",R.drawable.pitahaya4))
        products.add(Product("Molletes",                "La Pitahaya",          "2",    "9:00-18:00\"",                 "",         "",     "",R.drawable.pitahaya5))
        products.add(Product("Jugo buena digestión",    "Ramen Bar",            "2",    "9:00-18:00\"",                 "",         "",     "",R.drawable.ramen1))
        products.add(Product("Coctel de Frutas",        "Ramen Bar",            "2",    "12:00-20:00",      "",         "",     "",R.drawable.ramen2))
        products.add(Product("Paquete Coctel",          "Ramen Bar",            "2",    "9:00-18:00\"",                 "",         "",     "",R.drawable.ramen3))
        products.add(Product("Paquet Fruta",            "Ramen Bar",            "2",    "9:00-18:00\"",                 "",         "",     "",R.drawable.ramen4))
        products.add(Product("Molletes",                "Ramen Bar",            "2",    "",                 "",         "",     "",R.drawable.ramen5))
        products.add(Product("Jugo buena digestión",    "Soul la Roma",         "2",    "12:00-20:00",                 "",         "",     "",R.drawable.soul1))
        products.add(Product("Coctel de Frutas",        "Soul la Roma",         "2",    "",                 "",         "",     "",R.drawable.soul2))
        products.add(Product("Paquete Coctel",          "Soul la Roma",         "2",    "",                 "",         "",     "",R.drawable.soul3))
        products.add(Product("Paquet Fruta",            "Soul la Roma",         "2",    "",                 "",         "",     "",R.drawable.soul4))
        products.add(Product("Molletes",                "Soul la Roma",         "2",    "",                 "",         "",     "",R.drawable.soul5))
        products.add(Product("Manzanas",                "Azul Roma",            "12",   "12:00-20:00",                 "",         "",     "",R.drawable.breakfast))
        products.add(Product("Platillo de Brochetas",   "Azul Roma",            "1",    "",                 "",         "",     "",R.drawable.brochetas))
        products.add(Product("Coctel de Frutas",        "Azul Roma",            "5",    "12:00-20:00",                 "",         "",     "",R.drawable.macarrones))
        products.add(Product("Verduras y Frutas",       "Azul Roma",            "5",    "",                 "",         "",     "",R.drawable.postre))
        products.add(Product("Verduras y Frutas",       "Azul Roma",            "5",    "",                 "",         "",     "",R.drawable.espagueti))
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