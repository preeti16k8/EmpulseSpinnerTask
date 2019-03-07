package com.preeti.spinnereg;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner classSpinner, divSpinner;
    String selectedClass ,selectedDiv;
    TextView tv_selecteditems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        classSpinner = (Spinner) findViewById(R.id.classSpinner);
        divSpinner = (Spinner) findViewById(R.id.divSpinner);
        tv_selecteditems=(TextView)findViewById(R.id.tv_selecteditems);

        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                 selectedClass = parent.getItemAtPosition(position).toString();
                switch (selectedClass)
                {
                    case "Class 1":
                        divSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_1)));
                        break;

                    case "Class 2":
                        divSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_2)));
                        break;

                    case "Class 3":
                        divSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_3)));
                        break;

                    case "Class 4":
                        divSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_4)));
                        break;
                }

                divSpinner.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

        divSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                selectedDiv = parent.getItemAtPosition(position).toString();

              /*  Toast.makeText(MainActivity.this, "\n Class: \t " + selectedClass +
                        "\n Div: \t" + selectedDiv, Toast.LENGTH_LONG).show();*/
                tv_selecteditems.setText(selectedClass+ " : "+ selectedDiv);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }

        });
    }
}
