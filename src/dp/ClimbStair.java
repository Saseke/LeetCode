package dp;

/**
 * 爬楼梯
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * @Author Yoke
 * @Date 2018/11/10 上午11:18
 */
public class ClimbStair {
    //    装填转移方程: d[i] = d[i-1]+d[i-2];
    public int climbStair(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        if (n >= 0) {
            if (n < 3) {
                return arr[n];
            } else {
                for (int i = 3; i <= n; i++) {
                    arr[i] = arr[i - 1] + arr[i - 2];
                }
                return arr[n];
            }
        } else return -1;
    }

    public static void main(String[] args) {
//        1 : 1
//        2 : 1,1 ; 2
//        3 : 1,1,1;1,2;2,1;
        ClimbStair stair = new ClimbStair();

        System.out.println(stair.climbStair(4));
    }
}
