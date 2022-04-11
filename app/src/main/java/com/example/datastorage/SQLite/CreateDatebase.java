package com.example.datastorage.SQLite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.datastorage.R;

public class CreateDatebase extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createdatebase_layout);
        dbHelper = new MyDatabaseHelper(this, "Library.db", null, 2);
        Button createDatabase = (Button) findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.getWritableDatabase();
            }
        });

        Button addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //第一本书
                values.put("category_id", "101");
                values.put("id", "1");
                values.put("name","第一行代码");
                values.put("author","Dan Brown");
                values.put("pages","454");
                values.put("price","$9.99");
                db.insert("Book", null, values);
                values.clear();
                values.put("id", "1");
                values.put("category_name", "计算机科学");
                values.put("category_code", "101");
                db.insert("Category", null, values);
                values.clear();
                //第二本书
                values.put("category_id", "102");
                values.put("id", "2");
                values.put("name","三国演义");
                values.put("author","吴承恩");
                values.put("pages","1000");
                values.put("price","$99.9");
                db.insert("Book", null, values);
                values.clear();
                values.put("id", "2");
                values.put("category_name", "小说");
                values.put("category_code", "102");
                db.insert("Category", null, values);
            }
        });

    }
}