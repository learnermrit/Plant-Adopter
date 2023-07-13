package com.example.minorproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

public class Adopter extends AppCompatActivity {

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
            Intent intent =new Intent(getApplicationContext(),farmer_dashboard.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopter);
        mAuth = FirebaseAuth.getInstance();
        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.btn_loginn);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.registerNow);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
                finish();
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email, password;
                email = String.valueOf(editTextEmail.getText());
                password = String.valueOf(editTextPassword.getText());

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Adopter.this, "Enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Adopter.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    Toast.makeText(Adopter.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), Me.class);
                                    startActivity(intent);
                                    finish();
                                    // Sign in success, update UI with the signed-in user's information
                                    // Log.d(TAG, "signInWithEmail:success");
                                    //  FirebaseUser user = mAuth.getCurrentUser();
                                    //  updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    // Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(Adopter.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    // updateUI(null);
                                }
                            }
                        });
            }
        });
    }
        /*username=findViewById(R.id.username);
        passwd=findViewById(R.id.pass);
        register=findViewById(R.id.register);
        login=findViewById(R.id.login);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Plant Adopter");
        }



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  Intent i=new Intent(Adopter.this,adopter_home.class);
                //String value=username.getText().toString().trim();
                //i.putExtra("identifier",value);
                startActivity(i);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  Intent i=new Intent(Adopter.this,your_plant.class);
                //String value=username.getText().toString().trim();
                //i.putExtra("identifier",value);
                startActivity(i);

            }
        });
    }*/
/*

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        new MenuInflater(this).inflate(R.menu.opt_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId= item.getItemId();
        if(itemId==R.id.search){
            Intent intent=new Intent(Adopter.this,Gmappp.class);
            startActivity(intent);
            return true;
        }
        else if(itemId==R.id.me){
            Intent intent=new Intent(Adopter.this,Me.class);
            startActivity(intent);
            return true;
        }
        else if(itemId==R.id.home){
            Intent intent=new Intent(Adopter.this,MainActivity.class);
            startActivity(intent);
            return true;
        }
        else if(itemId==android.R.id.home){
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }*/
}
