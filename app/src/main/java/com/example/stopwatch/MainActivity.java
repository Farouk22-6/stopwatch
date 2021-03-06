package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Chronometer chronometer;
    private long pauseoffset;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer);
        chronometer.setFormat("Time: %s");
        chronometer.setBase(SystemClock.elapsedRealtime());


        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                
            }
        });

    }

    public void Startchronometer(View v) {
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseoffset);
            chronometer.start();
            running = true;
        }

    }

    public void Pausechronometer(View v) {
        if (running) {
            chronometer.stop();
            pauseoffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }

    }

    public void Resetchronometer(View v) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseoffset = 10;


        
    }
}
