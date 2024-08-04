package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CheckBstTest {

    static CheckBst svc;

    @BeforeAll
    public static void beforeAll() {
        svc = new CheckBst();
    }

    @Test
    public void testOk() throws Exception {

        TreeNode<Integer> root = new TreeNode<Integer>(10);
        root.left = new TreeNode<Integer>(8);
        root.right = new TreeNode<Integer>(15);

        root.left.left = new TreeNode<Integer>(7);
        root.left.right = new TreeNode<Integer>(9);

        root.right.left = new TreeNode<Integer>(14);
        root.right.right = new TreeNode<Integer>(20);

        assertEquals(svc.isValid(root), true);
    }

}
