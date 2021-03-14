package com.kimi.design_pattern.adapter.factory_method.factory;

/**
 * Created on 2021/3/15.
 * Copyright xKimi.inc
 *
 * @author Kimi
 */
public abstract class Factory {

    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    protected abstract Product createProduct(String owner);

    protected abstract void registerProduct(Product product);
}
