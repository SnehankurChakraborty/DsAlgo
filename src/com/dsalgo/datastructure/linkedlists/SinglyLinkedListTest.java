package com.dsalgo.datastructure.linkedlists;

public class SinglyLinkedListTest {
    public static void main(String[] args) {

        /* Part 1: Create, add and remove nodes*/
        // Create a singly linked list
        SinglyLinkedList linkedList = new SinglyLinkedList(0);
        linkedList
                // Insert node at end
                .insertAtEnd(1)
                .insertAtEnd(2)
                // Insert node at start
                .insertAtStart(-1)
                // Insert node at specific position
                .insertAtPos(20, 1)
                .insertAtPos(15, 4)
                .insertAtEnd(30);

        // Print contents of list
        linkedList.display();

        // Print length of list
        System.out.println(linkedList.length());

        // Delete node from first
        System.out.println(linkedList.deleteFirst());
        linkedList.display();

        // Delete node from end
        System.out.println(linkedList.deleteLast());
        linkedList.display();

        // Delete node at given position
        System.out.println(linkedList.deleteAtPos(1));
        linkedList.display();

        // Find element in list
        System.out.println(linkedList.exists(1));

        //Reverse the list
        linkedList.reverse();
        linkedList.display();

        // Find middle node
        System.out.println(linkedList.middleNode());

        //Find nth node of list
        System.out.print(linkedList.nthNodeFromEnd(5));


        /* Part 2: Operations on sorted arrays*/
        //Remove duplicates from sorted list
        SinglyLinkedList sortedLinkedList = new SinglyLinkedList(0);
        sortedLinkedList
                .insertAtEnd(1)
                .insertAtEnd(1)
                .insertAtEnd(2)
                .insertAtEnd(2)
                .insertAtEnd(3);
        sortedLinkedList.removeDuplicates();
        sortedLinkedList.display();

        //Find loop in sorted linked list
        SinglyLinkedList loopedList = new SinglyLinkedList();
        SinglyLinkedList.Node nodeA = new SinglyLinkedList.Node(1);
        SinglyLinkedList.Node nodeB = new SinglyLinkedList.Node(2);
        SinglyLinkedList.Node nodeC = new SinglyLinkedList.Node(3);
        SinglyLinkedList.Node nodeD = new SinglyLinkedList.Node(4);
        SinglyLinkedList.Node nodeE = new SinglyLinkedList.Node(5);
        SinglyLinkedList.Node nodeF = new SinglyLinkedList.Node(6);
        SinglyLinkedList.Node nodeG = new SinglyLinkedList.Node(7);
        nodeA.setNext(nodeB);
        nodeB.setNext(nodeC);
        nodeC.setNext(nodeD);
        nodeD.setNext(nodeE);
        nodeE.setNext(nodeF);
        nodeF.setNext(nodeG);
        nodeG.setNext(nodeC);
        loopedList.setHead(nodeA);
        System.out.print(loopedList.findLoopStartNode());


        /*Part3: Operations with two arrays*/
        SinglyLinkedList sortedListA = new SinglyLinkedList(1);
        sortedListA
                .insertAtEnd(3)
                .insertAtEnd(5)
                .insertAtEnd(7)
                .insertAtEnd(9);

        SinglyLinkedList sortedListB = new SinglyLinkedList(2);
        sortedListB
                .insertAtEnd(4)
                .insertAtEnd(6)
                .insertAtEnd(8);

        // Merge two linked lists in sorted order
        sortedListA.merge(sortedListB);
        sortedListA.display();

        // Add two linked lists
        sortedListA.add(sortedListB);
        sortedListA.display();


    }
}
