package com.example.mindbrowser.model.roomdatabase;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
public class ContactDetailsRepository {

    private static final String TAG = "contacts_repository";
    private ContactsDao ContactsDao;
    private LiveData<ContactDetails> ContactsLiveData;

    public ContactDetailsRepository(Application application){
        ContactDetailsDatabase database =
                ContactDetailsDatabase.getDatabase(application);
        ContactsDao = database.userDetailsDao();
        ContactsLiveData = ContactsDao.getContactDetails();
    }

    public LiveData<ContactDetails> getContactsDetails() {
        return ContactsLiveData;
    }

    public void insert(ContactDetails contactDetails) {
        ContactDetailsDatabase.databaseWriteExecutor.execute(() -> {
            Log.d(TAG, "Contacts Repository Insert Data");
            ContactsDao.Insert(contactDetails);
        });
    }


}
