package com.example.mindbrowser.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mindbrowser.databinding.ActivityContactsBinding;
import com.example.mindbrowser.model.Contacts;
import com.example.mindbrowser.model.ContactsAdapter;
import com.example.mindbrowser.model.ContactModel;
import com.example.mindbrowser.model.roomdatabase.ContactDetails;
import com.example.mindbrowser.viewModel.ContactsViewModel;
import com.example.mindbrowser.viewModel.MainViewModel;

public class ContactsActivity extends AppCompatActivity {

    private static final String TAG = "contacts_activity";
    private RecyclerView contactsRecyclerView;
    private ActivityContactsBinding contactsBinding;
    private Contacts contacts;
    private ContactsAdapter mContactsAdapter;
    private ContactModel contactModel = new ContactModel();
    private ContactsViewModel mContactsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "OnCreate Contacts Activity");
        contactsBinding = ActivityContactsBinding.inflate(getLayoutInflater());
        View view = contactsBinding.getRoot();
        setContentView(view);

        mContactsViewModel = new ViewModelProvider(this).get(ContactsViewModel.class);

        contactsRecyclerView = contactsBinding.contactsReclyclerView;
        contactsRecyclerView.setHasFixedSize(true);
        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        getAllContacts();

    }

    private void getAllContacts() {
        mContactsViewModel.getContactDetails().observe(this, contactDetails -> {
            if (contactDetails != null){
                mContactsAdapter = new ContactsAdapter(this, contactDetails.getContactModelArrayList());
                contactsRecyclerView.setAdapter(mContactsAdapter);
                mContactsAdapter.notifyDataSetChanged();
            }
        });
    }


}