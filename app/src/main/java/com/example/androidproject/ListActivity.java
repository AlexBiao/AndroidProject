package com.example.androidproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements RecyclerViewInterface
{
    private RecyclerView recyclerView;


    public ArrayList<Item> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        init_View();


        arrayList.add(new Item("鸡你太美",R.drawable.ji2));
        arrayList.add(new Item("守护最好的鸡哥",R.drawable.ji2));
        arrayList.add(new Item("非ikun勿进",R.drawable.ji2));
        arrayList.add(new Item("你干嘛哎呦",R.drawable.ji2));
        arrayList.add(new Item("唱、",R.drawable.ji2));
        arrayList.add(new Item("跳",R.drawable.ji2));
        arrayList.add(new Item("Rap",R.drawable.ji2));
        arrayList.add(new Item("篮球",R.drawable.ji2));
        arrayList.add(new Item("Music",R.drawable.ji2));
        arrayList.add(new Item("巅峰产生虚假的拥护，黄昏见证真正的信徒",R.drawable.ji2));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adapter(getApplicationContext(), arrayList, this));

    }

    private void init_View()
    {
        recyclerView = findViewById(R.id.recyclerView);
    }


    @Override
    public void onClick(int position)
    {
        Intent intent = new Intent();
        if (position % 2 == 0)
        {
            intent.setClass(ListActivity.this, OddActivity.class);
        }
        else
        {
            intent.setClass(ListActivity.this, EvenActivity.class);
        }
        startActivity(intent);

    }
}
