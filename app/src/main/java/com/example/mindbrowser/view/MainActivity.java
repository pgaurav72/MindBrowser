package com.example.mindbrowser.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mindbrowser.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "main_activity";
    private ActivityMainBinding mainBinding;
    private Button contactsButton, favouritesButton, deletedButton;
    public static final int PERMISSION_REQUEST_CODE = 12;

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

        permissionGrantedCheck();

    }

    private void permissionGrantedCheck() {
        Log.d(TAG, "permissionGrantedCheck: ");
        if (
                ContextCompat.checkSelfPermission(this,
                        Manifest.permission.READ_CONTACTS)
                        == PackageManager.PERMISSION_GRANTED
                &&
                        ContextCompat.checkSelfPermission(this,
                                Manifest.permission.WRITE_CONTACTS)
                                == PackageManager.PERMISSION_GRANTED
                &&
                        ContextCompat.checkSelfPermission(this,
                                Manifest.permission.INTERNET)
                                == PackageManager.PERMISSION_GRANTED

        )
        {
            Log.d(TAG, "Permissions Granted!");
        }else {
            Log.d(TAG, "Permissions Not Granted!");
            requestAppPermissions();
        }
    }

    @Override
    public void onClick(View v) {
        if (v == contactsButton){
            Log.d(TAG, "Contacts Button Clicked! ");
            startActivity(new Intent(this, ContactsActivity.class));
        }else if (v == favouritesButton){
            Log.d(TAG, "Favourites Button Clicked! ");

        }else if (v == deletedButton){
            Log.d(TAG, "Deleted Button Clicked! ");

        }

    }

    private void requestAppPermissions() {
        Log.d(TAG, "Request app permissions");
        final String[] REQUIRED_SDK_PERMISSIONS
                = new String[] {
                Manifest.permission.INTERNET,
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.WRITE_CONTACTS
        };
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(REQUIRED_SDK_PERMISSIONS, PERMISSION_REQUEST_CODE);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d(TAG, "onRequestPermissionsResult: ");
        switch (requestCode){
            case PERMISSION_REQUEST_CODE: {
                if (grantResults.length > 0
                        && grantResults[0] != PackageManager.PERMISSION_GRANTED)
                {
                    requestAppPermissions();
                }
                else {
                    Log.d(TAG, "onRequestPermissionsResult Permissions Granted: ");
                }
            }
        }
    }
}