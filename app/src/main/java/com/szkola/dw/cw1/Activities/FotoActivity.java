package com.szkola.dw.cw1.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.szkola.dw.cw1.Adapters.DrawerLeftFotoMenu;
import com.szkola.dw.cw1.Helpers.PreviewText;
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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Log.wtf("asd", "klikam font");
                    Intent intent = new Intent(FotoActivity.this, LettersActivity.class);
                    startActivityForResult(intent, 10);
                }
            }
        });
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle = data.getExtras();

        assert bundle != null;
        String fontName = (String) bundle.get("fontName");
        String text = (String) bundle.get("inputText");

        Log.wtf("asd", text);

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/"+fontName);
        PreviewText previewText = new PreviewText(FotoActivity.this, tf, text);

        RelativeLayout rlImage = findViewById(R.id.rlImage);

        previewText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("XX", "pos x:" + event.getRawX());
                Log.d("XX", "pos y:" + event.getRawX());


                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return false;
            }
        });

        rlImage.addView(previewText);


    }
}
