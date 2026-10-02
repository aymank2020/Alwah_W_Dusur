package com.aymanx.ai.alwahwdusur.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.aymanx.ai.alwahwdusur.R;
import com.aymanx.ai.alwahwdusur.adapter.CategoryAdapter;
import com.aymanx.ai.alwahwdusur.pojo.Category;
import com.aymanx.ai.alwahwdusur.ui.viewmodel.PostViewModel;

import java.util.ArrayList;

public class CustomFragment extends Fragment {
    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.custom_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        categoryRecyclerView = view.findViewById(R.id.custom_recycler);
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        categoryAdapter = new CategoryAdapter(new ArrayList<Category>(), requireContext());
        categoryRecyclerView.setAdapter(categoryAdapter);

        final PostViewModel viewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        swipeRefreshLayout = view.findViewById(R.id.swipeLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                viewModel.getPostFromLiveData();
            }
        });
        viewModel.loadingLiveData.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean loading) {
                swipeRefreshLayout.setRefreshing(Boolean.TRUE.equals(loading));
            }
        });
        viewModel.categoryLiveData.observe(getViewLifecycleOwner(), new Observer<ArrayList<Category>>() {
            @Override
            public void onChanged(ArrayList<Category> categories) {
                categoryAdapter.setList(categories);
            }
        });
        viewModel.errorLiveData.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean failed) {
                if (Boolean.TRUE.equals(failed)) {
                    Toast.makeText(requireContext(), R.string.offers_load_error, Toast.LENGTH_LONG).show();
                }
            }
        });
        if (viewModel.categoryLiveData.getValue() == null) {
            viewModel.getPostFromLiveData();
        }
    }

    @Override
    public void onDestroyView() {
        categoryRecyclerView.setAdapter(null);
        categoryRecyclerView = null;
        categoryAdapter = null;
        swipeRefreshLayout.setOnRefreshListener(null);
        swipeRefreshLayout = null;
        super.onDestroyView();
    }
}
