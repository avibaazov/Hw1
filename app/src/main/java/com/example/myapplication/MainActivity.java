package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private MaterialButton left_BTN;
    private MaterialButton right_BTN;
    private ShapeableImageView carPlacementCenter;
    private ShapeableImageView carPlacementLeft;
    private ShapeableImageView carPlacementRight;
    private ShapeableImageView asteroid1;
    private ShapeableImageView asteroid2;
    private ShapeableImageView asteroid3;
    final int DELAY = 1000;
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startTimer();
        findViews();
        left_BTN.setOnClickListener(view -> {
            moveCar(-1);
        });
        right_BTN.setOnClickListener(view -> {
            moveCar(1);
        });
    }

    private void moveCar(int direction) {

        if (direction == 1) {
            if (carPlacementCenter.getVisibility() == View.VISIBLE
                    && carPlacementLeft.getVisibility() == View.INVISIBLE &&
                    carPlacementRight.getVisibility() == View.INVISIBLE) {

                carPlacementCenter.setVisibility(View.INVISIBLE);
                carPlacementRight.setVisibility(View.VISIBLE);
            }
            if (carPlacementCenter.getVisibility() == View.INVISIBLE && carPlacementRight.getVisibility() == View.INVISIBLE && carPlacementLeft.getVisibility() == View.VISIBLE) {
                carPlacementCenter.setVisibility(View.VISIBLE);
                carPlacementLeft.setVisibility(View.INVISIBLE);
            }
        }
        if (direction == -1) {
            if (carPlacementCenter.getVisibility() == View.VISIBLE
                    && carPlacementLeft.getVisibility() == View.INVISIBLE &&
                    carPlacementRight.getVisibility() == View.INVISIBLE) {
                carPlacementLeft.setVisibility(View.VISIBLE);
                carPlacementCenter.setVisibility(View.INVISIBLE);
            }
            if (carPlacementCenter.getVisibility() == View.INVISIBLE
                    && carPlacementLeft.getVisibility() == View.INVISIBLE &&
                    carPlacementRight.getVisibility() == View.VISIBLE) {
                carPlacementCenter.setVisibility(View.VISIBLE);
                carPlacementRight.setVisibility(View.INVISIBLE);
            }
        }

    }


    long startTime = 0;

    private void startTimer() {
        startTime = System.currentTimeMillis();
        timer = new Timer();
        timer.scheduleAtFixedRate(
                new TimerTask() {
                    @Override
                    public void run() {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                asteroid3.setVisibility(View.INVISIBLE);
                            }
                        });
                    }
                }
                , DELAY, DELAY);
    }

    private void findViews() {
        left_BTN = findViewById(R.id.left_BTN);
        right_BTN = findViewById(R.id.right_BTN);
        carPlacementRight = findViewById(R.id.car3);
        carPlacementRight.setVisibility(View.INVISIBLE);
        carPlacementCenter = findViewById(R.id.car2);
        carPlacementLeft = findViewById(R.id.car1);
        carPlacementLeft.setVisibility(View.INVISIBLE);
        asteroid1 = findViewById(R.id.m1);
        asteroid2 = findViewById(R.id.m2);
        asteroid3 = findViewById(R.id.m3);
    }
}