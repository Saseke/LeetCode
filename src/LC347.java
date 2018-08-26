import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC347 {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        topKFrequent1(nums, 2);
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer size = map.get(num);
            if (size != null) {
                size++;
            } else {
                size = 1;
            }
            map.put(num, size);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Integer num = list.get(i).getKey();
            integers.add(num);
        }
        return integers;
    }

    public static List<Integer> topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        ArrayList[] bucket = new ArrayList[nums.length + 1];

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        for (int i = bucket.length - 1; i > 0 && result.size() < k; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }
        return result;
    }
}

