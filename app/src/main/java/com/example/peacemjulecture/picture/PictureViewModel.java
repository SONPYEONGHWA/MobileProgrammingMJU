package com.example.peacemjulecture.picture;

import android.content.Intent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PictureViewModel extends ViewModel {
    private MutableLiveData<Integer> animal = new MutableLiveData<Integer>(-1);

    public LiveData<Integer> getAnimal() {
        return animal;
    }

    public void fetchAnimal(Integer animalSelected) {
        animal.setValue(animalSelected);
    }
}
