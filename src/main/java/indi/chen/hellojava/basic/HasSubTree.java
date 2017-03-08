package indi.chen.hellojava.basic;

class Knot {
    int value;
    Knot left;
    Knot right;
}

public class HasSubTree {

    public boolean hasSubTree(Knot a, Knot b) {
        if (a == null && b != null || a != null && b == null) {
            return false;
        }
        if (a == null && b == null) {
            return true;
        }
        return hasSubTreeCore(a, b);
    }

    private boolean hasSubTreeCore(Knot a, Knot b) {
        boolean result = false;
        if (a.value == b.value) {
            result = doesTree1HaveAllNodesOfTree2(a, b);
        }
        if (!result && a.left != null) {
            result = hasSubTreeCore(a.left, b);
        }

        if (!result && a.right != null) {
            result = hasSubTreeCore(a.right, b);
        }

        return result;
    }

    boolean doesTree1HaveAllNodesOfTree2(Knot a, Knot b) {
        if (b == null) {
            return true;
        }

        if (a == null) {
            return false;
        }

        if (a.value != b.value) {
            return false;
        }

        return doesTree1HaveAllNodesOfTree2(a.left, b.left)
                && doesTree1HaveAllNodesOfTree2(a.right, b.right);
    }

}
