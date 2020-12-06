package com.example.cabinetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuPatientActivity extends AppCompatActivity {

    TextView tvspec, tvnom, tvdoc;
    Button btndex , btnrdv , btnHis, btnContact ;
    ImageView ivdoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_patient);

        tvnom=findViewById(R.id.tvnom);
        tvspec=findViewById(R.id.tvspec);
        tvdoc=findViewById(R.id.tvdoc);
        btndex=findViewById(R.id.btndex);
        btnrdv=findViewById(R.id.btnrdv);
        btnHis=findViewById(R.id.btnHis);
        btnContact=findViewById(R.id.btnContact);
        ivdoc=findViewById(R.id.ivdoc);
    }

    public void deconnexion(View v){
        Intent MainActivity = new Intent(MenuPatientActivity.this, LoginActivity.class);
        startActivity(MainActivity);
    }
    public void call(View v){
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:123"));
        startActivity(callIntent);
    }

    public void prendreRdv(View v) {
        Intent MainActivity = new Intent(MenuPatientActivity.this, PrendreRdvActivity.class);
        startActivity(MainActivity);
    }
}