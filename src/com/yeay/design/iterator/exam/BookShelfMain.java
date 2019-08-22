package com.yeay.design.iterator.exam;

import com.yeay.design.iterator.exam.inter.Iterator;
import com.yeay.design.iterator.exam.inter.impl.BookListShelf;
import com.yeay.design.iterator.exam.inter.impl.BookShelf;

public class BookShelfMain {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Around the world in 80 days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));

        Iterator iterator = bookShelf.iterator();
        while (iterator.hasNext()){
            Book book = (Book) iterator.next();
            System.out.println(book.getName());
        }

        BookListShelf bookListShelf = new BookListShelf(4);
        bookListShelf.appendBook(new Book("Around the world in 80 days"));
        bookListShelf.appendBook(new Book("Bible"));
        bookListShelf.appendBook(new Book("Cinderella"));
        bookListShelf.appendBook(new Book("Daddy-Long-Legs"));
        bookListShelf.appendBook(new Book("Daddy-Long-Legs(1)"));

        Iterator iterator1 = bookListShelf.iterator();
        while (iterator1.hasNext()){
            Book book = (Book) iterator1.next();
            System.out.println(book.getName());
        }
    }
}
