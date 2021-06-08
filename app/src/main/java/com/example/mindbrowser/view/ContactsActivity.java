package com.example.mindbrowser.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mindbrowser.R;
import com.example.mindbrowser.databinding.ActivityContactsBinding;
import com.example.mindbrowser.model.Contacts;
import com.example.mindbrowser.model.ContactsAdapter;

public class ContactsActivity extends AppCompatActivity {

    private static final String TAG = "contacts_activity";
    private RecyclerView contactsRecyclerView;
    private ActivityContactsBinding contactsBinding;
    private Contacts contacts;
    private ContactsAdapter mContactsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "OnCreate Contacts Activity");
        contactsBinding = ActivityContactsBinding.inflate(getLayoutInflater());
        View view = contactsBinding.getRoot();
        setContentView(view);

        contactsRecyclerView = contactsBinding.contactsReclyclerView;
        contactsRecyclerView.setHasFixedSize(true);
        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        contacts = new Contacts();
        mContactsAdapter = new ContactsAdapter(this, contacts.getContacts(this));
        contactsRecyclerView.setAdapter(mContactsAdapter);
        mContactsAdapter.notifyDataSetChanged();

    }
}