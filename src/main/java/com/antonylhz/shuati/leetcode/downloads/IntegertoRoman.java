public class Solution {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int last = num % 10;
        switch (last) {
            case 1:
                result.insert(0, "I");
                break;
            case 2:
                result.insert(0, "II");
                break;
            case 3:
                result.insert(0, "III");
                break;
            case 4:
                result.insert(0, "IV");
                break;
            case 5:
                result.insert(0, "V");
                break;
            case 6:
                result.insert(0, "VI");
                break;
            case 7:
                result.insert(0, "VII");
                break;
            case 8:
                result.insert(0, "VIII");
                break;
            case 9:
                result.insert(0, "IX");
                break;
        }
        num /= 10;
        if (num == 0) return result.toString();
        last = num % 10;
        switch (last) {
            case 1:
                result.insert(0, "X");
                break;
            case 2:
                result.insert(0, "XX");
                break;
            case 3:
                result.insert(0, "XXX");
                break;
            case 4:
                result.insert(0, "XL");
                break;
            case 5:
                result.insert(0, "L");
                break;
            case 6:
                result.insert(0, "LX");
                break;
            case 7:
                result.insert(0, "LXX");
                break;
            case 8:
                result.insert(0, "LXXX");
                break;
            case 9:
                result.insert(0, "XC");
                break;
        }
        num /= 10;
        if (num == 0) return result.toString();
        last = num % 10;
        switch (last) {
            case 1:
                result.insert(0, "C");
                break;
            case 2:
                result.insert(0, "CC");
                break;
            case 3:
                result.insert(0, "CCC");
                break;
            case 4:
                result.insert(0, "CD");
                break;
            case 5:
                result.insert(0, "D");
                break;
            case 6:
                result.insert(0, "DC");
                break;
            case 7:
                result.insert(0, "DCC");
                break;
            case 8:
                result.insert(0, "DCCC");
                break;
            case 9:
                result.insert(0, "CM");
                break;
        }
        num /= 10;
        if (num == 0) return result.toString();
        for (int i = 0; i < num; i++) result.insert(0, "M");
        return result.toString();
    }
}
