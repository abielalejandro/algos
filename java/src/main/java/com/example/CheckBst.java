package com.example;

public class CheckBst {
    private boolean isValid(TreeNode<Integer> node, int min, int max) {
        if (node == null)
            return true;
        if (node.val > max || node.val < min) {
            return false;
        }
        return isValid(node.left, min, node.val - 1) && isValid(node.right, node.val + 1, max);
    }

    public boolean isValid(TreeNode<Integer> node) {
        return isValid(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
