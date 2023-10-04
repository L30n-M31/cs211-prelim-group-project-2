/**
 * @author: Leung, Leonhard
 * Date: 10/04/2023
 */

package list;

import java.util.NoSuchElementException;

public class LinkedList<T> implements ListTemplate<T> {
    private Node<T> head;
    private int size = 0;

    @Override
    public int size() {
        return size;
    } // end of size method

    @Override
    public T get(int index) throws NoSuchElementException {
        Node<T> currentCurr = head;
        for (int i = 0; i < size(); i++) {
            if (i == index)
                return currentCurr.getData();
            currentCurr = currentCurr.getNext();
        }
        throw new NoSuchElementException();
    } // end of get method

    @Override
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> currentCurr = head;
            while (currentCurr.getNext() != head)
                currentCurr = currentCurr.getNext();

            currentCurr.setNext(newNode);
            newNode.setPrevious(currentCurr);
        }
        newNode.setNext(head);
        head.setPrevious(newNode);
        size++;
    } // end of add method

    @Override
    public boolean remove(T data) {
        Node<T> currentCurr = head;
        Node<T> previousCurr = head.getPrevious();

        do {
            if (currentCurr.getData().equals(data)) {
                if (previousCurr == head.getPrevious()) {
                    if (currentCurr.getNext() == head)
                        head = null;
                    else {
                        head = currentCurr.getNext();
                        Node<T> lastNode = head;
                        while (lastNode.getNext() != currentCurr)
                            lastNode = lastNode.getNext();

                        lastNode.setNext(head);
                        head.setPrevious(lastNode);
                    }
                } else {
                    previousCurr.setNext(currentCurr.getNext());
                    currentCurr.getNext().setPrevious(previousCurr);
                }
                size--;
                return true;
            }
            previousCurr = currentCurr;
            currentCurr = currentCurr.getNext();
        } while (currentCurr != head);
        return false;
    } // end of remove method

    @Override
    public void update(T currData, T newData) {
        Node<T> currentCurr = head;
        do {
            if (head.getData() == currData) {
                head.setData(newData);
            }
            if (currentCurr.getData() == currData) {
                currentCurr.setData(newData);
            }
            currentCurr = currentCurr.getNext();
        } while (currentCurr != head);
    } // end of update method
} // end of LinkedList class
