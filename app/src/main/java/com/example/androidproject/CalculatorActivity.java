package com.example.androidproject;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    TextView result,solution;
    MaterialButton button_Ac, button_Divide, button_Multiply, button_Minus, button_Plus, button_Equal;
    MaterialButton one, two, three, four, five, six, seven, eight, nine, zero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        result = findViewById(R.id.result);
        solution = findViewById(R.id.solution);

        assignId(one, R.id.button_1);
        assignId(two, R.id.button_2);
        assignId(three, R.id.button_3);
        assignId(four, R.id.button_4);
        assignId(five, R.id.button_5);
        assignId(six, R.id.button_6);
        assignId(seven, R.id.button_7);
        assignId(eight, R.id.button_8);
        assignId(nine, R.id.button_9);
        assignId(zero, R.id.button_0);

        assignId(button_Ac, R.id.button_ac);
        assignId(button_Divide, R.id.button_divide);
        assignId(button_Minus, R.id.button_minus);
        assignId(button_Multiply, R.id.button_multiply);
        assignId(button_Plus, R.id.button_plus);
        assignId(button_Equal, R.id.button_equal);
    }

    void assignId(MaterialButton btn, int id)
    {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = solution.getText().toString();

        if(buttonText.equals("AC"))
        {
            solution.setText("");
            result.setText("0");

            return;
        }


        if (buttonText.equals("="))
        {
            solution.setText(result.getText());
            return;
        }


        dataToCalculate = dataToCalculate + buttonText;

        solution.setText(dataToCalculate);
        String finalResult = getResult(dataToCalculate);
        if (!finalResult.equals("Error"))
        {
            result.setText(finalResult);
        }






    }

    String getResult(String data)
    {
        try{
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initSafeStandardObjects();
            String finalResult = context.evaluateString(scriptable, data, "Javascript",1, null).toString();
            return finalResult;

        }catch (Exception e)
        {
            return "Error";
        }



    }
}