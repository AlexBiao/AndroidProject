package com.example.androidproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OddActivity extends AppCompatActivity
{
    TextView cxk;
    int resID;
    String text;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odd);
        cxk = findViewById(R.id.cxk2);
        resID = getResources().getIdentifier("english", "string", getPackageName());
        text = getString(resID);
        cxk.setText(text);
    }
}
