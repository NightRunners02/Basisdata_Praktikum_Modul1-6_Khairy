package Basisdatapraktikum.UAP;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head;

    public void tambahElemen(int data) {
        Node baru = new Node(data);
        if (head == null) {
            head = baru;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = baru;
        }
    }

    public void cetakList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.tambahElemen(1);
        list.tambahElemen(2);
        list.tambahElemen(3);
        list.cetakList();
    }
}


