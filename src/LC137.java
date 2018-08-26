import java.util.*;

public class LC137 {


    public static void main(String[] args) {
        int[] nums = new int[]{-19, -46, -19, -46, -9, -9, -19, 17, 17, 17, -13, -13, -9, -13, -46, -28};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.keySet().contains(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((Comparator.comparingInt(Map.Entry::getValue)));
        return list.get(0).getKey();
    }
}
