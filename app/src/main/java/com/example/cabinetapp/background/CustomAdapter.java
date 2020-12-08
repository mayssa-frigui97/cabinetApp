package com.example.cabinetapp.background;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.cabinetapp.Entite.Patient;
import com.example.cabinetapp.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Patient> implements View.OnClickListener{

    private ArrayList<Patient> dataSet;
    Context mContext;


    // View lookup cache
    static class ViewHolder {
        TextView coordPat;
        TextView tel;
        TextView cnam;
    }

    public CustomAdapter(ArrayList<Patient> data, Context context) {
        super(context, R.layout.patient_item, data);
        this.dataSet = data;
        this.mContext=context;
    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Patient patient=(Patient) object;
/*
        switch (v.getId())
        {
            case R.id.imgPat:
                Snackbar.make(v, "Release date " +patient.getDateNaiss(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;
        }*/
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Patient patient = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.patient_item, parent, false);
            viewHolder.coordPat = (TextView) convertView.findViewById(R.id.coordPat);
            viewHolder.tel = (TextView) convertView.findViewById(R.id.tel);
            viewHolder.cnam = (TextView) convertView.findViewById(R.id.cnam);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        /*Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);*/
        lastPosition = position;

        viewHolder.coordPat.setText(patient.getNom()+" "+patient.getPrenom());
        viewHolder.tel.setText(patient.getTel());
        viewHolder.cnam.setText(patient.getCnam());
        // Return the completed view to render on screen
        return convertView;
    }
}
