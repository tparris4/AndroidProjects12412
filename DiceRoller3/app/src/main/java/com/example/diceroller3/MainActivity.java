package com.example.diceroller3;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
        implements RollLengthDialogFragment.OnRollLengthSelectedListener {


    public static final int MAX_DICE = 3;

    private int mVisibleDice;
    private Dice[] mDice;
    private ImageView[] mDiceImageViews;
    private Menu mMenu;
    private CountDownTimer mTimer;

    private int mTimerLength = 2000;
    private GestureDetectorCompat mDetector;

    public int Player1Score;
    public int Player2Score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an array of Dice
        mDice = new Dice[MAX_DICE];
        for (int i = 0; i < MAX_DICE; i++) {
            mDice[i] = new Dice(i + 1);
        }

        mDetector = new GestureDetectorCompat(this, new MyGestureListener());
        // Create an array of ImageViews
        mDiceImageViews = new ImageView[MAX_DICE];
        mDiceImageViews[0] = findViewById(R.id.dice1);
        mDiceImageViews[1] = findViewById(R.id.dice2);
        mDiceImageViews[2] = findViewById(R.id.dice3);

        // All dice are initially visible
        mVisibleDice = MAX_DICE;

        showDice();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        mMenu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    private void showDice() {
        // Display only the number of dice visible
        for (int i = 0; i < mVisibleDice; i++) {
            Drawable diceDrawable;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                diceDrawable = getResources().getDrawable(mDice[i].getImageId(),
                        getApplicationContext().getTheme());
            } else {
                diceDrawable = getResources().getDrawable(mDice[i].getImageId());
            }

            mDiceImageViews[i].setImageDrawable(diceDrawable);
            mDiceImageViews[i].setContentDescription(Integer.toString(mDice[i].getNumber()));
        }
    }


    @Override
    public void onRollLengthClick(int which) {
        // Convert to milliseconds
        mTimerLength = 1000 * (which + 1);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Determine which menu option was chosen
        switch (item.getItemId()) {
            case R.id.action_stop:
                mTimer.cancel();
                item.setVisible(false);
                return true;

            case R.id.action_roll_length:
                FragmentManager manager = getSupportFragmentManager();
                RollLengthDialogFragment dialog = new RollLengthDialogFragment();
                dialog.show(manager, "rollLengthDialog");
                return true;

            case R.id.action_roll:
                rollDice();
                return true;

            case R.id.score_detect:
                scoreDetect();
                return true;

            /*case R.id.action_one:
                changeDiceVisibility(1);
                showDice();
                return true;

            case R.id.action_two:
                changeDiceVisibility(2);
                showDice();
                return true;

            case R.id.action_three:
                changeDiceVisibility(3);
                showDice();
                return true;*/

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent event) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            rollDice();
            return true;
        }
    }

    private void rollDice() {
        mMenu.findItem(R.id.action_stop).setVisible(true);

        if (mTimer != null) {
            mTimer.cancel();
        }


        mTimer = new CountDownTimer(mTimerLength, 100) {
            public void onTick(long millisUntilFinished) {
                for (int i = 0; i < mVisibleDice; i++) {
                     mDice[i].roll();

                }
                showDice();
            }

            public void onFinish() {
                mMenu.findItem(R.id.action_stop).setVisible(false);
                

            }
        }.start();
    }


    private void changeDiceVisibility(int numVisible) {
        mVisibleDice = numVisible;

        // Make dice visible
        for (int i = 0; i < numVisible; i++) {
            mDiceImageViews[i].setVisibility(View.VISIBLE);
        }

        // Hide remaining dice
        for (int i = numVisible; i < MAX_DICE; i++) {
            mDiceImageViews[i].setVisibility(View.GONE);
        }
    }

    public void scoreDetect() {
        Intent intent = new Intent(this, DiceScore.class);
        Bundle b1 = new Bundle();
        b1.putInt("Player 1", Player1Score);
        b1.putInt("Player 2", Player2Score);
        intent.putExtra("Player 1", Player1Score);
        intent.putExtra("Player 2", Player2Score);
        startActivity(intent);
    }
}