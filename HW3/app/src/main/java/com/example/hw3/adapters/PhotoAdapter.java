package com.example.hw3.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hw3.R;
import com.example.hw3.models.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotoAdapter  extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {

    public interface OnPhotoAdapterListener{
        void onLeftClick(int position);
        void onRightClick(int position);
        void onEditClick(Photo photo, int position);
    }

    private LayoutInflater inflater;
    private List<Photo> photos;
    private Context context;
    private OnPhotoAdapterListener onPhotoAdapterListener;

    public PhotoAdapter(Context context, List<Photo> photos)
    {
        inflater = LayoutInflater.from(context);
        this.photos = photos;
        this.context = context;

        if (context instanceof OnPhotoAdapterListener)
        {
            onPhotoAdapterListener = (OnPhotoAdapterListener) context;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_photo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        Photo photo = photos.get(position);

        Picasso.get().load(photo.getPath()).into(holder.imageView);

        holder.imBtnLeft.setOnClickListener(v -> {
            onPhotoAdapterListener.onLeftClick(position);
        });
        holder.imBtnRight.setOnClickListener(v -> {
            onPhotoAdapterListener.onRightClick(position);
        });


        String message = photo.getAuthor() + "\n" + photo.getDescription() + "\n" + photo.getDownloadDate();

        holder.ivInfo.setOnClickListener(v -> {
            AlertDialog.Builder dlgBuilder = new AlertDialog.Builder(context);
            AlertDialog dialog = dlgBuilder.setTitle(photo.getTitle())
                    .setMessage(message)
                    .setPositiveButton("OK", (dialog1, which) -> {}).create();
            dialog.show();
        });

        holder.ivRemove.setOnClickListener(v -> {
            photos.remove(photo);
            notifyDataSetChanged();
        });

        holder.ivEdit.setOnClickListener(v -> {
            onPhotoAdapterListener.onEditClick(photo, position);
        });


    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView, ivInfo, ivEdit, ivRemove;
        ImageButton imBtnLeft, imBtnRight;

        public ViewHolder(@NonNull View view) {
            super(view);

            imBtnLeft = view.findViewById(R.id.imBtnLeft);
            imBtnRight = view.findViewById(R.id.imBtnRight);

            imageView = view.findViewById(R.id.imageView);
            ivInfo = view.findViewById(R.id.ivInfo);
            ivRemove = view.findViewById(R.id.ivRemove);
            ivEdit = view.findViewById(R.id.ivEdit);
        }
    }
}
