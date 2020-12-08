package com.example.cabinetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.cabinetapp.Entite.Patient;
import com.example.cabinetapp.Entite.RendezVous;
import com.example.cabinetapp.background.CustomAdapterConsultation;
import com.example.cabinetapp.background.CustomAdapterHistorique;

import java.util.ArrayList;

public class HistoriqueActivity extends AppCompatActivity {

    String  res = "";
    ListView listRdv;
    ArrayList<RendezVous> list =new ArrayList<RendezVous>();
    private static CustomAdapterHistorique adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);
        listRdv = findViewById(R.id.listRdv);

        res = getIntent().getStringExtra("key");
        if (res != null) {
            String[] tab = res.split("<br>");
            for (int i = 0; i < tab.length; i++) {
                String[] tab2 = tab[i].split(",");
                Patient o= new Patient(Integer.parseInt(tab2[2]));
                //Patient o= new Patient(1);
                RendezVous p = new RendezVous(Integer.parseInt(tab2[0]), tab2[1], o, tab2[3], tab2[4], tab2[5], tab2[6]);
                list.add(p);
            }
            adapter = new CustomAdapterHistorique(list, getApplicationContext());
            listRdv.setAdapter(adapter);
        }
    }

    public void back(View view) {
        Intent MainActivity = new Intent(HistoriqueActivity.this, MenuPatientActivity.class);
        startActivity(MainActivity);
    }
}