package com.example.namnam_uwu.fragments

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.namnam_uwu.R
import com.google.android.gms.location.FusedLocationProviderClient

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment() {
    private lateinit var fusedLocation: FusedLocationProviderClient
    private lateinit var mMap: GoogleMap
    private val callback = OnMapReadyCallback { googleMap ->
        
        mMap = googleMap
        val polanco = LatLng(19.4318578,-99.1965012)
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isCompassEnabled = true
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(polanco,16f))
        markers(googleMap)


    }
    fun markers(googleMap:GoogleMap){

        mMap = googleMap

        val cervezaBarrio = LatLng(19.431225,-99.1858892)
        val cabana = LatLng(19.4312519,-99.189154)
        val puertoMadero = LatLng(19.431225,-99.1880833)



        mMap.addMarker(MarkerOptions().position(puertoMadero).title("Puerto Madero").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_coffe_map)))
        mMap.addMarker(MarkerOptions().position(cabana).title("Cabana").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_coffe_map)))
        mMap.addMarker(MarkerOptions().position(cervezaBarrio).title("Cerveceria de barrio").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_coffe_map)))

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}