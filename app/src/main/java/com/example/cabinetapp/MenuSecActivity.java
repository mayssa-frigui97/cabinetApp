package com.example.cabinetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cabinetapp.background.backgroundListRDV;
import com.example.cabinetapp.background.backgroundListeNoteMedecin;
import com.example.cabinetapp.background.backgroundListeNoteSec;
import com.example.cabinetapp.background.backgroundListePatient;

public class MenuSecActivity extends AppCompatActivity {

    TextView tvspec, tvnom, tvdoc;
    Button btndex , btnrdv , btnpatients, btnNotes ;
    ImageView ivdoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_sec);

        tvnom=findViewById(R.id.tvnom);
        tvspec=findViewById(R.id.tvspec);
        tvdoc=findViewById(R.id.tvdoc);
        btndex=findViewById(R.id.btndex);
        btnrdv=findViewById(R.id.btnrdv);
        btnpatients=findViewById(R.id.btnpatients);
        btnNotes=findViewById(R.id.btnNotes);
        ivdoc=findViewById(R.id.ivdoc);

        /*String name = getIntent().getStringExtra("key");
        if(name != null){
            lblbnj.setText("Bonjour " +name.toUpperCase()+ " !");
        }*/
    }

    public void BtnPatient(View view) {

        backgroundListePatient bg = new backgroundListePatient(this);
        bg.execute();
    }
    public void BtnRDV(View view) {

        backgroundListRDV bg = new backgroundListRDV(this);
        bg.execute();
    }
    public void deconnexion(View v){
        Intent MainActivity = new Intent(MenuSecActivity.this, LoginActivity.class);
        startActivity(MainActivity);
    }

    public void btnNote(View view) {
        backgroundListeNoteSec bg = new backgroundListeNoteSec(this);
        bg.execute();
    }
}