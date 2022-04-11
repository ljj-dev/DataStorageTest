package com.example.datastorage.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_BOOK = "create table Book ("
            + "id integer primary key autoincrement, "
            + "author text, "
            + "price real, "
            + "pages integer, "
            + "name text, "
            + "category_id integer)";

    public static final String CREATE_CATEGORY = "create table Category ("
            + "id integer primary key autoincrement, "
            + "category_name text, "
            + "category_code integer)";

    private Context mContext;
    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    public MyDatabaseHelper(Context context) {
        super(context, "Library.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_BOOK);
        sqLiteDatabase.execSQL(CREATE_CATEGORY);
        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Book");
        sqLiteDatabase.execSQL("drop table if exists Category");
        onCreate(sqLiteDatabase);
    }

    public void addBook(Book book){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("category_id", book.getCategory_id());
        values.put("id", book.getId());
        values.put("name", book.getName());
        values.put("author", book.getAuthor());
        values.put("pages", book.getPages());
        values.put("price", book.getPrice());
        db.insert("Book", null, values);
        db.close();
        Toast.makeText(mContext, "Add succeeded", Toast.LENGTH_SHORT).show();
    }

    public void deleteBook(Book book){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Book", "id = ?", new String[]{String.valueOf(book.getId())});
        db.close();
    }

    public int updateBook(Book book){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", book.getName());
        values.put("author", book.getAuthor());
        values.put("pages", book.getPages());
        values.put("price", book.getPrice());
        values.put("category_id", book.getCategory_id());
        return db.update("Book", values, "id = ?", new String[]{String.valueOf(book.getId())});
    }

    public List<Book> getAllBook(){
        List<Book> bookList = new ArrayList<Book>();
        String selectQuery = "select Book.name,Book.price,category_name from Book,Category where Book.category_id=Category.category_code";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do{
                Book book = new Book();
                book.setName(cursor.getString(0));
                book.setPrice(cursor.getString(1));
                book.setCategory_name(cursor.getString(2));
                bookList.add(book);
            }while (cursor.moveToNext());
        }
        return bookList;
    }
}
