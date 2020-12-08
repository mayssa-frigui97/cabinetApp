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
import com.example.cabinetapp.background.CustomAdapterRDV;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ListeRdvMedecinActivity extends AppCompatActivity {

    String  res = "";
    ListView listRdv;
    ArrayList<RendezVous> list =new ArrayList<RendezVous>();
    private static CustomAdapterConsultation adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_rdv_medecin);

        listRdv = findViewById(R.id.listRdv);

        res = getIntent().getStringExtra("key");
        if (res != null) {
            String[] tab = res.split("<br>");
            for (int i = 0; i < tab.length; i++) {
                String[] tab2 = tab[i].split(",");
                Patient o= new Patient(Integer.parseInt(tab2[2]),tab2[7],tab2[8]);
                RendezVous p = new RendezVous(Integer.parseInt(tab2[0]), tab2[1], o, tab2[3], tab2[4], tab2[5], tab2[6]);
                list.add(p);
            }
            adapter = new CustomAdapterConsultation(list, getApplicationContext());
            listRdv.setAdapter(adapter);
        }
        listRdv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RendezVous rdv= list.get(position);

                /*Snackbar.make(view, patient.getNom()+"\n"+patient.getPrenom()+" Tel: "+patient.getTel()+"cnam:"+patient.getCnam(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();*/
                Context context;
                Intent intent = new Intent(ListeRdvMedecinActivity.this, ModifierConsultationActivity.class);
                intent.putExtra("key1", list.get(position).getPatient().getNom());
                intent.putExtra("key2", list.get(position).getPatient().getPrenom());
                intent.putExtra("key3", list.get(position).getNature());
                intent.putExtra("key4", list.get(position).getDiagnostic());
                intent.putExtra("key5", list.get(position).getOrdonnance());
                intent.putExtra("key6", list.get(position).getDateCons());
                intent.putExtra("key7", list.get(position).getHeureCons());
                startActivity(intent);
            }

            });
        }

    public void back(View view) {
        Intent MainActivity = new Intent(ListeRdvMedecinActivity.this, MenuMedecinActivity.class);
        startActivity(MainActivity);
    }
}