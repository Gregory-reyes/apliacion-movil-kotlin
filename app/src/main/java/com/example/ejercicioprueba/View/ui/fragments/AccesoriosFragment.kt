package com.example.ejercicioprueba.View.ui.fragments

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.ActivityNavigatorExtras
import com.example.ejercicioprueba.R
import com.google.android.gms.maps.GoogleMap
import org.osmdroid.views.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.auth.FirebaseAuth
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.overlay.Marker
import org.osmdroid.config.Configuration
import org.osmdroid.library.BuildConfig


/**
 * A simple [Fragment] subclass.
 * Use the [AccesoriosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AccesoriosFragment : Fragment(), OnMapReadyCallback {
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var googleMap: GoogleMap
    companion object{
        const val REQUEST_CODE_LOCATION=0
    }

    lateinit var mapView: MapView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_accesorios, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = this.childFragmentManager.findFragmentById(R.id.mapGoogle) as SupportMapFragment
        mapFragment.getMapAsync(this)

        //conexión open street map y la APP
        Configuration.getInstance().userAgentValue = BuildConfig.APPLICATION_ID

        //open street map
        mapView = view.findViewById(R.id.mapOpenStreet)
        mapView.setTileSource(TileSourceFactory.MAPNIK)

        //Localización
        val lat = 4.570868
        val long = -74.297333
        val geoPoint= GeoPoint(lat, long)
        val mapController = mapView.controller
        mapController.setZoom(15.0)
        mapController.setCenter(geoPoint)

        //Marcador
        val marker = Marker(mapView)
        marker.position = geoPoint
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        marker.setTitle("WIFE")
        mapView.overlays.add(marker)

    }

    override fun onMapReady(map: GoogleMap) {
        val colombia= LatLng(4.570868, -74.297333)
        map?.let {
            this.googleMap = it
            map.addMarker(MarkerOptions().position(colombia).title("Marker in Colombia"))
        }
        enableMyLocation()
    }

    @SuppressLint("MissingPermission")
    fun enableMyLocation(){
        if(!::googleMap.isInitialized)return
         if (IsLocationPermissionGranted()){
             googleMap.isMyLocationEnabled=true
         }else{
             requestLocationPermission()
         }
    }
    fun IsLocationPermissionGranted()=ContextCompat.checkSelfPermission(
        this.requireContext(),
        android.Manifest.permission.ACCESS_FINE_LOCATION
    )==PackageManager.PERMISSION_GRANTED

    fun requestLocationPermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(this.requireActivity(),android.Manifest.permission.ACCESS_FINE_LOCATION)){
            Toast.makeText(this.requireContext(),"Activar los permisos de ubicación",Toast.LENGTH_SHORT).show()
            }else{
                ActivityCompat.requestPermissions(this.requireActivity(), arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                    com.example.ejercicioprueba.View.ui.fragments.AccesoriosFragment.REQUEST_CODE_LOCATION)
            }

        }
    }

