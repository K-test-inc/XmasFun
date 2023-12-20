package com.accenture.internship.bst;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeImplTest {

    @Test
    void testInsert_emptyTree() {

        Node<Integer, Integer> node = new Node<>(10, 10);
        BinarySearchTree<Integer, Integer> expectedTree = new BinarySearchTreeImpl<>(node);

        BinarySearchTree<Integer, Integer> tree = new BinarySearchTreeImpl<Integer, Integer>();
        tree.insert(10, 10);

        assertEquals(expectedTree, tree);
    }

    @Test
    void testInsert_addSecondElementToLeft() {

        Node<Integer, Integer> node = new Node<>(10, 10);
        Node<Integer, Integer> nodeLeft = new Node<>(5, 5);
        node.setLeft(nodeLeft);
        BinarySearchTree<Integer, Integer> expectedTree = new BinarySearchTreeImpl<>(node);

        BinarySearchTree<Integer, Integer> tree = new BinarySearchTreeImpl<Integer, Integer>();
        tree.insert(10, 10);
        tree.insert(5, 5);

        assertEquals(expectedTree, tree);
    }

    @Test
    void testInsert_addSecondElementToRight() {

        Node<Integer, Integer> node = new Node<>(10, 10);
        Node<Integer, Integer> nodeRight = new Node<>(15, 15);
        node.setRight(nodeRight);
        BinarySearchTree<Integer, Integer> expectedTree = new BinarySearchTreeImpl<>(node);

        BinarySearchTree<Integer, Integer> tree = new BinarySearchTreeImpl<Integer, Integer>();
        tree.insert(10, 10);
        tree.insert(15, 15);

        assertEquals(expectedTree, tree);
    }

    @Test
    void testInsert_addElementToRightAndToLeft() {
        Node<Integer, Integer> node = new Node<>(10, 10);
        Node<Integer, Integer> nodeRight = new Node<>(15, 15);
        Node<Integer, Integer> nodeLeft = new Node<>(5, 5);
        node.setLeft(nodeLeft);
        node.setRight(nodeRight);
        BinarySearchTreeImpl<Integer, Integer> expectedTree = new BinarySearchTreeImpl<>(node);

        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<>();
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
    void testInsert_addElementToRightAndToLeft_Strings() {
        Node<String, String> node = new Node<>("6test", "6test");
        Node<String, String> nodeRight = new Node<>("7test", "7test");
        Node<String, String> nodeLeft = new Node<>("5test", "5test");
        node.setLeft(nodeLeft);
        node.setRight(nodeRight);
        BinarySearchTreeImpl<String, String> expectedTree = new BinarySearchTreeImpl<>(node);

        BinarySearchTreeImpl<String, String> tree = new BinarySearchTreeImpl<>();
        tree.insert("6test", "6test");
        tree.insert("7test", "7test");
        tree.insert("5test", "5test");

        assertEquals(expectedTree, tree);
    }

    @Test
    void testGetTopElement_emptyTree() {
        BinarySearchTree tree = new BinarySearchTreeImpl();

        assertNull(tree.getTopElement());
    }

    @Test
    void testGetTopElement_oneElementInTree() {
        BinarySearchTree<Integer, Integer> tree = new BinarySearchTreeImpl<>();
        tree.insert(10, 10);
        Integer topElement = tree.getTopElement();
        assertEquals(10, topElement);
    }

    @Test
    void testInsert_addTwoSameElementToLeft() {

        Node<Integer, Integer> expectedNode = new Node<>(10, 10);
        Node<Integer, Integer> nodeLeft = new Node<>(5, 5);
        expectedNode.setLeft(nodeLeft);
        BinarySearchTreeImpl<Integer, Integer> expectedTree = new BinarySearchTreeImpl<>(expectedNode);

        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<Integer, Integer>();
        tree.insert(10, 10);
        tree.insert(5, 5);
        tree.insert(5, 5);

        assertEquals(expectedTree, tree);
        assertEquals(nodeLeft, tree.getRoot().getLeft());
        assertNull(tree.getRoot().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getRight());

    }

    @Test
    void testInsert_addTwoSameElementToRight() {

        Node<Integer, Integer> expectedNode = new Node<>(10, 10);
        Node<Integer, Integer> expectedNodeRight = new Node<>(15, 15);
        expectedNode.setRight(expectedNodeRight);
        BinarySearchTreeImpl<Integer, Integer> expectedTree = new BinarySearchTreeImpl<>(expectedNode);

        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<Integer, Integer>();
        tree.insert(10, 10);
        tree.insert(15, 15);
        tree.insert(15, 15);

        assertEquals(expectedTree, tree);
        assertEquals(expectedNodeRight, tree.getRoot().getRight());
        assertNull(tree.getRoot().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight());
    }

    @Test
    void testInsert_addNewElementWithExistsKeyToLeft() {

        Node<Integer, Integer> expectedNode = new Node<>(10, 10);
        Node<Integer, Integer> expectedNodeLeft = new Node<>(5, 50);
        expectedNode.setLeft(expectedNodeLeft);
        BinarySearchTreeImpl<Integer, Integer> expectedTree = new BinarySearchTreeImpl<>(expectedNode);

        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<>();
        tree.insert(10, 10);
        tree.insert(5, 5);
        tree.insert(5, 50);


        assertEquals(expectedNodeLeft, tree.getRoot().getLeft());
        assertNull(tree.getRoot().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getRight());
        assertEquals(expectedTree, tree);
    }

    @Test
    void testInsert_addNewElementWithExistsKeyToRight() {

        Node<Integer, Integer> expectedNode = new Node<>(10, 10);
        Node<Integer, Integer> expectedNodeRight = new Node<>(15, 150);
        expectedNode.setRight(expectedNodeRight);
        BinarySearchTreeImpl<Integer, Integer> expectedTree = new BinarySearchTreeImpl<>(expectedNode);

        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<>();
        tree.insert(10, 10);
        tree.insert(15, 15);
        tree.insert(15, 150);

        assertEquals(expectedTree, tree);
        assertEquals(expectedNodeRight, tree.getRoot().getRight());
        assertNull(tree.getRoot().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight());
    }

    @Test
    void testInsert_addToLeftRightLeft() {

        Node<Integer, Integer> expectedNode = new Node<>(10, 10);
        Node<Integer, Integer> expectedNodeRight = new Node<>(15, 15);
        Node<Integer, Integer> expectedNodeLeft = new Node<>(5, 5);
        Node<Integer, Integer> expectedNodeLeft2 = new Node<>(7, 7);
        expectedNodeLeft.setRight(expectedNodeLeft2);
        expectedNode.setRight(expectedNodeRight);
        expectedNode.setLeft(expectedNodeLeft);
        BinarySearchTreeImpl<Integer, Integer> expectedTree = new BinarySearchTreeImpl<>(expectedNode);

        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<Integer, Integer>();
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
    void testInsert_addFourLevelsLeft() {

/*
                10
               /  \
              5    15
             / \
            2   7
           / \   \
          1   3   8
               \
                4
*/

        Node<Integer, Integer> expectedNode = new Node<>(10, 10);
        Node<Integer, Integer> expectedNode15 = new Node<>(15, 15);
        Node<Integer, Integer> expectedNode5 = new Node<>(5, 5);
        Node<Integer, Integer> expectedNode2 = new Node<>(2, 2);
        Node<Integer, Integer> expectedNode7 = new Node<>(7, 7);
        Node<Integer, Integer> expectedNode1 = new Node<>(1, 1);
        Node<Integer, Integer> expectedNode3 = new Node<>(3, 3);
        Node<Integer, Integer> expectedNode8 = new Node<>(8, 8);
        Node<Integer, Integer> expectedNode4 = new Node<>(4, 4);

        expectedNode.setLeft(expectedNode5);
        expectedNode.setRight(expectedNode15);
        expectedNode5.setLeft(expectedNode2);
        expectedNode5.setRight(expectedNode7);
        expectedNode2.setLeft(expectedNode1);
        expectedNode2.setRight(expectedNode3);
        expectedNode7.setRight(expectedNode8);
        expectedNode3.setRight(expectedNode4);
        BinarySearchTreeImpl<Integer, Integer> expectedTree = new BinarySearchTreeImpl<>(expectedNode);

        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<Integer, Integer>();
        tree.insert(10, 10);
        tree.insert(5, 5);
        tree.insert(15, 15);
        tree.insert(7, 7);
        tree.insert(8, 8);
        tree.insert(2, 2);
        tree.insert(3, 3);
        tree.insert(1, 1);
        tree.insert(4, 4);

        Node<Integer, Integer> resultingNode = tree.getRoot();
        Node<Integer, Integer> resultingNode15 = resultingNode.getRight();
        Node<Integer, Integer> resultingNode5 = resultingNode.getLeft();
        Node<Integer, Integer> resultingNode2 = resultingNode5.getLeft();
        Node<Integer, Integer> resultingNode7 = resultingNode5.getRight();
        Node<Integer, Integer> resultingNode8 = resultingNode7.getRight();
        Node<Integer, Integer> resultingNode1 = resultingNode2.getLeft();
        Node<Integer, Integer> resultingNode3 = resultingNode2.getRight();
        Node<Integer, Integer> resultingNode4 = resultingNode3.getRight();

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
        BinarySearchTreeImpl<Integer, Integer> expectedTree = new BinarySearchTreeImpl<>(expectedNode);

        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<Integer, Integer>();
        tree.insert(10, 10);
        tree.insert(15, 15);
        tree.insert(15, 15);
        tree.insert(12, 12);
        tree.insert(11, 11);
        tree.insert(25, 25);
        tree.insert(28, 28);
        tree.insert(20, 20);
        tree.insert(16, 16);

        Node<Integer, Integer> resultingNode = tree.getRoot();
        Node<Integer, Integer> resultingNode15 = resultingNode.getRight();
        Node<Integer, Integer> resultingNode12 = resultingNode15.getLeft();
        Node<Integer, Integer> resultingNode11 = resultingNode12.getLeft();
        Node<Integer, Integer> resultingNode25 = resultingNode15.getRight();
        Node<Integer, Integer> resultingNode28 = resultingNode25.getRight();
        Node<Integer, Integer> resultingNode20 = resultingNode25.getLeft();
        Node<Integer, Integer> resultingNode16 = resultingNode20.getLeft();

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

    @Test
    void testFind_EmptyTree() {
        BinarySearchTreeImpl<Integer, Object> tree = new BinarySearchTreeImpl<Integer, Object>();
        assertNull(tree.find(1));
    }

    @Test
    void testFind_successfullyOneTree() {
        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<Integer, Integer>();
        tree.insert(10, 10);
        assertEquals(10, tree.find(10));
    }

    @Test
    void testFind_unsuccessfullyOneTree() {
        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<>();
        tree.insert(10, 10);
        assertNull(tree.find(1));
    }

    @Test
    void testFind_twoLevels() {
        /*
                10
               /  \
              5   15
        */
        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<>();
        tree.insert(10, 10);
        tree.insert(5, 5);
        tree.insert(15, 15);
        assertNull(tree.find(1));
        assertEquals(5, tree.find(5));
        assertEquals(10, tree.find(10));
        assertEquals(15, tree.find(15));


    }

    @Test
    void testFind_FiveLevels() {
/*
                10
               /  \
              5    15
             / \    \
            2   7    25
           / \   \    \
          1   3   8    35
                      /  \
                     30   50
*/
        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<>();
        tree.insert(10, 10);
        tree.insert(5, 5);
        tree.insert(15, 15);
        tree.insert(7, 7);
        tree.insert(8, 8);
        tree.insert(2, 2);
        tree.insert(25, 25);
        tree.insert(1, 1);
        tree.insert(3, 3);
        tree.insert(35, 35);
        tree.insert(30, 30);
        tree.insert(50, 50);

        assertEquals(1, tree.find(1));
        assertEquals(2, tree.find(2));
        assertEquals(3, tree.find(3));
        assertEquals(5, tree.find(5));
        assertEquals(7, tree.find(7));
        assertEquals(8, tree.find(8));
        assertEquals(10, tree.find(10));
        assertEquals(15, tree.find(15));
        assertEquals(25, tree.find(25));
        assertEquals(30, tree.find(30));
        assertEquals(35, tree.find(35));
        assertEquals(50, tree.find(50));
        assertNull(tree.find(55));
    }

    @Test
    void testFindPreviousNode_EmptyTree() {
        BinarySearchTreeImpl tree = new BinarySearchTreeImpl<Integer, Object>();
        assertNull(tree.findPreviousNode(1));
    }

    @Test
    void testFindPreviousNode_OneElementTree() {
        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<>();
        tree.insert(10, 10);

        assertNull(tree.findPreviousNode(10));
        assertNull(tree.findPreviousNode(1));
    }

    @Test
    void testFindPreviousNode_TwoLevelTree() {
        Node<Integer, Integer> expectedNode = new Node<>(10, 10, new Node<>(5, 5), new Node<>(15, 15));

        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<>();
        tree.insert(10, 10);
        tree.insert(5, 5);
        tree.insert(15, 15);

        assertEquals(expectedNode, tree.findPreviousNode(5));
        assertEquals(expectedNode, tree.findPreviousNode(15));
    }

    @Test
    void testFindPreviousNode_FiveLevelTree() {
        /*
                10
               /  \
              5    15
             / \    \
            2   7    25
           / \   \    \
          1   3   8    35
                      /  \
                     30   50
                    /
                   29
*/
        Node<Integer, Integer> expectedNode1 = new Node<>(1, 1);
        Node<Integer, Integer> expectedNode2 = new Node<>(2, 2);
        Node<Integer, Integer> expectedNode3 = new Node<>(3, 3);
        Node<Integer, Integer> expectedNode5 = new Node<>(5, 5);
        Node<Integer, Integer> expectedNode7 = new Node<>(7, 7);
        Node<Integer, Integer> expectedNode8 = new Node<>(8, 8);
        Node<Integer, Integer> expectedNode10 = new Node<>(10, 10);
        Node<Integer, Integer> expectedNode15 = new Node<>(15, 15);
        Node<Integer, Integer> expectedNode25 = new Node<>(25, 25);
        Node<Integer, Integer> expectedNode30 = new Node<>(30, 30);
        Node<Integer, Integer> expectedNode29 = new Node<>(29, 29);
        Node<Integer, Integer> expectedNode35 = new Node<>(35, 35);
        Node<Integer, Integer> expectedNode50 = new Node<>(50, 50);
        expectedNode10.setLeft(expectedNode5);
        expectedNode10.setRight(expectedNode15);
        expectedNode5.setLeft(expectedNode2);
        expectedNode5.setRight(expectedNode7);
        expectedNode2.setLeft(expectedNode1);
        expectedNode2.setRight(expectedNode3);
        expectedNode7.setRight(expectedNode8);
        expectedNode15.setRight(expectedNode25);
        expectedNode25.setRight(expectedNode35);
        expectedNode30.setLeft(expectedNode29);
        expectedNode35.setLeft(expectedNode30);
        expectedNode35.setRight(expectedNode50);

        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<>();
        tree.insert(10, 10);
        tree.insert(5, 5);
        tree.insert(15, 15);
        tree.insert(7, 7);
        tree.insert(8, 8);
        tree.insert(2, 2);
        tree.insert(25, 25);
        tree.insert(1, 1);
        tree.insert(3, 3);
        tree.insert(35, 35);
        tree.insert(30, 30);
        tree.insert(50, 50);
        tree.insert(29, 29);
        assertNull(tree.findPreviousNode(10));
        assertEquals(expectedNode10, tree.findPreviousNode(5));
        assertEquals(expectedNode5, tree.findPreviousNode(2));
        assertEquals(expectedNode5, tree.findPreviousNode(7));
        assertEquals(expectedNode2, tree.findPreviousNode(1));
        assertEquals(expectedNode2, tree.findPreviousNode(3));
        assertEquals(expectedNode7, tree.findPreviousNode(8));
        assertEquals(expectedNode25, tree.findPreviousNode(35));
        assertEquals(expectedNode35, tree.findPreviousNode(30));
        assertEquals(expectedNode35, tree.findPreviousNode(50));
        assertEquals(expectedNode30, tree.findPreviousNode(29));
    }

    @Test
    void testDelete_EmptyTree() {
        BinarySearchTreeImpl<Integer, Object> tree = new BinarySearchTreeImpl<Integer, Object>();

        assertNull(tree.delete(1));
    }

    @Test
    void testDelete_successfullyOneElementTree() {
        BinarySearchTreeImpl expectedTree = new BinarySearchTreeImpl();
        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<>();
        tree.insert(10, 10);

        assertEquals(10, tree.delete(10));
        assertEquals(expectedTree, tree);
    }

    @Test
    void testDelete_unsuccessfullyOneElementTree() {
        Node<Integer, Integer> expectedNode10 = new Node<>(10, 10);
        BinarySearchTreeImpl<Integer, Integer> expectedTree = new BinarySearchTreeImpl<>(expectedNode10);

        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<>();

        tree.insert(10, 10);

        assertNull(tree.delete(1));
        assertEquals(expectedTree, tree);
    }

    @Test
    void testDelete_successfulLeafsDeletingLeftFirst() {
        Node<Integer, Integer> expectedNode = new Node<>(10, 10);
        BinarySearchTreeImpl<Integer, Integer> expectedTree = new BinarySearchTreeImpl<>(expectedNode);

        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<>();
        tree.insert(10, 10);
        tree.insert(5, 5);
        tree.insert(15, 15);

        assertEquals(5, tree.delete(5));
        assertEquals(15, tree.delete(15));
        assertEquals(10, tree.find(10));
        assertEquals(expectedTree, tree);
        assertEquals(expectedNode, tree.getRoot());
    }

    @Test
    void testDelete_successfulDeletingAllLeafs() {
        Node<Integer, Integer> expectedNode = new Node<>(10, 10);
        BinarySearchTreeImpl<Integer, Integer> expectedTree = new BinarySearchTreeImpl<>(expectedNode);

        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<Integer, Integer>();
        tree.insert(10, 10);
        tree.insert(5, 5);
        tree.insert(15, 15);

        assertEquals(15, tree.delete(15));
        assertEquals(5, tree.delete(5));
        assertEquals(10, tree.find(10));
        assertEquals(expectedTree, tree);
        assertEquals(expectedNode, tree.getRoot());
    }

    @Test
    void testDelete_FiveLevelTreeAllLeafs() {
        /*
                10
               /  \
              5    15
             / \    \
            2   7    25
           / \   \    \
          1   3   8    35
                      /  \
                     30   50
                    /
                   29
*/
        Node<Integer, Integer> expectedNode1 = new Node<>(1, 1);
        Node<Integer, Integer> expectedNode2 = new Node<>(2, 2);
        Node<Integer, Integer> expectedNode3 = new Node<>(3, 3);
        Node<Integer, Integer> expectedNode5 = new Node<>(5, 5);
        Node<Integer, Integer> expectedNode7 = new Node<>(7, 7);
        Node<Integer, Integer> expectedNode8 = new Node<>(8, 8);
        Node<Integer, Integer> expectedNode10 = new Node<>(10, 10);
        Node<Integer, Integer> expectedNode15 = new Node<>(15, 15);
        Node<Integer, Integer> expectedNode25 = new Node<>(25, 25);
        Node<Integer, Integer> expectedNode30 = new Node<>(30, 30);
        Node<Integer, Integer> expectedNode29 = new Node<>(29, 29);
        Node<Integer, Integer> expectedNode35 = new Node<>(35, 35);
        Node<Integer, Integer> expectedNode50 = new Node<>(50, 50);
        expectedNode10.setLeft(expectedNode5);
        expectedNode10.setRight(expectedNode15);
        expectedNode5.setRight(expectedNode7);
        expectedNode2.setLeft(expectedNode1);
        expectedNode2.setRight(expectedNode3);
        expectedNode7.setRight(expectedNode8);
        expectedNode15.setRight(expectedNode25);
        expectedNode25.setRight(expectedNode35);
        expectedNode30.setLeft(expectedNode29);
        expectedNode35.setLeft(expectedNode30);
        expectedNode35.setRight(expectedNode50);
        BinarySearchTreeImpl<Integer, Integer> expectedTree = new BinarySearchTreeImpl<>(expectedNode10);

        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<Integer, Integer>();
        tree.insert(10, 10);
        tree.insert(5, 5);
        tree.insert(15, 15);
        tree.insert(7, 7);
        tree.insert(8, 8);
        tree.insert(2, 2);
        tree.insert(25, 25);
        tree.insert(1, 1);
        tree.insert(3, 3);
        tree.insert(35, 35);
        tree.insert(30, 30);
        tree.insert(50, 50);
        tree.insert(29, 29);

        assertEquals(1, tree.delete(1));
        assertEquals(3, tree.delete(3));
        assertEquals(2, tree.delete(2));
        assertEquals(expectedTree, tree);
        assertEquals(29, tree.delete(29));
        assertEquals(8, tree.delete(8));
        assertEquals(7, tree.delete(7));
        assertEquals(5, tree.delete(5));
        assertEquals(30, tree.delete(30));
        assertEquals(50, tree.delete(50));
        assertEquals(35, tree.delete(35));
        assertEquals(25, tree.delete(25));
        assertEquals(15, tree.delete(15));
        assertEquals(10, tree.delete(10));
        assertNull(tree.getRoot());
    }

    @Test
    void testDelete30() {
        /*
                10                            10
               /  \                          /  \
              5    15                       5    15
             / \    \                      / \    \
            2   7    25                   2   7    25
           / \   \    \        =>        / \   \    \
          1   3   8    35               1   3   8    35
                      /  \                          /  \
                     30   50                      29   50
                    /
                   29
*/

        Node<Integer, Integer> expectedNode1 = new Node<>(1, 1);
        Node<Integer, Integer> expectedNode2 = new Node<>(2, 2);
        Node<Integer, Integer> expectedNode3 = new Node<>(3, 3);
        Node<Integer, Integer> expectedNode5 = new Node<>(5, 5);
        Node<Integer, Integer> expectedNode7 = new Node<>(7, 7);
        Node<Integer, Integer> expectedNode8 = new Node<>(8, 8);
        Node<Integer, Integer> expectedNode10 = new Node<>(10, 10);
        Node<Integer, Integer> expectedNode15 = new Node<>(15, 15);
        Node<Integer, Integer> expectedNode25 = new Node<>(25, 25);
        Node<Integer, Integer> expectedNode29 = new Node<>(29, 29);
        Node<Integer, Integer> expectedNode35 = new Node<>(35, 35);
        Node<Integer, Integer> expectedNode50 = new Node<>(50, 50);
        expectedNode10.setLeft(expectedNode5);
        expectedNode10.setRight(expectedNode15);
        expectedNode5.setRight(expectedNode7);
        expectedNode5.setLeft(expectedNode2);
        expectedNode2.setLeft(expectedNode1);
        expectedNode2.setRight(expectedNode3);
        expectedNode7.setRight(expectedNode8);
        expectedNode15.setRight(expectedNode25);
        expectedNode25.setRight(expectedNode35);
        expectedNode35.setLeft(expectedNode29);
        expectedNode35.setRight(expectedNode50);
        BinarySearchTreeImpl<Integer, Integer> expectedTree = new BinarySearchTreeImpl<>(expectedNode10);

        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<>();
        tree.insert(10, 10);
        tree.insert(5, 5);
        tree.insert(15, 15);
        tree.insert(7, 7);
        tree.insert(8, 8);
        tree.insert(2, 2);
        tree.insert(25, 25);
        tree.insert(1, 1);
        tree.insert(3, 3);
        tree.insert(35, 35);
        tree.insert(30, 30);
        tree.insert(50, 50);
        tree.insert(29, 29);

        assertEquals(30, tree.delete(30));
        assertEquals(expectedTree, tree);
    }

    @Test
    void testDelete7() {
        /*
               10                             10
              /   \                          /  \
             5     15                       5    15
            /  \    \                      / \    \
           2    7    25                   2   8    25
          / \   /\    \        =>        /\   /     \
         1   3 6  8   35                1  3 6      35
                      / \                           /  \
                     30  50                       30   50
                    /                             /
                   29                            29
*/

        Node<Integer, Integer> expectedNode1 = new Node<>(1, 1);
        Node<Integer, Integer> expectedNode2 = new Node<>(2, 2);
        Node<Integer, Integer> expectedNode3 = new Node<>(3, 3);
        Node<Integer, Integer> expectedNode5 = new Node<>(5, 5);
        Node<Integer, Integer> expectedNode6 = new Node<>(6, 6);
        Node<Integer, Integer> expectedNode8 = new Node<>(8, 8);
        Node<Integer, Integer> expectedNode10 = new Node<>(10, 10);
        Node<Integer, Integer> expectedNode15 = new Node<>(15, 15);
        Node<Integer, Integer> expectedNode25 = new Node<>(25, 25);
        Node<Integer, Integer> expectedNode29 = new Node<>(29, 29);
        Node<Integer, Integer> expectedNode30 = new Node<>(30, 30);
        Node<Integer, Integer> expectedNode35 = new Node<>(35, 35);
        Node<Integer, Integer> expectedNode50 = new Node<>(50, 50);
        expectedNode10.setLeft(expectedNode5);
        expectedNode10.setRight(expectedNode15);
        expectedNode5.setRight(expectedNode8);
        expectedNode5.setLeft(expectedNode2);
        expectedNode8.setLeft(expectedNode6);
        expectedNode2.setLeft(expectedNode1);
        expectedNode2.setRight(expectedNode3);
        expectedNode15.setRight(expectedNode25);
        expectedNode25.setRight(expectedNode35);
        expectedNode35.setLeft(expectedNode30);
        expectedNode30.setLeft(expectedNode29);
        expectedNode35.setRight(expectedNode50);
        BinarySearchTreeImpl<Integer, Integer> expectedTree = new BinarySearchTreeImpl<>(expectedNode10);

        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<Integer, Integer>();
        tree.insert(10, 10);
        tree.insert(5, 5);
        tree.insert(15, 15);
        tree.insert(7, 7);
        tree.insert(8, 8);
        tree.insert(2, 2);
        tree.insert(25, 25);
        tree.insert(1, 1);
        tree.insert(3, 3);
        tree.insert(35, 35);
        tree.insert(30, 30);
        tree.insert(50, 50);
        tree.insert(29, 29);
        tree.insert(6, 6);

        assertEquals(7, tree.delete(7));
        assertEquals(expectedTree, tree);
    }


    @Test
    void testDelete5() {
        /*
               10                             10
              /   \                          /  \
             5     15                       6    15
            /  \    \                      / \    \
           2    7    25                   2   7    25
          / \   /\    \        =>        / \   \    \
         1   3 6  8   35                1   3   8    35
                      / \                           /  \
                     30  50                       30   50
                    /                             /
                   29                            29
*/

        Node<Integer, Integer> expectedNode1 = new Node<>(1, 1);
        Node<Integer, Integer> expectedNode2 = new Node<>(2, 2);
        Node<Integer, Integer> expectedNode3 = new Node<>(3, 3);
        Node<Integer, Integer> expectedNode6 = new Node<>(6, 6);
        Node<Integer, Integer> expectedNode7 = new Node<>(7, 7);
        Node<Integer, Integer> expectedNode8 = new Node<>(8, 8);
        Node<Integer, Integer> expectedNode10 = new Node<>(10, 10);
        Node<Integer, Integer> expectedNode15 = new Node<>(15, 15);
        Node<Integer, Integer> expectedNode25 = new Node<>(25, 25);
        Node<Integer, Integer> expectedNode29 = new Node<>(29, 29);
        Node<Integer, Integer> expectedNode30 = new Node<>(30, 30);
        Node<Integer, Integer> expectedNode35 = new Node<>(35, 35);
        Node<Integer, Integer> expectedNode50 = new Node<>(50, 50);
        expectedNode10.setLeft(expectedNode6);
        expectedNode10.setRight(expectedNode15);
        expectedNode6.setRight(expectedNode7);
        expectedNode7.setRight(expectedNode8);
        expectedNode6.setLeft(expectedNode2);
        expectedNode2.setLeft(expectedNode1);
        expectedNode2.setRight(expectedNode3);
        expectedNode15.setRight(expectedNode25);
        expectedNode25.setRight(expectedNode35);
        expectedNode35.setLeft(expectedNode30);
        expectedNode30.setLeft(expectedNode29);
        expectedNode35.setRight(expectedNode50);
        BinarySearchTreeImpl<Integer, Integer> expectedTree = new BinarySearchTreeImpl<>(expectedNode10);

        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<>();
        tree.insert(10, 10);
        tree.insert(5, 5);
        tree.insert(15, 15);
        tree.insert(7, 7);
        tree.insert(8, 8);
        tree.insert(2, 2);
        tree.insert(25, 25);
        tree.insert(1, 1);
        tree.insert(3, 3);
        tree.insert(35, 35);
        tree.insert(30, 30);
        tree.insert(50, 50);
        tree.insert(29, 29);
        tree.insert(6, 6);

        assertEquals(5, tree.delete(5));
        assertEquals(expectedTree, tree);
    }

    @Test
    void testDelete2() {
        /*
               10                             10
              /   \                          /  \
             5     15                       5    15
            /  \    \                      / \    \
           2    7    25                   3   7    25
          / \   /\    \        =>        /    /\    \
         1   3 6  8   35                1    6  8    35
                      / \                           /  \
                     30  50                       30   50
                    /                             /
                   29                            29
*/

        Node<Integer, Integer> expectedNode1 = new Node<>(1, 1);
        //    Node<Integer, Integer> expectedNode2 = new Node<>(2, 2);
        Node<Integer, Integer> expectedNode3 = new Node<>(3, 3);
        Node<Integer, Integer> expectedNode5 = new Node<>(5, 5);
        Node<Integer, Integer> expectedNode6 = new Node<>(6, 6);
        Node<Integer, Integer> expectedNode7 = new Node<>(7, 7);
        Node<Integer, Integer> expectedNode8 = new Node<>(8, 8);
        Node<Integer, Integer> expectedNode10 = new Node<>(10, 10);
        Node<Integer, Integer> expectedNode15 = new Node<>(15, 15);
        Node<Integer, Integer> expectedNode25 = new Node<>(25, 25);
        Node<Integer, Integer> expectedNode29 = new Node<>(29, 29);
        Node<Integer, Integer> expectedNode30 = new Node<>(30, 30);
        Node<Integer, Integer> expectedNode35 = new Node<>(35, 35);
        Node<Integer, Integer> expectedNode50 = new Node<>(50, 50);
        expectedNode10.setLeft(expectedNode5);
        expectedNode10.setRight(expectedNode15);
        expectedNode5.setRight(expectedNode7);
        expectedNode7.setRight(expectedNode8);
        expectedNode7.setLeft(expectedNode6);
        expectedNode5.setLeft(expectedNode3);
        expectedNode3.setLeft(expectedNode1);
        expectedNode15.setRight(expectedNode25);
        expectedNode25.setRight(expectedNode35);
        expectedNode35.setLeft(expectedNode30);
        expectedNode30.setLeft(expectedNode29);
        expectedNode35.setRight(expectedNode50);
        BinarySearchTreeImpl<Integer, Integer> expectedTree = new BinarySearchTreeImpl<>(expectedNode10);

        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<Integer, Integer>();
        tree.insert(10, 10);
        tree.insert(5, 5);
        tree.insert(15, 15);
        tree.insert(7, 7);
        tree.insert(8, 8);
        tree.insert(2, 2);
        tree.insert(25, 25);
        tree.insert(1, 1);
        tree.insert(3, 3);
        tree.insert(35, 35);
        tree.insert(30, 30);
        tree.insert(50, 50);
        tree.insert(29, 29);
        tree.insert(6, 6);

        assertEquals(2, tree.delete(2));
        assertEquals(expectedTree, tree);
    }

    @Test
    void testDelete35() {
        /*
               10                             10
              /   \                          /  \
             5     15                       5    15
            /  \    \                      / \    \
           2    7    25                   2   7    25
          / \   /\    \        =>        /\   /\    \
         1   3 6  8   35                1  3 6  8    50
                      / \                           /
                     30  50                       30
                    /                             /
                   29                            29
*/

        Node<Integer, Integer> expectedNode1 = new Node<>(1, 1);
        Node<Integer, Integer> expectedNode2 = new Node<>(2, 2);
        Node<Integer, Integer> expectedNode3 = new Node<>(3, 3);
        Node<Integer, Integer> expectedNode5 = new Node<>(5, 5);
        Node<Integer, Integer> expectedNode6 = new Node<>(6, 6);
        Node<Integer, Integer> expectedNode7 = new Node<>(7, 7);
        Node<Integer, Integer> expectedNode8 = new Node<>(8, 8);
        Node<Integer, Integer> expectedNode10 = new Node<>(10, 10);
        Node<Integer, Integer> expectedNode15 = new Node<>(15, 15);
        Node<Integer, Integer> expectedNode25 = new Node<>(25, 25);
        Node<Integer, Integer> expectedNode29 = new Node<>(29, 29);
        Node<Integer, Integer> expectedNode30 = new Node<>(30, 30);
        //     Node<Integer, Integer> expectedNode35 = new Node<>(35, 35);
        Node<Integer, Integer> expectedNode50 = new Node<>(50, 50);
        expectedNode10.setLeft(expectedNode5);
        expectedNode10.setRight(expectedNode15);
        expectedNode5.setRight(expectedNode7);
        expectedNode7.setRight(expectedNode8);
        expectedNode7.setLeft(expectedNode6);
        expectedNode5.setLeft(expectedNode2);
        expectedNode2.setLeft(expectedNode1);
        expectedNode2.setRight(expectedNode3);
        expectedNode15.setRight(expectedNode25);
        expectedNode25.setRight(expectedNode50);
        expectedNode50.setLeft(expectedNode30);
        expectedNode30.setLeft(expectedNode29);

        BinarySearchTreeImpl<Integer, Integer> expectedTree = new BinarySearchTreeImpl<>(expectedNode10);

        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<>();
        tree.insert(10, 10);
        tree.insert(5, 5);
        tree.insert(15, 15);
        tree.insert(7, 7);
        tree.insert(8, 8);
        tree.insert(2, 2);
        tree.insert(25, 25);
        tree.insert(1, 1);
        tree.insert(3, 3);
        tree.insert(35, 35);
        tree.insert(30, 30);
        tree.insert(50, 50);
        tree.insert(29, 29);
        tree.insert(6, 6);

        assertEquals(35, tree.delete(35));
        assertEquals(expectedTree, tree);
    }

    @Test
    void testDelete10() {
        /*
               10                             15
              /   \                          /  \
             5     15                       5    \
            /  \    \                      / \    \
           2    7    25                   2   7    25
          / \   /\    \        =>        /\   /\    \
         1   3 6  8   35                1  3 6  8    35
                      / \                           /  \
                     30  50                       30    50
                    /                             /
                   29                            29
*/

        Node<Integer, Integer> expectedNode1 = new Node<>(1, 1);
        Node<Integer, Integer> expectedNode2 = new Node<>(2, 2);
        Node<Integer, Integer> expectedNode3 = new Node<>(3, 3);
        Node<Integer, Integer> expectedNode5 = new Node<>(5, 5);
        Node<Integer, Integer> expectedNode6 = new Node<>(6, 6);
        Node<Integer, Integer> expectedNode7 = new Node<>(7, 7);
        Node<Integer, Integer> expectedNode8 = new Node<>(8, 8);
     //   Node<Integer, Integer> expectedNode10 = new Node<>(10, 10);
        Node<Integer, Integer> expectedNode15 = new Node<>(15, 15);
        Node<Integer, Integer> expectedNode25 = new Node<>(25, 25);
        Node<Integer, Integer> expectedNode29 = new Node<>(29, 29);
        Node<Integer, Integer> expectedNode30 = new Node<>(30, 30);
        Node<Integer, Integer> expectedNode35 = new Node<>(35, 35);
        Node<Integer, Integer> expectedNode50 = new Node<>(50, 50);
        expectedNode15.setLeft(expectedNode5);
        expectedNode15.setRight(expectedNode25);
        expectedNode5.setRight(expectedNode7);
        expectedNode7.setRight(expectedNode8);
        expectedNode7.setLeft(expectedNode6);
        expectedNode5.setLeft(expectedNode2);
        expectedNode2.setLeft(expectedNode1);
        expectedNode2.setRight(expectedNode3);
        expectedNode25.setRight(expectedNode35);
        expectedNode35.setLeft(expectedNode30);
        expectedNode35.setRight(expectedNode50);
        expectedNode30.setLeft(expectedNode29);

        BinarySearchTreeImpl<Integer, Integer> expectedTree = new BinarySearchTreeImpl<>(expectedNode15);

        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<>();
        tree.insert(10, 10);
        tree.insert(5, 5);
        tree.insert(15, 15);
        tree.insert(7, 7);
        tree.insert(8, 8);
        tree.insert(2, 2);
        tree.insert(25, 25);
        tree.insert(1, 1);
        tree.insert(3, 3);
        tree.insert(35, 35);
        tree.insert(30, 30);
        tree.insert(50, 50);
        tree.insert(29, 29);
        tree.insert(6, 6);

        assertEquals(10, tree.delete(10));
        assertEquals(expectedTree, tree);
    }

    @Test
    void testDelete_allElementsByOrder() {
                /*
               10
              /   \
             5     15
            /  \    \
           2    7    25
          / \   /\    \
         1   3 6  8   35
                      / \
                     30  50
                    /
                   29
*/


        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<>();
        tree.insert(10, 10);
        tree.insert(5, 5);
        tree.insert(15, 15);
        tree.insert(7, 7);
        tree.insert(8, 8);
        tree.insert(2, 2);
        tree.insert(25, 25);
        tree.insert(1, 1);
        tree.insert(3, 3);
        tree.insert(35, 35);
        tree.insert(30, 30);
        tree.insert(50, 50);
        tree.insert(29, 29);
        tree.insert(6, 6);


        assertEquals(1, tree.delete(1));
        assertEquals(2, tree.delete(2));
        assertEquals(3, tree.delete(3));
        assertEquals(5, tree.delete(5));
        assertEquals(6, tree.delete(6));
        assertEquals(7, tree.delete(7));
        assertEquals(8, tree.delete(8));
        assertEquals(10, tree.delete(10));
        assertEquals(15, tree.delete(15));
        assertEquals(25, tree.delete(25));
        assertEquals(29, tree.delete(29));
        assertEquals(30, tree.delete(30));
        assertEquals(35, tree.delete(35));
        assertEquals(50, tree.delete(50));
        assertEquals(new BinarySearchTreeImpl<>(), tree);
    }

    @Test
    void testDelete_allElementsByReverseOrder() {
                /*
               10
              /   \
             5     15
            /  \    \
           2    7    25
          / \   /\    \
         1   3 6  8   35
                      / \
                     30  50
                    /
                   29
*/
        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<Integer, Integer>();
        tree.insert(10, 10);
        tree.insert(5, 5);
        tree.insert(15, 15);
        tree.insert(7, 7);
        tree.insert(8, 8);
        tree.insert(2, 2);
        tree.insert(25, 25);
        tree.insert(1, 1);
        tree.insert(3, 3);
        tree.insert(35, 35);
        tree.insert(30, 30);
        tree.insert(50, 50);
        tree.insert(29, 29);
        tree.insert(6, 6);

        assertEquals(50, tree.delete(50));
        assertEquals(35, tree.delete(35));
        assertEquals(30, tree.delete(30));
        assertEquals(29, tree.delete(29));
        assertEquals(25, tree.delete(25));
        assertEquals(15, tree.delete(15));
        assertEquals(10, tree.delete(10));
        assertEquals(8, tree.delete(8));
        assertEquals(7, tree.delete(7));
        assertEquals(6, tree.delete(6));
        assertEquals(5, tree.delete(5));
        assertEquals(3, tree.delete(3));
        assertEquals(2, tree.delete(2));
        assertEquals(1, tree.delete(1));
        assertEquals(new BinarySearchTreeImpl<>(), tree);
    }

    @Test
    void testDelete_allElementsRandomOrder() {
                /*
               10
              /   \
             5     15
            /  \    \
           2    7    25
          / \   /\    \
         1   3 6  8   35
                      / \
                     30  50
                    /
                   29
*/
        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<Integer, Integer>();
        tree.insert(10, 10);
        tree.insert(5, 5);
        tree.insert(15, 15);
        tree.insert(7, 7);
        tree.insert(8, 8);
        tree.insert(2, 2);
        tree.insert(25, 25);
        tree.insert(1, 1);
        tree.insert(3, 3);
        tree.insert(35, 35);
        tree.insert(30, 30);
        tree.insert(50, 50);
        tree.insert(29, 29);
        tree.insert(6, 6);

        assertEquals(30, tree.delete(30));
        assertEquals(5, tree.delete(5));
        assertEquals(50, tree.delete(50));
        assertEquals(35, tree.delete(35));
        assertEquals(10, tree.delete(10));
        assertEquals(25, tree.delete(25));
        assertEquals(15, tree.delete(15));
        assertEquals(8, tree.delete(8));
        assertEquals(6, tree.delete(6));
        assertEquals(3, tree.delete(3));
        assertEquals(2, tree.delete(2));
        assertEquals(1, tree.delete(1));
        assertEquals(7, tree.delete(7));
        assertEquals(29, tree.delete(29));
        assertEquals(new BinarySearchTreeImpl<>(), tree);
    }

    @Test
    void testDelete_allElementsHeadOrder() {
                /*
               10
              /   \
             5     15
            /  \    \
           2    7    25
          / \   /\    \
         1   3 6  8   35
                      / \
                     30  50
                    /
                   29
*/
        BinarySearchTreeImpl<Integer, Integer> tree = new BinarySearchTreeImpl<Integer, Integer>();
        tree.insert(10, 10);
        tree.insert(5, 5);
        tree.insert(15, 15);
        tree.insert(7, 7);
        tree.insert(8, 8);
        tree.insert(2, 2);
        tree.insert(25, 25);
        tree.insert(1, 1);
        tree.insert(3, 3);
        tree.insert(35, 35);
        tree.insert(30, 30);
        tree.insert(50, 50);
        tree.insert(29, 29);
        tree.insert(6, 6);

        assertEquals(10, tree.delete(10));
        assertEquals(15, tree.delete(15));
        assertEquals(25, tree.delete(25));
        assertEquals(35, tree.delete(35));
        assertEquals(50, tree.delete(50));
        assertEquals(30, tree.delete(30));
        assertEquals(29, tree.delete(29));
        assertEquals(5, tree.delete(5));
        assertEquals(7, tree.delete(7));
        assertEquals(8, tree.delete(8));
        assertEquals(6, tree.delete(6));
        assertEquals(3, tree.delete(3));
        assertEquals(2, tree.delete(2));
        assertEquals(1, tree.delete(1));

        assertEquals(new BinarySearchTreeImpl<>(), tree);
    }

}