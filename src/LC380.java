import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class LC380 {

	public static void main(String[] args) {

	}

}

class RandomizedSet {

	private  HashSet<Integer> hashSet;

	private  Random random;

	public RandomizedSet() {
		hashSet = new HashSet<>();
		random = new Random();
	}

	public boolean insert(int val) {
		return hashSet.add(val);
	}

	public boolean remove(int val) {
		return hashSet.remove(val);
	}

	public int getRandom() {
		int index = Math.abs(random.nextInt()) % hashSet.size();
		int count = 0;
		for(Integer i:hashSet) {
			if(count==index) {
				return i.intValue();
			}
			count++;
		}
		return 0;
	}
}