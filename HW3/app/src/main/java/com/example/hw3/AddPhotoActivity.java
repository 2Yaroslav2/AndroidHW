package com.example.hw3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hw3.models.Photo;

import java.io.Serializable;

import static com.example.hw3.models.MyResultCode.RESULT_ADD_PHOTO;

public class AddPhotoActivity extends AppCompatActivity {

    EditText etPath, etTitle, etDescription, etAuthor, etDownloadDate;

    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_photo);

        etTitle = findViewById(R.id.etAddTitle);
        etAuthor = findViewById(R.id.etAddAuthor);
        etDescription = findViewById(R.id.etAddDescription);
        etDownloadDate = findViewById(R.id.etAddDownloadDate);
        etPath = findViewById(R.id.etAddPath);

        btnSave = findViewById(R.id.btnSaveAddPhoto);

        btnSave.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra(Photo.class.getSimpleName(), new Photo(
                    etPath.getText().toString(),
                    etTitle.getText().toString(),
                    etDescription.getText().toString(),
                    etAuthor.getText().toString(),
                    etDownloadDate.getText().toString()
            ));
            setResult(RESULT_ADD_PHOTO, intent);

            finish();
        });

    }
}
