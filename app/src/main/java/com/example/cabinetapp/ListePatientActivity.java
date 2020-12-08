package com.example.cabinetapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.cabinetapp.Entite.Patient;
import com.example.cabinetapp.background.CustomAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;

public class ListePatientActivity extends AppCompatActivity {

    ListView listPat;
    String res = "";
    ArrayList<Patient> list = new ArrayList<Patient>();
    private static CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_patient);

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        listPat = findViewById(R.id.listPat);

        res = getIntent().getStringExtra("key");
        if (res != null) {
            String[] tab = res.split("<br>");
            for (int i = 0; i < tab.length; i++) {
                String[] tab2 = tab[i].split(",");

                Patient p = new Patient(Integer.parseInt(tab2[0]), tab2[1], tab2[2], tab2[3], tab2[4], tab2[5]);
                list.add(p);
            }

            //listPat.setText("nom patient 1:"+ list.get(0).getNom())
            adapter= new CustomAdapter(list,getApplicationContext());
            listPat.setAdapter(adapter);
            /*listPat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Patient patient= list.get(position);

                    Snackbar.make(view, patient.getNom()+"\n"+patient.getPrenom()+" Tel: "+patient.getTel()+"cnam:"+patient.getCnam(), Snackbar.LENGTH_LONG)
                            .setAction("No action", null).show();
                }
            });*/
        }
        /*@Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }*/

    }

    public void addPatient(View v){
        Intent MainActivity = new Intent(ListePatientActivity.this, AddPatientActivity.class);
        startActivity(MainActivity);
    }


    public void back(View view) {
        Intent MainActivity = new Intent(ListePatientActivity.this, MenuSecActivity.class);
        startActivity(MainActivity);
    }
}