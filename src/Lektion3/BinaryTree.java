package Lektion3;

public class BinaryTree { //BST -> Binära sökträd
    Node root;

    class Node {
        Node left;
        Node right;
        int key;

        Node(int key) {
            this.key = key;
        }
    }

    private Node insertRec(Node tree, int key) {
        if (tree == null) {
            tree = new Node(key);
            return tree;
        } else if (key < tree.key) {
            tree.left = insertRec(tree.left, key);
        } else if (key > tree.key) {
            tree.right = insertRec(tree.right, key);
        }
        return tree;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    public void printInOrderLeft() { //printInOrderLeft -> Low to High (left to right)
        printInOrderLeft(root);
    }

    private void printInOrderLeft(Node tree) {
        if (tree == null) {
            return;
        }
        printInOrderLeft(tree.left);
        System.out.println(tree.key);
        printInOrderLeft(tree.right);
    }

    public void printInOrderRight() { // printInOrderRight -> High to Low (Right to left)
        printInOrderRight(root);
    }

    private void printInOrderRight(Node tree) {
        if (tree == null) {
            return;
        }
        printInOrderRight(tree.right);
        System.out.println(tree.key);
        printInOrderRight(tree.left);
    }


    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        //5, 6, 4, 7, 3, 8, 2, 9, 1, 10, 0
        bt.insert(5);
        bt.insert(6);
        bt.insert(4);
        bt.insert(7);
        bt.insert(3);
        bt.insert(8);
        bt.insert(2);
        bt.insert(9);
        bt.insert(1);
        bt.insert(10);
        bt.insert(0);

        System.out.println("Left to right: ");
        bt.printInOrderLeft();
        System.out.println();
        System.out.println("Right to left: ");
        bt.printInOrderRight();
    }
}
