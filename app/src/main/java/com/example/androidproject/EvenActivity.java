package com.example.androidproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EvenActivity extends AppCompatActivity
{
    TextView cxk;
    int resID;
    String text;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_even);

        cxk = findViewById(R.id.cxk1);
        resID = getResources().getIdentifier("chinese", "string", getPackageName());
        text = getString(resID);
        cxk.setText(text);
    }
}
