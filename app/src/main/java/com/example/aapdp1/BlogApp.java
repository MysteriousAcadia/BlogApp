package com.example.aapdp1;
import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class BlogApp extends Application {
    public static String username;
    public static String userID;

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(getApplicationContext());

    }
}
