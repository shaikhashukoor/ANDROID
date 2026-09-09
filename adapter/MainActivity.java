package com.example.adapter;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    EditText num1, num2;
    Button btndivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        listview = findViewById(R.id.ls);
        num1 = findViewById(R.id.editTextText3);
        num2 = findViewById(R.id.editTextText4);
        btndivide = findViewById(R.id.button2);

        String[] students = {
                "anu",
                "arun",
                "rahul",
                "meera",
                "akhil",
                "aaru",
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, students);
        listview.setAdapter(adapter);
        btndivide.setOnClickListener(view -> {
            try {
                int a = Integer.parseInt(num1.getText().toString());
                int b = Integer.parseInt(num2.getText().toString());
                int result = a / b;
                Toast.makeText(MainActivity.this, "result= " + result, Toast.LENGTH_SHORT).show();
            } catch (ArithmeticException e) {
                Toast.makeText(MainActivity.this, "cant divide by zero", Toast.LENGTH_SHORT).show();
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "enter valid number", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "AN ERROR OCCUERED", Toast.LENGTH_SHORT).show();


            }
        });
    }
}
