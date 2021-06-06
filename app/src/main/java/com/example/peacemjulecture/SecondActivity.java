package com.example.peacemjulecture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.peacemjulecture.databinding.ActivitySecondBinding;
import com.example.peacemjulecture.databinding.ActivityThirdBinding;

public class SecondActivity extends AppCompatActivity {
    private ActivitySecondBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        goToThirdActivity();
        popBackStack();
    }

    private void goToThirdActivity() {
        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                startActivity(intent);
            }
        });

    }

    private void popBackStack() {
        binding.buttonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}