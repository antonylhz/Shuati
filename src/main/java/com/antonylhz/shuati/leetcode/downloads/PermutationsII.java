public class Solution {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> permuteUnique(int[] num) {
        if(num==null||num.length==0) return result;
        Arrays.sort(num);
        int i = 0;
        while(i<num.length) {
            int j = i+1;
            while(j<num.length&&num[j]==num[i]) j++;
            mingle(num[i], j-i);
            i=j;
        }
        return result;
    }
    private void mingle(int value, int count) {
        if(result.isEmpty()) {
            List<Integer> temp = new ArrayList<Integer>();
            for(int i=0; i<count; i++) temp.add(value);
            result.add(temp);
        } else {
            int size = result.size();
            for(int i=0; i<size; i++) {
                List<Integer> tlist = result.remove(0);
                List<List<Integer>> tresult = new ArrayList<List<Integer>>();
                List<Integer> left = new ArrayList<Integer>();
                tresult.add(tlist);
                left.add(0);
                for(int c = 0; c<count; c++) {
                    int tsize = tresult.size();
                    for(int j=0; j<tsize; j++) {
                        List<Integer> list = tresult.remove(0);
                        int start = left.remove(0);
                        for(int ins = start; ins<=list.size(); ins++) {
                            List<Integer> temp = new ArrayList<Integer>(list);
                            temp.add(ins, value);
                            tresult.add(temp);
                            left.add(ins+1);
                        }
                    }
                }
                result.addAll(tresult);
            }
        }
    }
}


