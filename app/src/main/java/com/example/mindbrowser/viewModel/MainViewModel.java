package com.example.mindbrowser.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mindbrowser.model.roomdatabase.ContactDetails;
import com.example.mindbrowser.model.roomdatabase.ContactDetailsRepository;

public class MainViewModel extends AndroidViewModel {

    private ContactDetailsRepository userDetailsRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        userDetailsRepository = new ContactDetailsRepository(application);
    }

    public void insert(ContactDetails contactDetails) {
        userDetailsRepository.insert(contactDetails);
    }

}
