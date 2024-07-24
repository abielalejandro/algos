package com.example;

import java.util.LinkedList;
import java.util.Queue;

public class InverseBt<T> {

    public TreeNode<T> buildInvertTree(T[] input) {
        if (null == input || input.length == 0)
            return null;

        Queue<TreeNode<T>> q = new LinkedList<>();
        TreeNode<T> tree = new TreeNode<T>(input[0]);
        q.add(tree);
        for (int i = 1; i < input.length; i += 2) {
            TreeNode<T> current = q.remove();
            current.right= new TreeNode<T>(input[i]);
            q.add(current.right);

            current.left= new TreeNode<T>(input[i+1]);
            q.add(current.left);
        }

        return tree;
    }

    public TreeNode<T> buildInvertTree(TreeNode<T> root) {
        if (root == null)
            return null;

        TreeNode<T> n = new TreeNode<T>(root.val);
        n.right = buildInvertTree(root.left);
        n.left = buildInvertTree(root.right);

        return n;
    }


    public TreeNode<T> buildTree(T[] input) {
        if (null == input || input.length == 0)
            return null;
        Queue<TreeNode<T>> q = new LinkedList<>();
        TreeNode<T> tree = new TreeNode<T>(input[0]);
        q.add(tree);
        for (int i = 1; i < input.length; i += 2) {
            TreeNode<T> current = q.remove();
            current.left= new TreeNode<T>(input[i]);
            q.add(current.left);

            current.right = new TreeNode<T>(input[i + 1]);
            q.add(current.right);
        }

        return tree;

    }
    
    public void print(TreeNode<T> n) {
        if (n == null)
            return;
        System.out.println(n);
        print(n.left);
        print(n.right);
    }

}
