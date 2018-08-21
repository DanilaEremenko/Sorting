import java.util.*;

public class Sorting {
    static private Random random = new Random();


    //----------------------------------------------------------------------------------------------
    //Worst and Average Case Time Complexity: O(n*n)
    //Auxiliary Space: O(1)
    //Stable: Yes
    public static <T extends Comparable<? super T>> List<T> bubbleSort(List<T> list) {
        List<T> result = new ArrayList<>(list);
        while (true) {
            boolean end = true;
            for (int i = 0; i < result.size() - 1; i++) {
                if (result.get(i).compareTo(result.get(i + 1)) > 0) {
                    T digit;
                    digit = result.get(i + 1);
                    result.set(i + 1, result.get(i));
                    result.set(i, digit);
                    end = false;
                }
            }
            if (end)
                break;
        }

        return result;

    }

    public static <T extends Comparable<? super T>> List<T> bubbleSortFromInternet(List<T> list) {
        List<T> result = new ArrayList<>(list);
        for (int i = 0; i < result.size() - 1; i++)
            for (int j = 0; j < result.size() - i - 1; j++)
                if (result.get(j).compareTo(result.get(j + 1)) > 0) {
                    // swap temp and arr[i]
                    T temp = result.get(j);
                    result.set(j, result.get(j + 1));
                    result.set(j + 1, temp);
                }
        return result;


    }


    //----------------------------------------------------------------------------------------------
    //Worst and Average Case Time Complexity: O(n*n)
    //Auxiliary Space: O(1)
    //Stable: Yes
    public static <T extends Comparable<? super T>> List<T> insertionSort(List<T> list) {
        List<T> result = new ArrayList<>(list);
        for (int i = 1; i < result.size(); ++i) {
            T key = result.get(i);
            int j = i - 1;
            while (j >= 0 && result.get(j).compareTo(key) > 0) {
                result.set(j + 1, result.get(j));
                j = j - 1;
            }
            result.set(j + 1, key);
        }


        return result;
    }


    //----------------------------------------------------------------------------------------------
    //Worst and Average Case Time Complexity: O(n*logn)
    //Auxiliary Space: O(n)
    //Stable: Yes
    private static <T extends Comparable<? super T>> List<T> merge(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>(list1.size() + list2.size());
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < result.size(); i++) {
            if (index1 == list1.size()) {
                result.set(i, list2.get(index2));
                index2++;
            } else if (index2 == list2.size()) {
                result.set(i, list1.get(index1));
                index1++;
            } else if (list1.get(index1).compareTo(list2.get(index2)) < 0) {
                result.set(i, list1.get(index1));
                index1++;
            } else {
                result.set(i, list2.get(index2));
                index2++;
            }

        }
        return result;
    }

    public static <T extends Comparable<? super T>> List<T> mergeSort(List<T> list) {
        int mediana = list.size() / 2;
        List<T> list1 = copyOfRange(list, 0, mediana);
        List<T> list2 = copyOfRange(list, mediana, list.size());
        if (mediana > 0) {
            list1 = mergeSort(list1);
            list2 = mergeSort(list2);
        }
        return merge(list1, list2);
    }

    public static <T extends Comparable<? super T>> List<T> copyOfRange(List<T> list, int from, int to) {
        List<T> result = new ArrayList<>();
        for (int i = from; i < to; i++)
            result.add(list.get(i));
        return result;
    }

    //----------------------------------------------------------------------------------------------

    private static <T extends Comparable<? super T>> List<T> mergesortInner(
            List<T> buffer1, List<T> buffer2, int startIndex, int endIndex) {

        if (startIndex >= endIndex - 1) {
            return buffer1;
        }
        // уже отсортирован.
        int middle = startIndex + (endIndex - startIndex) / 2;
        List<T> sorted1 = mergesortInner(buffer1, buffer2, startIndex, middle);
        List<T> sorted2 = mergesortInner(buffer1, buffer2, middle, endIndex);

        // Слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        List<T> result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result.set(destIndex++, sorted1.get(index1).compareTo(sorted2.get(index2)) < 0
                    ? sorted1.get(index1++) : sorted2.get(index2++));
        }
        while (index1 < middle) {
            result.set(destIndex++, sorted1.get(index1++));
        }
        while (index2 < endIndex) {
            result.set(destIndex++, sorted2.get(index2++));
        }
        return result;
    }

    public static <T extends Comparable<? super T>> List<T> mergesortFromInternet(List<T> list) {
        List<T> buffer1 = copyOfRange(list, 0, list.size());
        List<T> buffer2 = new ArrayList<>(list.size());
        return mergesortInner(buffer1, buffer2, 0, list.size());
    }


    //----------------------------------------------------------------------------------------------
    //Best:     O(n*logn)
    //Average:  O(n*logn)
    //Worst:    O(n*n)
    //Auxiliary Space: O(n)
    //Stable: No
    private static <T extends Comparable<? super T>> int partition(List<T> list, int low, int high) {
        T pivot = list.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (list.get(j).compareTo(pivot) <= 0) {
                i++;

                T temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        T temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        return i + 1;
    }


    private static <T extends Comparable<? super T>> void quickSort(List<T> list, int low, int high) {
        if (low < high) {

            int pi = partition(list, low, high);


            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    public static <T extends Comparable<? super T>> List<T> quickSort(List<T> list) {
        List<T> result = new ArrayList<>(list);

        int pi = partition(result, 0, result.size() - 1);

        quickSort(result, 0, pi - 1);
        quickSort(result, pi + 1, result.size() - 1);

        return result;
    }

    //----------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------
    //Best:     O(n*logn)
    //Average:  O(n*logn)
    //Worst:    O(n*logn)
    //Auxiliary Space: O(n)
    //Stable: Yes
    public static <T extends Comparable<? super T>> List<T> treeSort(List<T> list) {
        TreeSet<T> treeSet = new TreeSet<>(list);

        return new ArrayList<T>(treeSet);
    }

//    public static <T extends Comparable<? super T>> List<T> myTreeSort(List<T> list) {
//        List<T> result = new ArrayList<>(list);
//        BinaryTree<T> binaryTree = new BinaryTree<>();
//        for (T anResult : result)
//            binaryTree.add(T);
//
//        Iterator<T> iterator = binaryTree.iterator();
//        int i = 0;
//        while (iterator.hasNext()) {
//            result.set(i, iterator.next());
//            i++;
//        }
//        return result;
//
//    }

    //----------------------------------------------------------------------------------------------

    //Different Methods for arrays
    public static <T extends Comparable<? super T>> boolean listIsSorted(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++)
            if (list.get(i).compareTo(list.get(i + 1)) > 0)
                return false;
        return true;
    }


    public static <T extends Comparable<? super T>> boolean listsConsistsOfEqualElements
            (List<T> list1, List<T> list2) {
        if (list1.size() != list2.size())
            return false;

        List<T> list = new ArrayList<>(list2);

        for (T anArray1 : list1) {
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


}

