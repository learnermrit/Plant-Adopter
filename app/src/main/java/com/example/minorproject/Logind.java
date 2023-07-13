package com.example.minorproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

public class Logind extends AppCompatActivity {

    TextInputEditText editTextEmail,editTextPassword;
    TextView textView;
    Button buttonLogin;
    FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent =new Intent(getApplicationContext(),Me.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logind);
       // String userType = getIntent().getStringExtra("userType");
        String userType = getIntent().getStringExtra("userType");

        mAuth= FirebaseAuth.getInstance();
        editTextEmail=findViewById(R.id.email);
        editTextPassword=findViewById(R.id.password);
        buttonLogin = findViewById(R.id.btn_login);
        progressBar=findViewById(R.id.progressBar);
        textView= findViewById(R.id.registerNow);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent =new Intent(getApplicationContext(),Register.class);
                intent.putExtra("userType", userType);
                startActivity(intent);
//                Intent intent =new Intent(getApplicationContext(),Register.class);
//                startActivity(intent);
                finish();
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email,password;
                email= String.valueOf(editTextEmail.getText());
                password = String.valueOf(editTextPassword.getText());

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(Logind.this, "Enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(Logind.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Login successful, navigate to home activity
                                    Intent intent =new Intent(getApplicationContext(),Me.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // Login failed, show error message
                                    Toast.makeText(Logind.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                // Check if user is of type "farmer"
//                if (userType.equals("farmer")) {
//                    FirebaseFirestore db = FirebaseFirestore.getInstance();
//                    CollectionReference farmersRef = db.collection("farmers");
//                    Query query = farmersRef.whereEqualTo("email", email);
//                    query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                        @Override
//                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                            if (task.isSuccessful()) {
//                                // Check if a farmer with this email exists
//                                if (task.getResult().size() > 0) {
//                                    // Authenticate user with Firebase Auth
//                                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
//                                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                                                @Override
//                                                public void onComplete(@NonNull Task<AuthResult> task) {
//                                                    if (task.isSuccessful()) {
//                                                        // Login successful, navigate to home activity
//                                                        Intent intent =new Intent(getApplicationContext(),Me.class);
//                                                          startActivity(intent);
//                                                           finish();
////                                                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
////                                                        finish();
//                                                    } else {
//                                                        // Login failed, show error message
//                                                        Toast.makeText(Logind.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
//                                                    }
//                                                }
//                                            });
//                                } else {
//                                    // No farmer with this email exists, show error message
//                                    Toast.makeText(Logind.this, "Invalid email mrit or password.", Toast.LENGTH_SHORT).show();
//                                }
//                            } else {
//                                // Error fetching data from Firestore, show error message
//                                Toast.makeText(Logind.this, "Error fetching data from Firestore.", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//                }
//                else if (userType.equals("adopter")) {
//                    FirebaseFirestore db = FirebaseFirestore.getInstance();
//                    CollectionReference farmersRef = db.collection("adopters");
//                    Query query = farmersRef.whereEqualTo("email", email);
//                    query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                        @Override
//                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                            if (task.isSuccessful()) {
//                                // Check if a farmer with this email exists
//                                if (task.getResult().size() > 0) {
//                                    // Authenticate user with Firebase Auth
//                                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
//                                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                                                @Override
//                                                public void onComplete(@NonNull Task<AuthResult> task) {
//                                                    if (task.isSuccessful()) {
//                                                        // Login successful, navigate to home activity
//                                                        Intent intent =new Intent(getApplicationContext(),Me.class);
//                                                        startActivity(intent);
//                                                        finish();
////                                                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
////                                                        finish();
//                                                    } else {
//                                                        // Login failed, show error message
//                                                        Toast.makeText(Logind.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
//                                                    }
//                                                }
//                                            });
//                                } else {
//                                    // No farmer with this email exists, show error message
//                                    Toast.makeText(Logind.this, "Invalid email or password.", Toast.LENGTH_SHORT).show();
//                                }
//                            } else {
//                                // Error fetching data from Firestore, show error message
//                                Toast.makeText(Logind.this, "Error fetching data from Firestore.", Toast.LENGTH_SHORT).show();
////                            }
//                        }
//                    });
//                }
//
//                else {
//                    // User is not a farmer, proceed with authentication
//                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
//                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                                @Override
//                                public void onComplete(@NonNull Task<AuthResult> task) {
//                                    if (task.isSuccessful()) {
//                                        // Login successful, navigate to home activity
//                                        Intent intent =new Intent(getApplicationContext(),Me.class);
//                                        startActivity(intent);
//                                        finish();
//                                    } else {
//                                        // Login failed, show error message
//                                        Toast.makeText(Logind.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//                            });
//                }
             //   This code first checks if the user type is "farmer". If it is, it queries the Firestore database to see if a farmer with the entered email exists. If it does, it proceeds with Firebase authenticatio
//                just to authenticate no check
//                mAuth.signInWithEmailAndPassword(email, password)
//                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                progressBar.setVisibility(View.GONE);
//                                if (task.isSuccessful()) {
//                                    Toast.makeText(Logind.this, "Login Successful", Toast.LENGTH_SHORT).show();
//                                    Intent intent =new Intent(getApplicationContext(),Me.class);
//                                    startActivity(intent);
//                                    finish();
//                                    // Sign in success, update UI with the signed-in user's information
//                                   // Log.d(TAG, "signInWithEmail:success");
//                                  //  FirebaseUser user = mAuth.getCurrentUser();
//                                  //  updateUI(user);
//                                } else {
//                                    // If sign in fails, display a message to the user.
//                                   // Log.w(TAG, "signInWithEmail:failure", task.getException());
//                                    Toast.makeText(Logind.this, "Authentication failed.",
//                                            Toast.LENGTH_SHORT).show();
//                                   // updateUI(null);
//                                }
//                            }
//                        });
            }
        });
    }
}