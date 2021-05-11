package com.kimi.others.bst;

/**
 * Copyright (c) 2021. All Rights Reserved
 *
 * @author Feng Yalong
 * @date 2021/3/19 14:25
 */
public class BSTDemo {

    public class Node {
        public int key;
        public int val;

        public Node left;
        public Node right;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    // BST通用遍历
    void BST(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        if (root.val == target) {
            // do something here
        }
        if (root.val < target) {
            BST(root.right, target);
        }
        if (root.val > target) {
            BST(root.left, target);
        }
     }

    boolean isValidBST(Node root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    boolean isInBST(Node root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }

        if (root.val > target) {
            return isInBST(root.right, target);
        } else {
            return isInBST(root.left, target);
        }
    }

    void BST(Node root, int target) {
        if (root.val == target) {
            // 找到了目标
        }
        if (root.val < target) {
            BST(root.left, target);
        }
        if (root.val > target) {
            BST(root.right, target);
        }
    }

    Node insertIntoBST(Node root, int val) {
        if (root == null) {
            return new Node(val, val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    Node deleteNode(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            Node minNode = getMinNode(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    private Node getMinNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
