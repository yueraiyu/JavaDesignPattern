package com.yeay.design.iterator.instance.inter.impl;

import com.yeay.design.iterator.instance.Book;
import com.yeay.design.iterator.instance.inter.Iterator;

/**
 * 具体迭代器，实现迭代器中对所定义的方法
 *
 * 创建具体迭代器
 */
public class BookShelfIterator implements Iterator {
    // 保存集合实例
    private BookShelf bookShelf;
    // 保存当前访问元素下标，判断是否可以访问
    private int index;

    public BookShelfIterator(BookShelf bookShelf){
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if(index < bookShelf.getLength()){
            return true;
        }else {
            return  false;
        }
    }

    @Override
    public Object next() {
        Book book = bookShelf.getBookAt(this.index);
        this.index ++;
        return book;
    }
}
