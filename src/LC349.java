import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Yoke
 * @Date 2018/10/13 上午9:16
 */
public class LC349 {

    /**
     * beat 10% of Java Submissions
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> retSet = new HashSet<>();
        if (nums1.length <= nums2.length) {
            for (int aNums2 : nums2) {
                list.add(aNums2);
            }
            for (int cur : nums1) {
                if (list.contains(cur)) {
                    retSet.add(cur);
                }
            }
        } else {
            for (int aNums1 : nums1) {
                list.add(aNums1);
            }
            for (int cur : nums2) {
                if (list.contains(cur)) {
                    retSet.add(cur);
                }
            }
        }
        int[] ret = new int[retSet.size()];
        int p = 0;
        for (Integer i : retSet) {
            ret[p] = i;
            p++;
        }
        return ret;
    }

    /**
     * Beat 90% of Java Submissions
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> retSet = new HashSet<>();
        for (int num : nums1) {
            nums1Set.add(num);
        }
        for (int num : nums2) {
            if (nums1Set.contains(num)) {
                retSet.add(num);
            }
        }

        int[] ret = new int[retSet.size()];
        int p = 0;
        for (Integer i : retSet) {
            ret[p] = i;
            p++;
        }
        return ret;
    }

    public static void main(String[] args) {

    }
}
