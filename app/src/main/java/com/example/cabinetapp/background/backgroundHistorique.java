package com.example.cabinetapp.background;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.cabinetapp.Entite.RendezVous;
import com.example.cabinetapp.HistoriqueActivity;
import com.example.cabinetapp.ListeRdvMedecinActivity;
import com.example.cabinetapp.ListeRdvSecActivity;
import com.example.cabinetapp.LoginActivity;
import com.example.cabinetapp.MenuPatientActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by faiizii on 11-Feb-18.
 */

public class backgroundHistorique extends AsyncTask <String, Void,String> {

    AlertDialog dialog;
    Context context;
    String result = "";
    public Boolean login = false;
    public backgroundHistorique(Context context)
    {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        dialog = new AlertDialog.Builder(context).create();
        //dialog.setTitle("Login Status");
    }
    @Override
    protected void onPostExecute(String s) {
        dialog.setMessage(s);
        //dialog.show();
        Intent intent = new Intent(context, HistoriqueActivity.class);
        intent.putExtra("key", result);
        context.startActivity(intent);

    }
    @Override
    protected String doInBackground(String... voids) {

        String user =voids[0];


        String connstr = "http://169.254.96.165:80/ServiceAppAndroid/Historique.php";

        try {
            URL url = new URL(connstr);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            OutputStream ops = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));
            String data = URLEncoder.encode("user","UTF-8")+"="+URLEncoder.encode(user,"UTF-8");


            writer.write(data);
            writer.flush();
            writer.close();
            ops.close();

            InputStream ips = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ips,"ISO-8859-1"));
            String line ="";
            while ((line = reader.readLine()) != null)
            {
                result += line;
            }
            reader.close();
            ips.close();
            http.disconnect();
            System.out.println("***result:"+result);
            return result;

        } catch (MalformedURLException e) {
            result = e.getMessage();
        } catch (IOException e) {
            result = e.getMessage();
        }


        return result;
    }
}