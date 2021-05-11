package com.kimi.others.bst;

/**
 * Copyright (c) 2021. All Rights Reserved
 *
 * @author Feng Yalong
 * @date 2021/5/11 11:53
 */
public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            return insertIntoBST(root.left, val);
        } else if (root.val < val) {
            return insertIntoBST(root.right, val);
        } else {
            // do nothing
        }
        return root;
    }
}
