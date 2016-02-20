public class Solution {
    public String simplifyPath(String path) {
        List<String> list = new ArrayList<String>();
        String[] tokens = path.split("/");
        int cur = -1;
        for(String str : tokens) {
            if(str.equals(".")||str.equals("")) {
                continue;
            } else if(str.equals("..")) {
                cur--;
                if(cur==-2) {
                    list.add(0, "");list.add(0, "");
                    cur = 0;
                }
                if(cur==-1) {
                    list.add(0, "");
                    cur = 0;
                }
            } else {
                if(list.isEmpty()||cur==list.size()-1) {
                    list.add(str);
                } else{
                    list.set(cur+1, str);
                }
                cur++;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!list.isEmpty()&&list.get(0).equals("")) {
            list.remove(0);
            cur--;
        }
        for(int i=0; i<=cur; i++) {
            sb.append("/").append(list.get(i));
        }
        if(sb.toString().equals("")) return "/";
        return sb.toString();
    }
}
