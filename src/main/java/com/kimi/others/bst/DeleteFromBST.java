package com.kimi.others.bst;

/**
 * Copyright (c) 2021. All Rights Reserved
 *
 * @author Feng Yalong
 * @date 2021/5/11 11:56
 */
public class DeleteFromBST {

    public TreeNode deleteFromBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            // 没有子节点，直接删除
            if (root.left == null && root.right == null) {
                // 可以省略，逻辑覆盖在下面两个if中了
                return null;
            }
            // 左子节点或右子节点为空，返回另一个
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // 有两个子节点，找到左子树中最大的节点或右子树中最小的节点替代自己
            // 找到右子树中最小的节点
            TreeNode minNodeForRightChild = getMinNodeOfRightChild(root.right);
            root.val = minNodeForRightChild.val;
            root.right = deleteFromBST(root.right, minNodeForRightChild.val);
        } else if (root.val > val) {
            root.left = deleteFromBST(root.left, val);
        } else {
            root.right = deleteFromBST(root.right, val);
        }
        return root;
    }

    private TreeNode getMinNodeOfRightChild(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
