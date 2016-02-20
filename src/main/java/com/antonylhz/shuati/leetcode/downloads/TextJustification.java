public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        int wordlen = 0, start = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() + wordlen + i - start > maxWidth) {
                result.add(buildLine(words, start, i - start, wordlen, maxWidth, false));
                wordlen = 0;
                start = i;
            }
            wordlen += words[i].length();
        }
        result.add(buildLine(words, start, words.length - start, wordlen, maxWidth, true));
        return result;
    }

    private String buildLine(String[] words, int start, int word, int wordlen, int maxWidth, boolean last) {
        StringBuilder sb = new StringBuilder();
        if (word == 1) {
            sb.append(words[start]);
            while (sb.length() < maxWidth) sb.append(" ");
        } else if (last) {
            for (int i = 0; i < word - 1; i++) {
                sb.append(words[start + i]);
                sb.append(" ");
            }
            sb.append(words[start + word - 1]);
            while (sb.length() < maxWidth) sb.append(" ");
        } else {
            int space_len = (maxWidth - wordlen) / (word - 1);
            int left_extra = maxWidth - wordlen - space_len * (word - 1);
            for (int j = 0; j < word - 1; j++) {
                sb.append(words[start + j]);
                for (int k = 0; k < space_len; k++) sb.append(" ");
                if (left_extra > 0) {
                    sb.append(" ");
                    left_extra--;
                }
            }
            sb.append(words[start + word - 1]);
        }
        return sb.toString();
    }
}
