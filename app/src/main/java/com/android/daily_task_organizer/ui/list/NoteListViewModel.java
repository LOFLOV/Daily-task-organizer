package com.android.daily_task_organizer.ui.list;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.daily_task_organizer.model.Note;
import com.android.daily_task_organizer.model.NotesRepository;

import java.util.List;

public class NoteListViewModel extends ViewModel {

    private NotesRepository repository;

    public MutableLiveData<List<Note>> notes = new MutableLiveData<>();
}
