package com.example.registrationactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button b;
    EditText e1,e2,e3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        b=findViewById(R.id.button);
        e1=findViewById(R.id.editTextText);
        e2=findViewById(R.id.editTextText2);
        e3=findViewById(R.id.editTextText3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=e1.getText().toString();
                String e=e2.getText().toString();
                String p=e3.getText().toString();



                SharedPreferences sp=getSharedPreferences("userdata",MODE_PRIVATE);
                SharedPreferences.Editor editor=sp.edit();
                editor.putString("name",n);
                editor.putString("email",e);
                editor.putString("password",p);
                editor.commit();

                Toast.makeText(MainActivity.this, "registration successful", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("username",n);
                intent.putExtra("email",e);
                intent.putExtra("password",p);
                startActivity(intent);

            }
        });


        }
    }
