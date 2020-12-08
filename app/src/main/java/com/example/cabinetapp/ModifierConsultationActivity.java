package com.example.cabinetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cabinetapp.background.backgroundListRDVMedecin;
import com.example.cabinetapp.background.backgroundModifierConsultation;

public class ModifierConsultationActivity extends AppCompatActivity {

    TextView coordPat,dateRdv,natCons;
    EditText OrdCons,diagCons;
    Button btnRdv, btnBack;
    String nom,prenom,date,heure,nature,diag,ord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_consultation);

        coordPat=findViewById(R.id.coordPat);
        dateRdv=findViewById(R.id.dateRdv);
        natCons=findViewById(R.id.natCons);
        btnRdv=findViewById(R.id.btnRdv);
        btnBack=findViewById(R.id.btnBack);
        OrdCons=findViewById(R.id.OrdCons);
        diagCons=findViewById(R.id.diagCons);

        nom = getIntent().getStringExtra("key1");
        prenom = getIntent().getStringExtra("key2");
        coordPat.setText(nom+" "+prenom);
        nature = getIntent().getStringExtra("key3");
        natCons.setText(nature);
        diag = getIntent().getStringExtra("key4");
        diagCons.setText(diag);
        ord = getIntent().getStringExtra("key5");
        OrdCons.setText(ord);
        date = getIntent().getStringExtra("key6");
        heure = getIntent().getStringExtra("key7");
        dateRdv.setText(heure+" , "+date);
    }

    public void ModifierRDV(View view) {
        backgroundModifierConsultation bg = new backgroundModifierConsultation(this);
        String ordonnance=OrdCons.getText().toString();
        String diagnostic=diagCons.getText().toString();
        bg.execute(nom,prenom,diagnostic,ordonnance,heure,date,nature);
    }

    public void back(View view) {
        backgroundListRDVMedecin bg = new backgroundListRDVMedecin(this);
        bg.execute();
    }
}