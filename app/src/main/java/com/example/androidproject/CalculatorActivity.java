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



        ini_View();
    }

    void ini_View()
    {
        zero = findViewById(R.id.button_0);
        zero.setText(getString(R.string.zero));
        zero.setOnClickListener(this);

        one = findViewById(R.id.button_1);
        one.setText(getString(R.string.one));
        one.setOnClickListener(this);


        two = findViewById(R.id.button_2);
        two.setText(getString(R.string.two));
        two.setOnClickListener(this);


        three = findViewById(R.id.button_3);
        three.setText(getString(R.string.three));
        three.setOnClickListener(this);


        four = findViewById(R.id.button_4);
        four.setText(getString(R.string.four));
        four.setOnClickListener(this);


        five = findViewById(R.id.button_5);
        five.setText(getString(R.string.five));
        five.setOnClickListener(this);


        six = findViewById(R.id.button_6);
        six.setText(getString(R.string.six));
        six.setOnClickListener(this);


        seven = findViewById(R.id.button_7);
        seven.setText(getString(R.string.seven));
        seven.setOnClickListener(this);


        eight = findViewById(R.id.button_8);
        eight.setText(getString(R.string.eight));
        eight.setOnClickListener(this);


        nine = findViewById(R.id.button_9);
        nine.setText(getString(R.string.nine));
        nine.setOnClickListener(this);


        button_Ac = findViewById(R.id.button_ac);
        button_Ac.setText(getString(R.string.AC));
        button_Ac.setOnClickListener(this);


        button_Divide = findViewById(R.id.button_divide);
        button_Divide.setText(getString(R.string.divide));
        button_Divide.setOnClickListener(this);


        button_Plus = findViewById(R.id.button_plus);
        button_Plus.setText(getString(R.string.plus));
        button_Plus.setOnClickListener(this);


        button_Minus = findViewById(R.id.button_minus);
        button_Minus.setText(getString(R.string.minus));
        button_Minus.setOnClickListener(this);


        button_Multiply = findViewById(R.id.button_multiply);
        button_Multiply.setText(getString(R.string.multiply));
        button_Multiply.setOnClickListener(this);


        button_Equal = findViewById(R.id.button_equal);
        button_Equal.setText(getString(R.string.equals));
        button_Equal.setOnClickListener(this);


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