package com.yeay.design.iterator.exam.inter.impl;

import com.yeay.design.iterator.exam.Book;
import com.yeay.design.iterator.exam.inter.Iterator;

public class BookListShelfIterator implements Iterator {

    BookListShelf bookListShelf;

    int index;

    public BookListShelfIterator(BookListShelf bookListShelf) {
        this.bookListShelf = bookListShelf;
        index = 0;
    }


    @Override
    public boolean hasNext() {
        if (index < bookListShelf.getLength()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Object next() {
        Book book = bookListShelf.getBookAt(index);
        index ++;
        return book;
    }
}
