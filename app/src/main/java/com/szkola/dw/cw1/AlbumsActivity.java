package com.szkola.dw.cw1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.Arrays;

public class AlbumsActivity extends Activity {

    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        listView = findViewById(R.id.listView);
        String[] array = new String[]{"output 1", "output 2", "output 3"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                AlbumsActivity.this,
                R.layout.row,
                R.id.tv1,
                array
        );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int i, long l) {
                Log.d("Tag", "numer klikanego wiersza w listview = " + i);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("Tag", "dlugie przytrzymanie = " + i);

//                AlertDialog.Builder alert = new AlertDialog.Builder(AlbumsActivity.this);
//                alert.setTitle("UWaga");
//                alert.setCancelable(false); // nie zamknie sie kiedy klikniemy poza nim
//                alert.setMessage("TESTTT");
//                alert.setNeutralButton("OK", null).show();

                AlertDialog.Builder alert = new AlertDialog.Builder(AlbumsActivity.this);
                alert.setTitle("Uwaga");
                alert.setMessage("komunikat");
                alert.setIcon(R.drawable.outline_language_black_18dp);
                alert.setNeutralButton("OK", new AlertDialog.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){

                    }
                });
                alert.show();
                return false;
            }
        });

        File pic = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File wajda = new File(pic, "wajda");
        File[] files = pic.listFiles();
        Arrays.sort(files);

        for(File file : wajda.listFiles()){
            Log.d("xxx", String.valueOf(file.getName()));
            //file.delete(); - usuniecie pliku
        }
    }

}
