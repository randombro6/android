package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//THE APP WILL WORK ONLY FOR SINGLE OPERATION AT A TIME, I.E, DO 2+3 NOT 2+3+3

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button one, two, three, four, five, six, seven, eight, nine;
    Button add, sub, div, mul, clear, equals;
    EditText res;
    String operatorPressed = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        res= findViewById(R.id.res); //EditText
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        clear = findViewById(R.id.clear);
        sub = findViewById(R.id.sub);
        add = findViewById(R.id.add);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        equals = findViewById(R.id.equals);



        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
// operators
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        equals.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    
    @Override
    public void onClick(View view) {
        double finalResult = 0.0;
        switch(view.getId())
        {
            case R.id.one: res.append("1");
                break;
            case R.id.two: res.append("2");
                break;
            case R.id.three: res.append("3");
                break;
            case R.id.four: res.append("4");
                break;
            case R.id.five: res.append("5");
                break;
            case R.id.six: res.append("6");
                break;
            case R.id.seven: res.append("7");
                break;
            case R.id.eight: res.append("8");
                break;
            case R.id.nine: res.append("9");
                break;

            case R.id.add: res.append("+");
                operatorPressed="+";
                break;
            case R.id.sub: res.append("-");
                operatorPressed="-";
                break;
            case R.id.mul: res.append("*");
                operatorPressed="*";
                break;
            case R.id.div: res.append("/");
                operatorPressed="/";
                break;
            case R.id.clear: res.setText(" ");
                break;
            case R.id.equals: finalResult=
                    evaluateExpression(res.getText().toString(),operatorPressed);
                    res.setText(String.valueOf(finalResult));
                    break;

            default:return;
        }




    }
    private double evaluateExpression(String res, String operatorPressed)
    {
        String[] tokens = res.split("\\+|-|\\*|\\/");

        double firstOperand = Double.parseDouble(tokens[0]);
        double secondOperand = Double.parseDouble(tokens[1]);
        switch(operatorPressed)
        {
            case "+": return firstOperand + secondOperand;
            case "-": return firstOperand - secondOperand;
            case "*": return firstOperand * secondOperand;
            case "/": return firstOperand / secondOperand;
            default: return 0;
        }
    }
}
