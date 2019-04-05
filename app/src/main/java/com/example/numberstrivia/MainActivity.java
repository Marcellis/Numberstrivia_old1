package com.example.numberstrivia;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private TextView tvTrivia;
    private Button btnTrivia;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTrivia = findViewById(R.id.tv_trivia);
        btnTrivia = findViewById(R.id.btn_trivia);

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        viewModel.getTrivia().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tvTrivia.setText(s);
            }
        });

        viewModel.getError().observe(this, new Observer<String>() {

            @Override

            public void onChanged(@Nullable String s) {

                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();

            }

        });

        btnTrivia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getRandomNumberTrivia();
            }
        });


    }

}





