package com.example;

import java.util.ArrayList;
import java.util.List;

public class BTPostOrder<T> {

    public void walk(TreeNode<T> root, List<T> data) {
        if (null == root)
            return;
        walk(root.left, data);
        walk(root.right, data);
        data.add(root.val);
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
