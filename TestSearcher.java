package hus.oop.algorithm;

import java.util.Random;
import java.util.Arrays;

public class TestSearcher {
    private Searcher searcher;
    private Random random;

    public TestSearcher(Searcher searcher) {
        this.searcher = searcher;
        this.random = new Random();
    }

    public static void main(String[] args) {
        // Test Linear Search
        TestSearcher linearTest = new TestSearcher(new LinearSearch());
        linearTest.testLinearSearch();
        System.out.println();

        // Test Iterative Binary Search
        TestSearcher iterativeTest = new TestSearcher(new IterativeBinarySearch());
        iterativeTest.testIterativeBinarySearch();
        System.out.println();

        // Test Recursive Binary Search
        TestSearcher recursiveTest = new TestSearcher(new RecursiveBinarySearch());
        recursiveTest.testRecursiveBinarySearch();
    }

    public void testLinearSearch() {
        // Generate random size between 10 and 20
        int size = random.nextInt(11) + 10;
        double[] data = generateRandomArray(size);
        
        // Print the array
        System.out.println("Data: " + Arrays.toString(data));
        
        // Test with a value that exists in the array
        double existingValue = data[random.nextInt(size)];
        int result = searcher.search(existingValue, data);
        System.out.println("Linear search giá trị " + existingValue + ": " + result);
        
        // Test with a value that doesn't exist
        double nonExistingValue = 999.0;
        result = searcher.search(nonExistingValue, data);
        System.out.println("Linear search giá trị " + nonExistingValue + ": " + result);
    }

    public void testIterativeBinarySearch() {
        // Generate random size between 10 and 20
        int size = random.nextInt(11) + 10;
        double[] data = generateRandomArray(size);
        
        // Test with different sorting algorithms
        testWithSorter(data, new BubbleSort(), "Bubble Sort");
        testWithSorter(data, new InsertionSort(), "Insertion Sort");
        testWithSorter(data, new SelectionSort(), "Selection Sort");
    }

    public void testRecursiveBinarySearch() {
        // Generate random size between 10 and 20
        int size = random.nextInt(11) + 10;
        double[] data = generateRandomArray(size);
        
        // Test with different sorting algorithms
        testWithSorter(data, new BubbleSort(), "Bubble Sort");
        testWithSorter(data, new InsertionSort(), "Insertion Sort");
        testWithSorter(data, new SelectionSort(), "Selection Sort");
    }

    private void testWithSorter(double[] data, Sorter sorter, String sorterName) {
        // Create a copy of the data array
        double[] dataCopy = Arrays.copyOf(data, data.length);
        
        // Print before sorting
        System.out.println("Using " + sorterName + " Algorithm:");
        System.out.println("Before sorting: " + Arrays.toString(dataCopy));
        
        // Sort the array
        sorter.sort(dataCopy, true);
        
        // Print after sorting
        System.out.println("After sorting: " + Arrays.toString(dataCopy));
        
        // Test with a value that exists in the array
        double existingValue = dataCopy[random.nextInt(dataCopy.length)];
        int result = searcher.search(existingValue, dataCopy);
        System.out.println(searcher.getClass().getSimpleName() + " giá trị " + existingValue + ": " + result);
        
        // Test with a value that doesn't exist
        double nonExistingValue = 999.0;
        result = searcher.search(nonExistingValue, dataCopy);
        System.out.println(searcher.getClass().getSimpleName() + " giá trị " + nonExistingValue + ": " + result);
        System.out.println();
    }

    private double[] generateRandomArray(int size) {
        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextDouble() * 100; // Generate random doubles between 0 and 100
        }
        return array;
    }
}
