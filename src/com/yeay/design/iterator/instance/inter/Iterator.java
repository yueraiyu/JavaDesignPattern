package com.yeay.design.iterator.instance.inter;

/**
 * 迭代器接口
 *
 * 定义按顺序逐个遍历元素对接口
 */
public interface Iterator {

    /**
     * 判断是否还有下一个元素
     * @return
     */
    boolean hasNext();

    /**
     * 获取当前元素，并指向下一个元素
     * @return
     */
    Object next();
}
