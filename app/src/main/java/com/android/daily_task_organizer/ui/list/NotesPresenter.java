package com.android.daily_task_organizer.ui.list;

import com.android.daily_task_organizer.model.Callback;
import com.android.daily_task_organizer.model.Note;
import com.android.daily_task_organizer.model.NotesRepository;

import java.util.List;

public class NotesPresenter {

    private NotesListView view;

    private NotesRepository repository;

    public NotesPresenter(NotesListView view, NotesRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void requestNotes() {            //запрос

        view.showProgress();

        repository.getAll(new Callback<List<Note>>() {
            @Override
            public void onSuccess(List<Note> result) {
                view.showNotes(result);
                view.hideProgress();
            }

            @Override
            public void onError(Throwable error) {
                view.hideProgress();
            }
        });
    }
}
