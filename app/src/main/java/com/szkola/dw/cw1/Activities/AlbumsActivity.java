package com.szkola.dw.cw1.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.szkola.dw.cw1.Helpers.ImageList;
import com.szkola.dw.cw1.R;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class AlbumsActivity extends Activity {

    private ListView listView;
    private ImageView addFolder;
    private ArrayList<String> dirNames;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        listView = findViewById(R.id.listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int i, long l) {
                Log.d("Tag", "numer klikanego wiersza w listview = " + i);
                Intent intent = new Intent(AlbumsActivity.this, ImageList.class);
                intent.putExtra("thisDirName", dirNames.get(i));
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long l) {
                Log.d("Tag", "dlugie przytrzymanie = " + i);

                AlertDialog.Builder alert = new AlertDialog.Builder(AlbumsActivity.this);
                alert.setTitle("USUWANIE FOLDERU");
                alert.setMessage("Czy na pewno chcesz usunąć folder?");
                alert.setIcon(R.drawable.outline_language_black_18dp);

                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("which do OK", String.valueOf(i));
                        File pic = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                        File wajda = new File(pic, "wajda");
                        File[] dirs = wajda.listFiles();
                        dirs[i].delete();

                        ArrayList<String> dirNames = new ArrayList<>();
                        for (File dirName : wajda.listFiles()) {
                            dirNames.add(String.valueOf(dirName.getName()));
                        }
                        Log.d("dirnames", String.valueOf(dirNames));
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                                AlbumsActivity.this,
                                R.layout.row,
                                R.id.tv1,
                                dirNames
                        );
                        listView.setAdapter(adapter);
                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("which do NO", String.valueOf(which));

                    }
                });
                alert.show();
                return false;
            }
        });

        File pic = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File wajda = new File(pic, "wajda");
        File[] files = wajda.listFiles();
        Arrays.sort(files);

//        String[] dirNames = new String[0];
        dirNames = new ArrayList<>();
        for (File dirName : wajda.listFiles()) {
            dirNames.add(String.valueOf(dirName.getName()));
        }
        Log.d("dirnames", String.valueOf(dirNames));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                AlbumsActivity.this,
                R.layout.row,
                R.id.tv1,
                dirNames
        );
        listView.setAdapter(adapter);


        addFolder = findViewById(R.id.addFolder);
        addFolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("xxxxx", "KLIKAM");
                AlertDialog.Builder alert = new AlertDialog.Builder(AlbumsActivity.this);

                alert.setTitle("Stwórz folder");
                alert.setMessage("nazwa Folderu");
                final EditText input = new EditText(AlbumsActivity.this);
                input.setText("Folder1");
                alert.setView(input);
                alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        File pic = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                        File wajda = new File(pic, "wajda");
                        String strInput = input.getText().toString();
                        Log.d("XXXX", strInput);

                        File New = new File(wajda, strInput);
                        New.mkdir();

                        ArrayList<String> dirNames = new ArrayList<>();
                        for (File dirName : wajda.listFiles()) {
                            dirNames.add(String.valueOf(dirName.getName()));
                        }
                        Log.d("dirnames", String.valueOf(dirNames));
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                                AlbumsActivity.this,
                                R.layout.row,
                                R.id.tv1,
                                dirNames
                        );
                        listView.setAdapter(adapter);
                    }
                });

                alert.show();
            }
        });
    }

}
