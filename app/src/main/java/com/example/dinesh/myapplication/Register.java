package com.example.dinesh.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity implements View.OnClickListener{

    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignin;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();

        buttonRegister = (Button) findViewById(R.id.Register);

        editTextEmail = (EditText) findViewById(R.id.addEmail);
        editTextPassword = (EditText) findViewById(R.id.addPassword);
        textViewSignin = (TextView) findViewById(R.id.signin);

        progressDialog = new ProgressDialog(this);

        buttonRegister.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);

    }

    private void registerUser(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this , "Enter valid Email", Toast.LENGTH_SHORT);
            Toast.show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this , "Enter your password", Toast.LENGTH_SHORT);
            Toast.show();
            return;
        }

        else{
            progressDialog.setMessage("Registering User...");
            progressDialog.show();

            firebaseAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();

                                Intent mainA = new Intent(Register.this, MainActivity.class);
                                startActivity(mainA);
                            }
                            else{
                                Toast.makeText(Register.this, "Not Successful", Toast.LENGTH_SHORT).show();
                            }
                        }
                    })

        }


    }

    @Override
    public void onClick(View view) {
        if(view == buttonRegister){
            registerUser();
        }

        if(view == textViewSignin){
            Intent login = new Intent(Register.this, LoginActivity.class);
            startActivity(login);
        }
    }
}
