package com.example.androidproject;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{



    Context context;
    List<Item> items;
    private final RecyclerViewInterface recyclerViewInterface;

    public Adapter(Context context, List<Item> items, RecyclerViewInterface recyclerViewInterface)
    {

        this.context = context;
        this.items = items;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent,false), recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.text.setText(items.get(position).getText());
        holder.image.setImageResource(items.get(position).getImage());

    }

    @Override
    public int getItemCount()
    {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        RecyclerViewInterface recyclerViewInterface;


        ImageView image;
        TextView text;
        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            text = itemView.findViewById(R.id.text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    if (recyclerViewInterface != null)
                    {
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION)
                        {
                            recyclerViewInterface.onClick(pos);
                        }
                    }
                }
            });
        }
    }


}
