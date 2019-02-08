package com.szkola.dw.cw1;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("WrongViewCast")
    public void buttonClick(View v){
        TextView txt = findViewById(R.id.camera);
        txt.setText("@string/aparat");

        txt = findViewById(R.id.albums);
        txt.setText("@string/album");

        txt = findViewById(R.id.collage);
        txt.setText("@string/kolaz");

        txt = findViewById(R.id.network);
        txt.setText("@string/siec");

    }
}

