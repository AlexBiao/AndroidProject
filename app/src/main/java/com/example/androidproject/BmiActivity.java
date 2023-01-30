package com.example.androidproject;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class BmiActivity extends AppCompatActivity {
    TextView result, comment, bmiTitle;
    EditText height_input, weight_input;
    Button calculate;

    String commentText;
    int resID;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        init_View();
    }

    private void init_View() {
        height_input = findViewById(R.id.height_input);
        weight_input = findViewById(R.id.weight_input);
        result = findViewById(R.id.result);
        comment = findViewById(R.id.comment);
        bmiTitle = findViewById(R.id.bmi_title);
        calculate = findViewById(R.id.calculate_bmi);
        calculate.setOnClickListener(actionBtnOnClick);
        resID = getResources().getIdentifier("bmi_title", "string", getPackageName());
        commentText = getString(resID);
        bmiTitle.setText(commentText);

    }

    private View.OnClickListener actionBtnOnClick = new View.OnClickListener()
    {

        @Override
        public void onClick(View view)
        {
            switch (view.getId())
            {
                case R.id.calculate_bmi:

                    String h = height_input.getText().toString();
                    String w = weight_input.getText().toString();

                    if (h.equals("") || w.equals("") || h.equals("0") || w.equals("0"))
                    {
                        Toast.makeText(getApplicationContext(), "Enter BOTH height and weight!", Toast.LENGTH_LONG).show();
                    }

                    else
                    {
                        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                        inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(),0);
                        double height = Double.parseDouble(h);
                        double weight = Double.parseDouble(w);
                        double result_data = weight / ((height/100) * (height/100));

                        DecimalFormat df = new DecimalFormat("0.000");
                        String result_String = df.format(result_data);
                        Toast.makeText(getApplicationContext(), "BMI is: " + result_String, Toast.LENGTH_SHORT).show();
                        result.setText(result_String);
                        if (result_data < 18)
                        {
                            resID = getResources().getIdentifier("underweight", "string", getPackageName());
                            commentText = getString(resID);
                            comment.setText(commentText);
                            comment.setTextColor(Color.rgb(255, 0, 0));
                        }
                        else if (result_data <= 24 & result_data >= 18)
                        {
                            resID = getResources().getIdentifier("healthy", "string", getPackageName());
                            commentText = getString(resID);
                            comment.setText(commentText);
                            comment.setTextColor(Color.rgb(0, 255, 0));
                        }

                        else if (result_data > 24)
                        {
                            resID = getResources().getIdentifier("overweight", "string", getPackageName());
                            commentText = getString(resID);
                            comment.setText(commentText);
                            comment.setTextColor(Color.rgb(255, 0, 0));
                        }

                    }
                    break;
                default:
                    break;
            }


        }
    };

}


