package com.example.cabinetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cabinetapp.background.backgroundAjouterRdv;
import com.example.cabinetapp.background.backgroundAjouterRdvSec;
import com.example.cabinetapp.background.backgroundListRDV;
import com.example.cabinetapp.background.backgroundListRDVMedecin;

public class AddRdvActivity extends AppCompatActivity {

    EditText hrdv, daterdv, natrdv,nomPat,prenomPat;
    Button btnRdv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_rdv);

        hrdv=findViewById(R.id.hrdv);
        daterdv=findViewById(R.id.daterdv);
        natrdv=findViewById(R.id.natrdv);
        btnRdv=findViewById(R.id.btnRdv);
        nomPat=findViewById(R.id.nomPat);
        prenomPat=findViewById(R.id.prenomPat);

    }

    public void AjouterRDVBtn(View v){
        String h = hrdv.getText().toString();
        String d = daterdv.getText().toString();
        String n = natrdv.getText().toString();
        String nom = nomPat.getText().toString();
        String prenom = prenomPat.getText().toString();

        backgroundAjouterRdvSec bg = new backgroundAjouterRdvSec(this);
        bg.execute(nom,prenom,n,h,d);
    }

    public void back(View view) {
        backgroundListRDV bg = new backgroundListRDV(this);
        bg.execute();
    }
}