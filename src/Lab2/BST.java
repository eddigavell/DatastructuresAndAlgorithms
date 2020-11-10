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

    /* 10 -> 15 -> 5 -> 12 -> 20 -> 7 -> 2 -> 6 -> 8
                                10
                           5          15
                        2     7      12   20
                            6   8
    */

    public Node searchNodeBeforeTarget(Node node, int x) {
        if (x == node.left.key || x == node.right.key) {
            return node;
        } else {
            if (x > node.key) {
                return searchNodeBeforeTarget(node.right, x);
            } else if (x < node.key) {
                return searchNodeBeforeTarget(node.left, x);
            } else {
                return node;
            }
        }
    }

    public void newRemove(Node node, int x) {
        Node nodeBeforeTheTarget = searchNodeBeforeTarget(node, x);

        boolean targetIsToleft = (nodeBeforeTheTarget.left.key == x);
        boolean targetIsToRight = (nodeBeforeTheTarget.right.key == x);
        boolean targetRightChildren = false;
        boolean targetLeftChildren = false;

        /* 10 -> 15 -> 5 -> 12 -> 20 -> 7 -> 2 -> 6 -> 8
                                10
                           5          15
                        2     7      12   20
                            6   8
    */

        System.out.println("Node före target: " + nodeBeforeTheTarget.key);
        System.out.println("barn till vänster: " + targetIsToleft);
        System.out.println("barn till höger: " + targetIsToRight);


        if (targetIsToleft) { // Target node is the left children
            // Check if target has children
            if (nodeBeforeTheTarget.left.left != null) {
                targetLeftChildren = true;
            }
            if (nodeBeforeTheTarget.left.right != null) {
                targetRightChildren = true;
            }



            if (targetLeftChildren && targetRightChildren) { // target has two children


            } else if (targetLeftChildren) { // Target has only one children which is left


            } else if (targetRightChildren) { // Target has only one children which is right


            } else { // Target has no children


            }

        } else if (targetIsToRight) { // Target node is the right children
            // Check if target has children
            if (nodeBeforeTheTarget.right.left != null) {
                targetLeftChildren = true;
            }
            if (nodeBeforeTheTarget.right.right != null) {
                targetRightChildren = true;
            }


            if (targetLeftChildren && targetRightChildren) { // target has two children


            } else if (targetLeftChildren) { // Target has only one children which is left


            } else if (targetRightChildren) { // Target has only one children which is right


            } else { // Target has no children


            }

        } else { // Target node is the same as we stand in. probably the root node
            // Check if target has children
            if (nodeBeforeTheTarget.left != null) {
                targetLeftChildren = true;
            }
            if (nodeBeforeTheTarget.right != null) {
                targetRightChildren = true;
            }

            if (targetLeftChildren && targetRightChildren) { // target has two children


            } else if (targetLeftChildren) { // Target has only one children which is left


            } else if (targetRightChildren) { // Target has only one children which is right


            } else { // Target has no children


            }
        }
        System.out.println("Target children left: " + targetLeftChildren);
        System.out.println("Target children right: " + targetRightChildren);

        if (nodeBeforeTheTarget.left == null && nodeBeforeTheTarget.right == null) {
            nodeBeforeTheTarget = null;
        } else if (nodeBeforeTheTarget.left == null) {
            nodeBeforeTheTarget = nodeBeforeTheTarget.right;
        } else if (nodeBeforeTheTarget.right == null) {
            nodeBeforeTheTarget = nodeBeforeTheTarget.left;
        } else {

            if (nodeBeforeTheTarget.left == null && nodeBeforeTheTarget.right == null) {
                nodeBeforeTheTarget.key = nodeBeforeTheTarget.key;
                nodeBeforeTheTarget.right = null;
            } else if (nodeBeforeTheTarget.left == null) {
                nodeBeforeTheTarget.key = nodeBeforeTheTarget.key;
            }
        }
    }

    private void remove(Node node, int n) {
        if (node != null) { //As long as the node is not null.
            if (n == node.key) { //If node key is the same as we send in
                if (node.left == null && node.right == null) { //The node doesnt have kids
                    root = null;
                } else if (node.left == null) { // The node only has one bigger child
                    root = node.right;
                } else if (node.right == null) { // The node only has one smaller child
                    root = node.left;
                } else { // The node has two childrens
                    node.left.left.right = node.left.right;
                    root = node.left;
                    root.right = node.right;
                }
            } else if (n < node.key) { // our target to remove is smaller than current node.key
                if (node.left != null) {
                    if (n == node.left.key) {
                        if (node.left.left != null) {
                            node.left.left.right = node.left.right;
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
                            node.right.left.right = node.right.right;
                            node.right = node.right.left;
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

    public void traversePreOrder(Node tree) { // NLR
        // 10 -> 5 -> 2 -> 7 -> 6 -> 8 -> 15 -> 12 -> 20
        if (tree != null) {
            System.out.println(tree.key);
            traversePreOrder(tree.left);
            traversePreOrder(tree.right);
        }
    }

    public void traverseInOrder(Node tree) { // LNR
        // 2 -> 5 -> 6 -> 7 -> 8 -> 10 -> 12 -> 15 -> 20
        if (tree != null) {
            traverseInOrder(tree.left);
            System.out.println(tree.key);
            traverseInOrder(tree.right);
        }
    }

    public void traverseReverseInOrder(Node tree) { // RNL
        // 20 -> 15 -> 12 -> 10 -> 8 -> 7 -> 6 -> 5 -> 2
        if (tree != null) {
            traverseReverseInOrder(tree.right);
            System.out.println(tree.key);
            traverseReverseInOrder(tree.left);
        }
    }

    public void traversePostOrder(Node tree) { // LRN
        // 2 -> 6 -> 8 -> 7 -> 5 -> 12 -> 20 -> 15 -> 10
        if (tree != null) {
            traversePostOrder(tree.left);
            traversePostOrder(tree.right);
            System.out.println(tree.key);
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

        //System.out.println("-InOrder-");
        //bt.traverseInOrder(bt.root);
        //System.out.println();

        /*
                     10
                5            15
             2     7      12    20
                 6   8
         */

        bt.newRemove(bt.root, 7);

        //System.out.println("-InOrder-");
        //bt.traverseInOrder(bt.root);
        //System.out.println();


        /*
        System.out.println("-PreOrder-");
        bt.traversePreOrder(bt.root);
        System.out.println();
        System.out.println("-InOrder-");
        bt.traverseInOrder(bt.root);
        System.out.println();
        System.out.println("-ReverseInOrder-");
        bt.traverseReverseInOrder(bt.root);
        System.out.println();
        System.out.println("-PostOrder-");
        bt.traversePostOrder(bt.root);
        System.out.println();

         */
    }
}
