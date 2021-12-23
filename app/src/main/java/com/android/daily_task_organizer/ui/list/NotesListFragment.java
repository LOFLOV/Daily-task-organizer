package com.android.daily_task_organizer.ui.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.daily_task_organizer.R;
import com.android.daily_task_organizer.model.InMemoryNotesRepository;
import com.android.daily_task_organizer.model.Note;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class NotesListFragment extends Fragment implements NotesListView {

    private ProgressBar progressBar;

    private RecyclerView notesList;

    private NotesAdapter adapter;

    private NotesPresenter presenter;

    public NotesListFragment() {
        super(R.layout.fragment_notes_list);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new NotesPresenter(this, InMemoryNotesRepository.INSTANCE);
        adapter = new NotesAdapter();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressBar = view.findViewById(R.id.progress);
        notesList = view.findViewById(R.id.notes_list);

        notesList.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        notesList.setAdapter(adapter);

        presenter.requestNotes();
    }

    @Override
    public void showNotes(List<Note> notes) {
        adapter.setData(notes);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}