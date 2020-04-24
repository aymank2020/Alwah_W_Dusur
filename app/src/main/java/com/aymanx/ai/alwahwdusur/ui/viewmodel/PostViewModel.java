package com.aymanx.ai.alwahwdusur.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aymanx.ai.alwahwdusur.data.PostClient;
import com.aymanx.ai.alwahwdusur.pojo.Category;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {


    public MutableLiveData<ArrayList<Category>> categoryLiveData = new MutableLiveData<>();

    public void getPostFromLiveData() {

        PostClient.getPostClient().getPosts().enqueue(new Callback<ArrayList<Category>>() {
            @Override
            public void onResponse(Call<ArrayList<Category>> call, Response<ArrayList<Category>> response) {
                if (response.isSuccessful()) {
                    categoryLiveData.setValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Category>> call, Throwable t) {
                t.getMessage();
            }
        });
    }
}