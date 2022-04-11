package com.example.datastorage.SQLite;

public class Book {
    private int id;
    private String name;
    private String author;
    private String price;
    private int pages;
    private int category_id;
    private String category_name;

    public Book() {
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Book(int id, String name, String author, String price, int pages, int category_id, String category_name) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.pages = pages;
        this.category_id = category_id;
        this.category_name = category_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
