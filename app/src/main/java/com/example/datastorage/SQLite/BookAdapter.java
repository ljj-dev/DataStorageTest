package com.example.datastorage.SQLite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.datastorage.R;

import java.util.List;

public class BookAdapter extends BaseAdapter {
    private List<Book> books;
    private Context context;
    public BookAdapter(Context context, List<Book> books){
        super();
        this.context = context;
        this.books = books;
    }

    @Override
    public int getCount(){
        return books.size();
    }

    @Override
    public Object getItem(int i){
        return books.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        if(view==null){
            view= LayoutInflater.from(context).inflate(R.layout.book_layout,viewGroup,false);
        }
        TextView bookName= (TextView) view.findViewById(R.id.name);
        TextView bookPrice= (TextView) view.findViewById(R.id.price);
        TextView bookCategory= (TextView) view.findViewById(R.id.category);

        bookName.setText("书名:" + books.get(i).getName());
        bookPrice.setText("价格:" + books.get(i).getPrice());
        bookCategory.setText("书类别:" + books.get(i).getCategory_name());

        return view;
    }
}
