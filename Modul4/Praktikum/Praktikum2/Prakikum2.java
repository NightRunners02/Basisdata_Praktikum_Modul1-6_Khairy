package Basisdatapraktikum.Modul4.Praktikum.Praktikum2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

 class DataPemilih {
    private HashMap<String, String> users;
    private HashMap<String, ArrayList<String>> userDetails;
    private HashMap<String, Boolean> hasVoted;
    private Scanner scanner;
    private boolean isLoggedIn;
    private String loggedInUserEmail;
    private HashMap<String, Integer> candidates;

    public DataPemilih() {
        users = new HashMap<>();
        userDetails = new HashMap<>();
        hasVoted = new HashMap<>();
        scanner = new Scanner(System.in);
        isLoggedIn = false;
        candidates = new HashMap<>();
        candidates.put("Kandidat A", 0);
        candidates.put("Kandidat B", 0);
        candidates.put("Kandidat C", 0);
    }

    public void register() {
        System.out.println("\nDaftar Akun Baru");
        System.out.print("Masukkan email (format: example@gmail.com): ");
        String email = scanner.nextLine().trim();
        if (!email.endsWith("@gmail.com")) {
            System.out.println("Format email tidak valid.");
            showLoginOrRegisterMenu();
            return;
        }
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine().trim();
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine().trim();
        System.out.print("Masukkan NIK: ");
        String nik = scanner.nextLine().trim();

        if (users.containsKey(email) ||  userDetails.containsKey(nik)) {
            System.out.println("Email atau NIK sudah terdaftar.");
            return;
        }

        ArrayList<String> userDetailsList = new ArrayList<>();
        userDetailsList.add(nama);
        userDetailsList.add(nik);

        users.put(email, password);
        userDetails.put(email, userDetailsList);
        hasVoted.put(email, false);

        System.out.println("Berhasil Mendaftar.");

        showLoginOrRegisterMenu();
    }

    public void login() {
        System.out.println("\nLogin");
        System.out.print("Masukkan email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine().trim();

        if (!users.containsKey(email) || !users.get(email).equals(password)) {
            System.out.println("Gagal Login.");
            showLoginOrRegisterMenu();
            return;
        }

        if (!email.endsWith("@gmail.com")) {
            System.out.println("Gagal Login: Format email tidak valid.");
            showLoginOrRegisterMenu();
            return;
        }

        ArrayList<String> userDetailsList = userDetails.get(email);
        String nama = userDetailsList.get(0);
        String nik = userDetailsList.get(1);

        isLoggedIn = true;
        loggedInUserEmail = email;

        System.out.println("Login Berhasil.");
        System.out.println("Selamat Datang!");
        System.out.println("Nama : " + nama);
        System.out.println("NIK : " + nik);


        if (hasVoted.get(email)) {
            System.out.println("Anda telah memilih kandidat sebelumnya.");
            showLoginOrRegisterMenu();
        } else {
            pemilihan();
        }
    }

    public void pemilihan() {
        if (!isLoggedIn) {
            System.out.println("Anda harus login terlebih dahulu.");
            return;
        }

        System.out.println("\nPilih kandidat yang ingin Anda dukung:");
        for (String candidate : candidates.keySet()) {
            System.out.println("- " + candidate);
        }
        System.out.print("Masukkan nama kandidat (atau ketik 'selesai' untuk keluar): ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("selesai")) {
            logout();
        }

        if (candidates.containsKey(input)) {
            candidates.put(input, candidates.get(input) + 1);
            hasVoted.put(loggedInUserEmail, true); // Set status bahwa pengguna telah memilih
            System.out.println("Terima kasih, suara Anda telah direkam.");
        } else {
            System.out.println("Kandidat tidak valid, silakan coba lagi.");
        }

        showLoginOrRegisterMenu();
    }

    public void logout (){
        System.out.print("Ingin Logout? [y/n]");
        String pilihan = scanner.next();
        if (pilihan.equalsIgnoreCase("y")){
            showLoginOrRegisterMenu();
        }else {
            System.out.println("\nProgram Selesai");
            System.exit(0);
        }
    }

    public void showLoginOrRegisterMenu() {
        System.out.println("\nPilih menu :");
        System.out.println("1. Login");
        System.out.println("2. Daftar");
        System.out.println("3. Hasil Vote");
        System.out.print("Pilihan Anda: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                register();
                break;
            case 3:
                showVoteResult();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    public void showVoteResult() {
        System.out.println("\nHasil Voting:");
        for (String candidate : candidates.keySet()) {
            System.out.println("- " + candidate + ": " + candidates.get(candidate) + " suara");
        }
    }

    public static void main(String[] args) {
        DataPemilih dataPemilih = new DataPemilih();
        System.out.println("Selamat datang di System Voting Online");
        dataPemilih.showLoginOrRegisterMenu();
    }
}
