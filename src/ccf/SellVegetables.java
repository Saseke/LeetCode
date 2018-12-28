package ccf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Yoke
 * @Date 2018/12/20 上午10:48
 */
public class SellVegetables {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        while (n > 0) {
            int price = scanner.nextInt();
            list.add(price);
            n--;
        }
        int newPrice = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0 && list.size() >= 2) {
                newPrice = (list.get(i) + list.get(i + 1)) / 2;
            } else if (i == list.size() - 1 && list.size() >= 2) {
                newPrice = (list.get(i) + list.get(i - 1)) / 2;
            } else if (i != 0 && i != list.size() - 1) {
                newPrice = (list.get(i - 1) + list.get(i) + list.get(i + 1)) / 3;
            }
            ret.add(newPrice);
        }
        for (int i = 0; i < ret.size(); i++) {
            if (i == ret.size() - 1) {
                System.out.print(ret.get(i));
            } else {
                System.out.print(ret.get(i) + " ");
            }
        }
    }

}
