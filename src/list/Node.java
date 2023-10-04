/**
 * @author: Leung, Leonhard
 * Date: 10/04/2023
 */

package list;

public class Node<T> {
    private T data;
    private Node<T> next;
    private Node<T> previous;

    public Node(T data) {
        setData(data);
        setNext(null);
        setPrevious(null);
    } // end of constructor

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node<T> node) {
        next = node;
    }

    public void setPrevious(Node<T> node) {
        previous = node;
    }
} // end of Node class
