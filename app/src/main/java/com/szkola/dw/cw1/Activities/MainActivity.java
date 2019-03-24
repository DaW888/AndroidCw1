package com.szkola.dw.cw1.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.amitshekhar.DebugDB;
import com.szkola.dw.cw1.Helpers.NotesList;
import com.szkola.dw.cw1.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    LinearLayout AlbumsClick, CameraClick, NotesClick;
    ImageView networkImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.wtf("ADDRESS IP", DebugDB.getAddressLog());
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


        CameraClick = findViewById(R.id.cameraClick);
        CameraClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Wybierz źródło zdjęcia");
                String[] opcje = {"Aparat", "Galeria"};
                alert.setItems(opcje, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (i == 0) {
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            if (intent.resolveActivity(getPackageManager()) != null) {
                                startActivityForResult(intent, 200);
                            }
                        } else if (i == 1) {
                            Intent intent = new Intent(Intent.ACTION_PICK);
                            intent.setType("image/*");
                            startActivityForResult(intent, 100);
                        }
                    }

                });
                alert.show();
            }
        });

        NotesClick = findViewById(R.id.notes);
        NotesClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NotesActivity.class);
                startActivity(intent);
            }
        });


        File pic = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File wajda = new File(pic, "Wajda");
        File miejsca = new File(wajda, "miejsca");
        File ludzie = new File(wajda, "ludzie");
        File rzeczy = new File(wajda, "rzeczy");

        wajda.mkdir();
        miejsca.mkdir();
        ludzie.mkdir();
        rzeczy.mkdir();


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        networkImg = findViewById(R.id.networkImg);
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap b = null;
        if (requestCode == 200) {
            if (resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                b = (Bitmap) extras.get("data");
//                networkImg.setImageBitmap(b);
            }
        } else if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                Uri imgData = data.getData();
                InputStream stream = null;
                try {
                    stream = getContentResolver().openInputStream(imgData);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                b = BitmapFactory.decodeStream(stream);
//                networkImg.setImageBitmap(b);
            }
        }

        if (b != null) {
            ByteArrayOutputStream streamOut = new ByteArrayOutputStream();
            b.compress(Bitmap.CompressFormat.JPEG, 100, streamOut);
            byte[] byteArray = streamOut.toByteArray();

            FileOutputStream fs;
            File pic = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            File wajda = new File(pic, "Wajda");
            SimpleDateFormat df = new SimpleDateFormat("yyMMdd_HHmmss");
            String fileName = df.format(new Date());

            //Alert do poprawy
//            Arrays.sort(wajda.listFiles());
//            ArrayList<String> dirNames = new ArrayList<>();
//            for (File dirName : wajda.listFiles()) {
//                dirNames.add(String.valueOf(dirName.getName()));
//            }
//
//            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
//            alert.setTitle("Wybierz folder do zapisu");
//            alert.setItems((String[]) dirNames.toArray(), new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    Log.d("DASDSADWASD", String.valueOf(dialog));
//                    Log.d("Wazme mp moe", String.valueOf(which));
//                }
//            });
//            alert.show();

            //pomocnicze z linijek wyzej, do wywalenia
//            alert.setItems(opcje, new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    if (i == 0) {
//                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                        if (intent.resolveActivity(getPackageManager()) != null) {
//                            startActivityForResult(intent, 200);
//                        }
//                    } else if (i == 1) {
//                        Intent intent = new Intent(Intent.ACTION_PICK);
//                        intent.setType("image/*");
//                        startActivityForResult(intent, 100);
//                    }
//                }
//
//            });
//            alert.show();

            try {
                fs = new FileOutputStream(wajda.getPath() + "/ludzie/" + fileName + ".jpg");
                fs.write(byteArray);
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            b.compress(Bitmap.CompressFormat.JPEG, 100, stream); // stream zdefiniowac !
        }
    }
}
