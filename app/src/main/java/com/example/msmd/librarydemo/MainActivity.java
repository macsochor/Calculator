package com.example.msmd.librarydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv_firstnumber;
    TextView tv_secondnumber;
    TextView tv_operation;
    Button button_add;
    Button button_subtract;
    Button button_multiply;
    Button button_divide;
    Button button_equals;
    Button button_clear;
    Integer firstNumber;
    int i;
    int operation;
    static final int ADD = 0;
    static final int SUBTRACT = 1;
    static final int MULTIPLY = 2;
    static final int DIVIDE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_add = (Button) findViewById(R.id.button_add);
        button_subtract = (Button) findViewById(R.id.button_subtract);
        button_divide = (Button) findViewById(R.id.button_divide);
        button_multiply = (Button) findViewById(R.id.button_multiply);
        button_clear = (Button) findViewById(R.id.button_clear);
        button_equals = (Button) findViewById(R.id.button_equals);
        tv_firstnumber = (TextView) findViewById(R.id.tv_firstnumber);
        tv_secondnumber = (TextView)findViewById(R.id.tv_secondnumber);
        tv_operation = (TextView) findViewById(R.id.tv_operation);



        for (i = 0; i <= 9; i++) {
            final int finalI = i;
            findViewById(getResources().getIdentifier("button"+String.valueOf(i), "id", getPackageName())).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(tv_operation.getText().equals("")){
                        tv_firstnumber.setText(tv_firstnumber.getText().toString() + finalI);
                    } else {
                        tv_secondnumber.setText(tv_secondnumber.getText().toString() + finalI);
                    }
                }
            });
        }

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //make sure that there is a number first present
                if (tv_firstnumber.getText().length() > 0) {
                    firstNumber = Integer.valueOf(tv_firstnumber.getText().toString());
                    tv_operation.setText("+");
                    operation = ADD;
                } else {
                    Toast.makeText(MainActivity.this, "You must input a number first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tv_firstnumber.getText().length() > 0) {
                    firstNumber = Integer.valueOf(tv_firstnumber.getText().toString());
                    operation = SUBTRACT;
                    tv_operation.setText("-");
                } else {
                    Toast.makeText(MainActivity.this, "You must input a number first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tv_firstnumber.getText().length() > 0) {
                    firstNumber = Integer.valueOf(tv_firstnumber.getText().toString());
                    operation = DIVIDE;
                    tv_operation.setText("÷");
                } else {
                    Toast.makeText(MainActivity.this, "You must input a number first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //make sure that there is a number first present
                if (tv_firstnumber.getText().length() > 0) {
                    firstNumber = Integer.valueOf(tv_firstnumber.getText().toString());
                    operation = MULTIPLY;
                    tv_operation.setText("×");
                } else {
                    Toast.makeText(MainActivity.this, "You must input a number first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstNumber != null && tv_firstnumber.getText().length() > 0) {
                    int secondNumber = Integer.valueOf(tv_secondnumber.getText().toString());
                    int total = 0;
                    switch (operation){
                        case ADD:
                            total = firstNumber + secondNumber;
                            break;
                        case SUBTRACT:
                            total = firstNumber - secondNumber;
                            break;
                        case DIVIDE:
                            total = firstNumber / secondNumber;
                            break;
                        case MULTIPLY:
                            total = firstNumber * secondNumber;
                            break;
                    }
                    tv_firstnumber.setText(String.valueOf(total));
                    tv_operation.setText("");
                    tv_secondnumber.setText("");
                    firstNumber = null;
                } else {
                    Toast.makeText(MainActivity.this, "You must enter a number, an operation, and a second number", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_firstnumber.setText("");
            }
        });
    }
}
