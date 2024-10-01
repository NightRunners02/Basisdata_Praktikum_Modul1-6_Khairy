package Basisdatapraktikum.Modul3.Praktikum.Praktikum2;

import java.util.Scanner;

class Ticket {
    private static int count = 0;
    private int ticketNumber;
    private String name;
    private int quantity;

    public Ticket(String name, int quantity) {
        this.ticketNumber = ++count;
        this.name = name;
        this.quantity = quantity;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Ticket Number: " + ticketNumber + ", Name: " + name + ", Quantity: " + quantity;
    }
}

class Node {
    Ticket ticket;
    Node next;

    public Node(Ticket ticket) {
        this.ticket = ticket;
        this.next = null;
    }

    public Node(String url) {
    }

    public void setNext(Node newNode) {
    }

    public Node getNext() {
        return null;
    }

    public String getData() {
        return null;
    }
}

class Queue {
    private Node front;
    private Node rear;

    public Queue() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(Ticket ticket) {
        Node newNode = new Node(ticket);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
    }

    public Ticket dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong");
            return null;
        } else {
            Ticket ticket = front.ticket;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return ticket;
        }
    }

    public Ticket peek() {
        if (isEmpty()) {
            System.out.println("Antrian kosong");
            return null;
        } else {
            return front.ticket;
        }
    }
}

class SistemPemesananTiket {
    private Queue antrianTiket;

    public SistemPemesananTiket() {
        antrianTiket = new Queue();
    }

    public void pesanTiket(String nama, int jumlah) {
        Ticket tiketBaru = new Ticket(nama, jumlah);
        antrianTiket.enqueue(tiketBaru);
        System.out.println("Tiket berhasil dipesan: " + tiketBaru);
    }

    public void tampilkanTiket() {
        if (antrianTiket.isEmpty()) {
            System.out.println("Antrian tiket kosong");
            return;
        }

        Queue antrianSementara = new Queue();
        System.out.println("Daftar tiket yang dipesan:");
        while (!antrianTiket.isEmpty()) {
            Ticket tiket = antrianTiket.dequeue();
            antrianSementara.enqueue(tiket);
            System.out.println(tiket);
        }

        while (!antrianSementara.isEmpty()) {
            antrianTiket.enqueue(antrianSementara.dequeue());
        }
    }

    public void batalkanTiket(int nomorTiket) {
        Queue antrianSementara = new Queue();
        boolean ditemukan = false;
        while (!antrianTiket.isEmpty()) {
            Ticket tiket = antrianTiket.dequeue();
            if (tiket.getTicketNumber() == nomorTiket) {
                System.out.println("Tiket dengan nomor " + nomorTiket + " berhasil dibatalkan.");
                ditemukan = true;
            } else {
                antrianSementara.enqueue(tiket);
            }
        }
        if (!ditemukan) {
            System.out.println("Tiket dengan nomor " + nomorTiket + " tidak ditemukan.");
        }

        while (!antrianSementara.isEmpty()) {
            antrianTiket.enqueue(antrianSementara.dequeue());
        }
    }

    public static void main(String[] args) {
        SistemPemesananTiket sistemPemesanan = new SistemPemesananTiket();
        Scanner scanner = new Scanner(System.in);

        int pilihan;
        do {
            System.out.println("\nSistem Pemesanan Tiket");
            System.out.println("1. Pesan Tiket");
            System.out.println("2. Tampilkan Tiket");
            System.out.println("3. Batalkan Tiket");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama Anda: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan jumlah tiket: ");
                    int jumlah = scanner.nextInt();
                    sistemPemesanan.pesanTiket(nama, jumlah);
                    break;
                case 2:
                    sistemPemesanan.tampilkanTiket();
                    break;
                case 3:
                    System.out.print("Masukkan nomor tiket yang akan dibatalkan: ");
                    int nomorTiket = scanner.nextInt();
                    sistemPemesanan.batalkanTiket(nomorTiket);
                    break;
                case 4:
                    System.out.println("Keluar...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 4);

        scanner.close();
    }
}