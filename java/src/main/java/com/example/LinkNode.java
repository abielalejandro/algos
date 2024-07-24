package com.example;

public class LinkNode<T> {
    public T val;
    public LinkNode next;
    public LinkNode prev;

    private LinkNode() {
    }

    public LinkNode(T val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }

    public LinkNode(T val, LinkNode<T> prev, LinkNode<T> next) {
        this.val = val;
        this.prev = prev;
        this.next = prev;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        if (null != this.prev) {
            builder.append(this.prev.val.toString());
        }
        builder.append(",");
        builder.append(this.val.toString());
        builder.append(",");
        if (null != this.next) {
            builder.append(this.next.val);
        }
        builder.append("]");
        return builder.toString();
    }
}
