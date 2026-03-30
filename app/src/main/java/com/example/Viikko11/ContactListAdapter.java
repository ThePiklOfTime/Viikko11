package com.example.Viikko11;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

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
        holder.delete.setOnClickListener(view -> {
            int pos = holder.getAbsoluteAdapterPosition();
            ContactStorage.getInstance().removeContact(pos);
            notifyItemRemoved(pos);

        });
        holder.info.setOnClickListener(view -> {
            if (holder.number.getVisibility() == View.GONE) {
                holder.number.setVisibility(View.VISIBLE);
                holder.group.setVisibility(View.VISIBLE);

            }else {
                holder.number.setVisibility(View.GONE);
                holder.group.setVisibility(View.GONE);
            }
        });


    }
    public void sortByGroup() {
        ArrayList<Contact> firstGroup = new ArrayList<>();
        ArrayList<Contact> secondGroup = new ArrayList<>();

        Iterator<Contact> iterator = contacts.iterator();

        while (iterator.hasNext()) {
            Contact current = iterator.next();

            if (current.getContactGroup().equals("Henkilökohtainen")) {
                firstGroup.add(current);
            } else {
                secondGroup.add(current);
            }
        }


        contacts.clear();
        contacts.addAll(firstGroup);
        contacts.addAll(secondGroup);
        notifyDataSetChanged();
    }
    public void sortByAlphabet() {
        ArrayList<Contact> sorted = new ArrayList<>();
        Iterator<Contact> iterator = contacts.iterator();

        while (iterator.hasNext()) {
            Contact current = iterator.next();
            ListIterator<Contact> listIterator = sorted.listIterator();
            boolean inserted = false;

            while (listIterator.hasNext()) {
                Contact existing = listIterator.next();

                if (current.getFirstName().compareTo(existing.getFirstName()) < 0) {
                    listIterator.previous();
                    listIterator.add(current);
                    inserted = true;
                    break;
                }
            }

            if (!inserted) {
                sorted.add(current);
            }
        }

        contacts.clear();
        contacts.addAll(sorted);
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
