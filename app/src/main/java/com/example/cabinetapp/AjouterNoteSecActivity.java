package com.example.cabinetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cabinetapp.background.backgroundAjouterNoteMedecin;
import com.example.cabinetapp.background.backgroundAjouterNoteSec;
import com.example.cabinetapp.background.backgroundListeNoteMedecin;
import com.example.cabinetapp.background.backgroundListeNoteSec;

public class AjouterNoteSecActivity extends AppCompatActivity {

    EditText titreNote,desNote;
    Button btnadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_note_sec);
        titreNote=findViewById(R.id.titreNote);
        desNote=findViewById(R.id.desNote);
        btnadd=findViewById(R.id.btnadd);
    }

    public void AjouterNoteBtn(View view) {
        String titre = titreNote.getText().toString();
        String des = desNote.getText().toString();

        backgroundAjouterNoteSec bg = new backgroundAjouterNoteSec(this);
        bg.execute(titre,des);
    }

    public void back(View view) {
        backgroundListeNoteSec bg = new backgroundListeNoteSec(this);
        bg.execute();
    }
}