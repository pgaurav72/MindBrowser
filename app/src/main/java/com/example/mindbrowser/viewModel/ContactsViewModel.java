package com.example.mindbrowser.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mindbrowser.model.roomdatabase.ContactDetails;
import com.example.mindbrowser.model.roomdatabase.ContactDetailsRepository;

public class ContactsViewModel extends AndroidViewModel {

    private ContactDetailsRepository userDetailsRepository;
    private final LiveData<ContactDetails> contactsLiveData;

    public ContactsViewModel(@NonNull Application application) {
        super(application);
        userDetailsRepository = new ContactDetailsRepository(application);
        contactsLiveData = userDetailsRepository.getContactsDetails();
    }

    public LiveData<ContactDetails> getContactDetails() {
        return contactsLiveData;
    }
}
