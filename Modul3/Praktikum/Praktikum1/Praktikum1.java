package Basisdatapraktikum.Modul3.Praktikum.Praktikum1;

import java.util.Scanner;

class Node1 {
    String url;
    Node1 next;
    Node1 prev;

    public Node1(String url) {
        this.url = url;
        this.next = null;
        this.prev = null;
    }
}

class BrowserHistory {
    private Node1 current;

    public BrowserHistory() {
        this.current = null;
    }

    public void visitURL(String url) {
        Node1 newNode = new Node1(url);
        if (current != null) {
            current.next = newNode;
            newNode.prev = current;
        }
        current = newNode;
        System.out.println("Visited URL: " + url);
    }

    public void back() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Back to URL: " + current.url);
        } else {
            System.out.println("No previous URL");
        }
    }

    public void forward() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Forward to URL: " + current.url);
        } else {
            System.out.println("No next URL");
        }
    }

    public void getCurrentURL() {
        if (current != null) {
            System.out.println("Current URL: " + current.url);
        } else {
            System.out.println("No URL accessed yet");
        }
    }
}

 class Main {
    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Visit URL");
            System.out.println("2. Back");
            System.out.println("3. Forward");
            System.out.println("4. Current URL");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter URL to visit: ");
                    scanner.nextLine();
                    String url = scanner.nextLine();
                    history.visitURL(url);
                    break;
                case 2:
                    history.back();
                    break;
                case 3:
                    history.forward();
                    break;
                case 4:
                    history.getCurrentURL();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
