package com.szkola.dw.cw1.Helpers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.szkola.dw.cw1.R;

public class NotesList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list); // zmienic to na adapter
    }
}
