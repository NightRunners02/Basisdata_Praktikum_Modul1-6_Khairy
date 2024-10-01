package Basisdatapraktikum.Modul5.Praktikum.Praktikum2;

import java.util.Scanner;

class Book {
    int isbn;
    String title;
    Book left, right;

    public Book(int isbn, String title) {
        this.isbn = isbn;
        this.title = title;
        left = right = null;
    }
}

class BookInventory {
    Book root;

    BookInventory() {
        root = null;
    }

    void addBook(int isbn, String title) {
        root = insertBook(root, isbn, title);
    }

    Book insertBook(Book root, int isbn, String title) {
        if (root == null) {
            root = new Book(isbn, title);
            return root;
        }

        if (isbn < root.isbn)
            root.left = insertBook(root.left, isbn, title);
        else if (isbn > root.isbn)
            root.right = insertBook(root.right, isbn, title);

        return root;
    }

    void inorderTraversal(Book root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.println(root.isbn + " " + root.title);
            inorderTraversal(root.right);
        }
    }

    void preorderTraversal(Book root) {
        if (root != null) {
            System.out.println(root.isbn + " " + root.title);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    void postorderTraversal(Book root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.println(root.isbn + " " + root.title);
        }
    }

    Book searchBook(Book root, int isbn) {
        if (root == null || root.isbn == isbn)
            return root;

        if (root.isbn < isbn)
            return searchBook(root.right, isbn);

        return searchBook(root.left, isbn);
    }

    void addBookFromUserInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Masukkan ISBN buku:");
            int isbn = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.println("Masukkan judul buku:");
            String title = scanner.nextLine();
            addBook(isbn, title);
        }
        System.out.println("Buku berhasil ditambahkan ke inventaris.");
    }

    void searchAndAddBookFromUserInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Masukkan ISBN buku yang ingin dicari atau ditambahkan:");
            int isbn = scanner.nextInt();
            scanner.nextLine(); // consume newline

            Book foundBook = searchBook(root, isbn);
            if (foundBook != null) {
                System.out.println("Buku ditemukan: ISBN = " + foundBook.isbn + ", Judul " + foundBook.title);
            } else {
                System.out.println("Buku dengan ISBN " + isbn + " tidak ditemukan.");
                System.out.println("Masukkan judul buku:");
                String title = scanner.nextLine();
                addBook(isbn, title);
                System.out.println("Buku berhasil ditambahkan ke inventaris.");
            }
        }
    }
}

 class BookInventorySystem {
    public static void main(String[] args) {
        BookInventory inventory = new BookInventory();
        inventory.addBook(123, "Java Programming");
        inventory.addBook(21, "Python Programming");
        inventory.addBook(456, "Data Structures and Algorithms");
        inventory.addBook(143, "Statistics");
        inventory.addBook(789, "Computer Networks");

        System.out.println("Inventaris Buku (terurut berdasarkan ISBN InOrder):");
        inventory.inorderTraversal(inventory.root);

        System.out.println("\nInventaris Buku (PreOrder):");
        inventory.preorderTraversal(inventory.root);

        System.out.println("\nInventaris Buku (PostOrder):");
        inventory.postorderTraversal(inventory.root);

        inventory.searchAndAddBookFromUserInput();

        System.out.println("\nInventaris Buku setelah pencarian dan/atau penambahan:");
        inventory.inorderTraversal(inventory.root);
    }
}

