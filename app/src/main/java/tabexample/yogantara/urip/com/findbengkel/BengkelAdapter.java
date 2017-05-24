package tabexample.yogantara.urip.com.findbengkel;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Urip on 4/24/2017.
 */

public class BengkelAdapter extends BaseAdapter{
    // params
    private ArrayList listBengkel;
    private Activity activity;

    public BengkelAdapter(Activity activity, ArrayList listBengkel){
        this.activity = activity;
        this.listBengkel = listBengkel;
    }


    @Override
    public int getCount() {
        return listBengkel.size();
    }

    @Override
    public Object getItem(int position) {
        return listBengkel.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= convertView;
        ViewHolder holder=null;

        if (view==null){
            holder=new ViewHolder();
            LayoutInflater inflater= (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view= inflater.inflate(R.layout.list_bengkel,null);
            holder.imageBengkel=(ImageView)view.findViewById(R.id.imageBengkel);
            holder.imageLocation= (ImageView)view.findViewById(R.id.imageLocation);
            holder.imagePhone= (ImageView)view.findViewById(R.id.imagePhone);
            holder.namaBengkel = (TextView)view.findViewById((R.id.namaBengkel));
            holder.alamatBengkel = (TextView)view.findViewById((R.id.alamatBengkel));
            holder.teleponBengkel = (TextView)view.findViewById((R.id.teleponBengkel));
            view.setTag(holder);
        }else{
            holder= (ViewHolder)view.getTag();
        }
        Bengkel bengkel= (Bengkel)getItem(position);
//        holder.imageBengkel.(bengkel.getImage());
        holder.namaBengkel.setText(bengkel.getNama());
        holder.alamatBengkel.setText(bengkel.getAlamat());
        holder.teleponBengkel.setText(bengkel.getTelepon());
        Picasso.with(activity).load(bengkel.getImage()).into(holder.imageBengkel);
        Picasso.with(activity).load(R.drawable.location).into(holder.imageLocation);
        Picasso.with(activity).load(R.drawable.phone).into(holder.imagePhone);
        return view;
    }

    static class ViewHolder{
        ImageView imageBengkel, imageLocation,imagePhone;
        TextView namaBengkel,alamatBengkel,teleponBengkel;
    }
}
