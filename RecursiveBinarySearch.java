package hus.oop.algorithm;

public class RecursiveBinarySearch implements Searcher {
    private Sorter sorter;

    public RecursiveBinarySearch() {
        this.sorter = new SelectionSort();
    }

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    @Override
    public int search(double value, double[] data) {
        if (data == null || data.length == 0) {
            return -1;
        }
        sort(data);
        return recursiveBinarySearch(value, data);
    }

    /**
     * Tìm kiếm giá trị value trong mảng data từ vị trí from tới vị trí to,
     * sử dụng thuật toán tìm kiếm nhị phân code theo thuật toán đệ quy.
     * @param value
     * @param data
     * @param from
     * @param to
     * @return
     */
    private int recursiveBinarySearch(double value, double[] data, int from, int to) {
        if (from > to) {
            return -1;
        }
        
        int mid = (from + to) / 2;
        
        if (data[mid] == value) {
            return mid;
        }
        
        if (data[mid] > value) {
            return recursiveBinarySearch(value, data, from, mid - 1);
        }
        
        return recursiveBinarySearch(value, data, mid + 1, to);
    }

    /**
     * Tìm kiếm giá trị value trong toàn bộ mảng data, sử dụng thuật toán tìm kiếm nhị phân code theo thuật toán đệ quy.
     * @param value
     * @param data
     * @return
     */
    private int recursiveBinarySearch(double value, double[] data) {
        return recursiveBinarySearch(value, data, 0, data.length - 1);
    }

    /**
     * Sắp xếp mảng dữ liệu data.
     * @param data
     */
    private void sort(double[] data) {
        if (sorter != null) {
            sorter.sort(data, true); // Sort in ascending order for binary search
        }
    }
}
