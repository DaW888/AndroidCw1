package com.szkola.dw.cw1.Activities;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.szkola.dw.cw1.Adapters.DrawerLeftFotoMenu;
import com.szkola.dw.cw1.Helpers.Networking;
import com.szkola.dw.cw1.Helpers.PreviewText;
import com.szkola.dw.cw1.Helpers.UploadFoto;
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
        menuArray.add("To SPEC");
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
                ProgressDialog progressDialog;

                if (position == 0) {
                    Log.wtf("asd", "klikam font");
                    Intent intent = new Intent(FotoActivity.this, LettersActivity.class);
                    startActivityForResult(intent, 10);
                }
                if (position == 1){
                    boolean boolNetworking = Networking.checkNetworking(FotoActivity.this);
                    Log.d("XXX", String.valueOf(boolNetworking));
                    if(!boolNetworking){
                        Log.d("XXX", "BRAK INTERNETU");
                        progressDialog = new ProgressDialog(FotoActivity.this);
                        progressDialog.setMessage("POŁĄCZ SIĘ Z INTENERTEM");
                        progressDialog.setCancelable(true);
                        progressDialog.show();
                    }else{
                        new UploadFoto().execute("http://4ia1.spec.pl.hostingasp.pl/test_uploadu/SaveCollage.aspx");
                    }
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
        Integer colour = bundle.getInt("color");

        Log.wtf("asd", text);

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/" + fontName);
        PreviewText previewText = new PreviewText(FotoActivity.this, tf, text, colour);

        RelativeLayout rlImage = findViewById(R.id.rlImage);

        previewText.setOnTouchListener(new View.OnTouchListener() {
            private float xCord, yCord;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("XX", "pos x:" + event.getRawX());
                Log.d("XX", "pos y:" + event.getRawX());


                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        xCord = v.getX() - event.getRawX();
                        yCord = v.getY() - event.getRawY();

                        break;
                    case MotionEvent.ACTION_MOVE:

                        v.animate().x(event.getRawX() + xCord).y(event.getRawY() + yCord).setDuration(0).start();

                        break;
                    case MotionEvent.ACTION_UP:
                        v.setLayoutParams(new LayoutParams(v.getWidth(), 100));
                        break;
                    default:
                        return false;
                }

                return true;
            }
        });

        rlImage.addView(previewText);


    }
}
