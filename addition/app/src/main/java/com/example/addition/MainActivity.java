package com.example.addition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.text.TextWatcher;
import android.text.Editable;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText number1;
    EditText number2;
    TextView sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO 1: Initialize number1 and number 2 to the correct EditTexts
        number1 = (EditText)findViewById(R.id.number1);
        number2 = (EditText)findViewById(R.id.number2);
        sum = (TextView)findViewById(R.id.sum);
        String input_a = number1.getText().toString();
        String input_b = number2.getText().toString();

        //TODO 2: Either have main activity implement the textwatcher interface or implement the textwatcher interface as an anonymous inner class. Think about which one would be better for this

        //TODO 3: Implement the textWatcher inteface and add the class that implements the textWatcher interface to each editText
        number1.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                int num1 = Integer.parseInt(number1.getText().toString());
                int num2 = Integer.parseInt(number2.getText().toString());
                sum.setText("Sum is" + (num1 + num2));


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });

        number2.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                int num1 = Integer.parseInt(number1.getText().toString());
                int num2 = Integer.parseInt(number2.getText().toString());
                sum.setText("Sum is" + (num1 + num2));
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {



            }
        });

    }

}