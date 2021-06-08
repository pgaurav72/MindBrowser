package com.example.mindbrowser.model.roomdatabase;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.mindbrowser.model.ContactModel;

import java.util.ArrayList;

@Entity(tableName = "contact_details")
public class ContactDetails {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public ArrayList<ContactModel> getContactModelArrayList() {
        return contactModelArrayList;
    }

    public void setContactModelArrayList(ArrayList<ContactModel> contactModelArrayList) {
        this.contactModelArrayList = contactModelArrayList;
    }

    @TypeConverters(Converters.class)
    private ArrayList<ContactModel> contactModelArrayList =
            new ArrayList<>();

    public ContactDetails(){}

}
