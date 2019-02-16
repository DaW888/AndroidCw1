package com.szkola.dw.cw1;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    LinearLayout AlbumsClick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlbumsClick = findViewById(R.id.albumsClick);
        AlbumsClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlbumsActivity.class);
                startActivity(intent);
            }
        });

        File pic = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File wajda = new File(pic, "Wajda");
        File miejsca = new File(wajda, "miejsca");
        File ludzie = new File(wajda, "ludzie");
        File rzeczy = new File(wajda, "rzeczy");

        wajda.mkdir(); miejsca.mkdir(); ludzie.mkdir();
        rzeczy.mkdir();


    }
}
