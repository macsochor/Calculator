package com.example.msmd.librarydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.textView) TextView textView;
    @BindView(R.id.button_plus) Button button_plus;
    @BindView(R.id.button_equals) Button button_equals;
    @BindView(R.id.button_clear) Button button_clear;


    Integer firstNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        for (int i = 0; i <= 9; i++) {
            final int finalI = i;
            findViewById(getResources().getIdentifier("button"+String.valueOf(i), "id", getPackageName())).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView.setText(textView.getText().toString() + finalI);
                }
            });
        }

        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getText().length() > 0) {
                    firstNumber = Integer.valueOf(textView.getText().toString());
                    textView.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "You must input a number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstNumber != null && textView.getText().length() > 0) {
                    int secondNumber = Integer.valueOf(textView.getText().toString());
                    String total = String.valueOf(secondNumber + firstNumber);
                    textView.setText(total);
                    firstNumber = null;
                } else {
                    Toast.makeText(MainActivity.this, "You must hit plus with a number first!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstNumber = null;
                textView.setText("");
            }
        });
    }
}
