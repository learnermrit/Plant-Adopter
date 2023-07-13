package com.example.minorproject;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class Register extends AppCompatActivity {
    TextInputEditText editTextEmail, editTextPassword;
    EditText name, rePass, aadhar, pan, contact, address;
    TextView textView;
    Button buttonReg;
    FirebaseAuth mAuth;
    FirebaseFirestore firebaseFirestore;
    ProgressBar progressBar;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent(getApplicationContext(), adopter_home.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String userType = getIntent().getStringExtra("userType");
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        name = findViewById(R.id.name);
        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        rePass = findViewById(R.id.rpass);
        aadhar = findViewById(R.id.adhar);
        pan = findViewById(R.id.pan);
        contact = findViewById(R.id.contact);
        address = findViewById(R.id.address);
        buttonReg = findViewById(R.id.btn_register);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.loginNow);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Me.class);
                startActivity(intent);
                finish();
            }
        });


        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email, password, namet, aadhart, pant, conatactt, addresst;
                namet = name.getText().toString();
                aadhart = aadhar.getText().toString();
                pant = pan.getText().toString();
                conatactt = contact.getText().toString();
                addresst = address.getText().toString();
                email = String.valueOf(editTextEmail.getText());
                password = String.valueOf(editTextPassword.getText());

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Register.this, "Enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Register.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

               // String userType = getIntent().getStringExtra("userType");
                if (userType.equals("adopter")) {
                    // run the code for adopter login
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {

                                        Toast.makeText(Register.this, "Acount created",
                                                Toast.LENGTH_SHORT).show();

                                        firebaseFirestore.collection("adopters").document(FirebaseAuth.getInstance().getUid()).set(new UserModel(namet, email, password, aadhart, pant, conatactt, addresst,userType));

//                                        firebaseFirestore.collection("users")
//                                                .get()
//                                                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                                                    @Override
//                                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                                                        if (task.isSuccessful()) {
//                                                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                                                Log.d(TAG, document.getId() + " => " + document.getData());
//
//                                                            }
//                                                        } else {
//                                                            Log.w(TAG, "Error getting documents.", task.getException());
//                                                        }
//                                                    }
//                                                });
                                        // Sign in success, update UI with the signed-in user's information
                                        //Log.d(TAG, "createUserWithEmail:success");
                                        //  FirebaseUser user = mAuth.getCurrentUser();
                                        // updateUI(user);
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        // Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                        Toast.makeText(Register.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                        // updateUI(null);
                                    }
                                }
                            });
                } else if (userType.equals("farmer")) {
                    // run the code for farmer login
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {

                                        Toast.makeText(Register.this, "Acount created",
                                                Toast.LENGTH_SHORT).show();

                                        firebaseFirestore.collection("farmers").document(FirebaseAuth.getInstance().getUid()).set(new UserModel(namet, email, password, aadhart, pant, conatactt, addresst,userType));

//                                        firebaseFirestore.collection("users")
//                                                .get()
//                                                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                                                    @Override
//                                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                                                        if (task.isSuccessful()) {
//                                                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                                                Log.d(TAG, document.getId() + " => " + document.getData());
//
//                                                            }
//                                                        } else {
//                                                            Log.w(TAG, "Error getting documents.", task.getException());
//                                                        }
//                                                    }
//                                                });
                                        // Sign in success, update UI with the signed-in user's information
                                        //Log.d(TAG, "createUserWithEmail:success");
                                        //  FirebaseUser user = mAuth.getCurrentUser();
                                        // updateUI(user);
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        // Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                        Toast.makeText(Register.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                        // updateUI(null);
                                    }
                                }
                            });
                } else {
                    // handle the case where userType is neither "adopter" nor "farmer"
                    Toast.makeText(Register.this, "no body", Toast.LENGTH_SHORT).show();
                }



            }
        });

    }
}