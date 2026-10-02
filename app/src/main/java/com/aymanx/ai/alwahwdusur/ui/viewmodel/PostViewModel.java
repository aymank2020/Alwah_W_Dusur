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
    public MutableLiveData<Boolean> errorLiveData = new MutableLiveData<>();
    public MutableLiveData<Boolean> loadingLiveData = new MutableLiveData<>();
    private Call<ArrayList<Category>> pendingCall;

    public void getPostFromLiveData() {

        if (pendingCall != null) return;
        errorLiveData.setValue(false);
        loadingLiveData.setValue(true);
        pendingCall = PostClient.getPostClient().getPosts();
        pendingCall.enqueue(new Callback<ArrayList<Category>>() {
            @Override
            public void onResponse(Call<ArrayList<Category>> call, Response<ArrayList<Category>> response) {
                pendingCall = null;
                loadingLiveData.setValue(false);
                if (response.isSuccessful() && response.body() != null) {
                    categoryLiveData.setValue(response.body());
                } else {
                    errorLiveData.setValue(true);
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Category>> call, Throwable t) {
                pendingCall = null;
                loadingLiveData.setValue(false);
                if (!call.isCanceled()) errorLiveData.setValue(true);
            }
        });
    }

    @Override
    protected void onCleared() {
        if (pendingCall != null) pendingCall.cancel();
        super.onCleared();
    }
}
