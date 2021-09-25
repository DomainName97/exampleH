package com.example.hakatonapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.graphics.Color
import android.graphics.PointF
import com.example.hakatonapplication.databinding.FragmentHomeBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.location.LocationListener
import com.yandex.mapkit.location.LocationStatus
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import androidx.annotation.NonNull
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.yandex.mapkit.MapKit
import com.yandex.mapkit.layers.ObjectEvent
import com.yandex.mapkit.map.CompositeIcon
import com.yandex.mapkit.map.IconStyle
import com.yandex.mapkit.map.RotationType
import com.yandex.mapkit.user_location.UserLocationLayer
import com.yandex.mapkit.user_location.UserLocationObjectListener
import com.yandex.mapkit.user_location.UserLocationView
import com.yandex.runtime.image.ImageProvider
import org.json.JSONArray
import android.content.Context.NOTIFICATION_SERVICE

import androidx.core.content.ContextCompat.getSystemService

import android.app.NotificationManager
import androidx.core.content.ContextCompat
import com.example.hakatonapplication.R


class HomeFragment : Fragment(), UserLocationObjectListener {

    companion object {
        const val NOTIFICATION_ID = 101
        const val CHANNEL_ID = "channelID"
    }

    private lateinit var mapview: MapView
    private lateinit var userLocationLayer: UserLocationLayer

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val TARGET_LOCATION = Point(56.857524, 53.230243)

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {



        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root



        //mapview = binding.mapview

        //mapview.map.isRotateGesturesEnabled = false
        //mapview.map.move(CameraPosition(TARGET_LOCATION, 14.0f, 0.0f, 0.0f),
         //   Animation(Animation.Type.SMOOTH, 5F),
         //   null)

       // val mapKit = MapKitFactory.getInstance()
        //userLocationLayer = mapKit.createUserLocationLayer(mapview.mapWindow)
       // userLocationLayer.isVisible = true
       // userLocationLayer.isHeadingEnabled = true

       // userLocationLayer.setObjectListener(this)

        return root
    }

    override fun onStop() {
        super.onStop()
       // mapview.onStop()
       // MapKitFactory.getInstance().onStop()
    }

    override fun onStart() {
        super.onStart()
//        mapview.onStart()
       // MapKitFactory.getInstance().onStart()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onObjectAdded(userLocationView: UserLocationView) {
        userLocationLayer.setAnchor(
            PointF((mapview.width * 0.5).toFloat(), (mapview.height * 0.5).toFloat()),
            PointF((mapview.width * 0.5).toFloat(), (mapview.height * 0.83).toFloat())
        )

        val pinIcon: CompositeIcon = userLocationView.pin.useCompositeIcon()

        pinIcon.setIcon(
            "pin",
            ImageProvider.fromResource(activity, R.drawable.search_result),
            IconStyle().setAnchor(PointF(0.5f, 0.5f))
                .setRotationType(RotationType.ROTATE)
                .setZIndex(1f)
                .setScale(0.5f)
        )

        userLocationView.accuracyCircle.fillColor = Color.BLUE and -0x66000001
    }

    override fun onObjectRemoved(p0: UserLocationView) {
    }

    override fun onObjectUpdated(p0: UserLocationView, p1: ObjectEvent) {
    }
}