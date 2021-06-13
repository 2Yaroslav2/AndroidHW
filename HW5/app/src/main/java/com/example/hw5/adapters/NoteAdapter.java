package com.example.hw5.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hw5.R;
import com.example.hw5.database.entity.DbNote;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {


    public interface OnNoteAdapterListener{
        //void onViewProduct(Note note , int position);
    }

    //private List<Note> notes;
    private List<DbNote> dbNotes;
    private LayoutInflater inflater;
    private Context context;
    private OnNoteAdapterListener onNoteAdapterListener;

    public NoteAdapter(List<DbNote> dbNotes, Context context) {

        inflater = LayoutInflater.from(context);
        this.dbNotes = dbNotes;
        this.context = context;

        if (context instanceof OnNoteAdapterListener){
            onNoteAdapterListener = (OnNoteAdapterListener) context;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_list_notes,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        DbNote dbNote = dbNotes.get(position);

        holder.tvNote.setText(dbNote.getNote());
    }

    @Override
    public int getItemCount() {
        return dbNotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNote;

        public ViewHolder(@NonNull View view) {
            super(view);

            tvNote = view.findViewById(R.id.tvNote);
        }
    }
}
