package com.android.daily_task_organizer.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.daily_task_organizer.R;
import com.android.daily_task_organizer.model.InMemoryNotesRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}