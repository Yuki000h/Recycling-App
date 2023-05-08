package com.example.recyclingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    private TextView txtSignIn;//for Login Redirect
    private FirebaseAuth auth;
    private FirebaseDatabase database;
    private DatabaseReference dbReference;
    private EditText SignUpEmail,SignUpPassword, SignUpPhone, SignUpconPass, SignUpName;
    private Button singupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        auth = FirebaseAuth.getInstance();

        txtSignIn = findViewById(R.id.txtSignIn);
        SignUpName = findViewById(R.id.edtSignUpFullName);
        SignUpEmail = findViewById(R.id.edtSignUpEmail);
        SignUpPhone = findViewById(R.id.edtSignUpMobile);
        SignUpPassword = findViewById(R.id.edtSignUpPassword);
        SignUpconPass = findViewById(R.id.edtSignUpConfirmPassword);
        singupButton = findViewById(R.id.btnSignUp);

        singupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database = FirebaseDatabase.getInstance();
                dbReference = database.getReference("users");

                String name = SignUpName.getText().toString();
                String phone = SignUpPhone.getText().toString();
                String conPass = SignUpconPass.getText().toString();
                String user = SignUpEmail.getText().toString();
                String pass = SignUpPassword.getText().toString();

                HelperClass helperClass = new HelperClass(name, user, phone, conPass, pass);
                dbReference.child(name).setValue(helperClass);

                Toast.makeText(SignUpActivity.this, "You have been registered", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUpActivity.this, FormActivity.class);
                startActivity(intent);
            }
        });

        txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this,FormActivity.class);
                startActivity(intent);
            }
        });

    }
}