package se.hig.aod.lab3;

import java.util.ArrayList;
import java.util.List;

public class HeapSorter<T extends Comparable<? super T>> {

    public static void main(String[] args) {
        int[] arr = { 1, 5, 2, 8, 9, 3, 8, 2, 11 };
        List<Integer> inputList = new ArrayList<>();
        for (Integer integer : arr) {
            inputList.add(integer);
        }
        System.out.println("Osorterade lista: " + inputList + "\n" + "Sorterade listan: " + sort(inputList));
    }

    public static <T extends Comparable<? super T>> List<T> sort(List<T> inputList) {
        HeapPriorityQueue<T> heap = new HeapPriorityQueue<>(inputList.size());

        for (T element : inputList) {
            heap.enqueue(element);
        }


        List<T> sortedList = new ArrayList<>();

        while (!heap.isEmpty()) {
            sortedList.add(heap.dequeue());
        }

        return sortedList;

    }

}
