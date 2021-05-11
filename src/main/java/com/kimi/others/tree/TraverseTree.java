package com.kimi.others.tree;

import java.util.List;

/**
 * Copyright (c) 2021. All Rights Reserved
 *
 * @author Feng Yalong
 * @date 2021/5/10 10:53
 */
public class TraverseTree {

    public class TreeNode {
        private TreeNode left;

        private TreeNode right;

        private int val;

        public TreeNode() {}

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 前序遍历
    private void preOrderTraverseTree(TreeNode root, List<Integer> ans) {
        if (root != null) {
            ans.add(root.val);
            preOrderTraverseTree(root.left, ans);
            preOrderTraverseTree(root.right, ans);
        }
    }

    private void afterOrderTraverseTree(TreeNode root, List<Integer> ans) {
        if (root != null) {
            ans.add(root.val);
            afterOrderTraverseTree(root.right, ans);
            afterOrderTraverseTree(root.left, ans);
        }
    }
}
