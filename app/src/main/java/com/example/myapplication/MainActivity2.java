package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView edtngay,edtnhiet;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edtngay=findViewById(R.id.txt11);
        edtnhiet=findViewById(R.id.txt22);
        img=findViewById(R.id.img);
        Bundle bd=getIntent().getExtras();
        String n;
        String t;
        int i;
        i=bd.getInt("key3");
        n=bd.getString("key1");
        t=bd.getString("key2");
        edtngay.setText(n);
        edtnhiet.setText(t);
        img.setImageResource(i);
    }
}