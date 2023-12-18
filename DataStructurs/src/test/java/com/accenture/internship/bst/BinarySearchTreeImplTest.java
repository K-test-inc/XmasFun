package com.accenture.internship.bst;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeImplTest {

    @Test
    void testInsert_emptyTree() {

        Node<Integer, Integer> node = new Node<>(10, 10);
        BinarySearchTree expectedTree = new BinarySearchTreeImpl(node);

        BinarySearchTree tree = new BinarySearchTreeImpl();
        tree.insert(10, 10);

        assertEquals(expectedTree, tree);
    }

    @Test
    void testInsert_addSecondElementToLeft() {

        Node<Integer, Integer> node = new Node<>(10, 10);
        Node<Integer, Integer> nodeLeft = new Node<>(5, 5);
        node.setLeft(nodeLeft);
        BinarySearchTree expectedTree = new BinarySearchTreeImpl(node);

        BinarySearchTree tree = new BinarySearchTreeImpl();
        tree.insert(10, 10);
        tree.insert(5, 5);

        assertEquals(expectedTree, tree);
    }

    @Test
    void testInsert_addSecondElementToRight() {

        Node<Integer, Integer> node = new Node<>(10, 10);
        Node<Integer, Integer> nodeRight = new Node<>(15, 15);
        node.setRight(nodeRight);
        BinarySearchTree expectedTree = new BinarySearchTreeImpl(node);

        BinarySearchTree tree = new BinarySearchTreeImpl();
        tree.insert(10, 10);
        tree.insert(15, 15);

        assertEquals(expectedTree, tree);
    }

    @Test
    void testInsert_addElementToRightAndToLeft(){
        Node<Integer, Integer> node = new Node<>(10, 10);
        Node<Integer, Integer> nodeRight = new Node<>(15, 15);
        Node<Integer, Integer> nodeLeft = new Node<>(5, 5);
        node.setLeft(nodeLeft);
        node.setRight(nodeRight);
        BinarySearchTreeImpl expectedTree = new BinarySearchTreeImpl(node);

        BinarySearchTreeImpl tree = new BinarySearchTreeImpl();
        tree.insert(10, 10);
        tree.insert(15, 15);
        tree.insert(5, 5);

        assertEquals(expectedTree, tree);
        assertEquals(nodeLeft, tree.getRoot().getLeft());
        assertEquals(nodeRight, tree.getRoot().getRight());
        assertNull(tree.getRoot().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getRight());
        assertNull(tree.getRoot().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight());
    }

    @Test
    void testInsert_addElementToRightAndToLeft_Strings(){
        Node<String, String > node = new Node<>("6test", "6test");
        Node<String, String> nodeRight = new Node<>("7test", "7test");
        Node<String, String> nodeLeft = new Node<>("5test", "5test");
        node.setLeft(nodeLeft);
        node.setRight(nodeRight);
        BinarySearchTreeImpl expectedTree = new BinarySearchTreeImpl(node);

        BinarySearchTreeImpl tree = new BinarySearchTreeImpl();
        tree.insert("6test", "6test");
        tree.insert("7test", "7test");
        tree.insert("5test", "5test");

        assertEquals(expectedTree, tree);
    }

    @Test
    void testGetTopElement_emptyTree(){
        BinarySearchTree tree = new BinarySearchTreeImpl();

        assertNull(tree.getTopElement());
    }

    @Test
    void testGetTopElement_oneElementInTree(){
        BinarySearchTree tree = new BinarySearchTreeImpl();
        tree.insert(10, 10);
        Integer topElement = (Integer) tree.getTopElement();
        assertEquals(10, topElement);
    }

    @Test
    void testInsert_addTwoSameElementToLeft(){

        Node<Integer, Integer> expectedNode = new Node<>(10, 10);
        Node<Integer, Integer> nodeLeft = new Node<>(5, 5);
        expectedNode.setLeft(nodeLeft);
        BinarySearchTreeImpl expectedTree = new BinarySearchTreeImpl(expectedNode);

        BinarySearchTreeImpl tree = new BinarySearchTreeImpl();
        tree.insert(10, 10);
        tree.insert(5, 5);
        tree.insert(5, 5);

        assertEquals(expectedTree, tree);
        assertEquals(nodeLeft, tree.getRoot().getLeft());
        assertNull(tree.getRoot().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getRight());

    }

    @Test
    void testInsert_addTwoSameElementToRight(){

        Node<Integer, Integer> expectedNode = new Node<>(10, 10);
        Node<Integer, Integer> expectedNodeRight = new Node<>(15, 15);
        expectedNode.setRight(expectedNodeRight);
        BinarySearchTreeImpl expectedTree = new BinarySearchTreeImpl(expectedNode);

        BinarySearchTreeImpl tree = new BinarySearchTreeImpl();
        tree.insert(10, 10);
        tree.insert(15, 15);
        tree.insert(15, 15);

        assertEquals(expectedTree, tree);
        assertEquals(expectedNodeRight, tree.getRoot().getRight());
        assertNull(tree.getRoot().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight());
    }

    @Test
    void testInsert_addNewElementWithExistsKeyToLeft(){

        Node<Integer, Integer> expectedNode = new Node<>(10, 10);
        Node<Integer, Integer> expectedNodeLeft = new Node<>(5, 50);
        expectedNode.setLeft(expectedNodeLeft);
        BinarySearchTreeImpl expectedTree = new BinarySearchTreeImpl(expectedNode);

        BinarySearchTreeImpl tree = new BinarySearchTreeImpl();
        tree.insert(10, 10);
        tree.insert(5, 5);
        tree.insert(5, 50);


        assertEquals(expectedNodeLeft, tree.getRoot().getLeft());
        assertNull(tree.getRoot().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getRight());
        assertEquals(expectedTree, tree);
    }

    @Test
    void testInsert_addNewElementWithExistsKeyToRight(){

        Node<Integer, Integer> expectedNode = new Node<>(10, 10);
        Node<Integer, Integer> expectedNodeRight = new Node<>(15, 150);
        expectedNode.setRight(expectedNodeRight);
        BinarySearchTreeImpl expectedTree = new BinarySearchTreeImpl(expectedNode);

        BinarySearchTreeImpl tree = new BinarySearchTreeImpl();
        tree.insert(10, 10);
        tree.insert(15, 15);
        tree.insert(15, 150);

        assertEquals(expectedTree, tree);
        assertEquals(expectedNodeRight, tree.getRoot().getRight());
        assertNull(tree.getRoot().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight());
    }

    @Test
    void testInsert_addToLeftRightLeft(){

        Node<Integer, Integer> expectedNode = new Node<>(10, 10);
        Node<Integer, Integer> expectedNodeRight = new Node<>(15, 15);
        Node<Integer, Integer> expectedNodeLeft = new Node<>(5, 5);
        Node<Integer, Integer> expectedNodeLeft2 = new Node<>(7, 7);
        expectedNodeLeft.setRight(expectedNodeLeft2);
        expectedNode.setRight(expectedNodeRight);
        expectedNode.setLeft(expectedNodeLeft);
        BinarySearchTreeImpl expectedTree = new BinarySearchTreeImpl(expectedNode);

        BinarySearchTreeImpl tree = new BinarySearchTreeImpl();
        tree.insert(10, 10);
        tree.insert(5, 5);
        tree.insert(15, 15);
        tree.insert(7, 7);

        assertEquals(expectedTree, tree);
        assertEquals(expectedNode, tree.getRoot());
        assertEquals(expectedNodeLeft, tree.getRoot().getLeft());
        assertEquals(expectedNodeRight, tree.getRoot().getRight());

    }

    @Test
    void testInsert_addThreeLevelsLeft(){

/*
                10
               /  \
              5    15
             / \
            2   7
           / \   \
          1   3   8
*/

        Node<Integer, Integer> expectedNode = new Node<>(10, 10);
        Node<Integer, Integer> expectedNode15 = new Node<>(15, 15);
        Node<Integer, Integer> expectedNode5 = new Node<>(5, 5);
        Node<Integer, Integer> expectedNode2 = new Node<>(2, 2);
        Node<Integer, Integer> expectedNode7 = new Node<>(7, 7);
        Node<Integer, Integer> expectedNode1 = new Node<>(1, 1);
        Node<Integer, Integer> expectedNode3 = new Node<>(3, 3);
        Node<Integer, Integer> expectedNode8 = new Node<>(8, 8);

        expectedNode.setLeft(expectedNode5);
        expectedNode.setRight(expectedNode15);
        expectedNode5.setLeft(expectedNode2);
        expectedNode5.setRight(expectedNode7);
        expectedNode2.setLeft(expectedNode1);
        expectedNode2.setRight(expectedNode3);
        expectedNode7.setRight(expectedNode8);
        BinarySearchTreeImpl expectedTree = new BinarySearchTreeImpl(expectedNode);

        BinarySearchTreeImpl tree = new BinarySearchTreeImpl();
        tree.insert(10, 10);
        tree.insert(5, 5);
        tree.insert(15, 15);
        tree.insert(7, 7);
        tree.insert(8, 8);
        tree.insert(2, 2);
        tree.insert(1, 1);
        tree.insert(3, 3);

        Node resultingNode = tree.getRoot();
        Node resultingNode15 = resultingNode.getRight();
        Node resultingNode5 = resultingNode.getLeft();
        Node resultingNode2 = resultingNode5.getLeft();
        Node resultingNode7 = resultingNode5.getRight();
        Node resultingNode8 = resultingNode7.getRight();
        Node resultingNode1 = resultingNode2.getLeft();
        Node resultingNode3 = resultingNode2.getRight();

        assertEquals(expectedTree, tree);
        assertEquals(expectedNode, resultingNode);
        assertEquals(expectedNode1, resultingNode1);
        assertEquals(expectedNode2, resultingNode2);
        assertEquals(expectedNode3, resultingNode3);
        assertEquals(expectedNode5, resultingNode5);
        assertEquals(expectedNode7, resultingNode7);
        assertEquals(expectedNode8, resultingNode8);
        assertEquals(expectedNode15, resultingNode15);


    }

    @Test
    void testInsert_addFourLevelsRight() {

/*
                10
                  \
                   15
                   / \
                 12   25
                /    / \
               11   20 28
                   /
                  16
*/
        Node<Integer, Integer> expectedNode = new Node<>(10, 10);
        Node<Integer, Integer> expectedNode15 = new Node<>(15, 15);
        Node<Integer, Integer> expectedNode12 = new Node<>(12, 12);
        Node<Integer, Integer> expectedNode25 = new Node<>(25, 25);
        Node<Integer, Integer> expectedNode11 = new Node<>(11, 11);
        Node<Integer, Integer> expectedNode20 = new Node<>(20, 20);
        Node<Integer, Integer> expectedNode28 = new Node<>(28, 28);
        Node<Integer, Integer> expectedNode16 = new Node<>(16, 16);

        expectedNode.setRight(expectedNode15);
        expectedNode15.setLeft(expectedNode12);
        expectedNode12.setLeft(expectedNode11);
        expectedNode15.setRight(expectedNode25);
        expectedNode25.setRight(expectedNode28);
        expectedNode25.setLeft(expectedNode20);
        expectedNode20.setLeft(expectedNode16);
        BinarySearchTreeImpl expectedTree = new BinarySearchTreeImpl(expectedNode);

        BinarySearchTreeImpl tree = new BinarySearchTreeImpl();
        tree.insert(10,10);
        tree.insert(15,15);
        tree.insert(15,15);
        tree.insert(12,12);
        tree.insert(11,11);
        tree.insert(25,25);
        tree.insert(28,28);
        tree.insert(20,20);
        tree.insert(16,16);

        Node resultingNode = tree.getRoot();
        Node resultingNode15 = resultingNode.getRight();
        Node resultingNode12 = resultingNode15.getLeft();
        Node resultingNode11 = resultingNode12.getLeft();
        Node resultingNode25 = resultingNode15.getRight();
        Node resultingNode28 = resultingNode25.getRight();
        Node resultingNode20 = resultingNode25.getLeft();
        Node resultingNode16 = resultingNode20.getLeft();

        assertEquals(expectedTree, tree);
        assertEquals(expectedNode, resultingNode);
        assertEquals(expectedNode11, resultingNode11);
        assertEquals(expectedNode12, resultingNode12);
        assertEquals(expectedNode15, resultingNode15);
        assertEquals(expectedNode16, resultingNode16);
        assertEquals(expectedNode20, resultingNode20);
        assertEquals(expectedNode25, resultingNode25);
        assertEquals(expectedNode28, resultingNode28);


    }

}