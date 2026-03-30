package com.example.Viikko11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private RecyclerView rcv;
    private ContactStorage contactStorage;
    private ContactListAdapter contactListAdapter;
    //Had to ask chatgpt how to show images, becouse they didn't show up.
    // Also it fixed an error for me, when I was inflating the wrong view. It made only a simple line change.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.AddContactActivity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rcv = findViewById(R.id.ListContactsRV);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        contactStorage = ContactStorage.getInstance();
        ArrayList<Contact> contacts = contactStorage.getContacts();
        contactListAdapter = new ContactListAdapter(getApplicationContext(), contacts);
        rcv.setAdapter(contactListAdapter);


    }
    @Override
    protected void onResume() {
        super.onResume();
        contactListAdapter.notifyDataSetChanged();

    }
    public void switchToAddContactActivity(View view) {
        Intent intent = new Intent(this, AddContactActivity.class);
        startActivity(intent);
    }
}