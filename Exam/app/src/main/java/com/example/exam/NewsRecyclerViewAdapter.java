package com.example.exam;

import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.exam.database.entity.Publication;
import com.example.exam.dummy.NewsContent.NewsItem;
import com.squareup.picasso.Picasso;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link NewsItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder> {

    private final List<NewsItem> mValues;
    private static String tmpAuthors = "";
    public NewsRecyclerViewAdapter(List<NewsItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.tvPubDate.setText(mValues.get(position).pubDate);
        holder.tvCountry.setText(mValues.get(position).country);
        holder.tvLanguage.setText(mValues.get(position).language);
        holder.tvTitle.setText(mValues.get(position).title);
        holder.tvDescription.setText(mValues.get(position).description);
        holder.tvContent.setText(mValues.get(position).content);
        holder.tvSource.setText(mValues.get(position).source);
        holder.tvUrl.setText(mValues.get(position).url);
        holder.tvViews.setText(String.valueOf(mValues.get(position).views));


        int size = mValues.get(position).authors.size();

        if (size > 0)
        {
            for (int i = 0; i < size; i++) {
                tmpAuthors += mValues.get(position).authors.get(i);
            }

            holder.tvAuthors.setText(tmpAuthors);
        }
        else    {
            tmpAuthors = "...";
            holder.tvAuthors.setText(tmpAuthors);
        }

        Picasso.get().load(Uri.parse(mValues.get(position).imageUrl)).into(holder.ivImageUrl);

        holder.imageBtnSave.setOnClickListener(v -> {

           // NewsItem tmp = mValues.get(position);

            Publication publication = new Publication(mValues.get(position).url,
                    mValues.get(position).source,
                    tmpAuthors,
                    mValues.get(position).title,
                    mValues.get(position).pubDate,
                    mValues.get(position).country,
                    mValues.get(position).language,
                    mValues.get(position).description,
                    mValues.get(position).imageUrl,
                    mValues.get(position).content,
                    mValues.get(position).views);


            publication.save();


        });

        int a = 0;
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView tvPubDate, tvCountry, tvLanguage,
                tvTitle, tvDescription, tvContent, tvUrl, tvSource, tvAuthors, tvViews;
        public final ImageButton imageBtnSave;
        public final ImageView ivImageUrl, ivViews;

        public NewsItem mItem;

        public ViewHolder(View view) {
            super(view);

            tvPubDate = (TextView) view.findViewById(R.id.tvPubDate);
            tvCountry = (TextView) view.findViewById(R.id.tvCountry);
            tvLanguage = (TextView) view.findViewById(R.id.tvLanguage);
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            tvDescription = (TextView) view.findViewById(R.id.tvDescription);
            tvContent = (TextView) view.findViewById(R.id.tvContent);
            tvUrl = (TextView) view.findViewById(R.id.tvUrl);
            tvSource = (TextView) view.findViewById(R.id.tvSource);
            tvAuthors = (TextView) view.findViewById(R.id.tvAuthors);
            tvViews = (TextView) view.findViewById(R.id.tvViews);

            imageBtnSave = (ImageButton) view.findViewById(R.id.imageBtnSave);

            ivImageUrl = (ImageView) view.findViewById(R.id.ivImageUrl);
            ivViews = (ImageView) view.findViewById(R.id.ivViews);


        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvTitle.getText() + "'";
        }
    }
}