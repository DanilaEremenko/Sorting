import java.util.*;

public class Sorting {
    static private Random random = new Random();


    //----------------------------------------------------------------------------------------------
    //Worst and Average Case Time Complexity: O(n*n)
    //Auxiliary Space: O(1)
    //Stable: Yes
    public static Integer[] bubbleSort(Integer array[]) {
        Integer[] result;
        result = array.clone();
        while (true) {
            boolean end = true;
            for (int i = 0; i < result.length - 1; i++) {
                if (result[i] > result[i + 1]) {
                    int digit;
                    digit = result[i + 1];
                    result[i + 1] = result[i];
                    result[i] = digit;
                    end = false;
                }
            }
            if (end)
                break;
        }

        return result;

    }

    public static Integer[] bubbleSortFromInternet(Integer array[]) {
        Integer[] result = array.clone();
        for (int i = 0; i < result.length - 1; i++)
            for (int j = 0; j < result.length - i - 1; j++)
                if (result[j] > result[j + 1]) {
                    // swap temp and arr[i]
                    int temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
        return result;


    }


    //----------------------------------------------------------------------------------------------
    //Worst and Average Case Time Complexity: O(n*n)
    //Auxiliary Space: O(1)
    //Stable: Yes
    public static Integer[] insertionSort(Integer array[]) {
        Integer result[] = array.clone();
        for (int i = 1; i < result.length; ++i) {
            int key = result[i];
            int j = i - 1;
            while (j >= 0 && result[j] > key) {
                result[j + 1] = result[j];
                j = j - 1;
            }
            result[j + 1] = key;
        }


        return result;
    }


    //----------------------------------------------------------------------------------------------
    //Worst and Average Case Time Complexity: O(n*logn)
    //Auxiliary Space: O(n)
    //Stable: Yes
    private static Integer[] merge(Integer array1[], Integer array2[]) {
        Integer result[] = new Integer[array1.length + array2.length];
        int index1 = 0, index2 = 0;
        for (int i = 0; i < result.length; i++) {
            if (index1 == array1.length) {
                result[i] = array2[index2];
                index2++;
            } else if (index2 == array2.length) {
                result[i] = array1[index1];
                index1++;
            } else if (array1[index1] < array2[index2]) {
                result[i] = array1[index1];
                index1++;
            } else {
                result[i] = array2[index2];
                index2++;
            }

        }
        return result;
    }

    public static Integer[] mergeSort(Integer[] array) {
        int mediana = array.length / 2;
        Integer array1[] = Arrays.copyOfRange(array, 0, mediana);
        Integer array2[] = Arrays.copyOfRange(array, mediana, array.length);
        if (mediana > 0) {
            array1 = mergeSort(array1);
            array2 = mergeSort(array2);
        }
        return merge(array1, array2);
    }

    //----------------------------------------------------------------------------------------------

    private static Integer[] mergesortInner(Integer[] buffer1, Integer[] buffer2,
                                            int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        // уже отсортирован.
        int middle = startIndex + (endIndex - startIndex) / 2;
        Integer[] sorted1 = mergesortInner(buffer1, buffer2, startIndex, middle);
        Integer[] sorted2 = mergesortInner(buffer1, buffer2, middle, endIndex);

        // Слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        Integer[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }

    public static Integer[] mergesortFromInternet(Integer[] array1) {
        Integer[] buffer1 = Arrays.copyOf(array1, array1.length);
        Integer[] buffer2 = new Integer[array1.length];
        return mergesortInner(buffer1, buffer2, 0, array1.length);
    }


    //----------------------------------------------------------------------------------------------
    //Best:     O(n*logn)
    //Average:  O(n*logn)
    //Worst:    O(n*n)
    //Auxiliary Space: O(n)
    //Stable: No
    private static int partition(Integer array[], int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }


    private static void quickSort(Integer[] array, int low, int high) {
        if (low < high) {

            int pi = partition(array, low, high);


            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    public static Integer[] quickSort(Integer array[]) {
        Integer result[] = array.clone();


        int pi = partition(result, 0, result.length - 1);

        quickSort(result, 0, pi - 1);
        quickSort(result, pi + 1, result.length - 1);

        return result;
    }

    //----------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------
    //Best:     O(n*logn)
    //Average:  O(n*logn)
    //Worst:    O(n*logn)
    //Auxiliary Space: O(n)
    //Stable: Yes
    public static Integer[] standardTreeSort(Integer array[]) {
        Integer result[] = array.clone();
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(result));

        Iterator<Integer> iterator = treeSet.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            result[i] = iterator.next();
            i++;
        }
        return result;
    }

    public static Integer[] myTreeSort(Integer array[]) {
        Integer result[] = array.clone();
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        for (int anResult : result)
            binaryTree.add(anResult);

        Iterator<Integer> iterator = binaryTree.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            result[i] = iterator.next();
            i++;
        }
        return result;

    }

    //----------------------------------------------------------------------------------------------

    //Different Methods for arrays
    public static boolean arrayIsSorted(Integer array[]) {
        for (int i = 0; i < array.length - 1; i++)
            if (array[i] > array[i + 1])
                return false;
        return true;
    }


    private static boolean contains(Integer array[], int digit) {
        for (int anArray : array)
            if (anArray == digit)
                return true;
        return false;
    }


    public static boolean arraysConsistsOfEqualsElements(Integer array1[], Integer array2[]) {
        if (array1.length != array2.length)
            return false;

        List<Integer> list = new ArrayList<>(Arrays.asList(array2));

        for (int anArray1 : array1) {
            boolean hasFound = false;
            for (int i = 0; i < list.size(); i++)
                if (list.get(i) == anArray1) {
                    list.remove(i);
                    hasFound = true;
                    break;
                }
            if (!hasFound)
                return false;
        }
        return true;

    }


    public static Integer[] arrayShuffle(Integer array[]) {
        Integer randomedIndexes[] = new Integer[array.length];
        int rIndex = 0;
        Integer result[] = new Integer[array.length];

        result[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            int j;
            do
                j = random.nextInt(array.length);
            while (Sorting.contains(randomedIndexes, j));
            result[i] = array[j];
            randomedIndexes[rIndex] = j;
            rIndex++;
        }
        return result;
    }


    public static void printArray(Integer array[]) {
        for (int anArray : array)
            System.out.println(anArray);
        System.out.println("\n");
    }


    public static void printTwoArray(Integer array1[], Integer array2[]) {
        if (array1.length != array2.length) {
            System.out.println("Неравный размер массивов");
            return;
        }

        System.out.println("FirstArray\tSecondArray");
        for (int i = 0; i < array1.length; i++)
            System.out.println(array1[i] + "\t\t\t" + array2[i]);


    }


}

