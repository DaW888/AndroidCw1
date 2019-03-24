package com.szkola.dw.cw1.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.szkola.dw.cw1.Adapters.NotesArrayAdapter;
import com.szkola.dw.cw1.Helpers.DataBaseManager;
import com.szkola.dw.cw1.Helpers.Note;
import com.szkola.dw.cw1.R;

import java.util.ArrayList;

public class NotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

//        ArrayList<Note> notes = DataBaseManager.getAll(); //! błąd nwm co zrobic
//        NotesArrayAdapter adapter = new NotesArrayAdapter(
//                NotesActivity.this,
//                R.layout.notes_list_one_row,
//                notes
//        );
//        ListView lvNotesList = findViewById(R.id.NotesList);
//        lvNotesList.setAdapter(adapter);


    }

}
