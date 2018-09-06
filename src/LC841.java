import java.util.*;

public class LC841 {


    public static void main(String[] args) {

        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(1, 3);
        List<Integer> list2 = Arrays.asList(3, 0, 1);
        List<Integer> list3 = Arrays.asList(2);
        List<Integer> list4 = Arrays.asList(0);
        rooms.add(list1);
        rooms.add(list2);
        rooms.add(list3);
        rooms.add(list4);
        canVisitAllRooms1(rooms);
        canVisitAllRooms2(rooms);
    }

    public static boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        // define a boolean array
        boolean[] boolArray = new boolean[rooms.size()];
        // init the first bool
        boolArray[0] = true;
        dfs(boolArray, rooms, 0);
        for (boolean a : boolArray) {
            if (!a) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(boolean visit[], List<List<Integer>> rooms, int cur) {
        List<Integer> list = rooms.get(cur);
        for (Integer i : list) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(visit, rooms, i);
            }
        }
    }

    /**
     * method: use set storage passed room,use stack storage path
     *
     * @param rooms all rooms data array
     * @return is it a pathway
     */
    public static boolean canVisitAllRooms1(List<List<Integer>> rooms) {
        int roomNum = rooms.size();  // from number 1 to num room.size-1
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int curRoom = 0;
        Stack<Integer> stack = new Stack<>();
        for (Integer i : rooms.get(curRoom)) {
            stack.push(i);
        }
        while (stack.size() != 0) {
            curRoom = stack.pop();
            if (set.contains(curRoom)) {
                continue;
            }
            set.add(curRoom);
            for (Integer i : rooms.get(curRoom)) {
                stack.push(i);
            }
        }
        return set.size() == roomNum;
    }
}
