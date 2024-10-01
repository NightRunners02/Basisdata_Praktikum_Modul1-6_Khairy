package Basisdatapraktikum.Modul4.Praktikum.Praktikum1;

import java.util.HashMap;
import java.util.Scanner;

 public class Praktikum1 {
    private HashMap<String, Integer> candidates;

    public Praktikum1() {
        candidates = new HashMap<>();
    }

    public void startVoting() {
        Scanner scanner = new Scanner(System.in);
        boolean votingActive = true;

        System.out.println("Selamat datang di Sistem Voting Online");
        System.out.println("Pilih kandidat yang ingin Anda dukung:");


        candidates.put("Kandidat A", 0);
        candidates.put("Kandidat B", 0);
        candidates.put("Kandidat C", 0);

        while (votingActive) {
            System.out.println("Kandidat A");
            System.out.println("Kandidat B");
            System.out.println("Kandidat C");
            System.out.print("Masukkan nama kandidat (atau ketik 'selesai' untuk keluar): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("selesai")) {
                votingActive = false;
            } else if (candidates.containsKey(input)) {
                candidates.put(input, candidates.get(input) + 1);
                System.out.println("Terima kasih, suara Anda telah direkam.");
            } else {
                System.out.println("Kandidat tidak valid. Silakan pilih kandidat yang sesuai.");
            }
        }

        scanner.close();


        System.out.println("\nHasil Voting:");
        for (String candidate : candidates.keySet()) {
            System.out.println(candidate + ": " + candidates.get(candidate) + " suara");
        }
    }

    public static void main(String[] args) {
        Praktikum1 votingSystem = new Praktikum1();
        votingSystem.startVoting();
    }
}

