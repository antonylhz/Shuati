public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        char[] chars = digits.toCharArray();
        String temp;
        int size;
        for(char c : chars) {
            if(c>'9'||c<'2') return new ArrayList<String>();
            char[] options = getOptions(c);
            if(result.isEmpty()) {
                for(char o : options) result.add(""+o);
            } else {
                size = result.size();
                for(int i=0; i<size; i++) {
                    temp = result.get(0);
                    result.remove(0);
                    for(char o : options) result.add(temp+o);
                }
            }
        }
        return result;
    }
    private char[] getOptions(char c) {
        switch(c) {
            case '2':
                return new char[]{'a', 'b', 'c'};
            case '3':
                return new char[]{'d', 'e', 'f'};
            case '4':
                return new char[]{'g', 'h', 'i'};
            case '5':
                return new char[]{'j', 'k', 'l'};
            case '6':
                return new char[]{'m', 'n', 'o'};
            case '7':
                return new char[]{'p', 'q', 'r', 's'};
            case '8':
                return new char[]{'t', 'u', 'v'};
            case '9':
                return new char[]{'w', 'x', 'y', 'z'};
            default:
                return new char[]{};
        }
    }
}