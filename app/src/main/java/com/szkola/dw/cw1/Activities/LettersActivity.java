package com.szkola.dw.cw1.Activities;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.szkola.dw.cw1.Helpers.PreviewText;
import com.szkola.dw.cw1.R;

import java.io.IOException;
import java.security.cert.LDAPCertStoreParameters;

public class LettersActivity extends AppCompatActivity {

    String fontName = "comic.tff";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters);
        this.getSupportActionBar().hide();
        AssetManager assetManager = getAssets();
        try {
            String[] fonts = assetManager.list("fonts");

            LinearLayout llFontList = findViewById(R.id.llFontList);
            final EditText etInputText = findViewById(R.id.etInputText);


            for(final String font: fonts){
                final Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/"+font);

                TextView tv = new TextView(this);
                tv.setText("Nie wszystkie czcionki obsługują polskie znaki!");
                tv.setTypeface(tf);
                tv.setTextSize(20);
                llFontList.addView(tv);

                final RelativeLayout rvFontPreview = findViewById(R.id.rvFontPreview);
                PreviewText previewText = new PreviewText(LettersActivity.this, tf, "Podaj Teskt");
                rvFontPreview.removeAllViews();
                rvFontPreview.addView(previewText);


                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        fontName = font;
                        PreviewText previewText = new PreviewText(LettersActivity.this, tf, etInputText.getText().toString());
                        rvFontPreview.removeAllViews();
                        rvFontPreview.addView(previewText);

                        TextWatcher textWatcher = new TextWatcher() {

                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                            }

                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {

                            }

                            @Override
                            public void afterTextChanged(Editable s) {
                                PreviewText previewText = new PreviewText(LettersActivity.this, tf, etInputText.getText().toString());
                                rvFontPreview.removeAllViews();
                                rvFontPreview.addView(previewText);
                            }
                        };
                        etInputText.addTextChangedListener(textWatcher);
                    }
                });

            }

            ImageView ivAddTextToPhoto = findViewById(R.id.ivAddTextToPhoto);
            ivAddTextToPhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra("fontName", fontName);
                    intent.putExtra("inputText", etInputText.getText().toString());

                    setResult(10, intent);
                    finish();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
