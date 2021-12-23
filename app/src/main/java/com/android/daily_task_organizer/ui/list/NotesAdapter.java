package com.android.daily_task_organizer.ui.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.daily_task_organizer.R;
import com.android.daily_task_organizer.model.Note;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {

    private List<Note> data = new ArrayList<>();

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy", Locale.getDefault());

    public void setData(Collection<Note> notes) {
        data.clear();
        data.addAll(notes);
    }

    @NonNull @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);

        return new NoteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {

        Note note = data.get(position);

        holder.getTitle().setText(note.getTitle());
        holder.getMessage().setText(note.getMessage());
        holder.getDate().setText(dateFormat.format(note.getCreatedAt()));


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {

        private TextView title;

        private TextView message;

        private TextView date;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);

            message = itemView.findViewById(R.id.content);

            date = itemView.findViewById(R.id.date);
        }

        public TextView getTitle() {
            return title;
        }

        public TextView getMessage() {
            return message;
        }

        public TextView getDate() {
            return date;
        }
    }
}
