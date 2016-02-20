public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<int[]>();
        if(buildings==null||buildings.length==0) return result;
        List<Integer> xlist = new ArrayList<Integer>();
        for(int[] building : buildings) {
            xlist.add(building[0]);
            xlist.add(building[1]);
        }
        Collections.sort(xlist);
        for(int i=0; i<xlist.size()-1; i++) {
            if(xlist.get(i)==xlist.get(i+1)) {
                xlist.remove(i--);
            }
        }
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for(int i=0; i<xlist.size(); i++) hmap.put(xlist.get(i), i);
        int[] hlist = new int[xlist.size()];
        for(int[] building : buildings) {
            int left = hmap.get(building[0]);
            int right = hmap.get(building[1]);
            for(int i=left; i<right; i++) {
                if(hlist[i]<building[2]) hlist[i] = building[2];
            }
        }
        int last = 0, left = 0;
        for(int i=0; i<xlist.size(); i++) {
            if(i>0 && hlist[i]!=last) {
                result.add(new int[]{xlist.get(left), last});
                left = i;
            }
            last = hlist[i];
        }
        result.add(new int[]{xlist.get(left), last});
        return result;
    }
}

