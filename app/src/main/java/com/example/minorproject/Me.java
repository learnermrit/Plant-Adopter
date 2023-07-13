package com.example.minorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Me extends AppCompatActivity {

    Button your,account,statistics,allFarmer;
    FirebaseAuth auth;
    FirebaseUser user;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        auth =FirebaseAuth.getInstance();
        button= findViewById(R.id.button5);
        textView =findViewById(R.id.user_details);
        user= auth.getCurrentUser();
        your=findViewById(R.id.your);
        account=findViewById(R.id.account);
        statistics=findViewById(R.id.statistics);
        allFarmer=findViewById(R.id.AllFarmer);

        if(user == null){
            Intent intent =new Intent(getApplicationContext(),Logind.class);
            startActivity(intent);
            finish();
        }
        else{
            textView.setText(user.getEmail());
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent =new Intent(getApplicationContext(),Logind.class);
                startActivity(intent);
                finish();
            }
        });
        allFarmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Me.this,AllFarmersActivity.class);
                startActivity(i);
            }
        });
        your.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent i=new Intent(Me.this,AllFarmersActivity.class);
                Intent i=new Intent(Me.this,your_plant.class);
                startActivity(i);
            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Me.this,farmer_dashboard.class);
                startActivity(i);
            }
        });

        statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Me.this,Statistics_farmer.class);
                startActivity(i);
            }
        });
    }
}