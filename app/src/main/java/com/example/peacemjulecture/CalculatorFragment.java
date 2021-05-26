package com.example.peacemjulecture;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.peacemjulecture.databinding.FragmentCalculatorBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CalculatorFragment extends Fragment {
    private FragmentCalculatorBinding binding = null;
    private Double result = 0.0;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCalculatorBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        checkEditText();
        inputNumber();
        calculate();
    }

    private void checkEditText() {
        List<EditText> editTextList = Arrays.asList(binding.etLeftOperand,  binding.etRightOperand);

        binding.btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(InputChecker.checkEmpty(editTextList)) {
                    Toast.makeText(requireContext(), "계산할 숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(requireContext(), "Input OK", Toast.LENGTH_SHORT).show();
                }
            }
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

    private void calculate() {
        List<Button> calcuateButtons= Arrays.asList(binding.btnPlus, binding.btnMinus, binding.btnMultiply, binding.btnDivide);

        calcuateButtons.forEach((button -> {
            calcuateButtons.forEach(operator -> {
                operator.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String currentleftOperand = binding.etLeftOperand.getText().toString();
                        String currentRightOperand = binding.etRightOperand.getText().toString();
                        if (binding.btnPlus.equals(operator)) {
                            result = Double.parseDouble(currentleftOperand) + Double.parseDouble(currentRightOperand);
                        } else if (binding.btnMinus.equals(operator)) {
                            result = Double.parseDouble(currentleftOperand) - Double.parseDouble(currentRightOperand);
                        } else if (binding.btnMultiply.equals(operator)) {
                            result = Double.parseDouble(currentleftOperand) * Double.parseDouble(currentRightOperand);
                        } else {
                            result = Double.parseDouble(currentleftOperand) / Double.parseDouble(currentRightOperand);
                        }
                        binding.tvResult.setText(String.format(getString(R.string.result_format),result));
                    }
                });
            });
        })
        );
    }


    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }
}