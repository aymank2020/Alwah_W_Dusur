package com.aymanx.ai.alwahwdusur.data;

import com.aymanx.ai.alwahwdusur.pojo.Category;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {

    private static final String BASE_URL="https://jsonplaceholder.typicode.com/";
    private OffersAPI offersAPI;
    private static PostClient postClient;

    public PostClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        offersAPI = retrofit.create(OffersAPI.class);
    }

    public static PostClient getPostClient() {

        if ((null == postClient)){
            postClient=new PostClient();
        }

        return postClient;
    }

    public Call<ArrayList<Category>> getPosts() {

        return offersAPI.getAllOffers();
    }
}
