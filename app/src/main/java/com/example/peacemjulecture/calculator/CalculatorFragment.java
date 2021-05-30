package com.example.peacemjulecture.calculator;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.peacemjulecture.util.InputChecker;
import com.example.peacemjulecture.R;
import com.example.peacemjulecture.databinding.FragmentCalculatorBinding;

import java.util.Arrays;
import java.util.List;


public class CalculatorFragment extends Fragment {
    private FragmentCalculatorBinding binding = null;
    private List<Button> operatorBtnList = null;
    private Double result = 0.0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCalculatorBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        operatorBtnList = Arrays.asList(binding.btnPlus, binding.btnMinus, binding.btnMultiply, binding.btnDivide);

        checkEditText();
        inputNumber();
    }

    private void checkEditText() {
        List<EditText> editTextList = Arrays.asList(binding.etLeftOperand, binding.etRightOperand);
        InputChecker inputChecker = InputChecker.getInstance();

        operatorBtnList.forEach(button -> {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (inputChecker.checkEmpty(editTextList)) {
                        Toast.makeText(requireContext(), "계산할 숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(requireContext(), "Input OK", Toast.LENGTH_SHORT).show();
                        calculate(button);
                    }
                }
            });
        });
    }

    private void inputNumber() {
        List<Button> buttonList =
                Arrays.asList(binding.btnZero, binding.btnOne, binding.btnTwo, binding.btnThree, binding.btnFour,
                        binding.btnFive, binding.btnSix, binding.btnSeven, binding.btnEight, binding.btnNine);

        buttonList.forEach(button -> {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (binding.etLeftOperand.isFocused()) {
                        binding.etLeftOperand.setText(binding.etLeftOperand.getText().toString() + button.getText().toString());
                    } else if (binding.etRightOperand.isFocused()) {
                        binding.etRightOperand.setText(binding.etRightOperand.getText().toString() + button.getText().toString());
                    } else {
                        Toast.makeText(requireContext(), "입력창을 먼저 선택해주세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        });
    }

    private void calculate(Button button) {
        String currentLeftOperand = binding.etLeftOperand.getText().toString();
        String currentRightOperand = binding.etRightOperand.getText().toString();

        if (binding.btnPlus.equals(button)) {
            result = Double.parseDouble(currentLeftOperand) + Double.parseDouble(currentRightOperand);
        } else if (binding.btnMinus.equals(button)) {
            result = Double.parseDouble(currentLeftOperand) - Double.parseDouble(currentRightOperand);
        } else if (binding.btnMultiply.equals(button)) {
            result = Double.parseDouble(currentLeftOperand) * Double.parseDouble(currentRightOperand);
        } else {
            result = Double.parseDouble(currentLeftOperand) / Double.parseDouble(currentRightOperand);
        }
        binding.tvResult.setText(String.format(getString(R.string.result_format), result));
    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }
}