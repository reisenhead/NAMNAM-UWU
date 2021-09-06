package com.example.namnam_uwu.fragments

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.namnam_uwu.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


    class MapFragment : Fragment() {

        private  val CODIGO_PERMISOS_UBICACION_SEGUNDO_PLANO = 2106
        private  val LOG_TAG = "EnviarUbicacion"
        private lateinit var mMap: GoogleMap
        private lateinit var fusedLocation: FusedLocationProviderClient
        private var haConcedidoPermisos = false
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            verificarPermisos()
        }

        private val callback = OnMapReadyCallback { googleMap ->
            fusedLocation = LocationServices.getFusedLocationProviderClient(activity as Context?)
            mMap = googleMap
            markers(googleMap)



        }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_map, container, false)
        }


        override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
        ) {
            if (requestCode == CODIGO_PERMISOS_UBICACION_SEGUNDO_PLANO) {
                val todosLosPermisosConcedidos =
                    grantResults.all { it == PackageManager.PERMISSION_GRANTED }
                if (grantResults.isNotEmpty() && todosLosPermisosConcedidos) {
                    haConcedidoPermisos = true;
                    Log.d(LOG_TAG, "El usuario concedió todos los permisos")
                } else {
                    Log.d(LOG_TAG, "Uno o más permisos fueron denegados")
                }
            }
        }

        private fun verificarPermisos() {
            val permisos = arrayListOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
            )

            val permisosComoArray = permisos.toTypedArray()
            if (tienePermisos(permisosComoArray)) {
                haConcedidoPermisos = true
                Log.d(LOG_TAG, "Los permisos ya fueron concedidos")
            } else {
                solicitarPermisos(permisosComoArray)
            }
        }


        private fun solicitarPermisos(permisos: Array<String>) {
            Log.d(LOG_TAG, "Solicitando permisos...")
            requestPermissions(
                permisos,
                CODIGO_PERMISOS_UBICACION_SEGUNDO_PLANO
            )
        }

        private fun tienePermisos(permisos: Array<String>): Boolean {
            return permisos.all {
                return ContextCompat.checkSelfPermission(
                    requireActivity(),
                    it
                ) == PackageManager.PERMISSION_GRANTED
            }
        }
        @SuppressLint("MissingPermission")
        fun markers(googleMap:GoogleMap){

            mMap = googleMap

            val cervezaBarrio = LatLng(19.431225,-99.1858892)
            val cabana = LatLng(19.4312519,-99.189154)
            val puertoMadero = LatLng(19.431225,-99.1880833)


            mMap.isMyLocationEnabled = true
            mMap.addMarker(MarkerOptions().position(puertoMadero).title("Puerto Madero").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_coffe_map)))
            mMap.addMarker(MarkerOptions().position(cabana).title("Cabana").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_coffe_map)))
            mMap.addMarker(MarkerOptions().position(cervezaBarrio).title("Cerveceria de barrio").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_coffe_map)))
            mMap.setMinZoomPreference(12.0f)
            mMap.setMaxZoomPreference(16.0f)



            mMap.getUiSettings().setMyLocationButtonEnabled(true)

        }



        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
            mapFragment?.getMapAsync(callback)
        }

    }

