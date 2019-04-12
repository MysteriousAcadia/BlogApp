package com.example.aapdp1.blogcard;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.aapdp1.R;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class BlogCardAdapter extends RecyclerView.Adapter<BlogCardViewholder> {

    private ArrayList<BlogCardModel> blogCardModel;


    public BlogCardAdapter(ArrayList<BlogCardModel> arr){
        blogCardModel = arr;
        setHasStableIds(true);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }


    @NonNull
    @Override
    public BlogCardViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        Fresco.initialize(viewGroup.getContext());
        View view=layoutInflater.inflate(R.layout.blog_card, viewGroup, false);
        BlogCardViewholder notesViewHolder=new BlogCardViewholder(view);

        return notesViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull final BlogCardViewholder viewHolder, final int i) {
        viewHolder.blogBody.setText(blogCardModel.get(getItemCount()-i-1).getBody());
        viewHolder.blogTitle.setText(blogCardModel.get(getItemCount()-i-1).getTitle());
        viewHolder.blogLikes.setText(Integer.toString(blogCardModel.get(getItemCount()-i-1).getLikes()));
        //viewHolder.blogImage.setImageURI(Uri.parse(blogCardModel.get(i).toString()));
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Glide.with(viewHolder.itemView.getRootView().getContext()).load(blogCardModel.get(getItemCount()-i-1).getImage()).into(viewHolder.blogImage);

            }
        }, 3000);




    }

    @Override
    public int getItemCount() {
        return blogCardModel.size();
    }
}
