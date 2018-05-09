package com.example.keyboardsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private String mSpinnerLabel = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.label_spinner);

        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array,android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if (spinner != null) { spinner.setAdapter(adapter); }
    }

    public void showText(View view) {

        EditText editText = findViewById(R.id.editText_main);
        TextView textView = findViewById(R.id.text_phonelabel);

        if (editText != null) {
            String showString = (editText.getText().toString() + " - " + mSpinnerLabel);
            String showString2 = (editText.getText().toString());

            Toast.makeText(this, showString, Toast.LENGTH_SHORT).show();
            textView.setText(showString2);

        }
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        mSpinnerLabel = adapterView.getItemAtPosition(i).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
