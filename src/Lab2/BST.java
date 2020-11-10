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

    public Node searchNodeBeforeTarget(Node node, int x) {
        if (node == null) {
           return null;
        } else if (node.left == null && node.right == null) {
            return node;
        }

        if (node.left == null && node.right != null) {
            if (x == node.right.key) {
                return node;
            } else {
                return searchNodeBeforeTarget(node.right, x);
            }
        } else if (node.left != null && node.right == null) {
            if (x == node.left.key) {
                return node;
            } else {
                return searchNodeBeforeTarget(node.left, x);
            }
        } else {
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
    }

    public Node searchNodeBeforeHighestAfterTargetNode(Node node, int x) {
                    /* 10 -> 15 -> 5 -> 12 -> 20 -> 7 -> 2 -> 6 -> 8
                     10
                5            15
             2     7      12    20
                 6   8
         */

        if (node == null) { // Noden är tom
            return null;
        } else if (node.left == null && node.right == null) { // Inga barn alls
            return node;
        }

        if (node.left == null) { //Inga vänster barn
            if (node.right.right == null) {
                return node;
            } else {
                return searchNodeBeforeHighestAfterTargetNode(node.right, x);
            }
        } else if ( node.right == null) { // Inga höger barn
            if (node.left.right == null) {
                return node;
            } else if (node.left.right.right != null){
                return searchNodeBeforeHighestAfterTargetNode(node.left.right, x);
            }
        } else { // två barn
            if (x > node.key) {
                if (node.right.right != null) {
                    searchNodeBeforeHighestAfterTargetNode(node.right, x);
                } else {
                    return node;
                }
            } else if (x < node.key) {
                if (node.left.right == null) {
                    return node;
                } else if (node.left.right.right != null){
                    return searchNodeBeforeHighestAfterTargetNode(node.left.right, x);
                }
            }
        }
        return node;
    }



    public void removeRemove(Node node, int x) {
        Node nodeBeforeTheTarget = searchNodeBeforeTarget(node, x);
        Node nodeBeforeHighestAfterTargetNode = searchNodeBeforeHighestAfterTargetNode(nodeBeforeTheTarget, x);
        System.out.println(nodeBeforeTheTarget.key);
        System.out.println(nodeBeforeHighestAfterTargetNode.key);
    }

    public void removeRemove(int x) {
        removeRemove(root, x);
    }


    public void newRemove(Node node, int x) {
        Node nodeBeforeTheTarget = searchNodeBeforeTarget(node, x);
        boolean targetIsleftChildren = false;
        boolean targetIsRightChildren = false;
        if (nodeBeforeTheTarget.left != null) {
            if (x == nodeBeforeTheTarget.left.key) {
                targetIsleftChildren = true;
            }
        }
        if (nodeBeforeTheTarget.right != null) {
            if (x == nodeBeforeTheTarget.right.key) {
                targetIsRightChildren = true;
            }
        }

        boolean targetHasRightChildren = false;
        boolean targetHasLeftChildren = false;

        if (targetIsleftChildren) { // Target node is the left children
            // Check if target has children
            if (nodeBeforeTheTarget.left.left != null) {
                targetHasLeftChildren = true;
            }
            if (nodeBeforeTheTarget.left.right != null) {
                targetHasRightChildren = true;
            }
            if (targetHasLeftChildren && targetHasRightChildren) { // target has two children
                nodeBeforeTheTarget.left.left.right = nodeBeforeTheTarget.left.right;
                nodeBeforeTheTarget.left = nodeBeforeTheTarget.left.left;
            } else if (targetHasLeftChildren) { // Target has only one children which is left
                nodeBeforeTheTarget.left = nodeBeforeTheTarget.left.left;
            } else if (targetHasRightChildren) { // Target has only one children which is right
                nodeBeforeTheTarget.left = nodeBeforeTheTarget.left.right;
            } else { // Target has no children
                nodeBeforeTheTarget.left = null;
            }
        } else if (targetIsRightChildren) { // Target node is the right children
            // Check if target has children
            if (nodeBeforeTheTarget.right.left != null) {
                targetHasLeftChildren = true;
            }
            if (nodeBeforeTheTarget.right.right != null) {
                targetHasRightChildren = true;
            }
            if (targetHasLeftChildren && targetHasRightChildren) { // target has two children
                nodeBeforeTheTarget.right.left.right = nodeBeforeTheTarget.right.right;
                nodeBeforeTheTarget.right = nodeBeforeTheTarget.right.left;
            } else if (targetHasLeftChildren) { // Target has only one children which is left
                nodeBeforeTheTarget.left = nodeBeforeTheTarget.left.left;
            } else if (targetHasRightChildren) { // Target has only one children which is right
                nodeBeforeTheTarget.right = nodeBeforeTheTarget.right.right;
            } else { // Target has no children
                nodeBeforeTheTarget.right = null;
            }
        } else { // Target node is the same as we stand in. probably the root node
            // Check if target has children
            if (nodeBeforeTheTarget.left != null) {
                targetHasLeftChildren = true;
            }
            if (nodeBeforeTheTarget.right != null) {
                targetHasRightChildren = true;
            }
            if (targetHasLeftChildren && targetHasRightChildren) { // target has two children
                nodeBeforeTheTarget.left.left.right = nodeBeforeTheTarget.left.right;
                nodeBeforeTheTarget.left.right = null;
                nodeBeforeTheTarget.key = nodeBeforeTheTarget.left.key;
                nodeBeforeTheTarget.left = nodeBeforeTheTarget.left.left;
            } else if (targetHasLeftChildren) { // Target has only one children which is left
                nodeBeforeTheTarget = nodeBeforeTheTarget.left;
            } else if (targetHasRightChildren) { // Target has only one children which is right
                nodeBeforeTheTarget = nodeBeforeTheTarget.right;
            } else { // Target has no children
                nodeBeforeTheTarget = null;
            }
        }
    }

    public void newRemove(int x) {
        if (x == root.key && root.left == null && root.right == null) {
            root = null;
        } else {
            newRemove(root, x);
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

/*
        System.out.println("-InOrder-");
        bt.traverseInOrder(bt.root);
        System.out.println();


 */
        /* 10 -> 15 -> 5 -> 12 -> 20 -> 7 -> 2 -> 6 -> 8
                     10
                5            15
             2     7      12    20
                 6   8
         */

        bt.removeRemove(7);
/*
        System.out.println("-InOrder-");
        bt.traverseInOrder(bt.root);
        System.out.println();


 */

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
