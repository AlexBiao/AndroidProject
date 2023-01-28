package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button calculate_btn, listView_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init_View();
    }

    private void init_View()
    {

        calculate_btn = findViewById(R.id.calculate);
        calculate_btn.setOnClickListener(actionBtnOnClick);

        listView_btn = findViewById(R.id.listView);
        listView_btn.setOnClickListener(actionBtnOnClick);
    }


    private View.OnClickListener actionBtnOnClick = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            switch (view.getId())
            {
                case R.id.calculate:
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, CalculatorOrBmiActivity.class);
                    startActivity(intent);
                    break;

                case R.id.listView:
                    intent = new Intent();
                    intent.setClass(MainActivity.this, ListActivity.class);
                    startActivity(intent);
                    break;

                default:
                    break;
            }
        }
    };


}

