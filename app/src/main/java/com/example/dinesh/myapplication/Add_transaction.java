package com.example.dinesh.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.solver.widgets.Snapshot;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Add_transaction extends AppCompatActivity {

    EditText amt;
    Spinner spinner;
    Button button;
    ArrayList<String> names = new ArrayList<String>();

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, names);

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child("users");

    FirebaseUser user = mAuth.getCurrentUser();

    String uid = user.getUid();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_add_transaction);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        amt = (EditText) findViewById(R.id.amount);
        spinner = (Spinner) findViewById(R.id.spinner);
        button = (Button)findViewById(R.id.add);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Users userinfo = new Users();
                userinfo.setName((String) dataSnapshot.child("FN6sV61ej6gN4eYn3cQkmbhzrP93").child("name").getValue());
                Log.d("TAG", "User name is " + userinfo.getName());

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });



        }


    public void mainActButton(View view){
        String amount = amt.getText().toString();
        int amt= Integer.parseInt(amount);
        //String name = spinner.getSelectedItem().toString();
        Intent added = new Intent(Add_transaction.this, main_page.class);
        added.putExtra("amount", amt);
       // added.putExtra("name" , name);
        startActivity(added);
    }
    }

