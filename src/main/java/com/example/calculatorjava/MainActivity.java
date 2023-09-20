package com.example.calculatorjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    private TextView resultTextView; // to display the input and result
    private String currentNumber = ""; // holds the current number
    private String operator = ""; // holds the operator
    private double result = 0.0; // holds the result

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //initialize UI elements by finding the resultTextView using its ID

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);

    }

    public void onButtonClick(View view){ // called when digit or operator button is pressed

        Button button = (Button) view;
        String buttonText = button.getText().toString();
        // we get the button's text from the one that called the method

        switch(buttonText){

            case "=":
                calculate();
                break;

            case "C":
                clear();
                break;

            default: // when a number is tapped
                currentNumber += buttonText; // since it's a string, the numbers will be side by side
                resultTextView.setText(currentNumber);

        }

    }

    public void onOperatorClick(View view){ // called when operator is pressed

        Button button = (Button) view;
        operator = button.getText().toString();

        // If there's a current number, store it in the result and reset the current number
        if(!currentNumber.isEmpty()){

            result = Double.parseDouble(currentNumber);
            currentNumber = "";

        }

    }

    public void calculate(){ // performs calculation

        if(!currentNumber.isEmpty()){

            double secondNumber = Double.parseDouble(currentNumber);
            // converts the currentNumber into usable Double
            // so that it can perform operations

            switch(operator){

                case "+":
                    result += secondNumber;
                    break;
                case "-":
                    result -= secondNumber;
                    break;
                case "*":
                    result *= secondNumber;
                    break;
                case "/":
                    if (secondNumber != 0) {
                        result /= secondNumber;
                    } else {
                        resultTextView.setText("Error");
                        return;
                    }
                    break;

            }

            resultTextView.setText(String.valueOf(result));
            currentNumber = "";

        }

    }

    private void clear(){ // clears the attributes up top the class

        currentNumber = "";
        operator = "";
        result = 0.0;
        resultTextView.setText("");

    }

}