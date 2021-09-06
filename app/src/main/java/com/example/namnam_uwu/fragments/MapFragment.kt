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

            val cdMx = LatLng(19.4115814,-99.1717618)
            val fondaGarufa = LatLng(19.4116616,-99.1747227)
            val greenGlass = LatLng(19.4062635,-99.1738504)
            val elPescadito = LatLng(19.4142968,-99.1734571)
            val amamba = LatLng(19.4167556,-99.1732115)
            val forever = LatLng(19.417244,-99.156813)
            val forte = LatLng(19.414804,-99.1774675)
            val ramenBar = LatLng(19.4168965,-99.1657248)
            val pitahayaVegana = LatLng(19.4168625,-99.1661117)
            val soulRoma = LatLng(19.4197904,-99.1596364)
            val cachitoMio = LatLng(19.416417,-99.1630745)
            val losLoosers = LatLng(19.419011,-99.1766436)
            val laDocena = LatLng(19.4190101,-99.1920128)


            mMap.isMyLocationEnabled = true

            mMap.moveCamera(CameraUpdateFactory.newLatLng(cdMx))
            mMap.addMarker(MarkerOptions().position(fondaGarufa).title("Fonda Garufa").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_coffe_map)))
            mMap.addMarker(MarkerOptions().position(greenGlass).title("Green glass condesa").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_coffe_map)))
            mMap.addMarker(MarkerOptions().position(forever).title("Forever").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_coffe_map)))
            mMap.addMarker(MarkerOptions().position(amamba).title("Amamba").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_coffe_map)))
            mMap.addMarker(MarkerOptions().position(elPescadito).title("El Pescadito").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_coffe_map)))
            mMap.addMarker(MarkerOptions().position(forte).title("Forte").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_coffe_map)))
            mMap.addMarker(MarkerOptions().position(ramenBar).title("Ramen Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_coffe_map)))
            mMap.addMarker(MarkerOptions().position(pitahayaVegana).title("La pitahaya vegana").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_coffe_map)))
            mMap.addMarker(MarkerOptions().position(soulRoma).title("Soul la Roma").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_coffe_map)))
            mMap.addMarker(MarkerOptions().position(cachitoMio).title("Cachito Mío Quiches y Tartas").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_coffe_map)))
            mMap.addMarker(MarkerOptions().position(losLoosers).title("Los lossers").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_coffe_map)))
            mMap.addMarker(MarkerOptions().position(laDocena).title("La docena").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_coffe_map)))

            mMap.setMinZoomPreference(13.0f)
            mMap.setMaxZoomPreference(16.0f)



            mMap.getUiSettings().setMyLocationButtonEnabled(true)

        }



        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
            mapFragment?.getMapAsync(callback)
        }

    }

