package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.Random;
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
    private ShapeableImageView[][]myImages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        left_BTN.setOnClickListener(view -> {
            moveCar(-1);
        });
        right_BTN.setOnClickListener(view -> {
            moveCar(1);
        });
        //startTimer();
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
        while(true){

        timer.scheduleAtFixedRate(
                new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                               /* for (int i = 0; i < 5; i++) {
                                    Random random=new Random();
                                    int num=random.nextInt(3);
                                    myImages[num][i].setVisibility(View.VISIBLE);
                                }*/
                            }
                        });
                    }
                }
                , DELAY, DELAY);
        }
    }

    private void findViews() {
      myImages=new ShapeableImageView[5][3];
       myImages[0][0]=findViewById(R.id.m1);

        myImages[0][1]=findViewById(R.id.m2);
        myImages[0][2]=findViewById(R.id.m3);
        myImages[1][0]=findViewById(R.id.m4);
        myImages[1][2]=findViewById(R.id.m6);
        myImages[2][0]=findViewById(R.id.m7);
        myImages[2][1]=findViewById(R.id.m8);
        myImages[2][2]=findViewById(R.id.m9);
        myImages[3][0]=findViewById(R.id.m10);
        myImages[3][1]=findViewById(R.id.m11);
        myImages[3][2]=findViewById(R.id.m12);
        myImages[4][0]=findViewById(R.id.car1);
        myImages[4][1]=findViewById(R.id.car2);
        myImages[4][2]=findViewById(R.id.car3);
        left_BTN = findViewById(R.id.left_BTN);
        //turn the map invisible


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