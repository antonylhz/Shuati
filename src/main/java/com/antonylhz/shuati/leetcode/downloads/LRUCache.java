public class LRUCache {

    private int ts;
    private int capacity;
    private PriorityQueue<TS> heap;
    private HashMap<Integer, TS> map;

    public LRUCache(int capacity) {
        this.ts = 0;
        this.capacity = capacity;
        this.heap = new PriorityQueue<TS>(capacity, new TSComparator());
        this.map = new HashMap<Integer, TS>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        TS oldts = map.get(key);
        TS newts = new TS(++ts, key, oldts.val);
        heap.remove(oldts);
        heap.add(newts);
        map.put(key, newts);
        return oldts.val;
    }

    public void set(int key, int value) {
        TS curts = new TS(++ts, key, value);
        if (map.containsKey(key)) {
            heap.remove(map.get(key));
        }
        if (heap.size() == capacity) {
            map.remove(heap.poll().key);
        }
        map.put(key, curts);
        heap.add(curts);
    }

    class TS {
        int ts;
        int key;
        int val;

        public TS(int ts, int key, int val) {
            this.ts = ts;
            this.key = key;
            this.val = val;
        }
    }

    class TSComparator implements Comparator<TS> {
        @Override
        public int compare(TS x, TS y) {
            if (x.ts < y.ts) return -1;
            else if (x.ts > y.ts) return 1;
            else return 0;
        }
    }
}
