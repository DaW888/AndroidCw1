package com.szkola.dw.cw1.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.szkola.dw.cw1.Adapters.NotesArrayAdapter;
import com.szkola.dw.cw1.Helpers.DataBaseManager;
import com.szkola.dw.cw1.Helpers.ImageList;
import com.szkola.dw.cw1.Helpers.Note;
import com.szkola.dw.cw1.R;

import java.util.ArrayList;
import java.util.zip.DataFormatException;

public class NotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);


        DataBaseManager db = new DataBaseManager(
                NotesActivity.this,
                "NotatkiWajdaDawid.db",
                null,
                3
        );
        ArrayList<Note> notes = db.getAll();
        NotesArrayAdapter adapter = new NotesArrayAdapter(
                NotesActivity.this,
                R.layout.notes_list_one_row,
                notes
        );
        ListView lvNotesList = findViewById(R.id.NotesList);
        lvNotesList.setAdapter(adapter);


    }

}
