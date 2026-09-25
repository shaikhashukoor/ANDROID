package com.example.imagealert;

import android.app.AlertDialog;
import android.icu.text.ListFormatter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    GridView g;

    int[] images = {
            R.drawable.apple,
            R.drawable.banana,
            R.drawable.orange,
    };
    String[] names = {
            "apple",
            "banana",
            "orange",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        g = findViewById(R.id.gv);
        g.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {

                return images.length;
            }

            @Override
            public Object getItem(int position) {
                return images[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView i = new ImageView(MainActivity.this);
                i.setImageResource(images[position]);
                i.setLayoutParams(new GridView.LayoutParams(300,300));
                i.setScaleType(ImageView.ScaleType.CENTER_CROP);
                return i;
            }
        });
        g.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("SELECTED IMAGE")
                                .setMessage("you selected " + names[position])
                                .setPositiveButton("ok", null)
                                .show();
                    }
                });
    }
}



