package com.example.aapdp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aapdp1.blogcard.BlogCardAdapter;
import com.example.aapdp1.blogcard.BlogCardModel;
import com.example.aapdp1.blogcard.LoginActivity;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    DatabaseReference nameDatabase;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        if(FirebaseAuth.getInstance().getCurrentUser() == null){
            finish();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
        BlogApp.userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        BlogApp.userEmailID = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nameDatabase = FirebaseDatabase.getInstance().getReference();
        nameDatabase.child("User").child(BlogApp.userID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                BlogApp.username = dataSnapshot.getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this,"SOMETHINS WRONG",Toast.LENGTH_SHORT).show();
            }
        });
        rv=findViewById(R.id.blog_recycler_view);


        nameDatabase.child("Blogs").addValueEventListener(new ValueEventListener() {
                                                              @Override
                                                              public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                  ArrayList<BlogCardModel> blogCardModels = new ArrayList<>();
                                                                  for (DataSnapshot noteSnapshot : dataSnapshot.getChildren()) {
                                                                      String title = noteSnapshot.child("title").getValue().toString();
                                                                      String body = noteSnapshot.child("body").getValue().toString();
                                                                      String image = noteSnapshot.child("image").getValue().toString();
                                                                      String likes = noteSnapshot.child("likes").getValue().toString();
                                                                      blogCardModels.add(new BlogCardModel(title, body, image, Integer.parseInt(likes)));
                                                                  }
                                                                  Log.e("Debug", "Done with data");

                                                                  BlogCardAdapter blogAdapter = new BlogCardAdapter(blogCardModels);
                                                                  BlogCardAdapter blogCardAdapter1 = new BlogCardAdapter(new ArrayList<BlogCardModel>());
                                                                  rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                                                                  rv.setAdapter(blogCardAdapter1);
                                                                  rv.setAdapter(blogAdapter);

                                                              }

                                                              @Override
                                                              public void onCancelled(@NonNull DatabaseError databaseError) {
                                                                  Toast.makeText(MainActivity.this, "Nuable to load Text", Toast.LENGTH_SHORT).show();
                                                              }
                                                          })
;
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CreateBlogActivity.class));
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
//        TextView tv = navigationView.findViewById(R.id.header_main_username);
//        tv.setText(BlogApp.username);
//        TextView email = navigationView.findViewById(R.id.header_main_email);
//        email.setText(BlogApp.userEmailID);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
