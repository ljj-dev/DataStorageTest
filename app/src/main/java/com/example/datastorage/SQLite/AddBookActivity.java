package com.example.datastorage.SQLite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.datastorage.R;

public class AddBookActivity extends AppCompatActivity {
    private EditText bookname, bookid, bookprice, bookcategory, bookpages, bookauthor;
    private Button btn_addbook;
    private MyDatabaseHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addbook_layout);

        bookid = (EditText) findViewById(R.id.book_id);
        bookname = (EditText) findViewById(R.id.book_name);
        bookpages = (EditText) findViewById(R.id.book_pages);
        bookprice = (EditText) findViewById(R.id.book_price);
        bookcategory = (EditText) findViewById(R.id.book_category);
        bookauthor = (EditText) findViewById(R.id.book_author);

        btn_addbook = (Button) findViewById(R.id.btn_addBook);
        dbhelper = new MyDatabaseHelper(this);
        btn_addbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bookName = bookname.getText().toString();
                String bookPrice = bookprice.getText().toString();
                String bookAuthor = bookauthor.getText().toString();
                Integer bookId = Integer.valueOf(bookid.getText().toString());
                Integer bookPages = Integer.valueOf((bookpages.getText().toString()));
                Integer bookCategory = Integer.valueOf((bookcategory.getText().toString()));
                Book newbook = new Book(bookId, bookName, bookAuthor, bookPrice, bookPages, bookCategory, null);
                dbhelper.addBook(newbook);
            }
        });
    }
}