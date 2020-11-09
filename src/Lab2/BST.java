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

    public void remove(int n) {
        /*  2. Fortsätt med implementationen av ett binärt sökträd
            a) Lägg till metoder för att ta bort ett element, tänk på fallen:
            1. Noden har inga barn
            2. Noden har ett barn
            3. Noden har två barn
            Tänk också på att ni kan behöva hantera fallet där det som skall tas bort ligger i rot-noden. */
        removeNode(this.root, n);
    }

    public Node removeNode(Node root, int x) {
        if (root == null) {
            return root;
        }
        if (x < root.key) {
            root.left = removeNode(root.left, x);
        } else if (x > root.key) {
            root.right = removeNode(root.right, x);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                int min = minValue(root.right);
                root.key = min;
                root.right = removeNode(root.right,min);
            }
        }
        return root;
    }

    public int minValue(Node node) {
        if (node.left != null) {
            return minValue(node.left);
        } else {
            return node.key;
        }
    }

    public void traversePreOrder() {

    }

    public void traverseInOrder() {

    }

    public void traverseReverseInOrder() {

    }

    public void traversePostOrder() {

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

        bt.printInOrderLeft();

        bt.remove(5);

        bt.printInOrderLeft();

        /*
        System.out.println("Left to right: ");
        bt.printInOrderLeft();
        System.out.println();
        System.out.println("Right to left: ");
        bt.printInOrderRight();
         */
    }
}
