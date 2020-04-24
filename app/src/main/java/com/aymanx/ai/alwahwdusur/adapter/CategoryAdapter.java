package com.aymanx.ai.alwahwdusur.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aymanx.ai.alwahwdusur.R;
import com.aymanx.ai.alwahwdusur.pojo.Category;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.myViewHolder> {

    private ArrayList<Category> mCategory = new ArrayList<>();
    private LayoutInflater inflater;
    private Context mContext;
    private boolean flag = true;

    public CategoryAdapter() {

    }

    public CategoryAdapter(ArrayList<Category> mCategory, Context mContext) {
        this.mCategory = mCategory;
        this.mContext = mContext;
    }

    @NonNull
    @Override
     public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Check
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        View v = inflater.inflate(R.layout.item_design, parent, false);
        myViewHolder myViewHolderInstance = new myViewHolder(v);

        return myViewHolderInstance;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {


        holder.productName.setText(mCategory.get(position).getTitle());
        holder.productDescription.setText(mCategory.get(position).getBody());
        /*if (holder.photoID != null) {
            holder.photoID.setImageResource(mCategory.get(position).getPhotoID());
        }*/
    }

    @Override
    public int getItemCount() {
        return mCategory.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        public TextView productName, productDescription;
        //public ImageView photoID;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.name_of_product);
            productDescription = itemView.findViewById(R.id.descption_of_product);
            //photoID = itemView.findViewById(R.id.photo);
        }
    }

    public void setList(ArrayList<Category> mCategoryList){
        this.mCategory = mCategoryList;
        notifyDataSetChanged();
    }
}