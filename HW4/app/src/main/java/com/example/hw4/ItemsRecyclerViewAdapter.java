package com.example.hw4;

import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hw4.dummy.DummyContent.DummyItem;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ItemsRecyclerViewAdapter extends RecyclerView.Adapter<ItemsRecyclerViewAdapter.ViewHolder> {

    public interface OnItemsRecyclerViewAdapterListener {
        void onItemClick(DummyItem item);
    }

    private final List<DummyItem> mValues;
    private OnItemsRecyclerViewAdapterListener listener;

    public ItemsRecyclerViewAdapter(OnItemsRecyclerViewAdapterListener listener, List<DummyItem> items) {
        mValues = items;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.txtNum.setText(mValues.get(position).id);
        holder.txtName.setText(mValues.get(position).name);
        holder.txtAvailable.setText(mValues.get(position).available);
        holder.txtCount.setText(String.valueOf(mValues.get(position).count));

        Picasso.get().load(Uri.parse(mValues.get(position).path)).into(holder.ivItem);

        holder.mView.setOnClickListener(v -> {
            listener.onItemClick(mValues.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView txtNum, txtAvailable, txtName, txtCount;
        public final ImageView ivItem;

        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;

            txtNum = (TextView) view.findViewById(R.id.txtNum);
            txtAvailable = (TextView) view.findViewById(R.id.txtAvailable);
            txtName = (TextView) view.findViewById(R.id.txtName);
            txtCount = (TextView) view.findViewById(R.id.txtCount);

            ivItem = (ImageView) view.findViewById(R.id.ivItem);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + txtName.getText() + "'";
        }
    }
}