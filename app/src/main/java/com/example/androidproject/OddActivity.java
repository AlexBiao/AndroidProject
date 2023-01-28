package com.example.androidproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OddActivity extends AppCompatActivity
{
    TextView cxk;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odd);

        cxk = findViewById(R.id.cxk2);
    }
}
