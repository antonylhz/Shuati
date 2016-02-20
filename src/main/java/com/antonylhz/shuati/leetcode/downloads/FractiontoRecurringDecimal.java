public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
    	if(denominator == 0) return "";
    	else if(numerator == 0) return "0";
    	StringBuffer sb = new StringBuffer();
    	long n, d;
    	if((numerator>0&&denominator<0) || (numerator<0&&denominator>0)) sb.append('-');
    	n = Math.abs((long)numerator);
    	d = Math.abs((long)denominator);
    	sb.append(n/d);
    	long residue = n%d;
    	if(residue==0) return sb.toString();
    	sb.append('.');
    	StringBuffer fpart = new StringBuffer();
    	HashMap<Long, Integer> map = new HashMap<Long, Integer>();
    	int k = 0;
	    residue *= 10;
    	while(residue > 0) {
    		if(!map.isEmpty() && map.containsKey(residue)) {
    			int rindex = map.get(residue);
    			sb.append(fpart.substring(0, rindex)).append('(').append(fpart.substring(rindex)).append(')');
    			break;
    		}
	    	map.put(residue, k++);
	    	fpart.append(residue/d);
	    	residue%=d;
	    	if(residue==0) sb.append(fpart);
	    	residue *= 10;
    	}
    	return sb.toString();
    }
}
