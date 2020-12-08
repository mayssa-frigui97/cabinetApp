package com.example.cabinetapp.background;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.cabinetapp.Entite.RendezVous;
import com.example.cabinetapp.R;

import java.util.ArrayList;

public class CustomAdapterHistorique extends ArrayAdapter<RendezVous> implements View.OnClickListener{

    private ArrayList<RendezVous> dataSet;
    Context mContext;


    // View lookup cache
    private static class ViewHolder {
        TextView ConsNat;
        TextView dateCons;
        TextView Consdiag;
        TextView ConsOrd;
    }
    //ArrayList<Patient> patients,
    public CustomAdapterHistorique(ArrayList<RendezVous> data, Context context) {
        super(context, R.layout.historique_item, data);
        this.dataSet = data;
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
        CustomAdapterHistorique.ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new CustomAdapterHistorique.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.historique_item, parent, false);
            viewHolder.ConsNat = (TextView) convertView.findViewById(R.id.ConsNat);
            viewHolder.dateCons = (TextView) convertView.findViewById(R.id.dateCons);
            viewHolder.Consdiag = (TextView) convertView.findViewById(R.id.Consdiag);
            viewHolder.ConsOrd = (TextView) convertView.findViewById(R.id.ConsOrd);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (CustomAdapterHistorique.ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        viewHolder.dateCons.setText(rdv.getHeureCons()+" , le  "+rdv.getDateCons());
        viewHolder.ConsNat.setText(rdv.getNature());
        viewHolder.Consdiag.setText(rdv.getDiagnostic());
        viewHolder.ConsOrd.setText(rdv.getOrdonnance());
        // Return the completed view to render on screen
        return convertView;
    }
}
