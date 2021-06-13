package com.example.hw5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.example.hw5.adapters.NoteAdapter;
import com.example.hw5.database.entity.DbNote;
import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final int ADD_NOTE_REQUEST_CODE = 1;

    static List<DbNote> dbNotes = new ArrayList<>();
    //static List<Note> notes = new ArrayList<>();

    static {
//        notes.add(new DbNote("Note 1"));
//
//        notes.add(new Note("Note 2"));
//        notes.add(new Note("Note 3"));
//        notes.add(new Note("Note 4"));





    }

    RecyclerView rvNotes;
    NoteAdapter noteAdapter;
    ImageButton imageBtnCreateNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SugarContext.init(this);

        rvNotes = findViewById(R.id.rvNotes);
        imageBtnCreateNote = findViewById(R.id.imageBtnCreateNote);

        long countNote = DbNote.count(DbNote.class);

        for (int i = 1; i < countNote; i++){

            DbNote tmp = DbNote.findById(DbNote.class, i);
            dbNotes.add(tmp);

        }


        noteAdapter = new NoteAdapter(dbNotes, this);

        rvNotes.setAdapter(noteAdapter);


//        for (int i = 2; i < 4; i++)
//        {
//            DbNote tmpDbNote = new DbNote("Note" + i);
//            tmpDbNote.save();
//            notes.add(tmpDbNote);
//
//        }

       // DbNote tmpDbNote = DbNote.findById(DbNote.class, 2);


        imageBtnCreateNote.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddNoteActivity.class);
            startActivityForResult(intent, ADD_NOTE_REQUEST_CODE);
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode)
        {
            case ADD_NOTE_REQUEST_CODE: {
                if (resultCode == RESULT_OK) {
                    DbNote dbNote = (DbNote) data.getExtras().getSerializable(DbNote.class.getSimpleName());
                    dbNotes.add(dbNote);
                    dbNote.save();
                    noteAdapter.notifyDataSetChanged();
                }
                break;
            }

        }
    }
}