package com.example.agupta1409.maps;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng delhi = new LatLng(27,78);
        mMap.addMarker(new MarkerOptions().position(delhi).title("Marker in Delhi").snippet("Welcome to delhi"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(delhi));

        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setCompassEnabled(!mMap.getUiSettings().isCompassEnabled());

        CameraUpdate cu = CameraUpdateFactory.newLatLng(new LatLng(22,77));
        CameraUpdate cu3 = CameraUpdateFactory.newCameraPosition(
                new CameraPosition(new LatLng(22,77),10,2,5)
        );
        CameraUpdate cu2 = CameraUpdateFactory.zoomIn();

        mMap.addPolygon(new PolygonOptions().add(new LatLng(22,77)).add(new LatLng(26,76)).add(new LatLng(27,78)));
//        mMap.addPolyline(new PolylineOptions().add(new LatLng(21,78)).add(new LatLng(22,78.10)).add(new LatLng(21,78.20)).color(Color.RED));


        mMap.animateCamera(cu);
        mMap.animateCamera(cu3,5000,new GoogleMap.CancelableCallback(){
            @Override
            public void onFinish() {

            }

            @Override
            public void onCancel() {

            }
        });

    }
}
