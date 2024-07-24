package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;

public class CompareTwoBTTest {

    static CompareTwoBT<Integer> svc;

    @BeforeAll
    public static void beforeAll() {
        svc = new CompareTwoBT<Integer>();
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

        boolean result = svc.compare(root, root);
        boolean expected = true;

        assertEquals(result, expected);
    }

    @Test
    public void noEqualBTTestOne() {

        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(1);

        TreeNode<Integer> root2 = new TreeNode<Integer>(1);
        root2.left = new TreeNode<Integer>(1);
        root2.right = new TreeNode<Integer>(2);

        boolean result = svc.compare(root, root2);
        boolean expected = false;

        assertEquals(result, expected);

    }

    @Test
    public void noEqualBTTest() {

        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(3);
        root.right.left = new TreeNode<Integer>(4);

        TreeNode<Integer> root2 = new TreeNode<Integer>(1);
        root2.left = new TreeNode<Integer>(5);
        root2.right = new TreeNode<Integer>(3);
        root2.left.left = new TreeNode<Integer>(4);

        boolean result = svc.compare(root, root2);
        boolean expected = false;

        assertEquals(result, expected);

    }
}
