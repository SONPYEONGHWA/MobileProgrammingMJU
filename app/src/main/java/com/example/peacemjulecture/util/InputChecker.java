package com.example.peacemjulecture.util;

import android.text.TextUtils;
import android.widget.EditText;

import java.util.List;
import java.util.stream.Collectors;

public class InputChecker {
    private static InputChecker inputChecker= null;

    public static boolean checkEmpty(List<EditText> editTextList) {
        List<EditText> blankList = editTextList.stream().filter(editText ->
                TextUtils.isEmpty(editText.getText().toString()))
        .collect(Collectors.toList());

        return blankList.stream().count() > 0;
    }


    public static InputChecker getInstance() {
        if (inputChecker == null) {
            inputChecker = new InputChecker();
        }
        return inputChecker;
    }
}
