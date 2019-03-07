package com.preeti.spinnereg;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {


    Spinner CountrySpinner,StatesSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CountrySpinner = (Spinner)findViewById(R.id.spinner1);
        StatesSpinner = (Spinner)findViewById(R.id.spinner2);
        CountrySpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String sp1= String.valueOf(CountrySpinner.getSelectedItem());
        Toast.makeText(this, sp1, Toast.LENGTH_SHORT).show();
        if(sp1.contentEquals("India")) {
            List<String> list = new ArrayList<String>();
            list.add("Madhya Pradesh");
            list.add("Uttar Pradesh");
            list.add("Karnataka");
            list.add("Andhra Pradesh");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            StatesSpinner.setAdapter(dataAdapter);
        }
        if(sp1.contentEquals("Pakistan")) {
            List<String> list = new ArrayList<String>();
            list.add("Sindh");
            list.add("Islamabad");
            list.add("Punjab");
            list.add("Balochistan");
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            StatesSpinner.setAdapter(dataAdapter2);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
