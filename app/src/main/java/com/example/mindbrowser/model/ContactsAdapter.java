package com.example.mindbrowser.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.mindbrowser.R;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {

    public static final String TAG = "contacts_adapter";
    private Context mContext;
    private ArrayList<ContactModel> mContactsArrayList;

    public ContactsAdapter(Context context, ArrayList<ContactModel> contactsArrayList){
        this.mContext = context;
        this.mContactsArrayList = contactsArrayList;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.contacts_layout, parent, false);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapter.ContactsViewHolder holder, int position) {
        ContactModel contactModel =
                mContactsArrayList.get(position);

        holder.contactNameTextView.setText(contactModel.getName());
        holder.contactNumberTextView.setText(contactModel.getMobileNumber());
        Glide
                .with(mContext)
                .load(contactModel.photoURI)
                .addListener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        Log.d(TAG, "onLoadFailed: ");
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        Log.d(TAG, "onResourceReady: ");
                        return false;
                    }
                })
                .into(holder.userImageView);

    }

    @Override
    public int getItemCount() {
        return mContactsArrayList.size();
    }

    public static class ContactsViewHolder extends RecyclerView.ViewHolder {

        public ImageView userImageView, favouriteImageView, deleteImageView;
        public TextView contactNameTextView;
        public TextView contactNumberTextView;

        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);

            userImageView = itemView.findViewById(R.id.user_image_view);
            favouriteImageView = itemView.findViewById(R.id.add_remove_favourite_contact_image_view);
            deleteImageView = itemView.findViewById(R.id.delete_contact_image_view);
            contactNameTextView = itemView.findViewById(R.id.contact_name_text_view);
            contactNumberTextView = itemView.findViewById(R.id.contact_number_text_view);

        }

    }

}
