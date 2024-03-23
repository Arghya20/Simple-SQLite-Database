package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class ViewData extends AppCompatActivity {
    TextView displayData;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        displayData = findViewById(R.id.displayData);
        dbHelper = new DatabaseHelper(ViewData.this);

        Cursor cursor = dbHelper.searchDatabyName("amrit");

        displayData.setText("total data: " + cursor.getCount());

        while (cursor.moveToNext()) {

            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String email = cursor.getString(2);

            displayData.append("\nid: " + id + " name: " + name + " email: " + email + "\n\n");

        }


    }
}