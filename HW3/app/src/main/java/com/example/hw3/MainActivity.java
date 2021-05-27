package com.example.hw3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.hw3.adapters.PhotoAdapter;
import com.example.hw3.models.Photo;

import java.util.ArrayList;
import java.util.List;

import static com.example.hw3.models.MyResultCode.RESULT_ADD_PHOTO;
import static com.example.hw3.models.MyResultCode.RESULT_EDIT_PHOTO;

public class MainActivity extends AppCompatActivity implements PhotoAdapter.OnPhotoAdapterListener {

    private final int ADD_PHOTO_REQUEST_CODE = 1;
    private final int EDIT_PHOTO_REQUEST_CODE = 2;
    static List<Photo> photos = new ArrayList<>();

    static {
        photos.add(new Photo("https://pngicon.ru/file/uploads/voda.png",
                "title1",
                "description1",
                "author1",
                "downloadDate1"));

        photos.add(new Photo("https://img.freepik.com/free-vector/powder-holi-paints-frame-border-solated_1441-3793.jpg?size=626&ext=jpg&ga=GA1.2.485545868.1621641600",
                "title2",
                "description2",
                "author2",
                "downloadDate2"));

        photos.add(new Photo("https://purepng.com/public/uploads/large/purepng.com-sandwichfood-slice-salad-tasty-bread-vegetable-health-delicious-breakfast-sandwich-9415246181796gyc0.png",
                "title3",
                "description3",
                "author3",
                "downloadDate3"));
    }


    RecyclerView rvPhotos;
    PhotoAdapter photoAdapter;
    Button btnCreatePhoto;

    //Photo tmpPhoto;
    int tmpPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPhotos = findViewById(R.id.rvPhotos);
        btnCreatePhoto = findViewById(R.id.btnCreatePhoto);

//        rvPhotos.setNestedScrollingEnabled(false);
//        rvPhotos.setHasFixedSize(true);

        photoAdapter = new PhotoAdapter(this, photos);

        rvPhotos.setAdapter(photoAdapter);

        btnCreatePhoto.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddPhotoActivity.class);
            startActivityForResult(intent, ADD_PHOTO_REQUEST_CODE);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode)
        {
            case ADD_PHOTO_REQUEST_CODE: {
                if (resultCode == RESULT_ADD_PHOTO) {
                    Photo photo = (Photo) data.getExtras().getSerializable(Photo.class.getSimpleName());
                    photos.add(photo);
                    photoAdapter.notifyDataSetChanged();
                }
                break;
            }
            case EDIT_PHOTO_REQUEST_CODE:{
                if (requestCode == RESULT_EDIT_PHOTO){
                    Photo photo = (Photo) data.getExtras().getSerializable(Photo.class.getSimpleName());
                    photos.set(tmpPosition, photo);
                    photoAdapter.notifyItemChanged(tmpPosition);
                }
            }
        }
    }

    @Override
    public void onLeftClick(int position) {


    }

    @Override
    public void onRightClick(int position) {

    }

    @Override
    public void onEditClick(Photo photo, int position) {

        Intent intent = new Intent(this, EditPhotoActivity.class);
        intent.putExtra(Photo.class.getSimpleName(),photo);
        startActivityForResult(intent, RESULT_EDIT_PHOTO);

        //tmpPhoto = photo;
        tmpPosition = position;

    }

}