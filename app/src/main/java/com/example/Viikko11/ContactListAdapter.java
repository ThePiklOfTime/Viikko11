package com.example.Viikko11;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactListAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private Context context;
    private ArrayList<Contact> contacts;
    public ContactListAdapter(Context context, ArrayList<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContactViewHolder(LayoutInflater.from(context).inflate(R.layout.contact_view_holder, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        String fullName = contacts.get(position).getFirstName() + " " +  contacts.get(position).getLastName();
        Log.d("Lol", fullName);
        holder.name.setText(fullName);
        holder.number.setText(contacts.get(position).getNumber());
        holder.group.setText(contacts.get(position).getContactGroup());


    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
