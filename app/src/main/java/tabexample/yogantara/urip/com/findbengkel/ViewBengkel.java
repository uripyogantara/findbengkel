package tabexample.yogantara.urip.com.findbengkel;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ViewBengkel extends AppCompatActivity{
    TextView detailNamaBengkel, detailAlamatBengkel, detailTeleponBengkel;
    ImageView detailImageBengkel;
    double lat,lng;
    String namaBengkel,teleponBengkel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_bengkel);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        detailNamaBengkel= (TextView)findViewById(R.id.detailNamaBengkel);
        detailAlamatBengkel= (TextView)findViewById(R.id.detailAlamatBengkel);
        detailTeleponBengkel= (TextView)findViewById(R.id.detailTeleponBengkel);
        detailImageBengkel= (ImageView)findViewById(R.id.detailImageBengkel);

        Bundle bundle= getIntent().getExtras();
        setTitle(bundle.getString("detailNamaBengkel"));
        detailNamaBengkel.setText(bundle.getString("detailNamaBengkel"));
        detailAlamatBengkel.setText(bundle.getString("detailAlamatBengkel"));
        detailTeleponBengkel.setText(bundle.getString("detailTeleponBengkel"));
        detailImageBengkel.setImageResource(bundle.getInt("detailImageBengkel"));
        lat=bundle.getDouble("lat");
        lng=bundle.getDouble("lng");
        namaBengkel=bundle.getString("detailNamaBengkel");
        teleponBengkel=bundle.getString("detailTeleponBengkel");
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_call:
                                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+teleponBengkel));
                                startActivity(intentCall);
                                break;

                            case R.id.action_message:
                                Intent intentMsg = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+teleponBengkel));
                                startActivity(intentMsg);
                                break;

                            case R.id.action_map:
                                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putDouble("lat",lat);
                                bundle.putDouble("lng",lng);
                                bundle.putString("namaBengkel",namaBengkel);
                                intent.putExtras(bundle);
                                startActivity(intent);
                                break;
                        }
                        return true;
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.select_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        if (id==android.R.id.home){
            this.finish();
        }else if (id==R.id.mapsMenu){
            Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
            Bundle bundle = new Bundle();
            bundle.putDouble("lat",lat);
            bundle.putDouble("lng",lng);
            bundle.putString("namaBengkel",namaBengkel);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
