package com.example.main;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // dropdown_menu
    String[] kinds = {"Shiran", "Food", "Moovit"};
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText outcome_text = findViewById(R.id.outcome);
        EditText income_text = findViewById(R.id.income);
        Button submit = findViewById(R.id.submit);
        // submit press
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = "";
                // if didn't enter
                if (outcome_text.getText().toString().equals("") && income_text.getText().toString().equals(""))
                    s = "enter outcome/income";
                if (!outcome_text.getText().toString().equals("")) {
                    int outcome = Integer.parseInt(outcome_text.getText().toString());
                    s = "outcome is: " + String.valueOf(outcome) + " ";
                }
                if (!income_text.getText().toString().equals("")){
                    int income = Integer.parseInt(income_text.getText().toString());
                    s = s + "income is: " + String.valueOf(income);
                }
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
            }
        });

        autoCompleteTxt = findViewById(R.id.autoCompleteTextView);
        adapterItems = new ArrayAdapter<String>(this, R.layout.dropdown_item, kinds);
        autoCompleteTxt.setAdapter(adapterItems);
        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 String item = adapterView.getItemAtPosition(i).toString();

            }
        });




    }
}














