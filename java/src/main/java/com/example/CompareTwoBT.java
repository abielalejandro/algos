package com.example;

public class CompareTwoBT<T> {

    private boolean walk(TreeNode<T> a, TreeNode<T> b) {
        if ((null == a && null != b) || (null == b && a != null))
            return false;

        if (null == a && null == b)
            return true;

        return a.val.equals(b.val) && walk(a.left, b.left) && walk(a.right, b.right);
    }

    public boolean compare(TreeNode<T> a, TreeNode<T> b) {
        return walk(a, b);
    }

}
