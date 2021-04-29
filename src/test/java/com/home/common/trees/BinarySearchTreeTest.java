package com.home.common.trees;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BinarySearchTreeTest {
    @Test
    public void inOrderTraversal_happyPath() {
        BinarySearchTree tree = new BinarySearchTree();


//        tree.add(5);
//        tree.add(3);
//        tree.add(2);
//        tree.add(4);
//        tree.add(6);
//        tree.add(7);

//        tree.inOrderTraversal();
    }

    @Test
    public void isBSTTest_happyPath() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(5);
        tree.add(3);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(7);

        boolean isBst = tree.isBST(tree.getRoot());

        Assertions.assertThat(isBst).isTrue();
    }
}
