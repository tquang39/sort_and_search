package hus.oop.algorithm;

public class IterativeBinarySearch implements Searcher {
    private Sorter sorter;

    public IterativeBinarySearch() {
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
        return iterativeBinarySearch(value, data);
    }

    /**
     * Tìm kiếm giá trị value trong mảng data, sử dụng thuật toán tìm kiếm nhị phân code theo thuật toán lặp.
     * @param data
     * @param value
     * @return
     */
    private int iterativeBinarySearch(double value, double[] data) {
        int left = 0;
        int right = data.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (data[mid] == value) {
                return mid;
            }
            
            if (data[mid] > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return -1;
    }
    
    private void sort(double[] data) {
        if (sorter != null) {
            sorter.sort(data, true); // Sort in ascending order for binary search
        }
    }
}
