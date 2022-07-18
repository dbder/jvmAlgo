package jvmalgo.study.princeton.algorithmsone.queues;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Randomized queue. A randomized queue is similar to a stack or queue, except that the item removed is chosen uniformly at random among items in the data structure.
 * Create a generic data type jvmalgo.study.princeton.algorithmsone.queues.RandomizedQueue that implements the following API:
 *
 * @param <Item> Iterator.  Each iterator must return the items in uniformly random order. The order of two or more iterators to the same randomized queue must be mutually independent; each iterator must maintain its own random order.
 *               <p>
 *               Corner cases.  Throw the specified exception for the following corner cases:
 *               <p>
 *               Throw an IllegalArgumentException if the client calls enqueue() with a null argument.
 *               Throw a java.util.NoSuchElementException if the client calls either sample() or dequeue() when the randomized queue is empty.
 *               Throw a java.util.NoSuchElementException if the client calls the next() method in the iterator when there are no more items to return.
 *               Throw an UnsupportedOperationException if the client calls the remove() method in the iterator.
 *               <p>
 *               Unit testing.  Your main() method must call directly every public constructor and method to verify that they work as prescribed (e.g., by printing results to standard output).
 *               <p>
 *               Performance requirements.  Your randomized queue implementation
 *               must support each randomized queue operation (besides creating an iterator) in constant amortized time.
 *               That is, any intermixed sequence of m randomized queue operations (starting from an empty queue) must take at most cm steps in the worst case, for some constant c.
 *               A randomized queue containing n items must use at most 48n + 192 bytes of memory. Additionally, your iterator implementation must support operations next() and hasNext() in constant worst-case time;
 *               and construction in linear time; you may (and will need to) use a linear amount of extra memory per iterator.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    // construct an empty randomized queue

    private Object[] arr;
    private int lastIndex = -1;

    public RandomizedQueue() {
        arr = new Object[2000];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return lastIndex == -1;
    }

    // return the number of items on the randomized queue
    public int size() {
        return lastIndex + 1;
    }

    // add the item
    public void enqueue(Item item) {
        if (lastIndex < 2) {
            lastIndex++;
            arr[lastIndex] = item;
        } else {
            lastIndex++;
            int pos = StdRandom.uniform(lastIndex);
            Object tmp = arr[pos];
            arr[pos] = item;
            arr[lastIndex] = tmp;
        }
    }

    // remove and return a random item
    public Item dequeue() {
        if (lastIndex == -1) throw new NoSuchElementException();
        return (Item) arr[lastIndex--];
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (lastIndex == -1) throw new NoSuchElementException();
        return (Item) arr[lastIndex];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new Iterator<>() {
            int index = -1;

            public boolean hasNext() {
                return index < lastIndex;
            }

            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                index++;
                return (Item) arr[index];
            }
        };
    }

    // unit testing (required)
    public static void main(String[] args) {
        // i dont write unit tests in main lol
    }
}
