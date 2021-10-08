package com.example.namnam_uwu.Controller

import com.example.namnam_uwu.R
import com.example.namnam_uwu.Controller.*


class RegisterProduct {

    val amamba = ProductGroup(1, "Amamba", R.drawable.icon_amamba)
    val cachito = ProductGroup(2, "Cachito Mío", R.drawable.cachitomio)
    val forever = ProductGroup(3,"Forever", R.drawable.icon_forever)
    val forte = ProductGroup(4,"Forte", R.drawable.icon_forte)
    val greengrass = ProductGroup(5,"Green Grass", R.drawable.icon_greengrass)
    val ladocena = ProductGroup(6,"La Docena", R.drawable.icon_docena)
    val pitahaya = ProductGroup(7,"La Pitahaya Vegana", R.drawable.icon_pitahaya)
    val loosers = ProductGroup(8,"Los Loosers", R.drawable.icon_loosers)
    val ramenbar = ProductGroup(9,"Ramen Bar", R.drawable.icon_ramenbar)
    val soul = ProductGroup(10,"Soul La Roma", R.drawable.icon_soul)

    //AMAMBA
    val a_paquete1= Product(11,"Paquete Coctel", "Amamba", R.drawable.amamba3 , 35.00f, 0)
    val a_paquete2 = Product(12,"Jugo buena digestión", "Amamba", R.drawable.amamba1 , 40.00f,0)
    val a_paquete3= Product(13,"Coctel de Frutas", "Amamba", R.drawable.amamba2, 40.00f,0)
    val a_paquete4= Product(14,"Paquete Fruta", "Amamba", R.drawable.amamba4 , 40.90f, 0)
    val a_paquete5= Product(15,"Molletes", "Amamba", R.drawable.amamba5 , 38.90f, 0)

    //Cachito Mío
    val c_paquete1= Product(21,"Postre pastel", "Cachito Mío", R.drawable.cachito1 , 35.50f,0)
    val c_paquete2= Product(22,"Pizza", "Cachito Mío", R.drawable.cachito2 , 35.50f, 0)
    val c_paquete3= Product(23,"Paquete Postre", "Cachito Mío", R.drawable.cachito3 , 25.00f,0)
    val c_paquete4= Product(24,"Paquet Poste ", "Cachito Mío", R.drawable.cachito4 , 19.50f, 0)
    val c_paquete5= Product(25,"Pastel ", "Cachito Mío", R.drawable.cachito5 , 19.50f, 0)

    //Forever
    val f_paquete1= Product(31,"Paquete", "Forever", R.drawable.forever1 , 35.50f, 0)
    val f_paquete2= Product(32,"Coctel de Frutas", "Forever", R.drawable.forever2 , 25.90f,0 )
    val f_paquete3= Product(33,"Paquete Coctel", "Forever", R.drawable.forever3 , 25.90f, 0)
    val f_paquete4= Product(34,"Paquet Fruta", "Forever", R.drawable.forever4 , 38.90f, 0)
    val f_paquete5= Product(35,"Molletes", "Forever", R.drawable.forever5 , 38.90f, 0)

    //Forte
    val fo_paquete1= Product(41,"Paquete", "Forte", R.drawable.forte1 , 129.90f, 0)
    val fo_paquete2= Product(42,"Paquete", "Forte", R.drawable.forte2 , 159.00f,0 )
    val fo_paquete3= Product(43,"Paquete", "Forte", R.drawable.forte3 , 159.00f, 0)
    val fo_paquete4= Product(44,"Paquete", "Forte", R.drawable.forte4 , 120.00f, 0)
    val fo_paquete5= Product(45,"Paquete", "Forte", R.drawable.forte5 , 120.00f, 0)

    //Green Grass
    val g_paquete1= Product(51,"Paquete", "Green Grass", R.drawable.greeng1 , 129.90f, 0)
    val g_paquete2= Product(52,"Paquete", "Green Grass", R.drawable.greeng2 , 159.00f,0 )
    val g_paquete3= Product(53,"Paquete", "Green Grass", R.drawable.greeng3, 159.00f, 0)
    val g_paquete4= Product(54,"Paquete", "Green Grass", R.drawable.greeng4 , 120.00f, 0)
    val g_paquete5= Product(55,"Paquete", "Green Grass", R.drawable.greeng5 , 120.00f, 0)

    //La Docena
    val d_paquete1= Product(61,"Paquete one", "La Docena", R.drawable.docena1 , 129.90f, 0)
    val d_paquete2= Product(62,"Paquete", "La Docena", R.drawable.docena2 , 159.00f,0 )
    val d_paquete3= Product(63,"Paquete", "La Docena", R.drawable.docena3, 159.00f, 0)
    val d_paquete4= Product(64,"Paquete", "La Docena", R.drawable.docena4 , 120.00f, 0)
    val d_paquete5= Product(65,"Paquete", "La Docena", R.drawable.docena5 , 120.00f, 0)

    //La Pitahaya Vegana
    val p_paquete1= Product(71,"Paquete one", "La Pitahaya Vegana", R.drawable.pitahaya1 , 129.90f, 0)
    val p_paquete2= Product(72,"Paquete", "La Pitahaya Vegana", R.drawable.pitahaya2 , 159.00f,0 )
    val p_paquete3= Product(73,"Paquete", "La Pitahaya Vegana", R.drawable.pitahaya3, 159.00f, 0)
    val p_paquete4= Product(74,"Paquete", "La Pitahaya Vegana", R.drawable.pitahaya4 , 120.00f, 0)
    val p_paquete5= Product(75,"Paquete", "La Pitahaya Vegana", R.drawable.pitahaya5 , 120.00f, 0)

    //Los Loosers
    val l_paquete1= Product(81,"Paquete one", "Los Loosers", R.drawable.loosers1 , 129.90f, 0)
    val l_paquete2= Product(82,"Paquete", "Los Loosers", R.drawable.loosers2 , 159.00f,0 )
    val l_paquete3= Product(83,"Paquete", "Los Loosers", R.drawable.loosers3, 159.00f, 0)
    val l_paquete4= Product(84,"Paquete", "Los Loosers", R.drawable.loosers4 , 120.00f, 0)
    val l_paquete5= Product(85,"Paquete", "Los Loosers", R.drawable.loosers5 , 120.00f, 0)

    //Ramen Bar
    val r_paquete1= Product(91,"Paquete one", "Ramen Bar", R.drawable.ramen1 , 129.90f, 0)
    val r_paquete2= Product(92,"Paquete", "Ramen Bar", R.drawable.ramen2 , 159.00f,0 )
    val r_paquete3= Product(93,"Paquete", "Ramen Bars", R.drawable.ramen3, 159.00f, 0)
    val r_paquete4= Product(94,"Paquete", "Ramen Bar", R.drawable.ramen4 , 120.00f, 0)
    val r_paquete5= Product(95,"Paquete", "Ramen Bar", R.drawable.ramen5 , 120.00f, 0)

    //Soul La Roma
    val s_paquete1= Product(101,"Paquete one", "Soul La Roma", R.drawable.soul1 , 129.90f, 0)
    val s_paquete2= Product(102,"Paquete", "Soul La Roma", R.drawable.soul2 , 159.00f,0 )
    val s_paquete3= Product(103,"Paquete", "Soul La Roma", R.drawable.soul3, 159.00f, 0)
    val s_paquete4= Product(104,"Paquete", "Soul La Roma", R.drawable.soul4 , 120.00f, 0)
    val s_paquete5= Product(105,"Paquete", "Soul La Roma", R.drawable.soul5 , 120.00f, 0)


    val myProducts: MutableList<Product> = mutableListOf(a_paquete1,a_paquete2,a_paquete3,a_paquete4,a_paquete5,c_paquete1, c_paquete2,c_paquete3,c_paquete4,c_paquete5, f_paquete1,f_paquete2,f_paquete3,f_paquete4,f_paquete5, fo_paquete1,fo_paquete2, fo_paquete3,fo_paquete4,fo_paquete5,g_paquete1,g_paquete2,g_paquete3,g_paquete4,g_paquete5,d_paquete1,d_paquete2,d_paquete3, d_paquete4,d_paquete5,p_paquete1,p_paquete2,p_paquete3,p_paquete4,p_paquete5,l_paquete1,l_paquete2,l_paquete3,l_paquete4,l_paquete5, r_paquete1,r_paquete2,r_paquete3,r_paquete4,r_paquete5,s_paquete1,s_paquete2,s_paquete3,s_paquete4,s_paquete5)

    val myProductsCremas : MutableList<Product> = mutableListOf(a_paquete1,a_paquete2,a_paquete3,a_paquete4,a_paquete5)
    val myProductsDulces : MutableList<Product> = mutableListOf(c_paquete1,c_paquete2,c_paquete3,c_paquete4,c_paquete5)
    val myProductsBotanas : MutableList<Product> = mutableListOf(f_paquete1,f_paquete2,f_paquete3,f_paquete4,f_paquete5)
    val myProductsSalsas : MutableList<Product> = mutableListOf(fo_paquete1,fo_paquete2,fo_paquete3,fo_paquete4,fo_paquete5)

    val myShoppingCart : MutableList<Product> = mutableListOf()
    val myFavorites : MutableList<Product> = mutableListOf()

    val myProductGroup: MutableList<ProductGroup> = mutableListOf(amamba,cachito,forever,forte,greengrass,ladocena,pitahaya,loosers,ramenbar,soul)
    val myShippings: MutableList<Product> = mutableListOf()

    fun getTotalPrice() : Float{
        var acum = 0.0f
        for(cart in myShoppingCart){
            acum += cart.price * cart.quantity
        }
        return acum
    }

    fun addProduct( myP : Product){

        var aux1 = false
        var aux2 = 0

        var i = 0
        for(myPr in myShoppingCart){
            if(myPr.id.toInt() == myP.id.toInt() ){
                aux1 = true
                aux2 = i
            }
            i += 1
        }
        if(!aux1){
            myShoppingCart.add(myP)
        }
        else{
            myShoppingCart[aux2].quantity = myP.quantity
        }
    }
}

