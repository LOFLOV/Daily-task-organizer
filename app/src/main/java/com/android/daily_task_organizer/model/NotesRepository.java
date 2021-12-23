package com.android.daily_task_organizer.model;

import java.util.List;

public interface NotesRepository {

    void getAll(Callback<List<Note>> callback);
}
