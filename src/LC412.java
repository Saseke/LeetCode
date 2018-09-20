import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC412 {

	private String STR1 = "Fizz";
	private String STR2 = "Buzz";
	private String STR3 = "FizzBuzz";

	public List<String> fizzBuzz1(int n) {

		List<String> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			String string = String.valueOf(i);
			if (i % 3 == 0 && i % 5 == 0) {
//				list.set(i, STR3);
				string = STR3;
			} else if (i % 3 == 0) {
//				list.set(i, STR1);
				string = STR1;
			} else if (i % 5 == 0) {
//				list.set(i, STR2);
				string = STR2;
			}
			System.out.println(string);
			list.add(string);

		}
		return list;
	}

	public List<String> fizzBuzz2(int n) {
		List<String> list = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) {
				list.add(STR3);
			} else if (i % 3 == 0) {
				list.add(STR1);
			} else if (i % 5 == 0) {
				list.add(STR2);
			} else {
				list.add(Integer.toString(i));
			}
		}
		return list;
	}
}
