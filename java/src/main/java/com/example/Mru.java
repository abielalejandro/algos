package com.example;

import java.util.Map;
import java.util.HashMap;

public class Mru<K, V> {

    private int capacity;
    private int length;
    private LinkNode<V> tail;
    private LinkNode<V> head;
    private Map<K, LinkNode<V>> lookup;
    private Map<LinkNode<V>, K> reverseLookup;

    public Mru(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.head = null;
        this.tail = null;
        this.lookup = new HashMap<>();
        this.reverseLookup = new HashMap<>();
    }

    public V get(K key) {
        LinkNode<V> node = this.lookup.get(key);
        if (null == node) {
            return null;
        }

        this.detach(node);
        this.prepend(node);
        return node.val;
    }

    public void update(K key, V value) {
        LinkNode<V> node = this.lookup.get(key);
        if (null == node) {
            node = new LinkNode<V>(value);
            length++;
            this.trimCache();
            this.prepend(node);
            this.lookup.put(key, node);
            this.reverseLookup.put(node, key);
        } else {
            node.val = value;
            this.detach(node);
            this.prepend(node);
        }
    }

    private void trimCache() {
        if (length <= capacity)
            return;

        LinkNode<V> headV = this.head;
        K key = this.reverseLookup.get(this.head);
        this.detach(this.head);
        this.lookup.remove(key);
        this.reverseLookup.remove(headV);
        length--;
    }

    private void prepend(LinkNode<V> node) {
        if (null == head) {
            this.head = node;
            this.tail = node;
            return;
        }

        node.next = this.head;
        this.head.prev = node;
        this.head = node;
    }

    private void detach(LinkNode<V> node) {
        if (null != node.prev) {
            node.prev.next = node.next;
        }

        if (null != node.next) {
            node.next.prev = node.prev;
        }

        if (this.head.equals(node)) {
            this.head = this.head.next;
        }

        if (this.tail.equals(node)) {
            this.tail = this.tail.prev;
        }

        node.next = null;
        node.prev = null;
    }

    public void print() {
        System.out.println("#########");
        LinkNode<V> node = head;
        while (null != node) {
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println("#########");
    }
}