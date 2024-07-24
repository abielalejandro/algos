package com.example;

public class CustomLinkedList<T> {

    int counter;
    LinkNode<T> tail;
    LinkNode<T> head;

    public CustomLinkedList() {
        counter = 0;
        tail = null;
        head = null;
    }

    public int size() {
        return counter;
    }

    public void clear() {
        tail = null;
        head = null;
        counter = 0;
    }

    public void add(T v) {
        LinkNode<T> node = new LinkNode<T>(v);
        counter++;
        if (null == head) {
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        tail = node;

    }

    public void addFirst(T v) {
        LinkNode<T> node = new LinkNode<T>(v);
        counter++;
        if (null == head) {
            head = node;
            tail = node;
            return;
        }

        node.next = head;
        head = node;

    }

    public void addLast(T v) {
        add(v);
    }

    public void remove(T v) {
        int index = indexOf(v);
        removeAt(index);
    }

    public void removeAt(int index) {
        if (index > counter || index < 0) {
            return;
        }

        if (counter == 0) {
            return;
        }

        if (index == 0) { // Eliminar el head
            head = head.next;
            counter--;
            return;
        }

        LinkNode<T> prev = getAt(index - 1);
        if (null != prev) {
            prev.next = prev.next.next;
            if (null == prev.next) {
                tail = prev;
            }
            counter--;
        }
    }

    public void addAt(T v, int index) {
        if (index > counter || index < 0) {
            throw new RuntimeException("Overflow");
        }

        if (index == counter) {
            addLast(v);
            return;
        }

        if (index == 0) {
            addFirst(v);
            return;
        }

        LinkNode<T> node = new LinkNode<T>(v);
        counter++;
        LinkNode<T> current = getAt(index - 1);
        if (null != current) {
            node.next = current.next;
            current.next = node;
        }
    }

    public LinkNode<T> get(T v) {
        if (counter == 0)
            return null;

        LinkNode<T> current = head;
        while (null != current) {
            if (current.val.equals(v))
                return current;
            current = current.next;
        }

        return current;
    }

    public LinkNode<T> getAt(int index) {
        if (counter == 0 || index < 0 || index >= counter)
            return null;

        LinkNode<T> current = head;
        int i = 0;
        while (null != current) {
            if (index == i)
                return current;
            current = current.next;
            i++;
        }

        return current;
    }

    public int indexOf(T v) {
        if (counter == 0)
            return -1;
        LinkNode<T> current = head;
        int i = 0;
        while (null != current) {
            if (current.val.equals(v))
                return i;
            current = current.next;
            i++;
        }

        return -1;

    }

    public void print() {
        LinkNode<T> current = head;
        while (null != current) {
            System.out.println(current);
            current = current.next;
        }
    }

}
