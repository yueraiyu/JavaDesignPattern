package com.yeay.design.iterator.exam.inter.impl;

import com.yeay.design.iterator.exam.Book;
import com.yeay.design.iterator.exam.inter.Aggregate;
import com.yeay.design.iterator.exam.inter.Iterator;

public class BookShelf implements Aggregate{
    private Book[] books;

    private int last = 0;

    public BookShelf(int maxSize){
        this.books = new Book[maxSize];
    }

    public Book getBookAt(int index){
        return books[index];
    }

    public void appendBook(Book book){
        this.books[last] = book;
        last ++;
    }

    public int getLength(){
        return last;
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
