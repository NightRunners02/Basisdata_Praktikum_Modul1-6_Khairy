package Basisdatapraktikum.Modul2.Praktikum.Praktikum2;

import java.util.Scanner;

class Node {
    String nama;
    String nomorTelepon;
    Node next;

    public Node(String nama, String nomorTelepon) {
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
        this.next = null;
    }
}

public class Praktikum2 {
    private Node head;

    public Praktikum2() {
        head = null;
    }

    public void tambahKontak(String nama, String nomorTelepon) {
        if (isValidNomorTelepon(nomorTelepon)) {
            Node newNode = new Node(nama, nomorTelepon);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            System.out.println("Kontak berhasil ditambahkan!");
        } else {
            System.out.println("Nomor telepon tidak valid! Harap masukkan hanya digit.");
        }
    }

    private boolean isValidNomorTelepon(String nomorTelepon) {

        return nomorTelepon.matches("\\d+");
    }

    public void tampilkanKontak() {
        if (head == null) {
            System.out.println("Daftar kontak masih kosong!");
        } else {
            System.out.println("Daftar Kontak:");
            Node current = head;
            int counter = 1;
            while (current != null) {
                System.out.println(counter + ". " + current.nama + " - " + current.nomorTelepon);
                current = current.next;
                counter++;
            }
        }
    }

    public void cariKontak(String nama) {
        if (head == null) {
            System.out.println("Daftar kontak masih kosong!");
            return;
        }
        Node current = head;
        while (current != null) {
            if (current.nama.equalsIgnoreCase(nama)) {
                System.out.println("Kontak ditemukan!");
                System.out.println("Nama: " + current.nama);
                System.out.println("Nomor Telepon: " + current.nomorTelepon);
                return;
            }
            current = current.next;
        }
        System.out.println("Kontak tidak ditemukan!");
    }

    public static void main(String[] args) {
        Praktikum2 manager = new Praktikum2();
        Scanner scanner = new Scanner(System.in);

        int pilihan;
        do {
            System.out.println("\nSelamat datang di Manajemen Kontak!");
            System.out.println("1. Tambah Kontak");
            System.out.println("2. Tampilkan Kontak");
            System.out.println("3. Cari Kontak");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1/2/3/4): ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("\n-- Tambah Kontak --");
                    System.out.print("Masukkan nama kontak: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan nomor telepon: ");
                    String nomorTelepon = scanner.nextLine();
                    manager.tambahKontak(nama, nomorTelepon);
                    break;
                case 2:
                    System.out.println("\n-- Tampilkan Kontak --");
                    manager.tampilkanKontak();
                    break;
                case 3:
                    System.out.println("\n-- Cari Kontak --");
                    System.out.print("Masukkan nama kontak yang ingin dicari: ");
                    String searchName = scanner.nextLine();
                    manager.cariKontak(searchName);
                    break;
                case 4:
                    System.out.println("\nTerima kasih telah menggunakan Manajemen Kontak!");
                    break;
                default:
                    System.out.println("\nPilihan tidak valid!");
            }
        } while (pilihan != 4);

        scanner.close();
    }
}
