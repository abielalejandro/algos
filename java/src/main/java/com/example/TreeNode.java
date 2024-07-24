package com.example;

public class TreeNode<T> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode() {
    }

    public TreeNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = left;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        if (null != this.left) {
            builder.append(this.left.val.toString());
        }
        builder.append(",");
        builder.append(this.val.toString());
        builder.append(",");
        if (null != this.right) {
            builder.append(this.right.val);
        }
        builder.append("]");
        return builder.toString();
    }
}
