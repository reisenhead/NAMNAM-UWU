package com.example.namnam_uwu
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.namnam_uwu.fragments.HomeFragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_home.*
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

        products.add(Product("Break", "Disponible el 20 de noviembre", "2",4.6f,R.drawable.breakfast))
        products.add(Product("Manzanas", "10ma Generación", "12",4.4f,R.drawable.breakfast))
        products.add(Product("Platillo de Brochetas", "Disponible Prime", "1",3.8f,R.drawable.breakfast))
        products.add(Product("Coctel de Frutas", "Noise Cancelling", "5",4.8f,R.drawable.breakfast))
        products.add(Product("Verduras y Frutas", "Noise Cancelling", "5",4.8f,R.drawable.breakfast))
        products.add(Product("Platillo de Queso", "Noise Cancelling", "2",4.8f,R.drawable.breakfast))
        products.add(Product("Hot Dog", "Noise Cancelling", "3",4.8f,R.drawable.breakfast))
        products.add(Product("Legumbres", "Noise Cancelling", "4",4.8f,R.drawable.breakfast))
        products.add(Product("Sueter", "Noise Cancelling", "1",4.8f,R.drawable.breakfast))
        products.add(Product("Atuendo", "Noise Cancelling", "1",4.8f,R.drawable.breakfast))
        products.add(Product("Ropa Deportiva", "Noise Cancelling", "2",4.8f,R.drawable.breakfast))

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