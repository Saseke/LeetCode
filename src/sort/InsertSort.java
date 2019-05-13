package sort;

import java.util.Arrays;

/**
 * @Author Yoke
 * @Date 2019/01/21 上午11:19
 */
public class InsertSort {
    private int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && (key < arr[j])) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] arr = {10, 2, 3, 5, 1};
        System.out.println(Arrays.toString(insertSort.insertSort(arr)));
    }
}
