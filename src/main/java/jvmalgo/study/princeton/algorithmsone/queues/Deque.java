package jvmalgo.study.princeton.algorithmsone.queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Corner cases.  Throw the specified exception for the following corner cases:
 * <p>
 * Throw an IllegalArgumentException if the client calls either addFirst() or addLast() with a null argument.
 * Throw a java.util.NoSuchElementException if the client calls either removeFirst() or removeLast when the deque is empty.
 * Throw a java.util.NoSuchElementException if the client calls the next() method in the iterator when there are no more items to return.
 * Throw an UnsupportedOperationException if the client calls the remove() method in the iterator.
 * <p>
 * Performance requirements.  Your deque implementation must support each deque operation (including construction) in constant worst-case time.
 * A deque containing n items must use at most 48n + 192 bytes of memory.
 * Additionally, your iterator implementation must support each operation (including construction) in constant worst-case time.
 */
public class Deque<Item> implements Iterable<Item> {

    private int size = 0;

    private Node<Item> first;
    private Node<Item> last;

    // construct an empty deque
    public Deque() {

    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();
        final Node<Item> f = first;
        final Node<Item> newNode = new Node<>(null, item, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();
        final Node<Item> l = last;
        final Node<Item> newNode = new Node<>(l, item, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        final Node<Item> f = first;
        if (f == null)
            throw new NoSuchElementException();
        final Item element = f.item;
        final Node<Item> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        return element;

    }

    // remove and return the item from the back
    public Item removeLast() {
        final Node<Item> l = last;
        if (l == null) throw new NoSuchElementException();
        final Item element = l.item;
        final Node<Item> prev = l.prev;
        l.item = null;
        l.prev = null;
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        return element;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new Iterator<>() {
            Node<Item> cursor = first;
            int index = 0;

            public boolean hasNext() {
                return cursor != null;
            }

            public Item next() {
                if (cursor == null) throw new NoSuchElementException();
                Item item = cursor.item;
                cursor = cursor.next;
                index++;
                return item;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    /**
     * why must i add this ?
     */
    public static void main(String[] args) {
        // why must i add this ?
    }

    private static class Node<Item> {
        Item item;
        Node<Item> next;
        Node<Item> prev;

        Node(Node<Item> prev, Item element, Node<Item> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
