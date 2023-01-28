package com.example.androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorOrBmiActivity extends AppCompatActivity
{
    Button calculator_btn, bmi_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_or_bmi);
        init_View();
    }

    private void init_View()
    {
        calculator_btn = findViewById(R.id.calculator);
        calculator_btn.setOnClickListener(actionBtnOnClick);

        bmi_btn = findViewById(R.id.bmi);
        bmi_btn.setOnClickListener(actionBtnOnClick);
    }


    private View.OnClickListener actionBtnOnClick = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            switch (view.getId())
            {
                case R.id.calculator:
                    Intent intent = new Intent();
                    intent.setClass(CalculatorOrBmiActivity.this, CalculatorActivity.class);
                    startActivity(intent);
                    break;

                case R.id.bmi:
                    intent = new Intent();
                    intent.setClass(CalculatorOrBmiActivity.this, BmiActivity.class);
                    startActivity(intent);
                    break;

                default:
                    break;
            }
        }
    };


}

