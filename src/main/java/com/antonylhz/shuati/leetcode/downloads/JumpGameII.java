public class Solution {
    public int jump(int[] A) {
        List<Integer> exits = new ArrayList<Integer>();
        List<Integer> steps = new ArrayList<Integer>();
        exits.add(A.length - 1);
        steps.add(0);
        for (int i = A.length - 2; i >= 0; i--) {
            if (i + A[i] < exits.get(0)) continue;
            int min = steps.get(0) + 1;
            for (int j = 1; j < exits.size() && i + A[i] >= exits.get(j); j++) min = Math.min(min, steps.get(j) + 1);
            while (steps.get(0) >= min) {
                exits.remove(0);
                steps.remove(0);
            }
            exits.add(0, i);
            steps.add(0, min);
        }
        return steps.get(0);
    }
}