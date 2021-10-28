package com.github.dudiao.code.entity;

/**
 * 二叉树
 *
 * @author songyinyin
 * @since 2021/10/28 17:58
 */
public class BinaryTreeNode {

    public int val;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int val) {
        this.val = val;
    }

    public BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
