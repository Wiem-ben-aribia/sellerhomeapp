package com.example.examproject.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.examproject.Domain.itemsDomain;
import com.example.examproject.R;
import com.example.examproject.activities.DetailsActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView .Adapter<ItemsAdapter.ViewHolder> {
    ArrayList<itemsDomain> items ;
    DecimalFormat formatter;
    Context context;

    public ItemsAdapter(ArrayList<itemsDomain> items) {
        this.items = items;
        formatter=new DecimalFormat("###,###,###,###,##");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viewholder,parent,false);
        context=parent.getContext();

        return new ViewHolder(inflate);
    }

    @SuppressLint({"RecyclerView", "SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String title = items.get(position).getTitle();
        if (title != null) {
            holder.titletext.setText(title);
        } else {
            holder.titletext.setText("No title available");

        }
        holder.adresstxt.setText(items.get(position).getAddress());
        holder.pricetxt.setText("$"+ formatter.format(items.get(position).getPrice()));
        int drawableResouceId =holder.itemView.getResources().getIdentifier(items.get(position).getpic(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResouceId)
                .into(holder.pic);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,DetailsActivity.class);
                intent.putExtra("object",items.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titletext,adresstxt,pricetxt;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titletext= itemView.findViewById(R.id.titletext);
            adresstxt=itemView.findViewById(R.id.adresstxt);
            pricetxt=itemView.findViewById(R.id.pricetxt);
            pic=itemView.findViewById(R.id.pic);
        }
    }
}
