package com.example.msmd.librarydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.textView) TextView textView;

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
    }
}
