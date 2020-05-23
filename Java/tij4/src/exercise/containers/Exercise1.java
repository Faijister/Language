package exercise.containers;

/**
 * @author Leo
 * @since 2016/11/22
 * reverseIndexOf SingleLinkedList
 * singleLinkedList: [ 10 9 8 7 6 5 4 3 2 1 ]
 * reverseIndexOf(7): 7
 */
public class Exercise1 {
    public static void main(String[] args) {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        for (int i = 10; i > 0; i--) {
            singleLinkedList.add(i);
        }
        System.out.println(singleLinkedList);
        int result = singleLinkedList.reversedIndexOf(7);
        System.out.print(result);
    }
}


class SingleLinkedList<E> {
    private class Node<T> {
        T item;
        Node<T> next;

        Node(T element) {
            this.item = element;
            this.next = null;
        }
    }

    private Node<E> head;

    public SingleLinkedList() {
        clear();
    }

    void clear() {
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

    public E reversedIndexOf(int k) {
        Node<E> pNode = head;
        Node<E> pResult = head;
        for (int i = 0; i < k - 1; i++) {
            pNode = pNode.next;
        }
        while (pNode.next != null) {
            pNode = pNode.next;
            pResult = pResult.next;
        }
        return pResult.item;
    }
}