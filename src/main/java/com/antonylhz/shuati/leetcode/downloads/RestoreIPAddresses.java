public class Solution {
    public List<String> restoreIpAddresses(String s) {
        return restoreIpAddresses(s, 4);
    }

    private List<String> restoreIpAddresses(String s, int segment) {
        List<String> result = new ArrayList<String>();
        if (segment == 1) {
            if (s.length() > 0 && Integer.parseInt(s) < 256 && (s.charAt(0) != '0' || s.length() == 1)) result.add(s);
            return result;
        } else if (s.length() < segment || s.length() > segment * 3) return new ArrayList<String>();
        for (int d = 1; d <= 3 && d <= s.length(); d++) {
            if (s.charAt(0) == '0' && d > 1) break;
            String head = s.substring(0, d);
            if (d == 3 && Integer.parseInt(head) > 255) break;
            List<String> temp = restoreIpAddresses(s.substring(d, s.length()), segment - 1);
            for (String str : temp) {
                if (str != "") result.add(head + "." + str);
                else result.add(head);
            }
        }
        return result;
    }
}