package com.example.currencyconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
private EditText amount;
private EditText amount2;
private TextView result;
private TextView textView;
private String From;
private String To;
//private static ConverterModel ConversionRate = new ConverterModel();
//double static ConverterModel Calculate = new ConverterModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View mNumber;
        View mNumber2;


        Spinner spinner = findViewById(R.id.spinner_currency);
        amount = (EditText)findViewById(R.id.numberEditText);

        amount2 = (EditText)findViewById(R.id.numberEditText2);
        result = (TextView)findViewById(R.id.resultC);
        //To = spinner.getSelectedItem().toString();
        //amount.addTextChangedListener(amountIn);
        //Arrayadapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.currency_array, android.R.layout.simple_spinner_item);

        //ArrayDropDown
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //ArraySpinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();
                ConverterModel.Calculate(item);
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("getData",item);
                startActivity(i);

            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        amount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //String amounttoString = amount.getText().toString();
                //int amounttoInt = Integer.parseInt(amounttoString);

                //int positionitem = spinner.getSelectedItemPosition();
                String money2 = getIntent().getStringExtra("getData");
                double money = Double.parseDouble(money2);
                String text = amount.getText().toString();
                ConverterModel.ConversionRate(text, money);
                result.setText((CharSequence) amount);
            }
        });


      /*  amount2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 4) {
                    mLengthErrorMessage.setVisibility(View.VISIBLE);
                } else {
                    mLengthErrorMessage.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                String amount2toString = amount2.getText().toString();
                int amount2toInt = Integer.parseInt(amount2toString);
                ConverterModel.Calculate((double)amounttoInt, (double)amount2toInt, To);
            }

        });*/
    }
}
