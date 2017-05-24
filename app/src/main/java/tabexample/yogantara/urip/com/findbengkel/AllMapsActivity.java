package tabexample.yogantara.urip.com.findbengkel;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Urip on 5/4/2017.
 */

public class AllMapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private String [] namaBengkel= new String[8];
    private String [] alamatBengkel;
    private String [] teleponBengkel;
    private double [] latBengkel = new double[8];
    private double [] lngBengkel = new double[8];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Bundle bundle= getIntent().getExtras();
        namaBengkel=bundle.getStringArray("allNama");
        latBengkel=bundle.getDoubleArray("allLat");
        lngBengkel=bundle.getDoubleArray("allLng");
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
        for (int i=0; i<8;i++){
            LatLng teknologiinformasi = new LatLng(latBengkel[i], lngBengkel[i]);
            mMap.addMarker(new MarkerOptions().position(teknologiinformasi).title(namaBengkel[i]));
        }
        LatLng teknologiinformasi = new LatLng(-8.797803, 115.169506);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(teknologiinformasi,10));
    }
}
