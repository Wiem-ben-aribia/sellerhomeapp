package com.example.examproject.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.examproject.Adapter.ItemsAdapter;
import com.example.examproject.Domain.itemsDomain;
import com.example.examproject.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<itemsDomain> ItemsArraylist=new ArrayList<>();
        ItemsArraylist.add(new itemsDomain("House with great view","Sanfarnsisco,CA 94110","this 2bed /1 bath home an enormous\n"+
                "open-livingplan,accented by striking\n"+
                "architectural features and high-end finishes.\n"+
                "Feel inspired by open sight lines that\n"+
                "coffered ceilings.",2,1,841456,"pic1",true));
        ItemsArraylist.add(new itemsDomain("House with great view","paris, boulvard","this 2bed /1 bath home an enormous\n"+
                "open-livingplan,accented by striking\n"+
                "architectural features and high-end finishes.\n"+
                "Feel inspired by open sight lines that\n"+
                "coffered ceilings.",2,1,645677,"pic2",false));

        ItemsArraylist.add(new itemsDomain("House with great view","Bruxell","this 2bed /1 bath home an enormous\n"+
                "open-livingplan,accented by striking\n"+
                "architectural features and high-end finishes.\n"+
                "Feel inspired by open sight lines that\n"+
                "coffered ceilings.",2,1,841456,"pic1",true));
        RecyclerView recyclerViewPopular = findViewById(R.id.viewPopular);
        RecyclerView recyclerViewNew = findViewById(R.id.viewNew);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerViewNew.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        RecyclerView.Adapter<ItemsAdapter.ViewHolder> adapterNew = new ItemsAdapter(ItemsArraylist);
        RecyclerView.Adapter<ItemsAdapter.ViewHolder> adapterPopular = new ItemsAdapter(ItemsArraylist);
        recyclerViewNew.setAdapter(adapterNew);
        recyclerViewPopular.setAdapter(adapterPopular);

    }
}
