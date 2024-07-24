package com.example;

public class SearchInBT {

    private boolean dfs(TreeNode<Integer> node, Integer needle) {
        if (null == node)
            return false;

        if (node.val == needle)
            return true;
        if (node.val < needle)
            return dfs(node.right, needle);
        return dfs(node.left, needle);
    }

    public boolean search(TreeNode<Integer> head, Integer needle) {
        return dfs(head, needle);
    }
}
