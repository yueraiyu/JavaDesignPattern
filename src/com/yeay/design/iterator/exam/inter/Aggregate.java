package com.yeay.design.iterator.exam.inter;

/**
 * 集合接口
 *
 * 定义创建迭代器的接口
 */
public interface Aggregate {
    /**
     * 生成用于遍历集合的迭代器
     * @return
     */
     Iterator iterator();
}
