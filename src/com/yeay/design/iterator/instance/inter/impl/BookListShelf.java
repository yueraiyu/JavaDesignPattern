package com.yeay.design.iterator.instance.inter.impl;

import com.yeay.design.iterator.instance.Book;
import com.yeay.design.iterator.instance.inter.Aggregate;
import com.yeay.design.iterator.instance.inter.Iterator;

import java.util.ArrayList;
import java.util.List;

public class BookListShelf implements Aggregate {
    private List<Book> books;

    public BookListShelf(int maxSize){
        this.books = new ArrayList<>(maxSize);
    }

    public Book getBookAt(int index){
        return books.get(index);
    }

    public void appendBook(Book book){
        this.books.add(book);
    }

    public int getLength(){
        return books.size();
    }

    @Override
    public Iterator iterator() {
        return new BookListShelfIterator(this);
    }
}
