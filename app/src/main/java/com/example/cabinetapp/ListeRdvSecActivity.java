package com.example.cabinetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class ListeRdvSecActivity extends AppCompatActivity {

    ListView listRdv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_rdv_sec);

        listRdv=findViewById(R.id.listRdv);
    }
}