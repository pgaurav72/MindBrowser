package com.example.mindbrowser.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mindbrowser.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "main_activity";
    private ActivityMainBinding mainBinding;
    private Button contactsButton, favouritesButton, deletedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);

        contactsButton = mainBinding.contactsButton;
        favouritesButton = mainBinding.favouritesButton;
        deletedButton = mainBinding.deletedButton;

        contactsButton.setOnClickListener(this);
        favouritesButton.setOnClickListener(this);
        deletedButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == contactsButton){
            Log.d(TAG, "Contacts Button Clicked! ");

        }else if (v == favouritesButton){
            Log.d(TAG, "Favourites Button Clicked! ");

        }else if (v == deletedButton){
            Log.d(TAG, "Deleted Button Clicked! ");

        }

    }
}