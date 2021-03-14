package com.kimi.design_pattern.adapter.factory_method.idcard;

import com.kimi.design_pattern.adapter.factory_method.factory.Factory;
import com.kimi.design_pattern.adapter.factory_method.factory.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2021/3/15.
 * Copyright xKimi.inc
 *
 * @author Kimi
 */
public class IDCardFactory extends Factory {

    private List<String> owners = new ArrayList<>();

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        owners.add(((IDCard) product).getOwner());
    }

    public List<String> getOwners() {
        return owners;
    }
}
