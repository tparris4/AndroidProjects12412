package com.zybooks.tipcalculator;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.RadioGroup;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText mNumAttendEditText;
    private TextView mNumPizzasTextView;
    private RadioGroup mTipPercentRadioGroup;
    private RadioGroup mSplitBillRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign the widgets to class variables
        mNumAttendEditText = findViewById(R.id.attendEditText);
        mNumPizzasTextView = findViewById(R.id.answerTextView);
        mTipPercentRadioGroup = findViewById(R.id.hungryRadioGroup);
        mSplitBillRadioGroup = findViewById(R.id.splitRadioGroup);
    }

    public void calculateClick(View view) {

        // Get the text that was typed into the EditText
        String numAttendStr = mNumAttendEditText.getText().toString();

        // Convert the text into an integer
        int numAttend = Integer.parseInt(numAttendStr);

        // Determine how many slices on average each person will eat
        int tipAmount = 0;
        int checkedId = mTipPercentRadioGroup.getCheckedRadioButtonId();
        if (checkedId == R.id.fifthteenRadioButton) {
            tipAmount = 15;
        }
        else if (checkedId == R.id.twentyRadioButton) {
            tipAmount = 20;
        }
        else if (checkedId == R.id.twentyfiveRadioButton) {
            tipAmount = 25;
        }

        else if (checkedId == R.id.thirtyRadioButton) {
            tipAmount = 30;
        }

        // Calculate and show the number of pizzas needed
        if (numAttend < 0.0){
            System.out.print("Invalid Amount");
        }
        int tipTotal = (int) Math.ceil(numAttend * (tipAmount / 100));
        int totalAmount = (numAttend + tipTotal);
        mNumPizzasTextView.setText("Total amount: " + totalAmount);

        public void calculateSplit(View view){

       int SplitBill = 1;
        int checkedId2 = mSplitBillRadioGroup.getCheckedRadioButtonId();
        if (checkedId2 = R.id.twoRadioButton) {
            SplitBill = 2;
        }

        if (checkedId2 = R.id.threeRadioButton) {
            SplitBill = 3;
        }

        if (checkedId2 = R.id.fourRadioButton) {
            SplitBill = 4;
        }

        totalAmount = (totalAmount / SplitBill);
        mNumPizzasTextView.setText("New Split Bill: " + totalAmount);
        }
    }
}