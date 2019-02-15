package sort;

/**
 * @Author Yoke
 * @Date 2019/01/21 上午11:19
 */
public class Insertion {

    public void sort(int[] arr) {
        if (arr.length == 1) {
            return;
        }
        for (int j = 1; j < arr.length; j++) {
            int key = arr[j];
            int i = j - 1;
            while (i >= 0 && (key < arr[i])) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 4, 6, 1, 3};
        Insertion insertion = new Insertion();
        insertion.sort(arr);
        for (int i1 : arr) {
            System.out.println(i1);
        }
    }
}
