package Basisdatapraktikum.Modul5.Codelab.Codelab2;

class Node {

    int data;

    Node left;

    Node right;

    public Node(int data) {
        this.data = data;
    }

}

class BinaryTree {

    public Node root;

    public void addNode(int data) {
        root = addNode(root, new Node(data));
    }

    private Node addNode(Node root, Node newData) {
        if (root == null) {
            root = newData;
            return root;
        }

        if (newData.data < root.data) {
            root.left = addNode(root.left, newData);
        } else {
            root.right = addNode(root.right, newData);
        }

        return root;
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.addNode(20);
        tree.addNode(2);
        tree.addNode(25);
        tree.addNode(37);
        tree.addNode(16);

        System.out.println("\nPre Order: ");
        tree.preOrder(tree.root);

        System.out.println("\nIn Order: ");
        tree.inOrder(tree.root);

        System.out.println("\nPost Order: ");
        tree.postOrder(tree.root);
    }
}
