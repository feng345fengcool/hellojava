package indi.chen.hellojava.basic;

class Node {
    private int value;
    private Node left;
    private Node right;

    public Node() {
        this.value = 0;
    }

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

public class MemoryLeak {
    private static Node binaryTreeCopy(Node root) {
        if (root == null) {
            return null;
        }
        Node copyRoot = new Node(root.getValue());
        copyRoot.setLeft(root.getLeft());
        copyRoot.setRight(root.getRight());
        // 防止内存泄漏
        root.setLeft(null);
        root.setRight(null);
        binaryTreeCopy(root.getLeft());
        binaryTreeCopy(root.getRight());
        // 防止内存泄漏
        root = null;
        return copyRoot;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.setLeft(new Node(2));
        root.setRight(new Node(3));
        MemoryLeak.binaryTreeCopy(root);
    }
}
