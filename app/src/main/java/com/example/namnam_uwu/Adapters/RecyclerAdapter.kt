package com.example.namnam_uwu.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.namnam_uwu.Models.Product
import com.example.namnam_uwu.R

class RecyclerAdapter(
    private val context: Context,
    private val products: MutableList<Product>,
    private val clickListener: (Product) -> Unit): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    //Aquí atamos el ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products.get(position)
        holder.bind(product, context)

        holder.view.setOnClickListener{clickListener(product)}

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_card, parent, false))
    }

    override fun getItemCount(): Int {
        return products.size
    }

    //El ViewHolder ata los datos del RecyclerView a la Vista para desplegar la información
    //También se encarga de gestionar los eventos de la View, como los clickListeners
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        //obteniendo las referencias a las Views
        val productName = view.findViewById(R.id.tvProduct) as TextView
        val restaurnat = view.findViewById(R.id.tvDescription) as TextView
        val distance = view.findViewById(R.id.tvQuantity) as TextView
        val image = view.findViewById(R.id.imgProduct) as ImageView
        val hour = view.findViewById(R.id.watch) as TextView
        val day = view.findViewById(R.id.day) as TextView
        val amount = view.findViewById(R.id.available) as TextView
        val preci= view.findViewById(R.id.tvPrice) as TextView
        val preciOld= view.findViewById(R.id.tvPriceOld) as TextView
        val star = view.findViewById(R.id.like) as TextView

        //"atando" los datos a las Views
        fun bind(product: Product, context: Context){
            productName.text = product.paquete
            restaurnat.text = product.restaurant
            distance.text = product.distance
            image.setImageResource(product.idImage)
            hour.text = product.hour
            amount.text = product.amount
            day.text = product.day
            preci.text = product.preci
            preciOld.text = product.preciOld
            star.text = product.star
        }
    }

}