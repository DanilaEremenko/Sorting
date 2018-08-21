import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;


public class SortingTest<T extends Comparable<? super T>> {
    private final int TEST_DIGIT = 100;
    private final int ARRAYS_SIZE = 1000;
    private final int DIGITS_RADIUS = 10000;

    private Random random = new Random();
    private HashMap<Integer, List<Integer>> hashMap;
    private final int normalize_koef = 10000;

    private boolean BUBBLE_SORT = false;
    private boolean BUBBLE_FROM_INTERENT_SORT = false;
    private boolean INSERTION_SORT = false;
    private boolean MERGE_SORT = false;
    private boolean MERGE_FROM_INTERNET_SORT = false;
    private boolean QUICK_SORT = true;
    private boolean TREE_SORT = true;
    private boolean MY_TREE_SORT = false;
    private boolean TEAM_SORT = true;


    private List<Integer> getAbsolutelyUnsortedArraylist() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < ARRAYS_SIZE; i++)
            arrayList.add(ARRAYS_SIZE - i);

        return arrayList;
    }

    private List<Integer> getAbsolutelySortedArraylist() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < ARRAYS_SIZE; i++)
            arrayList.add(i);

        return arrayList;

    }

    private List<Integer> getRandomList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < ARRAYS_SIZE; i++)
            arrayList.add(random.nextInt(DIGITS_RADIUS));

        return arrayList;
    }


    private HashMap<Integer, List<Integer>> generateAbsolutelyUnsortedHashMapInteger() {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < TEST_DIGIT; i++)
            hashMap.put(i, getAbsolutelyUnsortedArraylist());

        return hashMap;

    }

    private HashMap<Integer, List<Integer>> generateAbsolutelySortedHashMapOfInteger() {

        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < TEST_DIGIT; i++)
            hashMap.put(i, getAbsolutelySortedArraylist());

        return hashMap;

    }

    private HashMap<Integer, List<Integer>> generateRandomHashMapOfInteger() {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < TEST_DIGIT; i++)
            hashMap.put(i, getRandomList());

        return hashMap;

    }


    private Integer[] listToArray(List<Integer> arrayList) {
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


    @Test
    public void consistsOfEqualsElements() {
        for (int i = 0; i < TEST_DIGIT; i++) {
            List<Integer> list1 = new ArrayList<>(getRandomList());
            List<Integer> list2 = new ArrayList<>(list1);
            Collections.shuffle(list2);
            assertEquals(true,
                    Sorting.listsConsistsOfEqualElements(list1, list2));
        }


    }


    private void testingOn(HashMap<Integer, List<Integer>> inputHashMap) {
        HashMap<String, Long> results = new HashMap<>();
        hashMap = inputHashMap;

        long startTime;
        long endTime;
        List<List<Integer>> teamSortResults = new ArrayList<>();
        if (TEAM_SORT) {
            startTime = System.nanoTime();
            for (int i = 0; i < TEST_DIGIT; i++) {

                List<Integer> list = new ArrayList<>(hashMap.get(i));
                Collections.sort(list);
                teamSortResults.add(list);
                assertEquals(true, Sorting.listIsSorted(list));
            }
            endTime = System.nanoTime();
            results.put("TEAM_SORT\t\t\t", (endTime - startTime) / normalize_koef);
        }

        if (BUBBLE_SORT) {
            startTime = System.nanoTime();
            for (int i = 0; i < TEST_DIGIT; i++) {
                List<Integer> list = new ArrayList<>(Sorting.bubbleSort(hashMap.get(i)));
                assertEquals(teamSortResults.get(i), list);
                assertEquals(true, Sorting.listIsSorted(list));
            }
            endTime = System.nanoTime();
            results.put("BUBBLE_SORT\t\t\t", (endTime - startTime) / normalize_koef);
        }


        if (BUBBLE_FROM_INTERENT_SORT) {
            startTime = System.nanoTime();
            for (int i = 0; i < TEST_DIGIT; i++) {
                List<Integer> list = new ArrayList<>(Sorting.bubbleSortFromInternet(hashMap.get(i)));
                assertEquals(teamSortResults.get(i), list);
                assertEquals(true, Sorting.listIsSorted(list));
            }
            endTime = System.nanoTime();
            results.put("BUBBLE_SORT_FROM_INTERNET\t\t\t", (endTime - startTime) / normalize_koef);
        }


        if (INSERTION_SORT) {
            startTime = System.nanoTime();
            for (int i = 0; i < TEST_DIGIT; i++) {
                List<Integer> list = new ArrayList<>(Sorting.insertionSort(hashMap.get(i)));
                assertEquals(teamSortResults.get(i), list);
                assertEquals(true, Sorting.listIsSorted(list));
            }
            endTime = System.nanoTime();
            results.put("INSERTION_SORT\t\t\t", (endTime - startTime) / normalize_koef);
        }


        if (MERGE_SORT) {
            startTime = System.nanoTime();
            for (int i = 0; i < TEST_DIGIT; i++) {
                List<Integer> list = new ArrayList<>(Sorting.mergeSort(hashMap.get(i)));
                assertEquals(teamSortResults.get(i), list);
                assertEquals(true, Sorting.listIsSorted(list));
            }
            endTime = System.nanoTime();
            results.put("MERGE_SORT\t\t\t", (endTime - startTime) / normalize_koef);
        }

        if (MERGE_FROM_INTERNET_SORT) {
            startTime = System.nanoTime();
            for (int i = 0; i < TEST_DIGIT; i++) {
                List<Integer> list = new ArrayList<>(Sorting.mergesortFromInternet(hashMap.get(i)));
                assertEquals(teamSortResults.get(i), list);
                assertEquals(true, Sorting.listIsSorted(list));
            }
            endTime = System.nanoTime();
            results.put("MERGE_FROM_INTERNET_SORT\t\t\t", (endTime - startTime) / normalize_koef);
        }


        if (QUICK_SORT) {
            startTime = System.nanoTime();
            for (int i = 0; i < TEST_DIGIT; i++) {
                List<Integer> list = new ArrayList<>(Sorting.quickSort(hashMap.get(i)));
                assertEquals(teamSortResults.get(i), list);
                assertEquals(true, Sorting.listIsSorted(list));
            }
            endTime = System.nanoTime();
            results.put("QUICK_SORT\t\t\t", (endTime - startTime) / normalize_koef);
        }

        if (TREE_SORT) {
            startTime = System.nanoTime();
            for (int i = 0; i < TEST_DIGIT; i++) {
                List<Integer> list = new ArrayList<>(Sorting.treeSort(hashMap.get(i)));
                assertEquals(teamSortResults.get(i), list);
                assertEquals(true, Sorting.listIsSorted(list));
            }
            endTime = System.nanoTime();
            results.put("TREE_SORT\t\t\t", (endTime - startTime) / normalize_koef);
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
        testingOn(generateAbsolutelyUnsortedHashMapInteger());
    }

    @Test
    public void testingOnAbsolutelySortedArrays() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Absolutely Sorted Arrays\n");
        testingOn(generateAbsolutelySortedHashMapOfInteger());
    }

    @Test
    public void testingOnRandomArrays() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Random Arrays\n");
        testingOn(generateAbsolutelySortedHashMapOfInteger());
    }


}


