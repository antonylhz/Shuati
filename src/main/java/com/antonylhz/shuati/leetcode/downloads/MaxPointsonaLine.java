/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
		if(points == null || points.length < 1) return 0;
		else if(points.length < 2) return 1;
        int max = 0;
        for(int i=0; i<points.length; i++) {
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            int dup = 1;
            for(int j=i+1; j<points.length; j++) {
                //Iterate all points, and calculate slope
                if(points[i].x == points[j].x && points[i].y == points[j].y) {
                	dup++;
                	max = max < dup ? dup : max;
                }
                else if(points[i].x == points[j].x){
                	int count;
                	if(map.get(Double.MAX_VALUE) != null)
                		count = map.get(Double.MAX_VALUE) + 1;
                	else count = 1;
                    map.put( new Double(Double.MAX_VALUE), new Integer(count));
                }
                else {
                    double slope = (points[j].y - points[i].y) / (double) (points[j].x-points[i].x);
                    if(Math.abs(slope) < 1e-16) slope = 0;
                    int count;
                    if(map.get(slope) != null)
                        count = map.get(new Double(slope)).intValue() + 1;
                    else count = 1;
                    map.put(new Double(slope), new Integer(count));
                }
            }
            Iterator it = map.entrySet().iterator();
            while(it.hasNext()) {
                Map.Entry<Double, Integer> entry = (Map.Entry<Double, Integer>)it.next();
                int count = entry.getValue() + dup;
                max = max < count ? count : max;
            }
        }
        return max;
    }
}


