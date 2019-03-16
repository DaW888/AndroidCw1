package com.szkola.dw.cw1.Helpers;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.szkola.dw.cw1.Adapters.TestAdapter;
import com.szkola.dw.cw1.R;

import java.io.File;
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

        Bundle bundle = getIntent().getExtras();
        String folderName = bundle.getString("thisDirName");
        Log.d("thisDirName", folderName);

        File pic = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File wajda = new File(pic, "wajda");
        File inFolder = new File(wajda, folderName);

        ArrayList<File> Images = new ArrayList<>();
        for (File dirName : inFolder.listFiles()) {
            Images.add(dirName);
        }

        lvImages = findViewById(R.id.listViewImages);
        TestAdapter adapter = new TestAdapter(
                ImageList.this,
                R.layout.row_with_images,
                Images
        );
        lvImages.setAdapter(adapter);

        DataBaseManager db = new DataBaseManager(
                ImageList.this,
                "NotatkiWajdaDawid2.db",
                null,
                2
        );
        db.insert("asd", "sad", -256);
        db.close();

    }

}
