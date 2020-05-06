package com.example.diceroller3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


public class DiceScore extends AppCompatActivity  implements View.OnClickListener{

    Button Player1;
    Button Player2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_score);


        Intent intent = getIntent();
        Bundle b2 = getIntent().getExtras();


        int p1Score = intent.getIntExtra("Player 1 Score", 0);
        int p2Score = intent.getIntExtra("Player 2 Score", 0);
        TextView P1 = (TextView) findViewById(R.id.player_1);
        P1.setText(b2.getInt("Player 1"));
        TextView P2 = (TextView) findViewById(R.id.player_2);
        P2.setText(b2.getInt("Player 2"));
        //updateScore();

        Player1 = (Button) findViewById(R.id.Button1);
        Player1.setOnClickListener(DiceScore.this);
        Player2 = (Button) findViewById(R.id.Button2);
        Player2.setOnClickListener(DiceScore.this);


    }

    @Override
    public void onClick(View v){

        switch (v.getId()){
            case R.id.Button1:
                Toast.makeText(this, "Player 1 has" + String.valueOf("Player 1 Score") , Toast.LENGTH_LONG).show();
                break;

            case R.id.Button2:
                Toast.makeText(this, "Player 2 has" + String.valueOf("Player 2 Score") , Toast.LENGTH_LONG).show();
                break;

            default:
                break;
        }
    }



    private void updateScore(){

    }

    public void goBack(View v){
        this.finish();
    }
}
