package com.example.namnam_uwu.Models

import android.os.Parcel
import android.os.Parcelable

class Product1 (
    val paquete: String,
    val restaurant: String,
    val distance: String,
    val hour: String,
    val day: String,
    val amount : String,
    val star : String,
    val preci : String,
    val preciOld : String,
    val idImage: Int
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(paquete)
        parcel.writeString(restaurant)
        parcel.writeString(distance)
        parcel.writeString(hour)
        parcel.writeString(day)
        parcel.writeString(amount)
        parcel.writeString(star)
        parcel.writeString(preci)
        parcel.writeString(preciOld)
        parcel.writeInt(idImage)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product1> {
        override fun createFromParcel(parcel: Parcel): Product1 {
            return Product1(parcel)
        }

        override fun newArray(size: Int): Array<Product1?> {
            return arrayOfNulls(size)
        }
    }
}