package com.example.androidproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class BmiActivity extends AppCompatActivity {
    TextView result;
    EditText height_input, weight_input;
    Button calculate;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        init_View();
    }

    private void init_View() {
        height_input = findViewById(R.id.height_input);
        weight_input = findViewById(R.id.weight_input);
        result = findViewById(R.id.result);
        calculate = findViewById(R.id.calculate_bmi);
        calculate.setOnClickListener(actionBtnOnClick);
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
                        Toast.makeText(getApplicationContext(), "Input can't be 0!", Toast.LENGTH_SHORT).show();
                    }

                    else
                    {
                        double height = Double.parseDouble(h);
                        double weight = Double.parseDouble(w);
                        double result_data = weight / (height * height);

                        DecimalFormat df = new DecimalFormat("0.000");
                        String result_String = df.format(result_data);
                        Toast.makeText(getApplicationContext(), "BMI is: " + result_String, Toast.LENGTH_SHORT).show();
                        result.setText(result_String);

                    }
                    break;
                default:
                    break;
            }


        }
    };

}


