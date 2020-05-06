package com.example.tictactoe;

import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

import static android.content.ContentValues.TAG;

public class TicTacToeGame {


    public static int NUM_ROWS = 4;
    public static int NUM_COLS = 4;
    public static char Player;
    private boolean gameEnded;

    // Lights that make up the grid
    public static int[][] mLights;

    public TicTacToeGame() {
        mLights = new int[NUM_ROWS][NUM_COLS];
    }

    public void newGame() {
        Random randomNumGenerator = new Random();
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                mLights[row][col] = randomNumGenerator.nextInt();

            }
        }
        Player = 'X';
        Log.d(TAG, "Game is now set");
        Log.d("TAG", String.valueOf(Player));
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    /*public void isLightOn(int row, int col) {
        return mLights[row][col];
    }*/


    public boolean isGameOver() {
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {

                //last row
                if ((mLights[row][col] == mLights[2][2]) && (mLights[row][col] == mLights[2][1]) && (mLights[row][col] == mLights[2][0])) {
                    return true;
                }
                //middle row
                if ((mLights[row][col] == mLights[1][2]) && (mLights[row][col] == mLights[1][1]) && (mLights[row][col] == mLights[1][0])) {
                    return true;
                }
                //first row
                if ((mLights[row][col] == mLights[0][2]) && (mLights[row][col] == mLights[0][1]) && (mLights[row][col] == mLights[0][0])) {
                    return true;
                }
                //first column
                if ((mLights[row][col] == mLights[0][0]) && (mLights[row][col] == mLights[1][0]) && (mLights[row][col] == mLights[2][0])) {
                    return true;
                }
                //middle column
                if ((mLights[row][col] == mLights[0][1]) && (mLights[row][col] == mLights[1][1]) && (mLights[row][col] == mLights[2][1])) {
                    return true;
                }
                //last column
                if ((mLights[row][col] == mLights[0][2]) && (mLights[row][col] == mLights[1][2]) && (mLights[row][col] == mLights[2][2])) {
                    return true;
                }
                //left to right
                if ((mLights[row][col] == mLights[0][0]) && (mLights[row][col] == mLights[1][1]) && (mLights[row][col] == mLights[2][2])) {
                    return true;
                }
                //right to left
                if ((mLights[row][col] == mLights[2][0]) && (mLights[row][col] == mLights[1][1]) && (mLights[row][col] == mLights[0][2])) {
                    return true;
                }

            }
        }
        return false;
    }

    public void changePlayer() {
        Player = (Player == 'X' ? 'O' : 'X');
        //Toast.makeText("Next Player").show();
    }
}
