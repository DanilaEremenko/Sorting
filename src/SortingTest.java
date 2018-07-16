import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;


public class SortingTest {
    private final int TEST_DIGIT = 100;
    private final int ARRAYS_SIZE = 10000;
    private final int DIGITS_RADIUS = 10000;

    private Random random = new Random();
    private HashMap<Integer, ArrayList<Integer>> hashMap;
    private final int normalize_koef = 10000;

    private boolean BUBBLE_SORT = false;
    private boolean BUBBLE_FROM_INTERENT_SORT = false;
    private boolean INSERTION_SORT = false;
    private boolean MERGE_SORT = true;
    private boolean MERGE_FROM_INTERNET_SORT = true;
    private boolean QUICK_SORT = true;
    private boolean TREE_SORT = false;
    private boolean MY_TREE_SORT = true;


    private ArrayList<Integer> getAbsolutelyUnsortedArraylist() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < ARRAYS_SIZE; i++)
            arrayList.add(ARRAYS_SIZE - i);

        return arrayList;
    }

    private ArrayList<Integer> getAbsolutelySortedArraylist() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < ARRAYS_SIZE; i++)
            arrayList.add(i);

        return arrayList;

    }

    private ArrayList<Integer> getRandomArrayList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < ARRAYS_SIZE; i++)
            arrayList.add(random.nextInt(DIGITS_RADIUS));

        return arrayList;
    }


    private HashMap<Integer, ArrayList<Integer>> generateAbsolutelyUnsortedHashMap() {
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < TEST_DIGIT; i++)
            hashMap.put(i, getAbsolutelyUnsortedArraylist());

        return hashMap;

    }

    private HashMap<Integer, ArrayList<Integer>> generateAbsolutelySortedHashMap() {
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < TEST_DIGIT; i++)
            hashMap.put(i, getAbsolutelySortedArraylist());

        return hashMap;

    }

    private HashMap<Integer, ArrayList<Integer>> generateRandomHashMap() {
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < TEST_DIGIT; i++)
            hashMap.put(i, getRandomArrayList());

        return hashMap;

    }


    private Integer[] listToArray(ArrayList<Integer> arrayList) {
        Integer result[] = new Integer[arrayList.size()];
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


    //@Test
    public void consistsOfEqualsElements() {
        for (int i = 0; i < TEST_DIGIT; i++) {
            Integer array1[] = listToArray(getRandomArrayList());
            Integer array2[] = array1.clone();
            array2 = Sorting.arrayShuffle(array2);
            assertEquals(true,
                    Sorting.arraysConsistsOfEqualsElements(array1, array2));
        }


    }


    private void testingOn(HashMap<Integer, ArrayList<Integer>> inputHashMap) {
        HashMap<String, Long> results = new HashMap<>();
        hashMap = inputHashMap;

        long startTime;
        long endTime;

        if (BUBBLE_SORT) {
            startTime = System.nanoTime();
            for (int i = 0; i < TEST_DIGIT; i++) {
                Integer array[] = Sorting.bubbleSort(listToArray(hashMap.get(i)));
                assertEquals(true,
                        Sorting.arraysConsistsOfEqualsElements(array, listToArray(hashMap.get(i))));
                assertEquals(true, Sorting.arrayIsSorted(array));
            }
            endTime = System.nanoTime();
            results.put("BUBBLE_SORT\t\t\t", (endTime - startTime) / normalize_koef);
        }


        if (BUBBLE_FROM_INTERENT_SORT) {
            startTime = System.nanoTime();
            for (int i = 0; i < TEST_DIGIT; i++) {
                Integer array[] = Sorting.bubbleSortFromInternet(listToArray(hashMap.get(i)));
                assertEquals(true,
                        Sorting.arraysConsistsOfEqualsElements(array, listToArray(hashMap.get(i))));
                assertEquals(true, Sorting.arrayIsSorted(array));
            }
            endTime = System.nanoTime();
            results.put("BUBBLE_FROM_INTERNET_SORT", (endTime - startTime) / normalize_koef);
        }


        if (INSERTION_SORT) {
            startTime = System.nanoTime();
            for (int i = 0; i < TEST_DIGIT; i++) {
                Integer array[] = Sorting.insertionSort(listToArray(hashMap.get(i)));
                assertEquals(true,
                        Sorting.arraysConsistsOfEqualsElements(array, listToArray(hashMap.get(i))));
                assertEquals(true, Sorting.arrayIsSorted(array));
            }
            endTime = System.nanoTime();
            results.put("INSERTION_SORT\t\t", (endTime - startTime) / normalize_koef);
        }


        if (MERGE_SORT) {
            startTime = System.nanoTime();
            for (int i = 0; i < TEST_DIGIT; i++) {
                Integer array[] = Sorting.mergeSort(listToArray(hashMap.get(i)));
                assertEquals(true,
                        Sorting.arraysConsistsOfEqualsElements(array, listToArray(hashMap.get(i))));
                assertEquals(true, Sorting.arrayIsSorted(array));
            }
            endTime = System.nanoTime();
            results.put("MERGE_SORT\t\t\t", (endTime - startTime) / normalize_koef);
        }

        if (MERGE_FROM_INTERNET_SORT) {
            startTime = System.nanoTime();
            for (int i = 0; i < TEST_DIGIT; i++) {
                Integer array[] = Sorting.mergesortFromInternet(listToArray(hashMap.get(i)));
                assertEquals(true,
                        Sorting.arraysConsistsOfEqualsElements(array, listToArray(hashMap.get(i))));
                assertEquals(true, Sorting.arrayIsSorted(array));
            }
            endTime = System.nanoTime();
            results.put("MERGE_FROM_INTERNET_SORT", (endTime - startTime) / normalize_koef);
        }

        if (QUICK_SORT) {
            startTime = System.nanoTime();
            for (int i = 0; i < TEST_DIGIT; i++) {
                Integer array[] = Sorting.quickSort(listToArray(hashMap.get(i)));
                assertEquals(true,
                        Sorting.arraysConsistsOfEqualsElements(array, listToArray(hashMap.get(i))));
                assertEquals(true, Sorting.arrayIsSorted(array));
            }
            endTime = System.nanoTime();
            results.put("QUICK_SORT\t\t\t", (endTime - startTime) / normalize_koef);
        }

        if (TREE_SORT) {
            startTime = System.nanoTime();
            for (int i = 0; i < TEST_DIGIT; i++) {
                Integer array[] = Sorting.standardTreeSort(listToArray(hashMap.get(i)));
                assertEquals(true,
                        Sorting.arraysConsistsOfEqualsElements(array, listToArray(hashMap.get(i))));
                assertEquals(true, Sorting.arrayIsSorted(array));
            }
            endTime = System.nanoTime();
            results.put("TREE_SORT\t\t\t\t", (endTime - startTime) / normalize_koef);
        }

        if (MY_TREE_SORT) {
            startTime = System.nanoTime();
            for (int i = 0; i < TEST_DIGIT; i++) {
                Integer array[] = Sorting.myTreeSort(listToArray(hashMap.get(i)));
                assertEquals(true,
                        Sorting.arraysConsistsOfEqualsElements(array, listToArray(hashMap.get(i))));
                assertEquals(true, Sorting.arrayIsSorted(array));
            }
            endTime = System.nanoTime();
            results.put("MY_TREE_SORT\t\t\t", (endTime - startTime) / normalize_koef);
        }

        final int RESULT_SIZE = results.size();
        for (int i = 0; i < RESULT_SIZE; i++) {

            long bestTime = Long.MAX_VALUE;
            String bestName = "";
            for (Map.Entry<String, Long> entry : results.entrySet()) {
                if (entry.getValue() < bestTime) {
                    bestName = entry.getKey();
                    bestTime = entry.getValue();
                }
            }
            results.remove(bestName, bestTime);
            System.out.println(i + " " + bestName + "\t = \t" + bestTime);
        }

    }

    @Test
    public void testingOnAbsolutelyUnsortedArrays() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Absolutely Unsorted Arrays\n");
        testingOn(generateAbsolutelyUnsortedHashMap());
    }

    @Test
    public void testingOnAbsolutelySortedArrays() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Absolutely Sorted Arrays\n");
        testingOn(generateAbsolutelySortedHashMap());
    }

    @Test
    public void testingOnRandomArrays() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Random Arrays\n");
        testingOn(generateRandomHashMap());
    }


}


