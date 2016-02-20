public class Solution {
    public int maximumGap(int[] num) {
        if (num == null || num.length < 2) return 0;
        int min = num[0], max = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] < min) min = num[i];
            if (num[i] > max) max = num[i];
        }
        int phlength = (int) Math.ceil((double) (max - min) / (num.length - 1));
        Range[] pigionhole = new Range[num.length - 1];
        for (int i = 0; i < num.length; i++) {
            if (num[i] == min || num[i] == max) continue;
            int index = (num[i] - min) / phlength;
            Range range = pigionhole[index];
            if (range == null) pigionhole[index] = new Range(num[i], num[i]);
            else range.add(num[i]);
        }
        int mgap = 0;
        int lastmax = min, newmin, newgap;
        for (int i = 0; i < pigionhole.length; i++) {
            if (pigionhole[i] != null) {
                newmin = pigionhole[i].min;
                newgap = newmin - lastmax;
                mgap = newgap > mgap ? newgap : mgap;
                lastmax = pigionhole[i].max;
            }
        }
        return Math.max(mgap, max - lastmax);
    }

    private class Range {
        int min;
        int max;

        public Range(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public void add(int num) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
    }
}

