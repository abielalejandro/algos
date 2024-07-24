package com.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InverseBtTest {

    Integer[] source = new Integer[] { 4, 2, 7, 1, 3, 6, 9 };
    TreeNode<Integer> tree;
    static InverseBt it;

    @BeforeAll
    public static void beforeAll() {
        it = new InverseBt();
    }

    @BeforeEach
    public void beforeEach() {
        tree =it.buildTree(source);
    }

    @Test
    void buildInvertTree() {
        tree = it.buildInvertTree(tree);

        assertEquals(tree.val,source[0]);
        assertEquals(tree.left.val,source[2]);
        assertEquals(tree.right.val,source[1]);

    }

    @Test
    void testBuildInvertTree() {

        tree = it.buildInvertTree(source);

        assertEquals(tree.val,source[0]);
        assertEquals(tree.left.val,source[2]);
        assertEquals(tree.right.val,source[1]);
    }

    @Test
    void buildTree() {
        assertEquals(tree.val,source[0]);
        assertEquals(tree.left.val,source[1]);
        assertEquals(tree.right.val,source[2]);
    }
}