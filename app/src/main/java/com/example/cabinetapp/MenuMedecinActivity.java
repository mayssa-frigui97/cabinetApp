package com.example.cabinetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cabinetapp.background.backgroundMedecin;

public class MenuMedecinActivity extends AppCompatActivity {

    TextView tvspec, tvnom, tvdoc;
    Button btndex , btnrdv , btnpatients, btnNotes ;
    ImageView ivdoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_medecin);

        tvnom=findViewById(R.id.tvnom);
        tvspec=findViewById(R.id.tvspec);
        tvdoc=findViewById(R.id.tvdoc);
        btndex=findViewById(R.id.btndex);
        btnrdv=findViewById(R.id.btnrdv);
        btnpatients=findViewById(R.id.btnpatients);
        btnNotes=findViewById(R.id.btnNotes);
        ivdoc=findViewById(R.id.ivdoc);
    }
    public void deconnexion(View v){
        Intent MainActivity = new Intent(MenuMedecinActivity.this, LoginActivity.class);
        startActivity(MainActivity);
    }
    public void BtnPatient(View view) {

        backgroundMedecin bg = new backgroundMedecin(this);
        bg.execute();
    }
}