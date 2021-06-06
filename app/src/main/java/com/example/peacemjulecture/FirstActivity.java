package com.example.peacemjulecture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.peacemjulecture.databinding.ActivityFirstBinding;
import com.example.peacemjulecture.databinding.ActivitySecondBinding;
import com.example.peacemjulecture.picture.PictureViewModel;

public class FirstActivity extends AppCompatActivity {
    private ActivityFirstBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFirstBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        goToSecondActivity();
    }

    private void goToSecondActivity() {
        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}