package com.example.minorproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class adopter_home extends AppCompatActivity {

    ImageSlider imageSlider;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopter_home);

        imageSlider=findViewById(R.id.image_slider);

        toolbar=findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Plant Adopter");
        }


        ArrayList<SlideModel> images=new ArrayList<>();

        images.add(new SlideModel(R.drawable.one,ScaleTypes.FIT));
        images.add(new SlideModel(R.drawable.two,ScaleTypes.FIT));
        images.add(new SlideModel(R.drawable.three,ScaleTypes.FIT));
        imageSlider.setImageList(images, ScaleTypes.CENTER_CROP);


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
            item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Intent intent = new Intent(adopter_home.this, Me.class);
                    startActivity(intent);
                    return false;
                }
            });
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