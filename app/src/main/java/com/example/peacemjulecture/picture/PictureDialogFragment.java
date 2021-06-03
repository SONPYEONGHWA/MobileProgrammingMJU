package com.example.peacemjulecture.picture;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.peacemjulecture.databinding.FragmentPictureDialogBinding;

public class PictureDialogFragment extends DialogFragment {
    private FragmentPictureDialogBinding binding = null;

    @Override
    public void onResume() {
        super.onResume();

        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.85);
        int height =(int) (getResources().getDisplayMetrics().heightPixels * 0.6);
        getDialog().getWindow().setLayout(width, height);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPictureDialogBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        closeDialog();
        getArgumentPicture();

    }
    private void getArgumentPicture() {
        if (getArguments() != null) {
            binding.ivAnimal.setBackgroundResource(getArguments().getInt("picture"));
        }
    }

    private void closeDialog() {
        binding.btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }
}