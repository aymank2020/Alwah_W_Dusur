package com.aymanx.ai.alwahwdusur.data;


import com.aymanx.ai.alwahwdusur.pojo.Category;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface OffersAPI {

    @GET("posts")
    public Call<ArrayList<Category>> getAllOffers();

}
