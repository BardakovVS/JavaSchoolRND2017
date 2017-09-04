package homeWork.homeWork4;


import java.io.IOException;
import java.util.AbstractCollection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;


public class LinkedList<E> extends AbstractCollection<E> /*implements Iterator<E>*/ {


    private static class OneNode<T> {
        OneNode<T> prev;
        T element;
        OneNode<T> next;

        public OneNode(OneNode<T> prev, T element, OneNode<T> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }

    private OneNode<E> head;
    private OneNode<E> end;
    private int size = 0;
    private int modification = 0;

    public LinkedList() {
        head = new OneNode<E>(null, null, null);
        end = head;
    }

    public boolean add(E element) {
        end = new OneNode<E>(end, element, null);
        end.prev.next = end;
        size++;
        modification++;
        return true;
    }

    public void add(int index, E element) throws IOException {
        OneNode<E> currentElement = this.getElement(index);
        currentElement.prev = currentElement.prev.next = new OneNode<E>(currentElement.prev, element, currentElement);
        size++;
        modification++;
    }

    private Boolean indexInBounds(int index) {
        if ((index > size - 1) || (index < 0)) {
            return false;
        } else {
            return true;
        }
    }

    private OneNode<E> getElement(int index) throws IOException {
        if (indexInBounds(index) || (size == index)) {
            OneNode<E> currentElement;
            if (size / 2 < index) {
                currentElement = end;
                for (int i = 0; i < size - 1 - index; i++) {
                    currentElement = currentElement.prev;
                }
            } else {
                currentElement = head;
                for (int i = 0; i <= index; i++) {
                    currentElement = currentElement.next;
                }
            }
            return currentElement;
        } else {
            //return null;
            throw new IndexOutOfBoundsException("Index = " + index + " вне границ: [0," + (size - 1) + "]");
        }
    }

    public void remove(int index) throws IOException {
        if ((indexInBounds(index)) || (size == index)) {
            OneNode<E> currentElement = this.getElement(index);
            if (currentElement == end) {
                currentElement.prev.next = null;
                end = currentElement.prev;
                size--;
            } else {
                currentElement.prev.next = currentElement.next;
                currentElement.next.prev = currentElement.prev;
                size--;
            }
             modification ++;
        } else {
            throw new IndexOutOfBoundsException("Удаление не возможно, " +
                    "Index = " + index + " вне границ: [0," + (size - 1) + "]");
        }
    }

    public E get(int index) throws IOException {
        return this.getElement(index).element;
    }


    public String toString() {
        String result = "[";
        OneNode<E> currentElement = head;
        while (currentElement.next != null) {
            currentElement = currentElement.next;
            result += currentElement.element.toString() + " ";
        }
        if (result.length() > 1) {
            result = result.substring(0, result.length() - 1) + "]";
        } else {
            result += "]";
        }
        return result.toString();
    }


    @Override
    public Iterator<E> iterator() {
        this.modification = 0;
        return new Iterator<E>() {

            //private int iteratorModification = 0;
            OneNode<E> currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode.next != null;
            }

            @Override
            public E next() {
                if (modification !=0) {
                    throw new ConcurrentModificationException("Modification during iterator!");
                }
                currentNode = currentNode.next;
                return currentNode.element;
            }

        };
    }

    @Override
    public int size() {
        return size;
    }



}






















