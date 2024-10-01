package Basisdatapraktikum.Modul1.Praktikum.Praktikum1;

import java.util.Scanner;

enum JenisBarang {
    NASI_KUNING,
    SATE,
    RENDANG
}

class Barang <T, U> {
    private T nama;
    private U harga;
    private JenisBarang jenis;

    public Barang(T nama, U harga, JenisBarang jenis) {
        this.nama = nama;
        this.harga = harga;
        this.jenis = jenis;
    }

    public T getNama() {
        return nama;
    }

    public U getHarga() {
        return harga;
    }

    public JenisBarang getJenis() {
        return jenis;
    }
}

public class Praktikum1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();

            System.out.print("Masukkan Harga: ");
            double harga = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Pilih Jenis Barang:");
            for (JenisBarang jenis : JenisBarang.values()) {
                System.out.println(jenis.ordinal() + ". " + jenis);
            }
            System.out.print("Masukkan pilihan: ");
            int pilihan = scanner.nextInt();

            JenisBarang jenisBarang = JenisBarang.values()[pilihan];

            Barang<String, Double> barang = new Barang<>(nama, harga, jenisBarang);

            System.out.println("Informasi Barang:");
            System.out.println("Nama: " + barang.getNama());
            System.out.println("Harga: " + barang.getHarga());
            System.out.println("Jenis: " + barang.getJenis());
        }
    }
}


