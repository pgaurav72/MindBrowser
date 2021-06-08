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
import com.example.mindbrowser.model.roomdatabase.ContactDetails;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter {

    public static final String TAG = "contacts_adapter";
    private Context mContext;
    private ArrayList<ContactModel> mContactsArrayList;
    private static final int CONTACTS_LAYOUT= 1;
    private static final int FAVOURITES_LAYOUT= 2;

    public ContactsAdapter(Context context, ArrayList<ContactModel> contactsArrayList){
        this.mContext = context;
        this.mContactsArrayList = contactsArrayList;
    }

    @Override
    public int getItemCount() {
        return mContactsArrayList.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder viewHolder;

        switch (viewType){
            case CONTACTS_LAYOUT:
                view = LayoutInflater.from(mContext).inflate(R.layout.contacts_layout, parent, false);
                viewHolder =  new ContactsViewHolder(view);
                break;
            case FAVOURITES_LAYOUT:
                view = LayoutInflater.from(mContext).inflate(R.layout.contacts_layout, parent, false);
                viewHolder =  new FavouritesViewHoler(view);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + viewType);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (holder.getItemViewType()) {
            case CONTACTS_LAYOUT:
                ContactsViewHolder contactsViewHolder = (ContactsViewHolder) holder;
                ContactModel contactModel =
                        mContactsArrayList.get(position);

                contactsViewHolder.contactNameTextView.setText(contactModel.getName());
                contactsViewHolder.contactNumberTextView.setText(contactModel.getMobileNumber());
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
                        .into(contactsViewHolder.userImageView);

                contactsViewHolder.favouriteImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                contactsViewHolder.deleteImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        
                    }
                });

                break;

            case FAVOURITES_LAYOUT:
                FavouritesViewHoler favouritesViewHoler = (FavouritesViewHoler) holder;
                ContactModel contactModel1 =
                        mContactsArrayList.get(position);

                favouritesViewHoler.contactNameTextView.setText(contactModel1.getName());
                favouritesViewHoler.contactNumberTextView.setText(contactModel1.getMobileNumber());
                Glide
                        .with(mContext)
                        .load(contactModel1.photoURI)
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
                        .into(favouritesViewHoler.userImageView);
                break;

        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0)
            return CONTACTS_LAYOUT;
        else
            return FAVOURITES_LAYOUT;
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

    public static class FavouritesViewHoler extends RecyclerView.ViewHolder {

        public ImageView userImageView, favouriteImageView, deleteImageView;
        public TextView contactNameTextView;
        public TextView contactNumberTextView;

        public FavouritesViewHoler(@NonNull View itemView) {
            super(itemView);

            userImageView = itemView.findViewById(R.id.user_image_view);
            favouriteImageView = itemView.findViewById(R.id.add_remove_favourite_contact_image_view);
            deleteImageView = itemView.findViewById(R.id.delete_contact_image_view);
            contactNameTextView = itemView.findViewById(R.id.contact_name_text_view);
            contactNumberTextView = itemView.findViewById(R.id.contact_number_text_view);

        }
    }

}
