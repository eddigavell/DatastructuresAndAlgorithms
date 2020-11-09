package Lab2;

public class BST { //BST -> Binära sökträd
    Node root;

    class Node {
        Node left;
        Node right;
        int key;

        Node(int key) {
            this.key = key;
        }
    }

    public void remove(Node node, int n) {
        /*  2. Fortsätt med implementationen av ett binärt sökträd
            a) Lägg till metoder för att ta bort ett element, tänk på fallen:
            1. Noden har inga barn
            2. Noden har ett barn
            3. Noden har två barn
            Tänk också på att ni kan behöva hantera fallet där det som skall tas bort ligger i rot-noden. */
        if (node != null) { //As long as the node isnt null.
            if (n == node.key) { //If nodekey is the same as we send in
                if (node.left == null && node.right == null) { //The node doesnt have kids
                    root = null;
                } else if (node.left == null) { // The node only has one bigger child
                    root = node.right;
                } else if (node.right == null) { // The node only has one smaller child
                    root = node.left;
                } else { // The node has two childrens
                    root = node.left;
                    root.right = node.right;
                }
            } else if (n < node.key) { // our target to remove is smaller than current node.key
                if (node.left!= null) {
                    if (n == node.left.key) {
                        if (node.left.left != null) {
                            node.left = node.left.left;
                        } else {
                            node.left = null;
                        }
                    } else {
                        remove(node.left, n);
                    }
                }
            } else { // our target to remove is bigger than current node.key
                if (node.right != null) {
                    if (n == node.right.key) {
                        if (node.right.right != null) {
                            node.right = node.right.right;
                        } else {
                            node.right = null;
                        }
                    } else {
                        remove(node.right, n);
                    }
                }
            }
        }
    }

    public void remove(int n) {
        remove(root, n);
    }

    /*
            10 -> 15 -> 5 -> 12 -> 20 -> 7 -> 2 -> 6 -> 8
                                      10
                                   5          15
                               2     7      12   20
                                   6   8
    */

    public void traversePreOrder() { // NLR
        // 5 -> 3 -> 1 -> 0 -> 2 -> 4 -> 8 -> 6 -> 7 -> 9 -> 10
    }

    public void traverseInOrder(Node tree) { // LNR
        // 2 -> 5 -> 6 -> 7 -> 8 -> 10 -> 12 -> 15 -> 20
        if (tree == null) {
            return;
        }
        traverseInOrder(tree.left);
        System.out.println(tree.key);
        traverseInOrder(tree.right);
    }

    public void traverseReverseInOrder(Node tree) { // RNL
        // 20 -> 15 -> 12 -> 10 -> 8 -> 7 -> 6 -> 5 -> 2
        if (tree == null) {
            return;
        }
        traverseReverseInOrder(tree.right);
        System.out.println(tree.key);
        traverseReverseInOrder(tree.left);
    }

    public void traversePostOrder() { // LRN
        // 0 ->
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
        BST bt = new BST();
        bt.insert(10);
        bt.insert(15);
        bt.insert(5);
        bt.insert(12);
        bt.insert(20);
        bt.insert(7);
        bt.insert(2);
        bt.insert(6);
        bt.insert(8);

        //bt.traverseInOrder(bt.root);
        //bt.traverseReverseInOrder(bt.root);

    }
}
