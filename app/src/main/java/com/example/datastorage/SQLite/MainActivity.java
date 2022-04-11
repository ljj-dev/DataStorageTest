package com.example.datastorage.SQLite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.datastorage.R;
import com.example.datastorage.SharedPreferences.LoginActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;
    private BookAdapter adapter;
    private ListView books;
    private Button btnAdd;
    private List<Book> bookList;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        books = (ListView) findViewById(R.id.books_list);

        dbHelper = new MyDatabaseHelper(this);
        //获取全部书本信息
        bookList = dbHelper.getAllBook();
        adapter = new BookAdapter(MainActivity.this, bookList);
        books.setAdapter(adapter);
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddBookActivity.class);
                startActivity(intent);
            }
        });
    }
}