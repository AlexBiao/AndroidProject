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

        for (int i = 0; i < 4; i++)
        {
            arrayList.add(new Item(getString(R.string.cxk1), R.drawable.ji2));
            arrayList.add(new Item(getString(R.string.cxk2), R.drawable.ji2));
            arrayList.add(new Item(getString(R.string.cxk3), R.drawable.ji2));
            arrayList.add(new Item(getString(R.string.cxk4), R.drawable.ji2));
            arrayList.add(new Item(getString(R.string.cxk5), R.drawable.ji2));
        }



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
