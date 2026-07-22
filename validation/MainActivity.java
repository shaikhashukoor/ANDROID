package com.example.validataion;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText etName, etEmail, etPassword;
    RadioGroup rgGender;
    Spinner spCountry;
    Button btSubmit;
    CheckBox chkTerms;

    String[] country = {"select country", "india", "usa", "uk", "canada"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.editTextText);
        etEmail = findViewById(R.id.editTextText2);
        etPassword = findViewById(R.id.editTextText3);
        spCountry = findViewById(R.id.spinner);
        rgGender=findViewById(R.id.radioGroup2);
        chkTerms = findViewById(R.id.checkBox);
        btSubmit = findViewById(R.id.button);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                country
        );

        spCountry.setAdapter(adapter);
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();

                String password = etPassword.getText().toString().trim();

                if (name.isEmpty()) {
                    etName.setError("enter name");
                    return;
                }
                if (email.isEmpty()) {
                    etEmail.setError("enter email");
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                   etEmail.setError("invalid email");
                   return;
                }
                if (password.length() < 8) {
                    etPassword.setError("password must be at least 8 characters");
                    return;
                }

                if (rgGender.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(MainActivity.this, "select gender", Toast.LENGTH_SHORT).show();
                    return;

                }
                if (spCountry.getSelectedItemPosition() == 0) {
                    Toast.makeText(MainActivity.this, "select country", Toast.LENGTH_SHORT).show();
                    return;

                }

                if (!chkTerms.isChecked()) {
                    Toast.makeText(MainActivity.this, "accept terms and conditions", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(MainActivity.this, "validation successfull", Toast.LENGTH_SHORT).show();
                return;
            }


        });
    }
}


