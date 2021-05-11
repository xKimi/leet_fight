package com.kimi.others.bst;

/**
 * Copyright (c) 2021. All Rights Reserved
 *
 * @author Feng Yalong
 * @date 2021/5/11 10:51
 */
public class PlusOne {

    public void plusOne(TreeNode root) {
        if (root == null) {
            return;
        }
        root.val += 1;
        plusOne(root.left);
        plusOne(root.right);
    }
}
