package Basisdatapraktikum.Modul2.Codelab.Codelab2;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Codelab2 {
    public static void main(String[] args) {
        Node head = new Node(5);
        Node second = new Node(10);
        head.next = second;
        Node third = new Node(15);
        second.next = third;

        System.out.println("Daftar Angka:");
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }

        System.out.println("Elemen kedua: " + head.next.data);

        head.data = 25;
        System.out.println("Daftar Angka setelah perubahan: ");
        current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }

        head.next = head.next.next;
        System.out.println("Daftar Angka setelah penghapusan:");
        current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
