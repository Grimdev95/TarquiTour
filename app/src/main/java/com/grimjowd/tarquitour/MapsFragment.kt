package com.grimjowd.tarquitour

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log


class MapsFragment : Fragment(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var btnCalculateRoute: Button

    private  var start: String = ""
    private  var end: String = ""
    var poly: Polyline? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_maps, container, false)

        btnCalculateRoute = rootView.findViewById(R.id.btnCalculateRoute)
        btnCalculateRoute.setOnClickListener {
            start = ""
            end = ""
            poly?.remove()
           poly = null
            if (::map.isInitialized){
                map.setOnMapClickListener {
                    if (start.isEmpty()){
                        start = "${it.longitude},${it.latitude}"
                    } else if (end.isEmpty()){
                        end = "${it.longitude},${it.latitude}"
                        createRoute()
                    }
                }
            }
        }

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)

        return rootView
    }

    override fun onMapReady(map: GoogleMap) {
        this.map = map

        val tarquiLocation = LatLng(2.1105555555556, -75.8230555556)
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(tarquiLocation, 12f))

    }

   private fun createRoute() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(ApiService::class.java)
                .getRoute("5b3ce3597851110001cf6248ff8ede00a9684ff48bdba9c78820ab28", start, end)
            if (call.isSuccessful){
            drawRoute(call.body())

            }else{
                Log.i("grim", "oko")
            }
        }

    }

    private fun drawRoute(routeResponse: RouteResponse?) {
    val polyLineOptions = PolylineOptions()
        routeResponse?.features?.first()?.geometry?.coordinates?.forEach {
            polyLineOptions.add(LatLng(it[1], it[0]))
        }
        requireActivity().runOnUiThread{
            poly = map.addPolyline(polyLineOptions)
        }

    }


    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.openrouteservice.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}