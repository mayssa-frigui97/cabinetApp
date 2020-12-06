package com.example.cabinetapp;

import android.os.Bundle;

import com.example.cabinetapp.Entite.Patient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ListePatientActivity extends AppCompatActivity {

    TextView listPat;
    String  res = "";
    ArrayList<Patient> list =new ArrayList<Patient>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_patient);

        listPat=findViewById(R.id.listPat);

        res = getIntent().getStringExtra("key");
        if(res != null){
            String[] tab = res.split("/");
            for(int i=0;i<tab.length;i++){
                String[] tab2 = tab[i].split(",");
                Patient p = new Patient(Integer.parseInt(tab2[0]),tab2[1],tab2[2],tab2[3],tab2[4],tab2[5]);
                list.add(p);
            }

            listPat.setText("nom patient 1:"+ list.get(0).getNom());
        }

    }
}