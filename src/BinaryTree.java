import java.util.*;
import java.util.function.Consumer;

public class BinaryTree<T extends Comparable<T>> {

    private static class Node<T> {
        final T value;
        Node<T> left;
        Node<T> right;

        Node(T value) {
            this.value = value;
        }

    }

    private Node<T> root = null;
    private int size;


    public BinaryTree(T array[]) {
        size = 0;
        for (T anArray : array)
            add(anArray);


    }


    public BinaryTree() {
        size = 0;
    }


    private void add(Node<T> node, T t) {
        if (t.compareTo(node.value) > 0)
            if (node.right == null)
                node.right = new Node<T>(t);
            else
                add(node.right, t);
        else {
            if (node.left == null)
                node.left = new Node<T>(t);
            else
                add(node.left, t);
        }
    }

    public void add(T t) {
        if (root == null)
            root = new Node<T>(t);
        else if (t.compareTo(root.value) > 0) {
            if (root.right == null)
                root.right = new Node<T>(t);
            else
                add(root.right, t);
        } else {
            if (root.left == null)
                root.left = new Node<T>(t);
            else
                add(root.left, t);
        }
        size++;


    }


    public class BinaryTreeIterator implements Iterator<T> {
        private Node<T> currentNode = null;
        private int counter;
        private Node<T> result;
        private boolean mustGoBack;
        private Deque<Node<T>> pastRoots;


        private BinaryTreeIterator() {
            pastRoots = new ArrayDeque<>();
            currentNode = root;
            counter = size;
        }


        private Node<T> findNext() {
            result = currentNode;
            if (!mustGoBack && currentNode.left != null) {
                pastRoots.add(currentNode);
                currentNode = currentNode.left;
                return findNext();
            } else if (currentNode.right != null) {
                currentNode = currentNode.right;
                mustGoBack = false;
            } else {
                currentNode = pastRoots.pollLast();
                mustGoBack = true;
            }
            counter--;
            return result;
        }


        @Override
        public boolean hasNext() {
            return counter != 0;
        }

        @Override
        public T next() {
            findNext();
            if (result == null) throw new NoSuchElementException();
            return result.value;
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {

        }
    }

    public Iterator<T> iterator() {
        return new BinaryTreeIterator();
    }

    public int size() {
        return size;
    }


}



