package com.example.Viikko11;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    TextView name, number, group;
    ImageView info, delete;
    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.ContactNameText);
        number = itemView.findViewById(R.id.ContactNumberText);
        group = itemView.findViewById(R.id.ContactGroupText);
        info = itemView.findViewById(R.id.ContactDetailsButton);
        delete = itemView.findViewById(R.id.ContactDeleteButton);


    }
}
