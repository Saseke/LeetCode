import java.util.*;

public class LC373 {

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 1, 2};
        int[] num2 = new int[]{1, 2, 3};
        long startTime = System.currentTimeMillis();
        kSmallPairs2(num1, num2, 3);
        System.out.println(System.currentTimeMillis() - startTime);
    }


    /**
     * LeetCode spend 45 ms
     * method: use a priority queue to store
     *
     * @param nums1 the first num array
     * @param nums2 the second num array
     * @param k     take the first k num
     * @return a list wrapped collection of array
     */
    public static List<int[]> kSmallPairs2(int[] nums1, int[] nums2, int k) {

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[0] + o1[1] - o2[0] - o2[1]);
        List<int[]> list = new ArrayList<>();
        int size = 0;
        if (nums1.length == 0 || nums2.length == 0) return list;
        for (int i = 0; i < k && i < nums1.length; i++) {
            q.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while (size < k && q.size() != 0) {
            int[] m = q.poll();
            list.add(new int[]{m[0], m[1]});
            size++;
            if (m[2] + 1 >= nums2.length) continue;
            q.offer(new int[]{m[0], nums2[m[2] + 1], m[2] + 1});
        }
        return list;
    }


    /**
     * LeetCode spend: 382ms
     *
     * @param num1 the first num array
     * @param num2 the second num array
     * @param k    take the first k num
     * @return a list wrapped collection of array
     */
    public static List<int[]> kSmallPairs1(int[] num1, int[] num2, int k) {
        if (num1.length == 0 || num2.length == 0) {
            return Collections.emptyList();
        }
        Map<int[], Integer> map = new IdentityHashMap<>();
        List<int[]> reList = new ArrayList<>();
        for (int aNum1 : num1) {
            for (int aNum2 : num2) {
                map.put(new int[]{aNum1, aNum2}, aNum1 + aNum2);
            }
        }
        List<Map.Entry<int[], Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getValue));
        int index = k < list.size() ? k : list.size();
        for (int i = 0; i < index; i++) {
            reList.add(list.get(i).getKey());
        }
        return reList;
    }
}
