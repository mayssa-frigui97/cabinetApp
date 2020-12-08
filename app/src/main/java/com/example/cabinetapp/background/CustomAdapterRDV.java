package com.example.cabinetapp.background;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.cabinetapp.Entite.Patient;
import com.example.cabinetapp.Entite.RendezVous;
import com.example.cabinetapp.R;

import java.util.ArrayList;

public class CustomAdapterRDV extends ArrayAdapter<RendezVous> implements View.OnClickListener{
    private ArrayList<RendezVous> dataSet;
    //private ArrayList<Patient> patients;
    Context mContext;


    // View lookup cache
    static class ViewHolder {
        TextView CoordPat;
        TextView ConsNat;
        TextView dateCons;
    }
    //ArrayList<Patient> patients,
    public CustomAdapterRDV(ArrayList<RendezVous> data, Context context) {
        super(context, R.layout.rdv_item, data);
        this.dataSet = data;
        //this.patients=patients;
        this.mContext=context;
    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        RendezVous rdv=(RendezVous) object;
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        RendezVous rdv = getItem(position);
        //Patient patient =getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        CustomAdapterRDV.ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new CustomAdapterRDV.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.rdv_item, parent, false);
            viewHolder.CoordPat = (TextView) convertView.findViewById(R.id.CorrdPat);
            viewHolder.ConsNat = (TextView) convertView.findViewById(R.id.ConsNat);
            viewHolder.dateCons = (TextView) convertView.findViewById(R.id.dateCons);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (CustomAdapterRDV.ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        viewHolder.CoordPat.setText(rdv.getPatient().getNom()+" "+rdv.getPatient().getPrenom());
        viewHolder.dateCons.setText(rdv.getHeureCons()+" , le  "+rdv.getDateCons());
        viewHolder.ConsNat.setText(rdv.getNature());
        // Return the completed view to render on screen
        return convertView;
    }
}
