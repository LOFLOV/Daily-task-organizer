package com.android.daily_task_organizer.model;

public interface Callback<T> {

    void  onSuccess(T result);

    void onError(Throwable error);
}
