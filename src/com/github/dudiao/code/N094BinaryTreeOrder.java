package com.github.dudiao.code;

import com.github.dudiao.code.entity.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树遍历：94,144,145
 *
 * @author songyinyin
 * @since 2021/10/28 17:57
 */
public class N094BinaryTreeOrder {

    public static void main(String[] args) {
        BinaryTreeNode left = new BinaryTreeNode(2);
        BinaryTreeNode right = new BinaryTreeNode(3);
        BinaryTreeNode root = new BinaryTreeNode(1, left, right);
       inorderTraversal(root);
    }


    public static List<Integer> inorderTraversal(BinaryTreeNode root) {
        /**
         *      1
         *   2     3
         */
        List<Integer> res = new ArrayList<>();
        // [2, 1, 3]
        inorder(root, res);
        System.out.println("中序遍历：" + res);
        res.clear();

        // [1, 2, 3]
        preorder(root, res);
        System.out.println("前序遍历：" + res);
        res.clear();

        // [2, 3, 1]
        postorder(root, res);
        System.out.println("后序遍历：" + res);
        res.clear();
        return res;
    }

    /**
     * 中序遍历：按照访问左子树——>根节点——>右子树的方式遍历这棵树，而在访问左子树或者右子树的时候我们按照同样的方式遍历，直到遍历完整棵树。
     *
     * @param root
     * @return
     */
    private static void inorder(BinaryTreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    /**
     * 前序遍历：按照访问根节点——>左子树——>右子树的方式遍历这棵树，而在访问左子树或者右子树的时候，我们按照同样的方式遍历，直到遍历完整棵树。
     *
     * @param root
     * @return
     */
    private static void preorder(BinaryTreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    /**
     * 后序遍历：按照访问左子树——>右子树——>根节点的方式遍历这棵树，而在访问左子树或者右子树的时候，我们按照同样的方式遍历，直到遍历完整棵树。
     *
     * @param root
     * @return
     */
    private static void postorder(BinaryTreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
}
