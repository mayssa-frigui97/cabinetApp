package com.example.cabinetapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cabinetapp.Entite.Patient;
import com.example.cabinetapp.Entite.RendezVous;
import com.example.cabinetapp.background.CustomAdapter;
import com.example.cabinetapp.background.CustomAdapterRDV;
import com.example.cabinetapp.background.background;

import java.util.ArrayList;

public class ListeRdvSecActivity extends AppCompatActivity {
    String  res = "";
    ListView listRdv;
    ArrayList<RendezVous> list =new ArrayList<RendezVous>();
    //ArrayList<Patient> listPersonne =new ArrayList<Patient>();
    private static CustomAdapterRDV adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_rdv_sec);

        listRdv = findViewById(R.id.listRdv);
        res = getIntent().getStringExtra("key");
        if (res != null) {
            String[] tab = res.split("<br>");
            for (int i = 0; i < tab.length; i++) {
                String[] tab2 = tab[i].split(",");
                Patient o= new Patient(Integer.parseInt(tab2[2]),tab2[7],tab2[8]);

                RendezVous p = new RendezVous(Integer.parseInt(tab2[0]), tab2[1], o, tab2[3], tab2[4], tab2[5], tab2[6]);
                //Patient o= new Patient(Integer.parseInt(tab[2]),tab[7],tab[8]);
                //listPersonne.add(o);
                list.add(p);

            }
            adapter = new CustomAdapterRDV(list, getApplicationContext());
            listRdv.setAdapter(adapter);
        }
    }

        public void addRDV(View v){
            Intent MainActivity = new Intent(ListeRdvSecActivity.this, AddRdvActivity.class);
            startActivity(MainActivity);
        }

    public void back(View view) {
        Intent MainActivity = new Intent(ListeRdvSecActivity.this, MenuSecActivity.class);
        startActivity(MainActivity);
    }
}