package com.example.peacemjulecture.picture;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.peacemjulecture.R;
import com.example.peacemjulecture.databinding.FragmentPicturesBinding;
import com.example.peacemjulecture.picture.PictureDialogFragment;


public class PicturesFragment extends Fragment {
    private FragmentPicturesBinding binding = null;
    private PictureViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPicturesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(PictureViewModel.class);
        showDialog();
    }

    private void showDialog() {
        binding.btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnimalChecked();
                showPicture();
            }
        });
    }

    private void showPicture() {
        try {
            PictureDialogFragment pictureDialogFragment = new PictureDialogFragment();
            pictureDialogFragment.show(getChildFragmentManager(), getTag());
        } catch (IllegalArgumentException e) {
            Toast.makeText(requireContext(), "Select Animal", Toast.LENGTH_SHORT).show();
        }
    }

    private void getAnimalChecked() {
        switch (binding.rbGroup.getCheckedRadioButtonId()) {
            case R.id.rb_dog:
                viewModel.fetchAnimal(R.drawable.dog);
                break;
            case R.id.rb_cat:
                viewModel.fetchAnimal(R.drawable.cat);
                break;
            case R.id.rb_rabbit:
                viewModel.fetchAnimal(R.drawable.rabbit);
                break;
            case R.id.rb_horse:
                viewModel.fetchAnimal(R.drawable.horse);
                break;
            default:
                throw new IllegalArgumentException("getCheckedButtonId Error");
        }
    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }
}