public class Solution {
    int hashcode; //each character takes up 2 bits, 10 would take 20 bits

    public List<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if (s == null || s.length() <= 10) return res;
        hashcode = 0;
        HashMap<Integer, Boolean> hmap = new HashMap<Integer, Boolean>(); // hashcode : whether this sample has been stored

        for (int i = 0; i < 10; i++) updateHashcode(s.charAt(i), s.charAt(i), false);
        hmap.put(hashcode, false);
        for (int i = 1; i <= s.length() - 10; i++) {
            updateHashcode(s.charAt(i - 1), s.charAt(i + 9), true);
            if (hmap.containsKey(hashcode)) {
                if (!hmap.get(hashcode)) {
                    res.add(s.substring(i, i + 10));
                    hmap.put(hashcode, true);
                }//when more than two instances are found, we just ignore them.
            } else hmap.put(hashcode, false);
        }
        return res;
    }

    private int valueOf(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
            default:
                return 0; //consider other cases as 'T'. need better solution for this!
        }
    }

    private void updateHashcode(char head, char tail, boolean deduct) {
        if (deduct) hashcode -= valueOf(head) * (int) Math.pow(4, 9);
        hashcode *= 4;
        hashcode += valueOf(tail);
    }
}


