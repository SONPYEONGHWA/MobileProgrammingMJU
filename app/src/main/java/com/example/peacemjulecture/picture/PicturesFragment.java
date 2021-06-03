package com.example.peacemjulecture.picture;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.peacemjulecture.R;
import com.example.peacemjulecture.databinding.FragmentPicturesBinding;
import com.example.peacemjulecture.picture.PictureDialogFragment;


public class PicturesFragment extends Fragment {
    private FragmentPicturesBinding binding = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPicturesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showDialog();
    }

    private void showDialog() {
        binding.btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    PictureDialogFragment pictureDialogFragment = new PictureDialogFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt("picture", getAnimalChecked());
                    pictureDialogFragment.setArguments(bundle);
                    pictureDialogFragment.show(getChildFragmentManager(), getTag());
                } catch (IllegalArgumentException e) {
                    Toast.makeText(requireContext(), "Select Animal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private int getAnimalChecked() {
        switch (binding.rbGroup.getCheckedRadioButtonId()) {
            case R.id.rb_dog:
                return R.drawable.dog;
            case R.id.rb_cat:
                return R.drawable.cat;
            case R.id.rb_rabbit:
                return R.drawable.rabbit;
            case R.id.rb_horse:
                return R.drawable.horse;
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