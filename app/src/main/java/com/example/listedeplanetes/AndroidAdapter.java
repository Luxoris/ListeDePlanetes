package com.example.listedeplanetes;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AndroidAdapter extends ArrayAdapter<Planete> {
    public List<Planete> planeteList;
    public Context context;
    public Resources res;
    public int viewRes;

    static class ViewHolder{
        TextView title;
        TextView distance;
        ImageView image;
    }

    public AndroidAdapter(Context context, int textViewResourceId, ArrayList<Planete> versions) {
        super(context,textViewResourceId,versions);
        this.planeteList =versions;
        this.context=context;
        this.res=context.getResources();
        this.viewRes=textViewResourceId;
    }

    @Override //Il faut implémenter getView ici
    public View getView(int position, View ConvertView, ViewGroup parent) {
        View view = ConvertView;
        ViewHolder holder;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(viewRes, parent, false);
            //cf. explications effectuée dans cours sur
            holder = new ViewHolder();
            holder.title= (TextView) view.findViewById(R.id.title);
            holder.distance = (TextView) view.findViewById(R.id.distance);
            holder.image = (ImageView) view.findViewById(R.id.image) ;
            view.setTag(holder);
        }
        else {
            holder= (ViewHolder) view.getTag();
        }
        final Planete maPlanete = planeteList.get(position);
        if (maPlanete != null) {
            final String name = String.format("%s", maPlanete.getName());
            holder.title.setText(name);
            final String distance = String.format("dist moy : %s", maPlanete.getDistance());
            holder.distance.setText(distance);
            holder.image.setImageResource(maPlanete.getImage());
        }
        return view;
    }

    @Override
    //Nombre d’éléments de la liste
    public int getCount() {
        return planeteList.size();
    }
}


