package com.example.peacemjulecture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.peacemjulecture.databinding.ActivitySigninBinding;

public class SingInActivity extends AppCompatActivity {
    ActivitySigninBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySigninBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        goToMenuActivity();
    }

    void goToMenuActivity() {
        binding.btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SingInActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}