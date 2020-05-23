package exercise.containers;

/**
 * Created by efuuxii on 11/25/2016.
 * removeMiddleElement (if even number, remove previous one)
 * singleLinkedList: [ 1 2 3 4 5 6 7 8 9 ]
 * removeMiddleElement -> [ 1 2 3 4 6 7 8 9 ]
 */
public class Exercise2 {
    public static void main(String[] args) {
        SingleLinkedList2<Integer> singleLinkedList = new SingleLinkedList2<>();
        for (int i = 1; i < 10; i++) {
            singleLinkedList.add(i);
        }
        System.out.println(singleLinkedList);
        singleLinkedList.removeMiddleElement();
        System.out.println(singleLinkedList);
    }
}

class SingleLinkedList2<E> {
    private class Node<T> {
        T item;
        Node<T> next;

        Node(T element) {
            this.item = element;
            this.next = null;
        }
    }

    private Node<E> head;

    SingleLinkedList2() {
        clear();
    }

    private void clear() {
        head = null;
    }

    void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> pNode = head;
            while (pNode.next != null) {
                pNode = pNode.next;
            }
            pNode.next = newNode;
        }
    }

    public String toString() {
        Node<E> pNode = head;
        String data = "";
        while (pNode != null) {
            data = data + pNode.item.toString() + " ";
            pNode = pNode.next;
        }
        return "[ " + data + "]";
    }

    void removeMiddleElement() {
        Node<E> pFast = head;
        Node<E> pSlow = head;

        // if empty linked list
        if (head == null) {
            return;
        }

        // if only has one element, remove this element
        if (head.next == null) {
            head = null;
            return;
        }

        // if has two element, remove first element
        if (head.next.next == null) {
            head = head.next;
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (pFast.next != null)
                pFast = pFast.next;
        }

        while (pFast.next != null) {
            pFast = pFast.next;
            if (pFast.next != null) {
                pFast = pFast.next;
                pSlow = pSlow.next;
            }
        }

        pSlow.next = pSlow.next.next;
    }
}

