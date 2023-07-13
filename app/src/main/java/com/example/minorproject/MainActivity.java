package com.example.minorproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);

        toolbar=findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Plant Adopter");
        }


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Logind.class);
                intent.putExtra("userType", "farmer");
                startActivity(intent);
  }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Logind.class);
                intent.putExtra("userType", "adopter");
                startActivity(intent);
//                Intent intent=new Intent(MainActivity.this,Logind.class);
//                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        new MenuInflater(this).inflate(R.menu.opt_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId= item.getItemId();
        if(itemId==R.id.home){
            Toast.makeText(this,"Created new file",Toast.LENGTH_SHORT).show();
        }
        else if(itemId==R.id.me){
            Toast.makeText(this,"Opened a file",Toast.LENGTH_SHORT).show();
        }
        else if(itemId==R.id.search){
            Toast.makeText(this,"Saved a file",Toast.LENGTH_SHORT).show();
        }
        else if(itemId==android.R.id.home){
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}