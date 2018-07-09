import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;


public class SortingTest {
    private final int TEST_DIGIT = 10;
    private final int ARRAYS_SIZE = 10;
    private final int DIGITS_RADIUS = 10;

    private Random random = new Random();
    private HashMap<Integer, ArrayList<Integer>> hashMap = generateHashMap();
    private final int normalize_koef = 10000;

    private boolean BUBBLE_SORT = false;
    private boolean BUBBLE_FROM_INTERENT_SORT = false;
    private boolean INSERTION_SORT = false;
    private boolean MERGE_SORT = true;
    private boolean MERGE_FROM_INTERNET_SORT = true;
    private boolean QUICK_SORT = true;

    private ArrayList<Integer> getRandomArrayList() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < ARRAYS_SIZE; i++)
            arrayList.add(random.nextInt(DIGITS_RADIUS));

        return arrayList;
    }

    private HashMap<Integer, ArrayList<Integer>> generateHashMap() {
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < TEST_DIGIT; i++)
            hashMap.put(i, getRandomArrayList());

        return hashMap;

    }

    private int[] listToArray(ArrayList<Integer> arrayList) {
        int result[] = new int[arrayList.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = arrayList.get(i);
        return result;
    }

    private List<Integer> arrayToList(int array[]) {
        List<Integer> result = new ArrayList<>();
        for (int anArray : array)
            result.add(anArray);
        return result;


    }




    @org.junit.Test
    public void bubbleSort() {
        for (int i = 0; i < TEST_DIGIT; i++) {

            int array[] = Sorting.bubbleSort(listToArray(hashMap.get(i)));

            assertEquals(true, Sorting.arrayIsSorted(array));

        }
    }

    @org.junit.Test
    public void mergeSort() {
        for (int i = 0; i < TEST_DIGIT; i++) {

            int array[] = Sorting.mergeSort(listToArray(hashMap.get(i)));

            assertEquals(true, Sorting.arrayIsSorted(array));

        }

    }

    @org.junit.Test
    public void insertionSort() {
        for (int i = 0; i < TEST_DIGIT; i++) {
            int array[] = Sorting.mergeSort(listToArray(hashMap.get(i)));
            array = Sorting.insertionSort(array);
            assertEquals(true, Sorting.arrayIsSorted(array));

        }

    }

    @Test
    public void consistsOfEqualsElements() {
        for (int i = 0; i < TEST_DIGIT; i++) {
            int array1[] = listToArray(getRandomArrayList());
            int array2[] = array1.clone();
            array2 = Sorting.arrayShuffle(array2);
            assertEquals(true,
                    Sorting.arraysConsistsOfEqualsElements(array1, array2));
        }


    }




    @org.junit.Test
    public void compareSorting() {

        long startTime;
        long endTime;

        if (BUBBLE_SORT) {
            startTime = System.nanoTime();
            for (int i = 0; i < TEST_DIGIT; i++) {
                int array[] = Sorting.bubbleSort(listToArray(hashMap.get(i)));
                assertEquals(true,
                        Sorting.arraysConsistsOfEqualsElements(array, listToArray(hashMap.get(i))));
                assertEquals(true, Sorting.arrayIsSorted(array));
            }
            endTime = System.nanoTime();
            System.out.println("BubbleSort   = " + (endTime - startTime) / normalize_koef);
        }


        if (BUBBLE_FROM_INTERENT_SORT) {
            startTime = System.nanoTime();
            for (int i = 0; i < TEST_DIGIT; i++) {
                int array[] = Sorting.bubbleSortFromInternet(listToArray(hashMap.get(i)));
                assertEquals(true,
                        Sorting.arraysConsistsOfEqualsElements(array, listToArray(hashMap.get(i))));
                assertEquals(true, Sorting.arrayIsSorted(array));
            }
            endTime = System.nanoTime();
            System.out.println("BubbleSortInt= " + (endTime - startTime) / normalize_koef);
        }


        if (INSERTION_SORT) {
            startTime = System.nanoTime();
            for (int i = 0; i < TEST_DIGIT; i++) {
                int array[] = Sorting.insertionSort(listToArray(hashMap.get(i)));
                assertEquals(true,
                        Sorting.arraysConsistsOfEqualsElements(array, listToArray(hashMap.get(i))));
                assertEquals(true, Sorting.arrayIsSorted(array));
            }
            endTime = System.nanoTime();
            System.out.println("InsertionSort= " + (endTime - startTime) / normalize_koef);
        }


        if (MERGE_SORT) {
            startTime = System.nanoTime();
            for (int i = 0; i < TEST_DIGIT; i++) {
                int array[] = Sorting.mergeSort(listToArray(hashMap.get(i)));
                assertEquals(true,
                        Sorting.arraysConsistsOfEqualsElements(array, listToArray(hashMap.get(i))));
                assertEquals(true, Sorting.arrayIsSorted(array));
            }
            endTime = System.nanoTime();
            System.out.println("MergeSort    = " + (endTime - startTime) / normalize_koef);
        }

        if (MERGE_FROM_INTERNET_SORT) {
            startTime = System.nanoTime();
            for (int i = 0; i < TEST_DIGIT; i++) {
                int array[] = Sorting.mergesortFromInternet(listToArray(hashMap.get(i)));
                assertEquals(true,
                        Sorting.arraysConsistsOfEqualsElements(array, listToArray(hashMap.get(i))));
                assertEquals(true, Sorting.arrayIsSorted(array));
            }
            endTime = System.nanoTime();
            System.out.println("MergeInternet= " + (endTime - startTime) / normalize_koef);
        }

        if (QUICK_SORT) {
            startTime = System.nanoTime();
            for (int i = 0; i < TEST_DIGIT; i++) {
                int array[] = Sorting.quickSort(listToArray(hashMap.get(i)));
                assertEquals(true,
                        Sorting.arraysConsistsOfEqualsElements(array, listToArray(hashMap.get(i))));
                assertEquals(true, Sorting.arrayIsSorted(array));
            }
            endTime = System.nanoTime();
            System.out.println("Quick Sort= " + (endTime - startTime) / normalize_koef);
        }


    }
}
