package Basisdatapraktikum.Modul4.Codelab.Codelab1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

 @SuppressWarnings("unused")
class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> inventori = new HashMap<>();
        inventori.put("Pensil", 50);
        inventori.put("Buku", 35);
        inventori.put("Penghapus", 25);

        System.out.println("Inventori awal: " + inventori);

        inventori.put("Pensil", inventori.get("Pensil") + 20);
        inventori.remove("Penghapus");

        System.out.println("Inventori setelah update: " + inventori);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Masukkan nama barang yang ingin dicari: ");
            String barang = scanner.nextLine();

            cariBarang(inventori, barang);
        }
    }

    public static void cariBarang(HashMap<String, Integer> inventori, String barang) {
        if (inventori.containsKey(barang)) {
            System.out.println("Stok barang: " + inventori.get(barang) + " unit.");
        } else {
            System.out.println("Barang tidak tersedia di inventori.");
        }
    }
}
