package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;

public class SearchInBTTest {

    static SearchInBT svc;

    @BeforeAll
    public static void beforeAll() {
        svc = new SearchInBT();
    }

    @Test
    public void walkTestFalseByNull() {
        boolean result = svc.search(null, 1);
        boolean expected = false;

        assertEquals(result, expected);
    }

    @Test
    public void walkTestFalseByNo() {
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        boolean result = svc.search(root, 4);
        boolean expected = false;

        assertEquals(result, expected);
    }

    @Test
    public void walkTestTrue() {
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(3);
        root.right.right = new TreeNode<Integer>(4);

        boolean result = svc.search(root, 4);
        boolean expected = true;

        assertEquals(result, expected);
    }

    @Test
    public void walkTest() {
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(3);
        root.right.left = new TreeNode<Integer>(4);

        boolean result = svc.search(root, 18);
        boolean expected = false;

        assertEquals(result, expected);
    }

}
