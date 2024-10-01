package Basisdatapraktikum.Modul5.Codelab.Codelab1;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    public Node root;

    public BinaryTree() {
        root = null;
    }


    public void addRoot(int data) {
        root = new Node(data);
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }

    public void preorder(Node node) {
        if (node != null) {
            System.out.println(node.data);
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.data);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();


        tree.addRoot(20);
        tree.root.left = new Node(2);
        tree.root.right = new Node(25);
        tree.root.left.left = new Node(37);
        tree.root.left.right = new Node(12);
        tree.root.right.right = new Node(16);

        System.out.println("\nPre Order: ");
        tree.preorder(tree.root);

        System.out.println("\nIn Order: ");
        tree.inOrder(tree.root);

        System.out.println("\nPost Order: ");
        tree.postorder(tree.root);
    }

    public void NewNode(int i) {
    }

    public void preOrder(Node root) {
    }

    public void postOrder(Node root) {
    }

    public void addNode(int i) {
    }
}
