package com.aymanx.ai.alwahwdusur.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.aymanx.ai.alwahwdusur.R;
import com.aymanx.ai.alwahwdusur.adapter.CategoryAdapter;
import com.aymanx.ai.alwahwdusur.pojo.Category;
import com.aymanx.ai.alwahwdusur.ui.viewmodel.PostViewModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class CustomFragment extends Fragment {

    View v;
    private RecyclerView mCategoryRecyclerView;
    //private SwipeRefreshLayout swipeRefreshLayout;
    private ArrayList<Category> mCategoryList = new ArrayList<>();
    private Context mContext;
    private CategoryAdapter categoryAdapter;
    PostViewModel postViewModel;


    public CustomFragment() {

    }

    //Override onStart method
    @Override
    public void onStart() {
        super.onStart();
    }

   /* @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
        mCategoryList.add(new Category(getString(R.string.prod_iphone), getString(R.string.pro_desc),
                R.drawable.iphone));
        mCategoryList.add(new Category(getString(R.string.prod_iphone), getString(R.string.pro_desc),
                R.drawable.iphone));
        mCategoryList.add(new Category(getString(R.string.prod_iphone), getString(R.string.pro_desc),
                R.drawable.iphone));
        mCategoryList.add(new Category(getString(R.string.prod_iphone), getString(R.string.pro_desc),
                R.drawable.iphone));
    }*/

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.custom_fragment, container, false);
        //fetchOffers();

        mCategoryRecyclerView = v.findViewById(R.id.custom_recycler);
        mCategoryRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false));
        categoryAdapter = new CategoryAdapter(mCategoryList, mContext);
        mCategoryRecyclerView.setAdapter(categoryAdapter);

        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        postViewModel.getPostFromLiveData();


        postViewModel.categoryLiveData.observe(this, new Observer<ArrayList<Category>>() {
            @Override
            public void onChanged(ArrayList<Category> categories) {

                categoryAdapter.setList(categories);
            }
        });

/*
        // Read from the database
        products.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                String value = null;
                try {
                    value = dataSnapshot.getValue(String.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

*/
        return v;
    }

    private void fetchOffers() {
        //Connect URL with View
        /*
        showOffers(mCategoryList);
        //postViewModel.getPostFromLiveData();
        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        postViewModel.getPostFromLiveData();
/*
        swipeRefreshLayout = v.findViewById(R.id.swipeLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                postViewModel.categoryLiveData.observe((LifecycleOwner) mContext, new Observer<ArrayList<Category>>() {
                    @Override
                    public void onChanged(ArrayList<Category> categories) {

                        categoryAdapter.setList(categories);
                    }
                });
            }
        });


    postViewModel.categoryLiveData.observe(this, new Observer<ArrayList<Category>>() {
            @Override
            public void onChanged(ArrayList<Category> categories) {

                categoryAdapter.setList(categories);
            }
        });
        */

    }
/*
    private void showOffers(ArrayList<Category> offersList) {
        mCategoryRecyclerView = v.findViewById(R.id.custom_recycler);
        this.mCategoryList = offersList;

        mCategoryRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false));
        categoryAdapter = new CategoryAdapter(mCategoryList, mContext);
        mCategoryRecyclerView.setAdapter(categoryAdapter);

    }

 */
}