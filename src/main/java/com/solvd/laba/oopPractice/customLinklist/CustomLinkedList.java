package com.solvd.laba.oopPractice.customLinklist;


public class CustomLinkedList<T> {
    // Node class
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;

    // Constructor
    public CustomLinkedList() {
        this.head = null;
    }

    // Method to insert a new element at the beginning of the linked list
    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    // Method to print the elements of the linked list
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
