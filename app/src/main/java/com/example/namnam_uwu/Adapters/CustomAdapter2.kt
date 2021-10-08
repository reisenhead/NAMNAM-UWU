package com.example.namnam_uwu.Adapters


import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.namnam_uwu.R
import com.example.namnam_uwu.UI.sizeOfProducts
import com.example.namnam_uwu.UI.*
import org.w3c.dom.Text
import java.text.FieldPosition

class CustomAdapter2 : RecyclerView.Adapter<CustomAdapter2.ViewHolder>(){

    val sizeProducts = sizeOfProducts

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick (position: Int)
        fun onImageAddClick (position: Int, button : ImageView , text : TextView , precioText: TextView)
        fun onImageDeleteClick (position: Int, button : ImageView , text : TextView , precioText: TextView)
        fun onStarSelected (position: Int, button : ImageView)
        fun onButtonSelected(position: Int, text : TextView, precioText: TextView)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v, mListener)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.productName.text = products.myProducts[i + num].tittle
        viewHolder.productDescription.text = products.myProducts[i + num].description
        viewHolder.itemImage.setImageResource(products.myProducts[i + num].image)
        viewHolder.priceText.text = products.myProducts[i + num].price.toString()
    }

    override fun getItemCount(): Int {
        return sizeProducts
    }

    inner class ViewHolder(itemView: View , listener: onItemClickListener): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var productName: TextView
        var plus: ImageView
        var delete: ImageView
        var productDescription: TextView
        var quantity: TextView
        var star : ImageView
        var buttonShopping : Button
        var priceText : TextView


        init{
            itemImage = itemView.findViewById(R.id.item_image)
            productName = itemView.findViewById(R.id.name_product)
            plus = itemView.findViewById(R.id.addButton)
            delete = itemView.findViewById(R.id.deleteButton)
            productDescription = itemView.findViewById(R.id.description_product)
            quantity = itemView.findViewById(R.id.quantityToAdd)
            star = itemView.findViewById(R.id.favoriteIcon)
            buttonShopping = itemView.findViewById(R.id.buttonShoppingCart)
            priceText = itemView.findViewById(R.id.precioText)


            itemView.setOnClickListener{
                listener.onItemClick(absoluteAdapterPosition)
            }

            plus.setOnClickListener{
                listener.onImageAddClick(absoluteAdapterPosition, plus, quantity,priceText)
            }

            delete.setOnClickListener{
                listener.onImageDeleteClick(absoluteAdapterPosition, delete , quantity,priceText)
            }

            star.setOnClickListener{
                listener.onStarSelected(absoluteAdapterPosition, star)
            }

            buttonShopping.setOnClickListener{
                listener.onButtonSelected(absoluteAdapterPosition, quantity, priceText)
            }

        }

    }
}