package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity
{
    Button calculate_btn, listView_btn, calculator_btn, bmi_btn;
    TextView mainTitle;
    private PopupWindow popCalculate;
    private View calculateView;

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
        calculate_btn.setText(getString(R.string.calculate));
        calculate_btn.setOnClickListener(actionBtnOnClick);

        listView_btn = findViewById(R.id.listView);
        listView_btn.setText(getString(R.string.listview));
        listView_btn.setOnClickListener(actionBtnOnClick);

        mainTitle = findViewById(R.id.main_title);
        mainTitle.setText(getString(R.string.main_title));
        go_to_calculate();
    }


    private View.OnClickListener actionBtnOnClick = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            switch (view.getId())
            {
                case R.id.calculate:
                    popCalculateWindow(calculateView);
                    break;

                case R.id.listView:
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, ListActivity.class);
                    startActivity(intent);
                    break;
                case R.id.calculator:
                    intent = new Intent();
                    intent.setClass(MainActivity.this, CalculatorActivity.class);
                    startActivity(intent);

                    WindowManager.LayoutParams lp = getWindow().getAttributes();
                    lp.alpha =  1f;
                    getWindow().setAttributes(lp);
                    popCalculate.dismiss();
                    break;
                case R.id.bmi:
                    intent = new Intent();
                    intent.setClass(MainActivity.this, BmiActivity.class);
                    startActivity(intent);

                    lp = getWindow().getAttributes();
                    lp.alpha =  1f;
                    getWindow().setAttributes(lp);
                    popCalculate.dismiss();
                    break;

                    default:
                    break;
            }
        }
    };

    public void go_to_calculate()
    {
        LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        calculateView = layoutInflater.inflate(R.layout.activity_calculator_or_bmi, null);

        calculator_btn = calculateView.findViewById(R.id.calculator);
        calculator_btn.setOnClickListener(actionBtnOnClick);

        bmi_btn = calculateView.findViewById(R.id.bmi);
        bmi_btn.setOnClickListener(actionBtnOnClick);
    }

    public void popCalculateWindow(final View popupView)
    {
        popCalculate = new PopupWindow(
                popupView,
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        popCalculate.showAtLocation(this.findViewById(R.id.main), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

        popCalculate.setOutsideTouchable(true);

        WindowManager.LayoutParams lp = getWindow().getAttributes();

        lp.alpha =  0.2f;
        getWindow().setAttributes(lp);

        popupView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                int height = popupView.findViewById(R.id.id_pop_layout).getTop();
                int bottom = popupView.findViewById(R.id.id_pop_layout).getBottom();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height || y > bottom) {

                        lp.alpha = 1f;
                        getWindow().setAttributes(lp);

                        popCalculate.dismiss();
                    }
                }
                return true;
            }
        });
    }



}

