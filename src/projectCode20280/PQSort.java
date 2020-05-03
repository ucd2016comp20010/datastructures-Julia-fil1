package projectCode20280;

import java.util.LinkedList;
import java.util.Random;
import java.util.stream.Collectors;

public class PQSort {

    public PQSort() {
        // TODO Auto-generated constructor stub
    }

    public static void fillRandom(LinkedList<Integer> ll, int n) {
        Random rnd = new Random();
        for (int i = 0; i < n; ++i) {
            ll.addLast(rnd.nextInt());
        }
    }

    public static Integer removeMin(LinkedList<Integer> ll) {
        int min_idx = 0;
        Integer min_val = ll.get(min_idx);
        for (int i = 1; i < ll.size(); ++i) {
            Integer curr = ll.get(i);
            if (curr < min_val) {
                min_val = curr;
                min_idx = i;
            }
        }
        ll.remove(min_idx);
        return min_val;
    }

    public static boolean isSorted(Integer[] array, int length) {
        if (array == null || length < 2)
            return true;
        if (array[length - 2].compareTo(array[length - 1]) > 0)
            return false;
        return isSorted(array, length - 1);
    }

    public static void main(String[] args) {
        // System.out.println("Hello");

        // LinkedList<Integer> arr = new LinkedList<Integer>();
        // fillRandom(arr, n);

        int n = 100;
        while (n < 100000) {
            LinkedList<Integer> arr = new Random().ints(0, 1000).distinct().limit(n).boxed()
                    .collect(Collectors.toCollection(LinkedList::new));
            // System.out.println(arr);

            long startTime = System.nanoTime();
            // first phase
            // move all the elements from Array -> PQ
            LinkedList<Integer> pq = new LinkedList<Integer>();

            while (!arr.isEmpty()) {
                pq.addLast(arr.removeFirst());
            }

            // move all the elements from PQ -> Array (removeMin)
            while (!pq.isEmpty()) {
                arr.addLast(removeMin(pq));
            }

            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;
            boolean is_sorted = isSorted(arr.toArray(new Integer[arr.size()]), arr.size());
            System.out.println(n + ", " + elapsedTime + ", " + is_sorted);
            // System.out.println(arr);
            n = (int) (n * 1.1);
        }
    }

//    public static void main(String[] args) {
//        int n = 100;
//        while (n < 100000) {
//            LinkedList<Integer> arr = new Random().ints(0, 1000).distinct().limit(n).boxed()
//                    .collect(Collectors.toCollection(LinkedList::new));
//            // System.out.println(arr);
//
//            long startTime = System.nanoTime();
//            // first phase
//            // move all the elements from Array -> PQ
//            //LinkedList<Integer> pq = new LinkedList<Integer>();
////			 naive style initialisation of Heap
////			HeapPriorityQueue<Integer, Integer> pq = new HeapPriorityQueue<Integer, Integer>();
//            Integer[] arr_arr = arr.toArray(Integer[]::new);
//            HeapPriorityQueue<Integer, Integer> pq = new HeapPriorityQueue<Integer, Integer>(arr_arr, arr_arr);
//            while (!arr.isEmpty()) {
//                Integer val = arr.removeFirst();
//                pq.insert(val, val);
//            }
//
//
//            // move all the elements from PQ -> Array (removeMin)
//
//            while (!pq.isEmpty()) {
//                arr.addLast(pq.removeMin().getValue());
//            }
//
//            long endTime = System.nanoTime();
//            long elapsedTime = endTime - startTime;
//            boolean is_sorted = isSorted(arr.toArray(new Integer[arr.size()]), arr.size());
//            System.out.println(n + ", " + elapsedTime + ", " + is_sorted);
//            // System.out.println(arr);
//            n = (int) (n * 1.1);
//        }
//    }
}
