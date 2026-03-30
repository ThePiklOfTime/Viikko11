package com.example.Viikko11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddContactActivity extends AppCompatActivity {
    EditText firstName, lastName, number;
    RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_contact);

        firstName = findViewById(R.id.FirstNameEdit);
        lastName = findViewById(R.id.LastNameEdit);
        number = findViewById(R.id.PhoneNumberEdit);
        group = findViewById(R.id.ContactTypeRadioGroup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.SortAlphabeticallyButton), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }
    public void addContact(View view) {
        String first = firstName.getText().toString();
        String last  = lastName.getText().toString();
        String nm = lastName.getText().toString();
        int groupId = group.getCheckedRadioButtonId();
        Contact contact;
        if (groupId == R.id.PersonalRadioButton){
            contact = new Contact(first, last, nm, "Henkilökohtainen");
        } else {
            contact = new Contact(first, last, nm, "Työt");
        }
        ContactStorage.getInstance().addContact(contact);
    }
    public void back(View view ) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}