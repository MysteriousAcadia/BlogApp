package com.example.aapdp1;
import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class BlogApp extends Application {
    public static String username;
    public static String userID;
    public static String userEmailID;

    @Override
    public void onCreate() {
        username = "Test username";
        userID = "Test userID";
        Fresco.initialize(this);
        super.onCreate();
        FirebaseApp.initializeApp(getApplicationContext());

    }
}
