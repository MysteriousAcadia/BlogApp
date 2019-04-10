package com.example.aapdp1.blogcard;

import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.aapdp1.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class BlogCardAdapter extends RecyclerView.Adapter<BlogCardViewholder> {

    private ArrayList<BlogCardModel> blogCardModel;


    public BlogCardAdapter(ArrayList<BlogCardModel> arr){
        blogCardModel = arr;
    }

    @NonNull
    @Override
    public BlogCardViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View view=layoutInflater.inflate(R.layout.blog_card, viewGroup, false);
        BlogCardViewholder notesViewHolder=new BlogCardViewholder(view);

        return notesViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull BlogCardViewholder viewHolder, int i) {
        viewHolder.blogBody.setText(blogCardModel.get(i).getBody());
        viewHolder.blogTitle.setText(blogCardModel.get(i).getTitle());
        URL newurl = null;
        try {
            newurl = new URL(blogCardModel.get(i).getImage());
            viewHolder.blogImage.setImageBitmap(BitmapFactory.decodeStream(newurl.openConnection() .getInputStream()));
        } catch (MalformedURLException e) {
            Log.d("BlogCardAdapter",e.toString());
            e.printStackTrace();
        }
         catch (IOException e) {
             Log.d("BlogCardAdapter",e.toString());
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return blogCardModel.size();
    }
}
