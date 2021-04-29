package com.example.peacemjulecture;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.peacemjulecture.databinding.FragmentMenuBinding;


public class MenuFragment extends Fragment {
    private FragmentMenuBinding binding = null;

    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMenuBinding.inflate(inflater, container, false);
         return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        openNaverUrl();
        callEmergency();
        openGallery();
        finishApplication();
    }

    // 버튼 클릭시 Naver로 이동
    private void openNaverUrl(){
        binding.btnMoveWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(NAVER_URL));
                startActivity(intent);
            }
        });
    }

    // 버튼 클릭시 다이얼로 이동하고 119 입력
    private void callEmergency() {
        binding.btnCall119.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("tel:/119"));
                startActivity(intent);
            }
        });
    }

    // 버튼 클릭시 Gallery앱으로 이동
    private void openGallery() {
        binding.btnOpenGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivity(intent);
            }
        });
    }

    private void finishApplication() {
        binding.btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_menuFragment_to_secondLectureFragment);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    private static final String NAVER_URL = "https://www.naver.com/";
}