package com.example.hw5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hw5.database.entity.DbNote;

public class AddNoteActivity extends AppCompatActivity {

    EditText etNewNote;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        etNewNote = findViewById(R.id.etNewNote);

        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra(DbNote.class.getSimpleName(), new DbNote(
                   etNewNote.getText().toString()
            ));
            setResult(RESULT_OK, intent);

            finish();
        });

    }
}
