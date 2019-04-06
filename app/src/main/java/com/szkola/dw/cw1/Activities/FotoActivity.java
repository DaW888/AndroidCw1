package com.szkola.dw.cw1.Activities;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.szkola.dw.cw1.Adapters.DrawerLeftFotoMenu;
import com.szkola.dw.cw1.R;

import java.io.File;
import java.util.ArrayList;

public class FotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

        ImageView mainPhoto = findViewById(R.id.ivChoosenImage);

        Bundle bundle = getIntent().getExtras();
        String photoPath = bundle.getString("ImagePath");
        Log.wtf("asd", photoPath);

        File photoFile = new File(photoPath);
        Uri uri = Uri.fromFile(photoFile);
        mainPhoto.setImageURI(uri);


        ArrayList<String> menuArray = new ArrayList<>();
        menuArray.add("Fonts");
        menuArray.add("Test");
        menuArray.add("Test");

        Log.d("dirnames", String.valueOf(menuArray));
        DrawerLeftFotoMenu adapter = new DrawerLeftFotoMenu(
                FotoActivity.this,
                R.layout.drawer_foto_one_row,
                menuArray
        );
        ListView listView = findViewById(R.id.lvMenuFoto);
        listView.setAdapter(adapter);
    }
}
