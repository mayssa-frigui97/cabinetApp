package com.example.cabinetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.cabinetapp.Entite.Note;
import com.example.cabinetapp.background.CustomAdapterNote;

import java.util.ArrayList;

public class ListeNoteSecActivity extends AppCompatActivity {

    ListView listNote;
    String res = "";
    ArrayList<Note> list = new ArrayList<Note>();
    private static CustomAdapterNote adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_note_medecin);

        listNote = findViewById(R.id.listNote);

        res = getIntent().getStringExtra("key");
        if (res != null) {
            String[] tab = res.split("<br>");
            for (int i = 0; i < tab.length; i++) {
                String[] tab2 = tab[i].split(",");

                Note p = new Note(Integer.parseInt(tab2[0]), tab2[1], tab2[2], tab2[3]);
                list.add(p);
            }

            //listPat.setText("nom patient 1:"+ list.get(0).getNom())
            adapter = new CustomAdapterNote(list, getApplicationContext());
            listNote.setAdapter(adapter);
            /*listPat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Patient patient= list.get(position);

                    Snackbar.make(view, patient.getNom()+"\n"+patient.getPrenom()+" Tel: "+patient.getTel()+"cnam:"+patient.getCnam(), Snackbar.LENGTH_LONG)
                            .setAction("No action", null).show();
                }
            });*/
        }
    }

    public void addNote(View view) {
        Intent MainActivity = new Intent(ListeNoteSecActivity.this, AjouterNoteActivity.class);
        startActivity(MainActivity);
    }

    public void back(View view) {
        Intent MainActivity = new Intent(ListeNoteSecActivity.this, MenuSecActivity.class);
        startActivity(MainActivity);
    }
}