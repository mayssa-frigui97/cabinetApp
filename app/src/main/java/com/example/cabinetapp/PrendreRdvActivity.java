package com.example.cabinetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cabinetapp.background.backgroundAjouterRdv;

public class PrendreRdvActivity extends AppCompatActivity {

    EditText hrdv, daterdv, natrdv;
    Button btnRdv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prendre_rdv);

        hrdv=findViewById(R.id.hrdv);
        daterdv=findViewById(R.id.daterdv);
        natrdv=findViewById(R.id.natrdv);
        btnRdv=findViewById(R.id.btnRdv);
    }
    public void AjouterRDVBtn(View view) {
        String user= LoginActivity.user;
        String h = hrdv.getText().toString();
        String d = daterdv.getText().toString();
        String n = natrdv.getText().toString();

        backgroundAjouterRdv bg = new backgroundAjouterRdv(this);
        bg.execute(user,h,d,n);
    }

    public void back(View view) {
        Intent MainActivity = new Intent(PrendreRdvActivity.this, MenuPatientActivity.class);
        startActivity(MainActivity);
    }
}