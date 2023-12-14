package com.accenture.internship.mapImpl;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {

    @Test
    void testHash() {
        String k1 = "test";
        String k2 = "TEST";
        String k3 = "test_test";
        String k4 = null;
        Map<String, String> map = new HashMap<String, String>();
        assertEquals(116, map.hash(k1));
        assertEquals(84, map.hash(k2));
        assertEquals(116, map.hash(k3));
        assertEquals(0, map.hash(k4));
    }

    @Test
    void testisEmpty_emptyHashmap() {
        HashMap<String, String> map = new HashMap<>();

        assertTrue(map.isEmpty());
    }

    @Test
    void testisEmpty_notEmptyHashmap() {
        HashMap<String, String> map = new HashMap<>();
        map.put(null, "value");

        assertFalse(map.isEmpty());
    }

    @Test
    void testSize_emptyHashmap() {
        HashMap<String, String> map = new HashMap<>();

        assertEquals(0, map.size());
    }

    @Test
    void testSize_notEmptyHashmap() {
        HashMap<String, String> map = new HashMap<>();
        map.put(null, "value");

        assertEquals(1, map.size());
    }

    @Test
    void testPut_emptyTable_noNeedToGrowTable() {

        Node<String, String> expectedNode = new Node<>(null, "value", null);
        Node[] expectedTable = new Node[16];
        expectedTable[0] = expectedNode;
        Map<String, String> expectedMap = new HashMap<>(1, 16, expectedTable);

        HashMap<String, String> map = new HashMap<>();
        map.put(null, "value");

        assertEquals(1, map.size());
        assertEquals(expectedNode, map.getTable()[0]);
        assertEquals(expectedMap, map);
    }

    @Test
    void testPut_emptyTable_NeedToGrowTable() {

        Node<String, String> expectedNode = new Node<>("0", "value", null);
        Node[] expectedTable = new Node[128];
        expectedTable[48] = expectedNode;
        Map<String, String> expectedMap = new HashMap(1, 128, expectedTable);

        HashMap<String, String> map = new HashMap<>();
        map.put("0", "value");

        assertEquals(1, map.size());
        assertEquals(expectedNode, map.getTable()[48]);
        assertEquals(expectedMap, map);
    }

    @Test
    void testPut_NeedToGrowTable() {

        Node<String, String> expectedNode1 = new Node<>(null, "nullValue", null);
        Node<String, String> expectedNode2 = new Node<>("test", "testValue", null);
        Node<String, String> expectedNode3 = new Node<>("TEST", "TESTValue", null);
        Node[] expectedTable = new Node[256];
        expectedTable[0] = expectedNode1;
        expectedTable[116] = expectedNode2;
        expectedTable[84] = expectedNode3;
        Map<String, String> expectedMap = new HashMap(3, 256, expectedTable);

        HashMap<String, String> map = new HashMap<>();
        map.put(null, "nullValue");
        map.put("test", "testValue");
        map.put("TEST", "TESTValue");

        assertEquals(3, map.size());
        assertEquals(expectedNode1, map.getTable()[0]);
        assertEquals(expectedNode2, map.getTable()[116]);
        assertEquals(expectedNode3, map.getTable()[84]);
        assertEquals(expectedMap, map);
    }

    @Test
    void testPut_twoElementsWithSameHash() {

        Node<String, String> expectedNode1 = new Node<>("key1", "Value1", null);
        Node<String, String> expectedNode2 = new Node<>("key2", "Value2", null);
        Node[] expectedTable = new Node[256];
        expectedNode1.setNext(expectedNode2);
        expectedTable[107] = expectedNode1;
        Map<String, String> expectedMap = new HashMap(2, 256, expectedTable);

        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "Value1");
        map.put("key2", "Value2");

        assertEquals(2, map.size());
        assertEquals(expectedNode1, map.getTable()[107]);
        assertEquals(expectedNode2, map.getTable()[107].getNext());
        assertEquals(expectedMap, map);
    }

    @Test
    void testPut_fourElementsWithSameHash() {

        Node<String, String> expectedNode1 = new Node<>("key1", "Value1", null);
        Node<String, String> expectedNode2 = new Node<>("key2", "Value2", null);
        Node<String, String> expectedNode3 = new Node<>("key3", "Value3", null);
        Node<String, String> expectedNode4 = new Node<>("key4", "Value4", null);
        Node[] expectedTable = new Node[256];
        expectedNode1.setNext(expectedNode2);
        expectedNode2.setNext(expectedNode3);
        expectedNode3.setNext(expectedNode4);
        expectedTable[107] = expectedNode1;
        Map<String, String> expectedMap = new HashMap(4, 256, expectedTable);

        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "Value1");
        map.put("key2", "Value2");
        map.put("key3", "Value3");
        map.put("key4", "Value4");

        assertEquals(4, map.size());
        assertEquals(expectedNode1, map.getTable()[107]);
        assertEquals(expectedNode2, map.getTable()[107].getNext());
        assertEquals(expectedNode3, map.getTable()[107].getNext().getNext());
        assertEquals(expectedNode4, map.getTable()[107].getNext().getNext().getNext());
        assertEquals(expectedMap, map);
    }

    @Test
    void testPut_twoSameElements() {

        Node<String, String> expectedNode1 = new Node<>("key", "Value", null);

        Node[] expectedTable = new Node[256];
        expectedTable[107] = expectedNode1;
        Map<String, String> expectedMap = new HashMap(1, 256, expectedTable);

        HashMap<String, String> map = new HashMap<>();
        map.put("key", "Value");
        map.put("key", "Value");

        assertEquals(1, map.size());
        assertEquals(expectedNode1, map.getTable()[107]);
        assertEquals(expectedMap, map);
    }

    @Test
    void testPut_twoSameKeyElementsDifferentValue() {

        Node<String, String> expectedNode = new Node<>("key2", "Value2", null);
        Node[] expectedTable = new Node[256];
        expectedTable[107] = expectedNode;
        Map<String, String> expectedMap = new HashMap(1, 256, expectedTable);

        HashMap<String, String> map = new HashMap<>();
        map.put("key2", "Value1");
        map.put("key2", "Value2");

        assertEquals(1, map.size());
        assertEquals(expectedNode, map.getTable()[107]);
        assertEquals(expectedMap, map);
    }

    @Test
    void testGet_emptyHashmap_smallTable() {

        HashMap<String, String> map = new HashMap<>();
        assertNull(map.get(null));
    }

    @Test
    void testGet_notEmptyHashmap_nullKey() {

        HashMap<String, String> map = new HashMap<>();
        map.put(null, "value");

        assertEquals("value", map.get(null));

    }

    @Test
    void testGet_emptyHashmap_notExistingTableIndex() {

        HashMap<String, String> map = new HashMap<>();
        assertNull(map.get("key"));
    }

    @Test
    void testGet_notEmptyHashmap_largeTable() {

        HashMap<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("null", "nullValue");
        assertEquals("value", map.get("key"));
        assertEquals("nullValue", map.get("null"));
        assertNull(map.get("nonExistentKey"));
        assertNull(map.get(null));
    }

    @Test
    void testGet_twoElementsWithSameHash() {

        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "Value1");
        map.put("key2", "Value2");
        assertEquals("Value1", map.get("key1"));
        assertEquals("Value2", map.get("key2"));
    }

    @Test
    void testGet_noElementWithSameHash() {

        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "Value1");
        map.put("key2", "Value2");
        map.put("key3", "Value3");
        map.put("key4", "Value4");

        assertNull(map.get("key5"));
    }

    @Test
    void testRemove_emptyHashmap() {
        HashMap<String, String> map = new HashMap<>();

        assertNull(map.remove("key"));
        assertEquals(0, map.size());
    }

    @Test
    void testRemove_emptyHashmap_nullKey() {
        HashMap<String, String> map = new HashMap<>();

        assertNull(map.remove(null));
        assertEquals(0, map.size());
    }

    @Test
    void testRemove_notEmptyHashmap_nonExistentKey() {
        HashMap<String, String> map = new HashMap<>();
        map.put(null, "value1");
        map.put("key", "value2");
        map.put("test", "value3");

        assertEquals(3, map.size());
        assertNull(map.remove("nonExistentKey"));
        assertEquals(3, map.size());
    }

    @Test
    void testRemove_notEmptyHashmap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "value1");
        map.put("test", "value2");

        assertEquals(2, map.size());
        assertEquals("value1", map.remove("key"));
        assertEquals(1, map.size());
    }

    @Test
    void testRemove_notEmptyHashmap_nullKey() {
        HashMap<String, String> map = new HashMap<>();
        map.put(null, "value1");
        map.put("key", "value2");

        assertEquals(2, map.size());
        assertEquals("value1", map.remove(null));
        assertEquals(1, map.size());
    }

    @Test
    void testRemove_sameHashRemoveThirdElement() {

        Node<String, String> expectedNode1 = new Node<>("key1", "Value1", null);
        Node<String, String> expectedNode2 = new Node<>("key2", "Value2", null);
        Node<String, String> expectedNode4 = new Node<>("key4", "Value4", null);
        Node[] expectedTable = new Node[256];
        expectedNode1.setNext(expectedNode2);
        expectedNode2.setNext(expectedNode4);
        expectedTable[107] = expectedNode1;
        Map<String, String> expectedMap = new HashMap(3, 256, expectedTable);

        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "Value1");
        map.put("key2", "Value2");
        map.put("key3", "Value3");
        map.put("key4", "Value4");

        assertEquals("Value3", map.remove("key3"));
        assertEquals(3, map.size());
        assertEquals(expectedNode1, map.getTable()[107]);
        assertEquals(expectedNode2, map.getTable()[107].getNext());
        assertEquals(expectedNode4, map.getTable()[107].getNext().getNext());
        assertNull(map.getTable()[107].getNext().getNext().getNext());
        assertEquals(expectedMap, map);
    }

    @Test
    void testRemove_sameHashRemoveFirstElement() {

        //      Node<String, String> expectedNode1 = new Node<>("key1", "Value1", null);
        Node<String, String> expectedNode2 = new Node<>("key2", "Value2", null);
        Node<String, String> expectedNode3 = new Node<>("key3", "Value3", null);
        Node<String, String> expectedNode4 = new Node<>("key4", "Value4", null);
        Node[] expectedTable = new Node[256];
        expectedNode2.setNext(expectedNode3);
        expectedNode3.setNext(expectedNode4);
        expectedTable[107] = expectedNode2;
        Map<String, String> expectedMap = new HashMap(3, 256, expectedTable);

        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "Value1");
        map.put("key2", "Value2");
        map.put("key3", "Value3");
        map.put("key4", "Value4");

        assertEquals("Value1", map.remove("key1"));
        assertEquals(3, map.size());
        assertEquals(expectedNode2, map.getTable()[107]);
        assertEquals(expectedNode3, map.getTable()[107].getNext());
        assertEquals(expectedNode4, map.getTable()[107].getNext().getNext());
        assertNull(map.getTable()[107].getNext().getNext().getNext());
        assertEquals(expectedMap, map);
    }

    @Test
    void testRemove_sameHashRemoveLastElement() {

        Node<String, String> expectedNode1 = new Node<>("key1", "Value1", null);
        Node<String, String> expectedNode2 = new Node<>("key2", "Value2", null);
        Node<String, String> expectedNode3 = new Node<>("key3", "Value3", null);
  //      Node<String, String> expectedNode4 = new Node<>("key4", "Value4", null);
        Node[] expectedTable = new Node[256];
        expectedNode1.setNext(expectedNode2);
        expectedNode2.setNext(expectedNode3);
        expectedTable[107] = expectedNode1;
        Map<String, String> expectedMap = new HashMap(3, 256, expectedTable);

        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "Value1");
        map.put("key2", "Value2");
        map.put("key3", "Value3");
        map.put("key4", "Value4");

        assertEquals("Value4", map.remove("key4"));
        assertEquals(3, map.size());
        assertEquals(expectedNode1, map.getTable()[107]);
        assertEquals(expectedNode2, map.getTable()[107].getNext());
        assertEquals(expectedNode3, map.getTable()[107].getNext().getNext());
        assertNull(map.getTable()[107].getNext().getNext().getNext());

        assertEquals(expectedMap, map);
    }


}