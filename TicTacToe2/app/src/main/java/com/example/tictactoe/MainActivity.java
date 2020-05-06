package com.example.tictactoe;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TicTacToeGame mGame;
    private Button[][] mButtons;
    private int mOnColor;
    private int mColorX;
    private Button button_1;
    private Button button_2;
    private Button button_3;
    private Button button_4;
    private Button button_5;
    private Button button_6;
    private Button button_7;
    private Button button_8;
    private Button button_9;
    private Button newGameButton;
    private int mColorO;

    private int PlayerTurnCount;
    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_1 = findViewById(R.id.Button_1);
        button_1.setOnClickListener(this);
        button_2 = findViewById(R.id.Button_2);
        button_2.setOnClickListener(this);
        button_3 = findViewById(R.id.Button_3);
        button_3.setOnClickListener(this);
        button_4 = findViewById(R.id.Button_4);
        button_4.setOnClickListener(this);
        button_5 = findViewById(R.id.Button_5);
        button_5.setOnClickListener(this);
        button_6 = findViewById(R.id.Button_6);
        button_6.setOnClickListener(this);
        button_7 = findViewById(R.id.Button_7);
        button_7.setOnClickListener(this);
        button_8 = findViewById(R.id.Button_8);
        button_8.setOnClickListener(this);
        button_9 = findViewById(R.id.Button_9);
        button_9.setOnClickListener(this);

        mOnColor = ContextCompat.getColor(this, R.color.colorOn);
        mColorX = ContextCompat.getColor(this, R.color.colorX);
        mColorO = ContextCompat.getColor(this, R.color.colorO);

        mButtons = new Button[TicTacToeGame.NUM_ROWS][TicTacToeGame.NUM_COLS];

        GridLayout gridLayout = findViewById(R.id.light_grid);
        int childIndex = 0;
        for (int row = 0; row < TicTacToeGame.NUM_ROWS; row++) {
            for (int col = 0; col < TicTacToeGame.NUM_COLS; col++) {
                mButtons[row][col] = (Button) gridLayout.getChildAt(childIndex);
                childIndex++;
            }

        }

        mGame = new TicTacToeGame();
        startGame();

        newGameButton = findViewById(R.id.button_new_game);
        newGameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.d(TAG, "Game started");
                startGame();
            }
        });
    }

    private void startGame() {
        mGame.newGame();
        Log.d(TAG, "Game is ready to begin");
        PlayerTurnCount = 0;
        int CurrentNum = 3;
        boardClear();
        Toast.makeText(this, "Game is ready to start", Toast.LENGTH_LONG).show();
        //setButtonColors();
    }

    public void onClick(View view) {
        // Find the row and col selected
        switch (view.getId()) {


            case R.id.Button_1:
                boolean buttonFound = false;

                Log.d(TAG, "Button 1 pressed");
                for (int row = 0; row < TicTacToeGame.NUM_ROWS && !buttonFound; row++) {
                    for (int col = 0; col < TicTacToeGame.NUM_COLS && !buttonFound; col++) {
                        if (view == mButtons[row][col]) {
                            // mGame.selectLight(row, col);
                            buttonFound = true;
                            button_1.setText(String.valueOf(mGame.Player));
                            if (TicTacToeGame.Player == 'X') {
                                TicTacToeGame.mLights[row][col] = 1;
                                Log.d(TAG, String.valueOf(TicTacToeGame.mLights[row][col]));
                            } else {
                                TicTacToeGame.mLights[row][col] = 2;
                                Log.d(TAG, String.valueOf(TicTacToeGame.mLights[row][col]));
                            }
                            Log.d(TAG, "Next Player");
                            Toast.makeText(this, "Next Player", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
                PlayerTurnCount++;
                if (PlayerTurnCount == 9) {
                    Toast.makeText(this, "Game is over", Toast.LENGTH_LONG).show();
                }
                    mGame.changePlayer();
                    // Congratulate the user if the game is over
                    if (mGame.isGameOver()) {
                        Toast.makeText(this, "Congratulations! Press New Game to start again.", Toast.LENGTH_LONG).show();
                    }
                    break;

                    case R.id.Button_2:
                        buttonFound = false;
                        Log.d(TAG, "Button 2 pressed");
                        for (int row = 0; row < TicTacToeGame.NUM_ROWS && !buttonFound; row++) {
                            for (int col = 0; col < TicTacToeGame.NUM_COLS && !buttonFound; col++) {
                                if (view == mButtons[row][col]) {
                                    // mGame.selectLight(row, col);
                                    buttonFound = true;
                                    button_2.setText(String.valueOf(mGame.Player));
                                    if (TicTacToeGame.Player == 'X') {
                                        TicTacToeGame.mLights[row][col] = 1;
                                        Log.d(TAG, String.valueOf(TicTacToeGame.mLights[row][col]));
                                    } else {
                                        TicTacToeGame.mLights[row][col] = 2;
                                        Log.d(TAG, String.valueOf(TicTacToeGame.mLights[row][col]));
                                    }
                                    Log.d(TAG, "Next Player");
                                    Toast.makeText(this, "Next Player", Toast.LENGTH_SHORT).show();
                                }
                            }

                        }
                        PlayerTurnCount++;
                        if (PlayerTurnCount == 9) {
                            Toast.makeText(this, "Game is over", Toast.LENGTH_LONG).show();

                        }
                        mGame.changePlayer();
                        // Congratulate the user if the game is over
                        if (mGame.isGameOver()) {
                            Toast.makeText(this, "Congratulations! Press New Game to start again.", Toast.LENGTH_LONG).show();
                        }
                        break;

                    case R.id.Button_3:
                        buttonFound = false;

                        Log.d(TAG, "Button 3 pressed");
                        for (int row = 0; row < TicTacToeGame.NUM_ROWS && !buttonFound; row++) {
                            for (int col = 0; col < TicTacToeGame.NUM_COLS && !buttonFound; col++) {
                                if (view == mButtons[row][col]) {
                                    // mGame.selectLight(row, col);
                                    buttonFound = true;
                                    button_3.setText(String.valueOf(mGame.Player));
                                    if (TicTacToeGame.Player == 'X') {
                                        TicTacToeGame.mLights[row][col] = 1;
                                        Log.d(TAG, String.valueOf(TicTacToeGame.mLights[row][col]));
                                    } else {
                                        TicTacToeGame.mLights[row][col] = 2;
                                        Log.d(TAG, String.valueOf(TicTacToeGame.mLights[row][col]));
                                    }

                                    Log.d(TAG, "Next Player");
                                    Toast.makeText(this, "Next Player", Toast.LENGTH_SHORT).show();
                                }
                            }

                        }
                        PlayerTurnCount++;
                        if (PlayerTurnCount == 9) {
                            Toast.makeText(this, "Game is over", Toast.LENGTH_LONG).show();

                        }
                        mGame.changePlayer();
                        // Congratulate the user if the game is over
                        if (mGame.isGameOver()) {
                            Toast.makeText(this, "Congratulations! Press New Game to start again.", Toast.LENGTH_LONG).show();
                        }
                        break;

                    case R.id.Button_4:
                        buttonFound = false;

                        Log.d(TAG, "Button 4 pressed");
                        for (int row = 0; row < TicTacToeGame.NUM_ROWS && !buttonFound; row++) {
                            for (int col = 0; col < TicTacToeGame.NUM_COLS && !buttonFound; col++) {
                                if (view == mButtons[row][col]) {
                                    // mGame.selectLight(row, col);
                                    buttonFound = true;
                                    button_4.setText(String.valueOf(mGame.Player));
                                    if (TicTacToeGame.Player == 'X') {
                                        TicTacToeGame.mLights[row][col] = 1;
                                        Log.d(TAG, String.valueOf(TicTacToeGame.mLights[row][col]));
                                    } else {
                                        TicTacToeGame.mLights[row][col] = 2;
                                        Log.d(TAG, String.valueOf(TicTacToeGame.mLights[row][col]));
                                    }
                                    Log.d(TAG, "Next Player");
                                    Toast.makeText(this, "Next Player", Toast.LENGTH_SHORT).show();
                                }
                            }

                        }
                        PlayerTurnCount++;
                        if (PlayerTurnCount == 9) {
                            Toast.makeText(this, "Game is over", Toast.LENGTH_LONG).show();

                        }
                        mGame.changePlayer();
                        // Congratulate the user if the game is over
                        if (mGame.isGameOver()) {
                            Toast.makeText(this, "Congratulations! Press New Game to start again.", Toast.LENGTH_LONG).show();
                        }
                        break;

                    case R.id.Button_5:
                        buttonFound = false;

                        Log.d(TAG, "Button 5 pressed");
                        for (int row = 0; row < TicTacToeGame.NUM_ROWS && !buttonFound; row++) {
                            for (int col = 0; col < TicTacToeGame.NUM_COLS && !buttonFound; col++) {
                                if (view == mButtons[row][col]) {
                                    // mGame.selectLight(row, col);
                                    buttonFound = true;
                                    button_5.setText(String.valueOf(mGame.Player));
                                    if (TicTacToeGame.Player == 'X') {
                                        TicTacToeGame.mLights[row][col] = 1;
                                        Log.d(TAG, String.valueOf(TicTacToeGame.mLights[row][col]));
                                    } else {
                                        TicTacToeGame.mLights[row][col] = 2;
                                        Log.d(TAG, String.valueOf(TicTacToeGame.mLights[row][col]));
                                    }
                                    Log.d(TAG, "Next Player");
                                    Toast.makeText(this, "Next Player", Toast.LENGTH_SHORT).show();
                                }
                            }

                        }
                        PlayerTurnCount++;
                        if (PlayerTurnCount == 9) {
                            Toast.makeText(this, "Game is over", Toast.LENGTH_LONG).show();

                        }
                        mGame.changePlayer();
                        // Congratulate the user if the game is over
                        if (mGame.isGameOver()) {
                            Toast.makeText(this, "Congratulations! Press New Game to start again.", Toast.LENGTH_LONG).show();
                        }
                        break;

                    case R.id.Button_6:
                        buttonFound = false;

                        Log.d(TAG, "Button 6 pressed");
                        for (int row = 0; row < TicTacToeGame.NUM_ROWS && !buttonFound; row++) {
                            for (int col = 0; col < TicTacToeGame.NUM_COLS && !buttonFound; col++) {
                                if (view == mButtons[row][col]) {
                                    // mGame.selectLight(row, col);
                                    buttonFound = true;
                                    button_6.setText(String.valueOf(mGame.Player));
                                    if (TicTacToeGame.Player == 'X') {
                                        TicTacToeGame.mLights[row][col] = 1;
                                        Log.d(TAG, String.valueOf(TicTacToeGame.mLights[row][col]));
                                    } else {
                                        TicTacToeGame.mLights[row][col] = 2;
                                        Log.d(TAG, String.valueOf(TicTacToeGame.mLights[row][col]));
                                    }
                                    Log.d(TAG, "Next Player");
                                    Toast.makeText(this, "Next Player", Toast.LENGTH_SHORT).show();
                                }
                            }

                        }
                        PlayerTurnCount++;
                        if (PlayerTurnCount == 9) {
                            Toast.makeText(this, "Game is over", Toast.LENGTH_LONG).show();

                        }
                        mGame.changePlayer();
                        // Congratulate the user if the game is over
                        if (mGame.isGameOver()) {
                            Toast.makeText(this, "Congratulations! Press New Game to start again.", Toast.LENGTH_LONG).show();
                        }
                        break;

                    case R.id.Button_7:
                        buttonFound = false;

                        Log.d(TAG, "Button 7 pressed");
                        for (int row = 0; row < TicTacToeGame.NUM_ROWS && !buttonFound; row++) {
                            for (int col = 0; col < TicTacToeGame.NUM_COLS && !buttonFound; col++) {
                                if (view == mButtons[row][col]) {
                                    // mGame.selectLight(row, col);
                                    buttonFound = true;
                                    button_7.setText(String.valueOf(mGame.Player));
                                    if (TicTacToeGame.Player == 'X') {
                                        TicTacToeGame.mLights[row][col] = 1;
                                        Log.d(TAG, String.valueOf(TicTacToeGame.mLights[row][col]));
                                    } else {
                                        TicTacToeGame.mLights[row][col] = 2;
                                        Log.d(TAG, String.valueOf(TicTacToeGame.mLights[row][col]));
                                    }
                                    Log.d(TAG, "Next Player");
                                    Toast.makeText(this, "Next Player", Toast.LENGTH_SHORT).show();
                                }
                            }

                        }
                        PlayerTurnCount++;
                        if (PlayerTurnCount == 9) {
                            Toast.makeText(this, "Game is over", Toast.LENGTH_LONG).show();

                        }
                        mGame.changePlayer();
                        // Congratulate the user if the game is over
                        if (mGame.isGameOver()) {
                            Toast.makeText(this, "Congratulations! Press New Game to start again.", Toast.LENGTH_LONG).show();
                        }
                        break;

                    case R.id.Button_8:
                        buttonFound = false;

                        Log.d(TAG, "Button 8 pressed");
                        for (int row = 0; row < TicTacToeGame.NUM_ROWS && !buttonFound; row++) {
                            for (int col = 0; col < TicTacToeGame.NUM_COLS && !buttonFound; col++) {
                                if (view == mButtons[row][col]) {
                                    // mGame.selectLight(row, col);
                                    buttonFound = true;
                                    button_8.setText(String.valueOf(mGame.Player));
                                    if (TicTacToeGame.Player == 'X') {
                                        TicTacToeGame.mLights[row][col] = 1;
                                        Log.d(TAG, String.valueOf(TicTacToeGame.mLights[row][col]));
                                    } else {
                                        TicTacToeGame.mLights[row][col] = 2;
                                        Log.d(TAG, String.valueOf(TicTacToeGame.mLights[row][col]));
                                    }
                                    Log.d(TAG, "Next Player");
                                    Toast.makeText(this, "Next Player", Toast.LENGTH_SHORT).show();
                                }
                            }

                        }
                        PlayerTurnCount++;
                        if (PlayerTurnCount == 9) {
                            Toast.makeText(this, "Game is over", Toast.LENGTH_LONG).show();

                        }
                        mGame.changePlayer();
                        // Congratulate the user if the game is over
                        if (mGame.isGameOver()) {
                            Toast.makeText(this, "Congratulations! Press New Game to start again.", Toast.LENGTH_LONG).show();
                        }
                        break;

                    case R.id.Button_9:
                        buttonFound = false;

                        Log.d(TAG, "Button 9 pressed");
                        for (int row = 0; row < TicTacToeGame.NUM_ROWS && !buttonFound; row++) {
                            for (int col = 0; col < TicTacToeGame.NUM_COLS && !buttonFound; col++) {
                                if (view == mButtons[row][col]) {
                                    // mGame.selectLight(row, col);
                                    buttonFound = true;
                                    button_9.setText(String.valueOf(mGame.Player));
                                    if (TicTacToeGame.Player == 'X') {
                                        TicTacToeGame.mLights[row][col] = 1;
                                        Log.d(TAG, String.valueOf(TicTacToeGame.mLights[row][col]));
                                    } else {
                                        TicTacToeGame.mLights[row][col] = 2;
                                        Log.d(TAG, String.valueOf(TicTacToeGame.mLights[row][col]));
                                    }
                                    Log.d(TAG, "Next Player");
                                    Toast.makeText(this, "Next Player", Toast.LENGTH_SHORT).show();
                                }
                            }

                        }
                        PlayerTurnCount++;
                        if (PlayerTurnCount == 9) {
                            Toast.makeText(this, "Game is over", Toast.LENGTH_LONG).show();

                        }
                        mGame.changePlayer();
                        // Congratulate the user if the game is over
                        if (mGame.isGameOver()) {
                            Toast.makeText(this, "Congratulations! Press New Game to start again.", Toast.LENGTH_LONG).show();

                        }
                        break;

                    default:
                        break;


                }
        }
   /* private void setButtonColors() {

        // Set all buttons' background color
        for (int row = 0; row < TicTacToeGame.NUM_ROWS; row++) {
            for (int col = 0; col < TicTacToeGame.NUM_COLS; col++) {
                if (mGame.isLightOn(row, col)) {
                    mButtons[row][col].setBackgroundColor(mColorX);
                } else {
                    mButtons[row][col].setBackgroundColor(mColorX);
                }
            }
        }
    }
    */

    private void boardClear() {
        button_1.setText("");
        button_2.setText("");
        button_3.setText("");
        button_4.setText("");
        button_5.setText("");
        button_6.setText("");
        button_7.setText("");
        button_8.setText("");
        button_9.setText("");
        Log.d(TAG, "Board cleared");
    }


    protected void savedState(Bundle currentState) {
        super.onSaveInstanceState(currentState);

        currentState.putInt("row", TicTacToeGame.NUM_ROWS);
        currentState.putInt("col", TicTacToeGame.NUM_COLS);
        currentState.putInt("Player Turn", PlayerTurnCount);
        currentState.putChar("Player", TicTacToeGame.Player);

    }

    protected void restoredState(Bundle newState) {
        super.onRestoreInstanceState(newState);

        PlayerTurnCount = newState.getInt("Player Turn");
        TicTacToeGame.NUM_ROWS = newState.getInt("row");
        TicTacToeGame.NUM_COLS = newState.getInt("col");
        TicTacToeGame.Player = newState.getChar("Player");
    }


}