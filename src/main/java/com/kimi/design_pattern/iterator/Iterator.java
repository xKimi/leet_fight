package com.kimi.design_pattern.iterator;

/**
 * Created on 2021/3/10.
 * Copyright xKimi.inc
 *
 * @author Kimi
 */
public interface Iterator {

    /**
     * 是否还有下一个元素
     * @return boolean
     * 主要用于结束循环
     */
    public abstract boolean hasNext();

    public abstract Object next();
}
