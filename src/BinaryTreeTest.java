//import org.junit.Test;
//
//import java.util.Arrays;
//import java.util.Iterator;
//import java.util.Random;
//import java.util.TreeSet;
//
//import static org.junit.Assert.*;
//
//public class BinaryTreeTest {
//
//    @Test
//    public void constructors() {
//        BinaryTree<Integer> binaryTree = new BinaryTree<>();
//        assertEquals(0, binaryTree.size());
//
//        Integer array[] = {1, 2, 3, 4};
//        binaryTree = new BinaryTree<>(array);
//        assertEquals(array.length, binaryTree.size());
//    }
//
//    @Test
//    public void add() {
//        int array[] = {5, 2, 2, 4, 4};
//        BinaryTree<Integer> binaryTree = new BinaryTree<>();
//        for (int anArray : array)
//            binaryTree.add(anArray);
//        assertEquals(binaryTree.size(), array.length);
//
//    }
//
//    @Test
//    public void iterator() {
//        final int ARRAY_SIZE = 100;
//        Integer array[] = new Integer[ARRAY_SIZE];
//        Random random = new Random();
//        for (int i = 0; i < ARRAY_SIZE; i++)
//            array[i] = random.nextInt(10);
//
//
//        Integer rightResult[] = Sorting.mergesortFromInternet(array);
//
//
//        BinaryTree<Integer> binaryTree = new BinaryTree<>(array);
//        Iterator<Integer> iterator = binaryTree.iterator();
//        Integer myResult[] = new Integer[ARRAY_SIZE];
//        int i = 0;
//        while (iterator.hasNext()) {
//            myResult[i] = iterator.next();
//            i++;
//        }
//        assertEquals(true, Arrays.equals(rightResult, myResult));
//    }
//
//    @Test
//    public void compareWithTreeSet() {
//        final int ARRAY_SIZE = 10000;
//        Integer array[] = new Integer[ARRAY_SIZE];
//
//        for (int i = 0; i < ARRAY_SIZE; i++)
//            array[i] = ARRAY_SIZE - i;
//
//        long startTime, endTime;
//
//
//        startTime = System.nanoTime();
//        TreeSet<Integer> treeSet = new TreeSet<>();
//        for (int anArray:array)
//            treeSet.add(anArray);
//        endTime = System.nanoTime();
//        System.out.println("TreeSet \t\t= " + (endTime - startTime));
//
//
//        startTime = System.nanoTime();
//        BinaryTree<Integer> binaryTree = new BinaryTree<>();
//        for (int anArray:array)
//            binaryTree.add(anArray);
//        endTime = System.nanoTime();
//        System.out.println("MyBinaryTree \t= " + (endTime - startTime));
//
//
//    }
//}