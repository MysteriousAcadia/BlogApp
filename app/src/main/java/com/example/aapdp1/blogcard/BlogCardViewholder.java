package com.example.aapdp1.blogcard;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aapdp1.R;
import com.facebook.drawee.view.SimpleDraweeView;

import pl.droidsonroids.gif.GifImageView;

public class BlogCardViewholder extends RecyclerView.ViewHolder {
    TextView blogTitle,blogBody,blogLikes;
    GifImageView blogImage;

    public BlogCardViewholder(@NonNull View itemView) {
        super(itemView);
        this.blogTitle = itemView.findViewById(R.id.blog_title);
        this.blogBody = itemView.findViewById(R.id.blog_body);
        this.blogImage = itemView.findViewById(R.id.blog_card_image);
        this.blogLikes = itemView.findViewById(R.id.blog_likes);
    }
}
