package com.example.cabinetapp.background;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.cabinetapp.MenuMedecinActivity;
import com.example.cabinetapp.MenuPatientActivity;
import com.example.cabinetapp.MenuSecActivity;

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

/**
 * Created by faiizii on 11-Feb-18.
 */

public class backgroundModifierConsultation extends AsyncTask <String, Void,String> {

    AlertDialog dialog;
    Context context;
    public Boolean login = false;
    public backgroundModifierConsultation(Context context)
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
        dialog.show();
        backgroundListRDVMedecin bg = new backgroundListRDVMedecin(context);
        bg.execute();

    }
    @Override
    protected String doInBackground(String... voids) {
        String result = "";
        String nomPatient = voids[0];
        String prenomPatient = voids[1];
        String diagnostic = voids[2];
        String ordonnance = voids[3];
        String heureCons = voids[4];
        String dateCons= voids[5];
        String nature= voids[6];


        String connstr = "http://169.254.96.165:80/ServiceAppAndroid/ModifierConsultation.php";

        try {
            URL url = new URL(connstr);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            OutputStream ops = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));
            String data = URLEncoder.encode("nomPatient","UTF-8")+"="+URLEncoder.encode(nomPatient,"UTF-8")
                    +"&&"+URLEncoder.encode("prenomPatient","UTF-8")+"="+URLEncoder.encode(prenomPatient,"UTF-8")
                    +"&&"+URLEncoder.encode("diagnostic","UTF-8")+"="+URLEncoder.encode(diagnostic,"UTF-8")
                    +"&&"+URLEncoder.encode("ordonnance","UTF-8")+"="+URLEncoder.encode(ordonnance,"UTF-8")
                    +"&&"+URLEncoder.encode("heureCons","UTF-8")+"="+URLEncoder.encode(heureCons,"UTF-8")
                    +"&&"+URLEncoder.encode("dateCons","UTF-8")+"="+URLEncoder.encode(dateCons,"UTF-8")
                    +"&&"+URLEncoder.encode("nature","UTF-8")+"="+URLEncoder.encode(nature,"UTF-8");



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
            return result;

        } catch (MalformedURLException e) {
            result = e.getMessage();
        } catch (IOException e) {
            result = e.getMessage();
        }
        return result;
    }
}