public class BinaryTree<T extends Comparable<T>> {


    private static class Node<T> {
        final T value;
        Node<T> left;
        Node<T> rigth;

        Node(T value) {
            this.value = value;
        }

    }

    private Node<T> root = null;


    private void add(Node<T> node, T t) {
        if (t.compareTo(node.value) > 0)
            if (node.rigth == null)
                node.rigth = new Node<T>(t);
            else
                add(node.rigth, t);
        else {
            if (node.left == null)
                node.left = new Node<T>(t);
            else
                add(node.left, t);
        }
    }


    void add(T t) {
        if (root == null)
            root = new Node<T>(t);
        if (t.compareTo(root.value) > 0) {
            if (root.rigth == null)
                root.rigth = new Node<T>(t);
            else
                add(root.rigth, t);
        } else {
            if (root.left == null)
                root.left = new Node<T>(t);
            else
                add(root.left, t);
        }


    }


    public BinaryTree(T array[]) {
        for (T anArray : array)
            add(anArray);


    }
}



