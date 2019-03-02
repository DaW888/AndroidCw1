package com.szkola.dw.cw1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ImageList extends AppCompatActivity {
    ListView lvImages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);

        ArrayList<String> list = new ArrayList<>();
        list.add("cos");
        list.add("cos");

        lvImages = findViewById(R.id.listViewImages);
        TestAdapter adapter = new TestAdapter(
                ImageList.this,
                R.layout.row_with_images,
                list
        );
        lvImages.setAdapter(adapter);


    }

}
