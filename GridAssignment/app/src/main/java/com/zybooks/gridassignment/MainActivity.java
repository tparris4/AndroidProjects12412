package com.zybooks.gridassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.mybutton);
        button.setOnClickListener(mButtonClickListener);
    }
    private View.OnClickListener mButtonClickListener = new View.OnClickListener() {
        public void onClick(View v){
            Toast.makeText (MainActivity.this, "Button Clicked", Toast.LENGTH_LONG).show();
        }
        };

}