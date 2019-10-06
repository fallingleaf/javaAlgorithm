package array;


// https://www.programcreek.com/2016/04/get-target-using-number-list-and-arithmetic-operations-google/
// give list of number and target, check if can use + - * / between number to create target
// Divide and conquer: left and right part, concat 2 part using operations
public class ArithmeticOperation {
    public boolean isReachable(ArrayList<Integer> list, int target) {
        if (list == null || list.size() == 0)
            return false;

        int i = 0;
        int j = list.size() - 1;

        ArrayList<Integer> results = getResults(list, i, j);

        for (int num : results) {
            if (num == target) {
                return true;
            }
        }

        return false;
    }

    public ArrayList<Integer> getResults(ArrayList<Integer> list,
                                                int left, int right) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (left > right) {
            return result;
        } else if (left == right) {
            result.add(list.get(left));
            return result;
        }

        for (int i = left; i < right; i++) {

            ArrayList<Integer> result1 = getResults(list, left, i);
            ArrayList<Integer> result2 = getResults(list, i + 1, right);

            for (int x : result1) {
                for (int y : result2) {
                    result.add(x + y);
                    result.add(x - y);
                    result.add(x * y);
                    if (y != 0)
                        result.add(x / y);
                }
            }
        }

        return result;
    }
}
