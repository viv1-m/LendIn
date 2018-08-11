package com.example.dinesh.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TableLayout;

public class main_page extends AppCompatActivity {

    TableLayout tableLayout;
    EditText balanceText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        tableLayout = (TableLayout) findViewById(R.id.tableTrans);
        balanceText = (EditText) findViewById(R.id.balance);


    }
}
