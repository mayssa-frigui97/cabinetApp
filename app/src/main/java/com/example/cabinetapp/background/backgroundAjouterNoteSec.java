package com.example.cabinetapp.background;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

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

public class backgroundAjouterNoteSec extends AsyncTask<String, Void,String> {
    AlertDialog dialog;
    Context context;
    public Boolean login = false;
    public backgroundAjouterNoteSec(Context context)
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
        backgroundListeNoteSec bg = new backgroundListeNoteSec(this.context);
        bg.execute();
    }
    @Override
    protected String doInBackground(String... voids) {
        String result = "";
        String titre = voids[0];
        String description= voids[1];


        String connstr = "http://169.254.96.165:80/ServiceAppAndroid/AjouterNoteSec.php";

        try {
            URL url = new URL(connstr);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            OutputStream ops = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));
            String data = URLEncoder.encode("titre","UTF-8")+"="+URLEncoder.encode(titre,"UTF-8")
                    +"&&"+URLEncoder.encode("description","UTF-8")+"="+URLEncoder.encode(description,"UTF-8");


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
