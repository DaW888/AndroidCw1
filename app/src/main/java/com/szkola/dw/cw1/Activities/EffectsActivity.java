package com.szkola.dw.cw1.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.szkola.dw.cw1.Adapters.rvEffects;
import com.szkola.dw.cw1.R;

import java.util.ArrayList;

public class EffectsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_effects);

        RecyclerView recyclerView = findViewById(R.id.rvEffects);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<String> list = new ArrayList<>();
        list.add("jeden");
        list.add("jeden");
        list.add("jeden");
        list.add("jeden");
        list.add("jeden");
        list.add("jeden");
        list.add("jeden");
        list.add("jeden");
        list.add("jeden");
        list.add("jeden");
        list.add("jeden");
        list.add("jeden");
        list.add("jeden");
        list.add("jeden");

        rvEffects adapter = new rvEffects(list);
        recyclerView.setAdapter(adapter);


    }
}
