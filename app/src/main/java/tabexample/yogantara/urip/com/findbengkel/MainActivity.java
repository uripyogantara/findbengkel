package tabexample.yogantara.urip.com.findbengkel;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvBengkel;
    private BengkelAdapter adapter;
    private ArrayList<Bengkel> listBengkel;
//    Bengkel[] itemBengkel;
    private String [] namaBengkel;
    private String [] alamatBengkel;
    private String [] teleponBengkel;
    private double [] latBengkel;
    private double [] lngBengkel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namaBengkel= new String[]{"Dangin Seme Motor", "Urip Motor","Suranadi Motor", "Jimbaran Motor","Maju Jaya Motor","Mimi Peri Motor","Ini Bengkel Motor","Apa ya hmm"};
        latBengkel = new double[]{-8.800357,-8.800436,-8.794983,-8.797507,-8.798524,-8.790848,-8.800687,-8.794761};
        lngBengkel = new double[]{115.185275,115.184784,115.175965,115.173777,115.171073,115.177575,115.172768,115.171899};

        lvBengkel=(ListView)findViewById(R.id.listView);
        listBengkel = new ArrayList<>();

        listBengkel.add(new Bengkel(R.drawable.bengkel_1,"Urip Motor","Karangasem","085739893931",-8.800436,115.184784));
        listBengkel.add(new Bengkel(R.drawable.bengkel_2,"Suranadi Motor","Jalan in aja dulu","081238957185",-8.794983,115.175965));
        listBengkel.add(new Bengkel(R.drawable.bengkel_3,"Jimbaran Motor","Jalan menuju surga","08759047152",-8.797507,115.173777));
        listBengkel.add(new Bengkel(R.drawable.bengkel_4,"Maju Jaya Motor","Jalan Gatot Subroto","08595728592",-8.798524,115.171073));
        listBengkel.add(new Bengkel(R.drawable.bengkel_5,"Mimi Peri Motor","Jalan Aspal","08957286924",-8.790848,115.177575));
        listBengkel.add(new Bengkel(R.drawable.bengkel_6,"Dangin Seme Motor","Jalan Iwak Peyek","08223876592",-8.800357,115.185275));
        listBengkel.add(new Bengkel(R.drawable.bengkel_7,"Ini Bengkel Motor","Jalan Jalan Setiap Hari Minggu","085739576825",-8.800687,115.172768));
        listBengkel.add(new Bengkel(R.drawable.bengkel_8,"Apa Ya Motor","Jalan Apa men ya","08598576027",-8.794761,115.171899));

        adapter = new BengkelAdapter(MainActivity.this,listBengkel);
        lvBengkel.setAdapter(adapter);

        lvBengkel.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long l){
                Intent intent = new Intent(getApplicationContext(),ViewBengkel.class);
                Bundle bundle = new Bundle();

                bundle.putString("detailNamaBengkel",listBengkel.get(position).getNama());
                bundle.putString("detailAlamatBengkel",listBengkel.get(position).getAlamat());
                bundle.putString("detailTeleponBengkel",listBengkel.get(position).getTelepon());
                bundle.putInt("detailImageBengkel",listBengkel.get(position).getImage());
                bundle.putDouble("lat",listBengkel.get(position).getLat());
                bundle.putDouble("lng",listBengkel.get(position).getLng());
                intent.putExtras(bundle);
                startActivity(intent);
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

        if (id==R.id.mapsMenu){
            Bundle bundle = new Bundle();
            bundle.putStringArray("allNama",namaBengkel);
            bundle.putDoubleArray("allLat",latBengkel);
            bundle.putDoubleArray("allLng",lngBengkel);
            Intent intent = new Intent(getApplicationContext(),AllMapsActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
