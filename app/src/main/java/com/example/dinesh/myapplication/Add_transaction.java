package com.example.dinesh.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Add_transaction extends AppCompatActivity {

    //Old file

    EditText amt;
    Spinner spinner;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_add_transaction);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        amt = (EditText) findViewById(R.id.amount);
        spinner = (Spinner) findViewById(R.id.spinner);
        button = (Button)findViewById(R.id.add);

        button.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        String amount = amt.getText().toString();
                        //int amt= Integer.parseInt(amount);
                        String name = spinner.getSelectedItem().toString();
                        Intent added = new Intent(Add_transaction.this, MainActivity.class);
                        added.putExtra("amount", amount);
                        startActivity(added);
                    }
                });
    }

}
