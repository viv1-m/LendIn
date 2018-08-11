package com.example.dinesh.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Activity extends AppCompatActivity {

    AutoCompleteTextView emailText ;
    EditText passwordText;
    Button sign_in_button;
    FirebaseAuth mAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(mAuth.getCurrentUser() != null){
            loggedin();
        }

        emailText = (AutoCompleteTextView) findViewById(R.id.email);
        passwordText = (EditText) findViewById(R.id.password);
        sign_in_button = (Button) findViewById(R.id.email_sign_in_button);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();

    }

    private void SigninUser(){
        String email = emailText.getText().toString().trim();
        String password = passwordText.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this , "Enter valid Email", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this , "Enter your password", Toast.LENGTH_SHORT).show();
            return;
        }

        else{
            progressDialog.setMessage("Verifying User...");
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Login_Activity.this, "Entered Successfully", Toast.LENGTH_SHORT).show();

                                Intent mainA = new Intent(Login_Activity.this, main_page.class);
                                startActivity(mainA);
                            }
                            else{
                                Toast.makeText(Login_Activity.this, "Not Successful", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }
                    });

        }

    }

    public void emailButtonClick(View view){
        SigninUser();
    }

    public void loggedin(){
        Intent loggedin = new Intent(Login_Activity.this, main_page.class);
        startActivity(loggedin);
    }

}
