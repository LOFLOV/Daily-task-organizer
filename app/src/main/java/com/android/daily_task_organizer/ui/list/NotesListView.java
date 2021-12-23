package com.android.daily_task_organizer.ui.list;

import com.android.daily_task_organizer.model.Note;

import java.util.List;

public interface NotesListView {

    void showNotes(List<Note> notes);

    void showProgress();

    void hideProgress();

}
