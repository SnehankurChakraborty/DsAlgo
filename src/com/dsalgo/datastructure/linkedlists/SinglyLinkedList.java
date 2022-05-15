package com.dsalgo.datastructure.linkedlists;

public class SinglyLinkedList {
    private Node head;

    public static class Node {
        private final int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public SinglyLinkedList(int data) {
        this.head = new Node(data);
    }

    public SinglyLinkedList() {
        this.head = null;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int length() {
        int count = 0;
        Node nextNode = this.head;
        while (null != nextNode) {
            count++;
            nextNode = nextNode.next;
        }
        return count;
    }

    public SinglyLinkedList insertAtEnd(int data) {
        Node nextNode = this.head;
        if (null == nextNode) {
            setHead(new Node(data));
            return this;
        }
        while (null != nextNode.next) {
            nextNode = nextNode.next;
        }
        nextNode.next = new Node(data);
        return this;
    }

    public SinglyLinkedList insertAtStart(int data) {
        Node node = new Node(data);
        node.next = this.head;
        this.head = node;
        return this;
    }

    public SinglyLinkedList insertAtPos(int data, int pos) {

        if (pos > this.length() || pos < 0)
            throw new IllegalArgumentException("Invalid position");

        if (pos == 0)
            return this.insertAtStart(data);

        int count = 0;
        Node prevNode = this.head;
        while (null != prevNode && count < pos - 1) {
            count++;
            prevNode = prevNode.next;
        }
        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        return this;
    }

    public int deleteFirst() {
        Node node = this.head;
        this.head = head.next;
        return node.data;
    }

    public int deleteLast() {

        int length = this.length();
        if (length - 1 == 0) {
            return this.deleteFirst();
        }

        Node node = this.head;
        int count = 0;
        while (count < length - 2) {
            count++;
            node = node.next;
        }
        int data = node.next.data;
        node.next = null;
        return data;
    }

    public int deleteAtPos(int pos) {
        int length = this.length();
        if (pos > length || pos < 0)
            throw new IllegalArgumentException("Invalid position");

        if (pos == 0) {
            return this.deleteFirst();
        }

        int count = 0;
        Node node = this.head;
        while (count < pos - 1 && null != node.next) {
            count++;
            node = node.next;
        }
        int data = node.next.data;
        node.next = node.next.next;
        return data;
    }

    public boolean exists(int data) {
        Node node = this.head;
        while (null != node) {
            if (node.data == data) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public SinglyLinkedList reverse() {
        Node node = this.head;
        Node nextNode = node.next;
        node.next = null;
        while (null != nextNode) {
            Node prev = node;
            node = nextNode;
            nextNode = nextNode.next;
            node.next = prev;
        }
        this.head = node;
        return this;
    }

    public void display() {
        Node nextNode = this.head;
        while (null != nextNode) {
            System.out.print(nextNode.data + "-->");
            nextNode = nextNode.next;
        }
        System.out.println("null");
    }

    public int middleNode() {
        Node slow = this.head;
        Node fast = this.head;
        while (null != slow && null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public int nthNodeFromEnd(int n) {

        Node node = this.head;
        while (null != node.next) {
            Node pointer = node;
            int count = n - 1;
            while (null != pointer.next && count >= 0) {
                pointer = pointer.next;
                count--;
            }
            if (count == 0) return node.data;
            else node = node.next;
        }
        return node.data;
    }

    public SinglyLinkedList removeDuplicates() {
        Node node = this.head;
        while (null != node.next) {
            Node nextNode = node.next;
            if (node.data == nextNode.data) {
                node.next = nextNode.next;
            } else {
                node = node.next;
            }
        }
        return this;
    }

    public int findLoopStartNode() {
        Node fast = this.head;
        Node slow = this.head;
        while (null != slow && null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        if (null != fast && null != fast.next) {

            Node temp = this.head;
            while (temp != slow) {
                temp = temp.next;
                slow = slow.next;
            }
            return temp.data;
        }
        throw new IllegalStateException("No loops exist in the linked list");
    }

    public SinglyLinkedList merge(SinglyLinkedList list) {
        Node first = this.head;
        Node second = list.head;
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        while (null != first && null != second) {
            if (first.data > second.data) {
                singlyLinkedList.insertAtEnd(second.data);
                second = second.next;
            } else {
                singlyLinkedList.insertAtEnd(first.data);
                first = first.next;
            }

        }
        this.head = singlyLinkedList.head;
        return this;
    }

    public SinglyLinkedList add(SinglyLinkedList list) {
        Node first = this.head;
        Node second = list.head;
        int carry = 0;
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        while (null != first || null != second || carry > 0) {
            int sum = carry + (null != first ? first.data : 0) + (null != second ? second.data : 0);
            carry = sum / 10;
            singlyLinkedList.insertAtEnd(sum % 10);

            first = null != first ? first.next: null;
            second = null != second ? second.next : null;
        }
        this.head = singlyLinkedList.head;
        return this;
    }
}
