package com.example;

import java.util.ArrayList;
import java.util.List;

public class BTInOrder<T> {

    public void walk(TreeNode<T> root, List<T> data) {
        if (null == root)
            return;
        walk(root.left, data);
        data.add(root.val);
        walk(root.right, data);
    }

    public List<T> walk(TreeNode<T> root) {
        List<T> data = new ArrayList<>();
        walk(root, data);
        return data;
    }

    public void print(List<T> data) {
        for (T o : data) {
            System.out.println(o);
        }
    }
}
