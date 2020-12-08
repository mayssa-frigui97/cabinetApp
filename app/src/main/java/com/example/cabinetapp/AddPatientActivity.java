package com.example.cabinetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cabinetapp.background.backgroundAjouterPatient;
import com.example.cabinetapp.background.backgroundAjouterRdvSec;
import com.example.cabinetapp.background.backgroundListRDVMedecin;
import com.example.cabinetapp.background.backgroundListePatient;

public class AddPatientActivity extends AppCompatActivity {

    EditText telPat, datePat, cnamPat,nomPat,prenomPat,usernamePat;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);

        telPat=findViewById(R.id.telPat);
        datePat=findViewById(R.id.datePat);
        cnamPat=findViewById(R.id.cnamPat);
        nomPat=findViewById(R.id.nomPat);
        prenomPat=findViewById(R.id.prenomPat);
        usernamePat=findViewById(R.id.usernamePat);
        btnAdd=findViewById(R.id.btnRdv);
    }

    public void AjouterPatient(View view) {
        String tel = telPat.getText().toString();
        String date = datePat.getText().toString();
        String cnam = cnamPat.getText().toString();
        String nom = nomPat.getText().toString();
        String prenom = prenomPat.getText().toString();
        String username = usernamePat.getText().toString();

        backgroundAjouterPatient bg = new backgroundAjouterPatient(this);
        bg.execute(nom,prenom,date,tel,cnam,username);
    }

    public void back(View view) {
        backgroundListePatient bg = new backgroundListePatient(this);
        bg.execute();
    }
}