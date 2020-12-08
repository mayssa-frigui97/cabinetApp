package com.example.cabinetapp.background;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.cabinetapp.Entite.Note;
import com.example.cabinetapp.ListeNoteSecActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class backgroundListeNoteSec extends AsyncTask<String, Void,String> {
    AlertDialog dialog;
    String result = "";
    Intent intent;
    public Boolean login = false;
    ArrayList<Note> tab=new ArrayList<Note>();
    Context context;

    public backgroundListeNoteSec(Context context) {
        this.context = context;
    }


    @Override
    protected void onPreExecute() {
        dialog = new AlertDialog.Builder(context).create();

    }
    @Override
    protected void onPostExecute(String s) {
        dialog.setMessage(s);
        //  dialog.show();
        intent= new Intent(context, ListeNoteSecActivity.class);
        intent.putExtra("key", result);
        context.startActivity(intent);
    }
    @Override
    protected String doInBackground(String... voids) {



        String connstr = "http://169.254.96.165:80/ServiceAppAndroid/ListeNotesSec.php";

        try {
            URL url = new URL(connstr);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            OutputStream ops = http.getOutputStream();

            InputStream ips = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ips,"ISO-8859-1"));
            String line ="";

            while ((line = reader.readLine()) != null)
            {
                result+= line;


            }
            reader.close();
            ips.close();
            http.disconnect();
            return result;

        } catch (MalformedURLException e) {
            result = e.getMessage();
        } catch (IOException e) {
            result = e.getMessage();
        }


        return result;
    }
}
