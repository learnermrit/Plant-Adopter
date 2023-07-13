package com.example.minorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Farmer extends AppCompatActivity {

    EditText username,passwd;
    TextView register;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer);

        username=findViewById(R.id.username);
        passwd=findViewById(R.id.pass);
        register=findViewById(R.id.register);
        login=findViewById(R.id.login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Farmer.this,farmer_dashboard.class);
                //String value=username.getText().toString().trim();
                //i.putExtra("identifier",value);
                startActivity(i);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent i=new Intent(Farmer.this,farmer_register.class);
                //String value=username.getText().toString().trim();
                //i.putExtra("identifier",value);
                startActivity(i);
            }
        });


    }



}