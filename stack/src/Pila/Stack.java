package Pila;
import java.util.ArrayList;
import java.util.EmptyStackException;

import javax.xml.soap.Node;

public class Stack {
    Node top;
    int count = 0;
    ArrayList<Node> stack = new ArrayList<Node>();

    public boolean isEmpty() {
        if (count == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public Node getTop() {
        if (count > 0) {
            return top;
        }
        else {
            return null;
        }
    }

    public void pop() {
        if (count > 0) {
            stack.remove(0);
            count--;
        }
        else {
            throw new EmptyStackException();
        }
    }

    public void push(int data) {
        Node node = new Node(data);
        stack.add(node);
        count++;
    }

    public int size() {
        return count;
    }

}