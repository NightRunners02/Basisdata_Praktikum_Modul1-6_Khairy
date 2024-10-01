package Basisdatapraktikum.Modul5.Praktikum.Praktikum1;

import java.util.Scanner;

class TreeNode {
    String key;
    TreeNode left, right;

    public TreeNode(String item) {
        key = item;
        left = right = null;
    }
}

class BinaryTree {
    TreeNode root;

    BinaryTree() {
        root = null;
    }

    void insert(String key) {
        root = insertRec(root, key);
    }

    TreeNode insertRec(TreeNode root, String key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        if (key.compareTo(root.key) < 0)
            root.left = insertRec(root.left, key);
        else if (key.compareTo(root.key) > 0)
            root.right = insertRec(root.right, key);

        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    void preorder() {
        preorderRec(root);
    }

    void preorderRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    void postorder() {
        postorderRec(root);
    }

    void postorderRec(TreeNode root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    TreeNode find(TreeNode root, String key) {
        if (root == null || root.key.equals(key))
            return root;

        if (root.key.compareTo(key) > 0)
            return find(root.left, key);

        return find(root.right, key);
    }

    TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    TreeNode findMax(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    TreeNode successor(TreeNode root, String key) {
        TreeNode current = find(root, key);

        if (current == null)
            return null;

        if (current.right != null)
            return findMin(current.right);

        TreeNode successor = null;
        TreeNode ancestor = root;
        while (ancestor != current) {
            if (current.key.compareTo(ancestor.key) < 0) {
                successor = ancestor;
                ancestor = ancestor.left;
            } else {
                ancestor = ancestor.right;
            }
        }
        return successor;
    }

    TreeNode predecessor(TreeNode root, String key) {
        TreeNode current = find(root, key);

        if (current == null)
            return null;

        if (current.left != null)
            return findMax(current.left);

        TreeNode predecessor = null;
        TreeNode ancestor = root;
        while (ancestor != current) {
            if (current.key.compareTo(ancestor.key) > 0) {
                predecessor = ancestor;
                ancestor = ancestor.right;
            } else {
                ancestor = ancestor.left;
            }
        }
        return predecessor;
    }

    boolean isAncestor(TreeNode root, String ancestor, String node) {
        if (root == null)
            return false;

        if (root.key.equals(ancestor)) {
            return find(root, node) != null;
        }

        return isAncestor(root.left, ancestor, node) || isAncestor(root.right, ancestor, node);
    }

    void printTree(TreeNode node, String prefix, boolean isLeft) {
        if (node != null) {
            String position = (node == root) ? " (root)" : (isLeft ? " (L)" : " (R)");
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + node.key + position);
            printTree(node.left, prefix + (isLeft ? "|   " : "    "), true);
            printTree(node.right, prefix + (isLeft ? "|   " : "    "), false);
        }
    }

    void displayTree() {
        printTree(root, "", false);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements to create binary tree (enter 'done' to finish):");
        while (true) {
            String input = sc.nextLine();
            if (input.equals("done"))
                break;
            tree.insert(input);
        }

        System.out.println("Binary Tree:");
        tree.displayTree();

        System.out.println("Inorder traversal:");
        tree.inorder();
        System.out.println("\nPreorder traversal:");
        tree.preorder();
        System.out.println("\nPostorder traversal:");
        tree.postorder();

        System.out.println("\nEnter node to find its predecessor:");
        String predNode = sc.nextLine();
        TreeNode pred = tree.predecessor(tree.root, predNode);
        if (pred != null)
            System.out.println("Predecessor of " + predNode + " is " + pred.key);
        else
            System.out.println(predNode + " has no predecessor.");

        System.out.println("Enter node to find its successor:");
        String succNode = sc.nextLine();
        TreeNode succ = tree.successor(tree.root, succNode);
        if (succ != null)
            System.out.println("Successor of " + succNode + " is " + succ.key);
        else
            System.out.println(succNode + " has no successor.");

        System.out.println("Enter ancestor and node to check if it is an ancestor (format: ancestor node):");
        String[] ancestorInput = sc.nextLine().split(" ");
        if (ancestorInput.length == 2 && tree.isAncestor(tree.root, ancestorInput[0], ancestorInput[1]))
            System.out.println(ancestorInput[0] + " is an ancestor of " + ancestorInput[1]);
        else
            System.out.println(ancestorInput[0] + " is not an ancestor of " + ancestorInput[1]);

        sc.close();
    }
}

