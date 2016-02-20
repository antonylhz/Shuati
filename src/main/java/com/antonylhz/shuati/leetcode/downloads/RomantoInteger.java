public class Solution {
    int value = 0;

    public int romanToInt(String s) {
        int base = 1;
        int i = s.length() - 1;
        while (i >= 0) {
            i = evaluateGroup(s, i, 'X', 'V', 'I', base);
            base *= 10;
            i = evaluateGroup(s, i, 'C', 'L', 'X', base);
            base *= 10;
            i = evaluateGroup(s, i, 'M', 'D', 'C', base);
            base *= 10;
            for (; i >= 0; i--) {
                if (s.charAt(i) == 'M') value += base;
                else return value;
            }
        }
        return value;
    }

    private int evaluateGroup(String s, int i, char ten, char five, char one, int base) {
        if (i < 0) return i;
        if (s.charAt(i) == ten) {
            if (i == 0 || s.charAt(i - 1) != one) return i;
            value += 9 * base;
            return i - 2;
        } else if (s.charAt(i) == five) {
            if (i == 0 || s.charAt(i - 1) != one) {
                value += 5 * base;
                return i - 1;
            }
            value += 4 * base;
            return i - 2;
        } else if (s.charAt(i) == one) {
            value += base;
            return evaluateGroup(s, i - 1, ten, five, one, base);
        } else return i;
    }
}
