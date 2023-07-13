package com.example.minorproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class AllFarmersActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FirebaseFirestore db;
    private List<UserModel> farmersList;
    private FarmerAdapter farmerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_farmers);

        recyclerView = findViewById(R.id.farmers_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        db = FirebaseFirestore.getInstance();
        farmersList = new ArrayList<>();
        farmerAdapter = new FarmerAdapter(farmersList);
        recyclerView.setAdapter(farmerAdapter);

        db.collection("farmers")
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                        UserModel farmer = document.toObject(UserModel.class);
                        farmersList.add(farmer);
                    }
                    farmerAdapter.notifyDataSetChanged();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Error retrieving farmers", Toast.LENGTH_SHORT).show();
                });
    }
}

