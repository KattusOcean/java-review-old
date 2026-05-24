package UL;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main (String[] args) {
        Queue<String> q = new LinkedList<>();

        q.offer("a");
        q.offer("b");
        q.offer("c");
        q.offer("d");
        q.offer("e");
        q.offer("f");

        // .peek() shows the first element but won't remove it
        // the output will be -> a -> a
        System.out.println("The first element is: " + q.peek());
        System.out.println("The second (first) element is: " + q.peek());

        System.out.println("---------------------------------");

        // .pool() and .remove() shows and removes the actual offer
        // the output will be -> a -> b
        System.out.println("The first element is: " + q.poll());
        System.out.println("The second element is: " + q.peek());
    }
}
