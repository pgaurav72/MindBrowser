package com.example.mindbrowser.model.roomdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface ContactsDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void Insert(ContactDetails contactDetails);

    @Query("SELECT * FROM contact_details")
    LiveData<ContactDetails> getContactDetails();

}
