package Basisdatapraktikum.Modul2.Praktikum.Praktikum1;

import java.util.ArrayList;
import java.util.Scanner;

public class Praktikum1 {
    private ArrayList<Praktikum1> daftarKontak;
    @SuppressWarnings("unused")
    private Scanner scanner;

    public Praktikum1() {
        daftarKontak = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void tambahKontak(String nama, String nomorTelepon) {
        if (isValidNomorTelepon(nomorTelepon)) {
            Praktikum1 kontak = new Praktikum1();
            daftarKontak.add(kontak);
            System.out.println("Kontak berhasil ditambahkan!");
        } else {
            System.out.println("Nomor telepon tidak valid! Harap masukkan hanya digit.");
        }
    }

    private boolean isValidNomorTelepon(String nomorTelepon) {
        return nomorTelepon.matches("\\d+");
    }

    public void tampilkanKontak() {
        if (daftarKontak.isEmpty()) {
            System.out.println("Daftar kontak masih kosong!");
        } else {
            System.out.println("Daftar Kontak:");
            int counter = 1;
            for (Praktikum1 kontak : daftarKontak) {
                System.out.println(counter + ". " + kontak);
                counter++;
            }
        }
    }

    public void cariKontak(String nama) {
        if (daftarKontak.isEmpty()) {
            System.out.println("Daftar kontak masih kosong!");
            return;
        }
        boolean found = false;
        for (Praktikum1 kontak : daftarKontak) {
            if (kontak.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Kontak ditemukan!");
                System.out.println("Nama: " + kontak.getNama());
                System.out.println("Nomor Telepon: " + kontak.getNomorTelepon());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Kontak tidak ditemukan!");
        }
    }

    private String getNomorTelepon() {
        return null;
    }

    private String getNama() {
        return null;
    }

    public static void main(String[] args) {
        Praktikum1 manager = new Praktikum1();
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
            scanner.nextLine(); // consume newline

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
