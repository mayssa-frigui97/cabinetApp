package com.example.cabinetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cabinetapp.background.background;

public class LoginActivity extends AppCompatActivity {

    private EditText username,password;
    private Button login;
    private TextView msgerreur;

    String name="";
    String pswd="";

    class Credentials
    {
        String name = "mayssa";
        String pswd = "1234";
    }

    boolean isValid = false;
    private int counter = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        msgerreur=findViewById(R.id.msgerreur);

    }
    public void loginBtn(View view) {
        String user = username.getText().toString();
        String pass = password.getText().toString();

        background bg = new background(this);
        bg.execute(user,pass);
    }

}