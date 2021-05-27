package com.example.hw3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hw3.models.Photo;

import static com.example.hw3.models.MyResultCode.RESULT_EDIT_PHOTO;

public class EditPhotoActivity extends AppCompatActivity {

    EditText etPath, etTitle, etDescription, etAuthor, etDownloadDate;

    Button btnSave;

    Photo photo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_photo);

        etTitle = findViewById(R.id.etEditTitle);
        etAuthor = findViewById(R.id.etEditAuthor);
        etDescription = findViewById(R.id.etEditDescription);
        etDownloadDate = findViewById(R.id.etEditDownloadDate);
        etPath = findViewById(R.id.etEditPath);

        btnSave = findViewById(R.id.btnSaveEditPhoto);

        Bundle bundle = getIntent().getExtras();
        photo = (Photo) bundle.getSerializable(Photo.class.getSimpleName());

        loadData();

        btnSave.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra(Photo.class.getSimpleName(), new Photo(
                    etPath.getText().toString(),
                    etTitle.getText().toString(),
                    etDescription.getText().toString(),
                    etAuthor.getText().toString(),
                    etDownloadDate.getText().toString()
            ));
            setResult(RESULT_EDIT_PHOTO, intent);

            finish();
        });

    }

    private void loadData()
    {
        etTitle.setText(photo.getTitle());
        etAuthor.setText(photo.getAuthor());
        etDescription.setText(photo.getDescription());
        etDownloadDate.setText(photo.getDownloadDate());
        etPath.setText(photo.getPath());

    }
}
