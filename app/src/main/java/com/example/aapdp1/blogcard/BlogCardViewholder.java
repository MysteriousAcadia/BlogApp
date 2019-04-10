package com.example.aapdp1.blogcard;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aapdp1.R;

public class BlogCardViewholder extends RecyclerView.ViewHolder {
    TextView blogTitle,blogBody,blogLikes;
    ImageView blogImage;

    public BlogCardViewholder(@NonNull View itemView) {
        super(itemView);
        this.blogTitle = itemView.findViewById(R.id.blog_title);
        this.blogBody = itemView.findViewById(R.id.blog_body);
        this.blogImage = itemView.findViewById(R.id.blog_image);
        this.blogTitle = itemView.findViewById(R.id.blog_title);
    }
}
