package com.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class BTPreOrderTest {

    static BTPreOrder<Integer> svc;

    @BeforeAll
    public static void beforeAll() {
        svc = new BTPreOrder<Integer>();
    }

    @Test
    public void walkTest() {
        TreeNode<Integer> root = new TreeNode<Integer>(50);
        TreeNode<Integer> n1 = new TreeNode<Integer>(5);
        TreeNode<Integer> n2 = new TreeNode<Integer>(10);
        TreeNode<Integer> n3 = new TreeNode<Integer>(65);
        TreeNode<Integer> n4 = new TreeNode<Integer>(88);
        TreeNode<Integer> n5 = new TreeNode<Integer>(120);
        TreeNode<Integer> n6 = new TreeNode<Integer>(18);
        TreeNode<Integer> n7 = new TreeNode<Integer>(44);

        n2.left = n1;
        n2.right = n6;
        root.left = n2;

        n3.left = n7;
        n4.left = n3;
        n4.right = n5;
        root.right = n4;

        List<Integer> data = svc.walk(root);

        int[] expected = new int[] { 50, 10, 5, 18, 88, 65, 44, 120 };

        for (int i = 0; i < expected.length; i++) {
            assertEquals(data.get(i), expected[i]);
        }
    }
}
