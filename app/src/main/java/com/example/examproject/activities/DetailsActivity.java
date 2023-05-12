package com.example.examproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.examproject.Domain.itemsDomain;
import com.example.examproject.R;

public class DetailsActivity extends AppCompatActivity {
private TextView titletext,addressTxt,bedtext,bathtext,wifitext,description;
    private ImageView pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initView();
        setVariable();

    }

    @SuppressLint("SetTextI18n")
    private void setVariable() {
        itemsDomain item = (itemsDomain) getIntent().getSerializableExtra("object");
        titletext.setText(item.getTitle());
        addressTxt.setText(item.getAddress());
        bedtext.setText(item.getBed()+"Bed");
        bathtext.setText(item.getBath()+"Bath");
        description.setText(item.getDescription());
        if(item.isWifi()){
            wifitext.setText("wifi");
        }else { wifitext.setText("No-wifi");}
        @SuppressLint("DiscouragedApi") int drawableResourceId=getResources().getIdentifier(item.getpic(),"drawable",getPackageName() );
        Glide.with(this).load(drawableResourceId)
                .into(pic);
    }



    private void initView() {
        titletext=findViewById(R.id.titletext);
        addressTxt=findViewById(R.id.adresstxt);
        bedtext=findViewById(R.id.bedtext);
        bathtext=findViewById(R.id.bathtext);
        wifitext=findViewById(R.id.wifitext);
        description=findViewById(R.id.descriptionTxt);
        pic=findViewById(R.id.pic);


    }
}