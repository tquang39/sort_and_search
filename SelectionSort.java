package hus.oop.algorithm;

public class SelectionSort implements Sorter {
    /**
     * Sắp xếp mảng dữ liệu, sử dụng thuật toán Selection sort.
     * @param data
     * @param order: true sắp xếp theo thứ tự tăng dần, false sắp xếp theo thứ tự giảm dần.
     */
    @Override
    public void sort(double[] data, boolean order) {
        if (order) {
            sortAscending(data);
        } else {
            sortDescending(data);
        }
    }

    /**
     * Sắp xếp mảng dữ liệu theo thứ tự tăng dần, sử dụng thuật toán Selection sort.
     * @param data
     */
    private void sortAscending(double[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap elements
            double temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }
    }

    /**
     * Sắp xếp mảng dữ liệu theo thứ tự giảm dần, sử dụng thuật toán Selection sort.
     * @param data
     */
    private void sortDescending(double[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] > data[maxIndex]) {
                    maxIndex = j;
                }
            }
            // Swap elements
            double temp = data[i];
            data[i] = data[maxIndex];
            data[maxIndex] = temp;
        }
    }
}
