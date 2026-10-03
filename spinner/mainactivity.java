package com.example.Spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.spinner.R;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    TextView textView2;

    String[] courses = {
            "MCA",
            "MBA",
            "BCA",
            "BBA",
            "BSc Computer Science"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Connect Java variables with XML views
        spinner = findViewById(R.id.spinner);
        textView2 = findViewById(R.id.textView2);

        // Create adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                courses
        );

        // Dropdown layout
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        // Set adapter to Spinner
        spinner.setAdapter(adapter);

        // Handle Spinner selection
        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {

                        String course =
                                parent.getItemAtPosition(position).toString();

                        textView2.setText(
                                "Selected course: " + course
                        );
                    }

                    @Override
                    public void onNothingSelected(
                            AdapterView<?> parent) {
                        textView2.setText("No course selected");
                    }
                }
        );
    }
}
