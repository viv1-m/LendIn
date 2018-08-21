package com.example.dinesh.myapplication;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {


    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnimatedViewPager pager= findViewById(R.id.pager);
        pager.setAdapter(new AuthAdapter(getSupportFragmentManager(),pager));

        tableLayout = (TableLayout) findViewById(R.id.tableTrans);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("amount");
                int amount = Integer.parseInt(newString);
                TableRow addRow= new TableRow(this);
                TextView amt = new TextView(this);
                amt.setText(amount);
                tableLayout.addView(addRow);
                addRow.addView(amt);

            }
        } else {
            newString= (String) savedInstanceState.getSerializable("amount");
            int amount = Integer.parseInt(newString);
            TableRow addRow= new TableRow(this);
            TextView amt = new TextView(this);
            amt.setText(amount);
            tableLayout.addView(addRow);
            addRow.addView(amt);
        }


        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
       // Spinner spinner = findViewById(R.id.spinner);

        /*ArrayAdapter<ArrayList<String>> adapter = new ArrayAdapter<ArrayList<String>>(this,
                android.R.layout.simple_spinner_item, mylist);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ArrayAdapter<ArrayList<String>> adapter= new ArrayAdapter<ArrayList<String>>(this,android.R.layout.simple_spinner_item, Collections.singletonList(mylist));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }*/
    }
}
