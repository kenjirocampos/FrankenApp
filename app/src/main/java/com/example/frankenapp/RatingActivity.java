package com.example.frankenapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RatingActivity extends AppCompatActivity {
private RecyclerView rView;
private ItemAdapter itemAdapter;
private int totalBars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        rView = (RecyclerView) findViewById(R.id.rView);

        itemAdapter = new ItemAdapter(this);
        itemAdapter.setData(getData());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        rView.setAdapter(itemAdapter);
        rView.setLayoutManager(linearLayoutManager);
    }
    private List<Item> getData() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(5,"Diseño"));
        list.add(new Item(5,"Experiencia"));
        list.add(new Item(5,"Factibilidad"));
        list.add(new Item(5,"Gameplay"));
        return list;
    }
    public void calcularRating(View v) {
        float sumaRatings = 0;
        int totalBars = itemAdapter.getItemCount();
        List<Item> items = itemAdapter.getItemList();
        for(Item item : items){
            sumaRatings += item.getEstrellas();
        }
        float promedio = sumaRatings / totalBars;
        Toast.makeText(RatingActivity.this, "El promedio del rating fue: "+promedio, Toast.LENGTH_LONG).show();
    }
    public void volverMainActivity(View v){
        Intent cambiar = new Intent(this,MainActivity.class);
        startActivity(cambiar);
    }
}