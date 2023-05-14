package com.example.recyclingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class FormActivity extends AppCompatActivity {
    private TextView txtSignUp;
    private FirebaseAuth auth;
    private EditText loginName, loginPassword;
    private Button loginButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formview);

        txtSignUp = findViewById(R.id.txtSignUp);//for registration Redirect
        loginName = findViewById(R.id.edtSignInName);
        loginPassword = findViewById(R.id.edtSignInPassword);
        loginButton = findViewById(R.id.btnSignIn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!validateUserName() | !validatePassword()){

                }else {
                    checkUser();
                }
            }
        });
        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
    public Boolean validateUserName() {
        String val = loginName.getText().toString();
        if (val.isEmpty()) {
            loginName.setError("Name must not be Empty");
            return false;
        } else {
            loginName.setError(null);
            return true;
        }
    }

    public Boolean validatePassword() {
        String val = loginPassword.getText().toString();
        if (val.isEmpty()) {
            loginPassword.setError("Password must not be Empty");
            return false;
        } else {
            loginPassword.setError(null);
            return true;
        }
    }
    public void checkUser() {
        String userUserName = loginName.getText().toString().trim();
        String userPassword = loginPassword.getText().toString().trim();

        DatabaseReference dbReference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = dbReference.orderByChild("name").equalTo(userUserName);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {
                    loginName.setError(null);
                    String passwordFromDB = snapshot.child(userUserName).child("password").getValue(String.class);

                    if (Objects.equals(passwordFromDB, userPassword)) {
                        loginName.setError(null);
                        Intent intent = new Intent(FormActivity.this, DashboardActivity.class);
                        startActivity(intent);
                    } else {
                        loginPassword.setError("Invalid Credentials");
                        loginPassword.requestFocus();
                    }
                } else {
                    loginName.setError("User Name does not exist");
                    loginName.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}