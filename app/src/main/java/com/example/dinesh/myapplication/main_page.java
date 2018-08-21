package com.example.dinesh.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class main_page extends AppCompatActivity {

    TableLayout tableLayout;
    TextView balanceText;
    TextView tvName;
    TextView tvAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        int amt;
        String name;
        if(savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                amt = 0;
              //  name = null;
            } else {
                amt = extras.getInt("amount");
               // name=extras.getString("name");

                TableRow tableRow = new TableRow(this);

                // tvName.setText(R.string.name);
                tvAmount.setText(amt);
                //tableRow.addView(tvName);
                tableRow.addView(tvAmount);
                tableLayout.addView(tableRow);

            }
        }else {
            amt= (Integer) savedInstanceState.getSerializable("amount");
            //name= (String) savedInstanceState.getSerializable("name");

            TableRow tableRow = new TableRow(this);

            // tvName.setText(R.string.name);
            tvAmount.setText(amt);
            //tableRow.addView(tvName);
            tableRow.addView(tvAmount);
            tableLayout.addView(tableRow);

        }

        tableLayout = (TableLayout) findViewById(R.id.tableTrans);
        balanceText = (TextView) findViewById(R.id.balance);

        /*ArrayList<View> textViews  = tableLayout.getTouchables();

        for (View view:textViews
             ) {
            Log.v("a" , view.toString());
        }*/



    }

    public void addTransButtonClicked(){

        Intent TransPage = new Intent(main_page.this, Add_transaction.class);
        startActivity(TransPage);

    }
}
