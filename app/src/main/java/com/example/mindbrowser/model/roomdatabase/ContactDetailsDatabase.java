package com.example.mindbrowser.model.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = ContactDetails.class, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class ContactDetailsDatabase extends RoomDatabase {

    private static volatile ContactDetailsDatabase INSTANCE;
    public abstract ContactsDao userDetailsDao();
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ContactDetailsDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ContactDetailsDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ContactDetailsDatabase.class, "user_details")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
