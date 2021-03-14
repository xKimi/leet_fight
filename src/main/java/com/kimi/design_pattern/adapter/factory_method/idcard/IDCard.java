package com.kimi.design_pattern.adapter.factory_method.idcard;

import com.kimi.design_pattern.adapter.factory_method.factory.Product;

/**
 * Created on 2021/3/15.
 * Copyright xKimi.inc
 *
 * @author Kimi
 */
public class IDCard extends Product {

    private String owner;

    IDCard(String owner) {
        System.out.println("制作" + owner + "的ID卡。");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println("使用" + owner + "的卡。");
    }

    public String getOwner() {
        return owner;
    }
}
