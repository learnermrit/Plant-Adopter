package com.example.minorproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.Console;

public class farmer_dashboard extends AppCompatActivity {

    Button statistics;
    FirebaseAuth auth;
    FirebaseUser user;
    TextView name,contact,address ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_dashboard);
        name=findViewById(R.id.textView3);
        contact=findViewById(R.id.textView7);
        address=findViewById(R.id.textView6);
        statistics=findViewById(R.id.statistics);
        auth =FirebaseAuth.getInstance();
        user= auth.getCurrentUser();

       //textView.setText(user.getEmail());
        Toast.makeText(this, user.getUid(), Toast.LENGTH_SHORT).show();

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference userRef =   db.collection("User").document(user.getUid());

        userRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d("TAG", "User document: " + document.getData());

                        String userEmail = document.getString("email");
                        Toast.makeText(farmer_dashboard.this, userEmail, Toast.LENGTH_SHORT).show();
                        name.setText(document.getString("name"));
                        contact.setText(document.getString("contact"));
                        address.setText(document.getString("address"));
                        Log.d("TAG", "User email: " + userEmail);
                    } else {
                       // Log.d("TAG", "No such document");
                        Toast.makeText(farmer_dashboard.this, "no sucjh", Toast.LENGTH_SHORT).show();
                    }
                } else {
                  //  Log.d("TAG", "get failed with ", task.getException());
                    Toast.makeText(farmer_dashboard.this, "get failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(farmer_dashboard.this,Statistics_farmer.class);
                startActivity(intent);
            }
        });
    }
}