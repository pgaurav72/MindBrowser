package com.example.mindbrowser.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.mindbrowser.R;
import com.example.mindbrowser.databinding.ActivityContactsBinding;
import com.example.mindbrowser.databinding.ActivityFavouriteContactsBinding;

public class FavouriteContactsActivity extends AppCompatActivity {

    private ActivityFavouriteContactsBinding favouriteContactsBinding;
    private RecyclerView mContactsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        favouriteContactsBinding = ActivityFavouriteContactsBinding.inflate(getLayoutInflater());
        View view = favouriteContactsBinding.getRoot();
        setContentView(view);

        mContactsRecyclerView = favouriteContactsBinding.favouritesLayout.contactsReclyclerView;
        mContactsRecyclerView.setHasFixedSize(true);
        mContactsRecyclerView.setLayoutManager(new LinearLayoutManager(this));



    }
}