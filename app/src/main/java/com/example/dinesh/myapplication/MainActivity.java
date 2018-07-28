package com.example.dinesh.myapplication;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {


    //public String[] users = new String[]();

/*    public void addUser (String[] users){
        users.add("");
    }*/

    ArrayList<String> mylist = new ArrayList<String>();

    public void setMylist(ArrayList<String> mylist) {
        this.mylist = mylist;
        mylist.add("Vivek");
        mylist.add("Vidit");
        mylist.add("Rahul");
        mylist.add("Himani");
        mylist.add("Deepak");
        mylist.add("Sankalp");
        mylist.add("Gourav");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

*/
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Spinner spinner = findViewById(R.id.spinner);

        setMylist(mylist);

        /*ArrayAdapter<ArrayList<String>> adapter = new ArrayAdapter<ArrayList<String>>(this,
                android.R.layout.simple_spinner_item, mylist);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
*/
        ArrayAdapter<ArrayList<String>> adapter= new ArrayAdapter<ArrayList<String>>(this,android.R.layout.simple_spinner_item, Collections.singletonList(mylist));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }
}
