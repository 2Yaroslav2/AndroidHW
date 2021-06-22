package com.example.exam;

import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.exam.dummy.SaveNewsContent.SaveNewsItem;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link SaveNewsItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class SaveNewsRecyclerViewAdapter extends RecyclerView.Adapter<SaveNewsRecyclerViewAdapter.ViewHolder> {

    private final List<SaveNewsItem> mValues;

    public SaveNewsRecyclerViewAdapter(List<SaveNewsItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_save_news, parent, false);
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
        holder.tvAuthors.setText(mValues.get(position).authors);


        Picasso.get().load(Uri.parse(mValues.get(position).imageUrl)).into(holder.ivImageUrl);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView tvPubDate, tvCountry, tvLanguage,
                tvTitle, tvDescription, tvContent, tvUrl, tvSource, tvAuthors, tvViews;

        public final ImageView ivImageUrl, ivViews;

        public SaveNewsItem mItem;

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


            ivImageUrl = (ImageView) view.findViewById(R.id.ivImageUrl);
            ivViews = (ImageView) view.findViewById(R.id.ivViews);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvTitle.getText() + "'";
        }
    }
}