public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null || num.length < 1) return result;
        RecordComparator comparator = new RecordComparator();
        PriorityQueue<Record> q = new PriorityQueue<Record>(num.length, comparator);

        num = mergeSort(num, 0, num.length - 1);

        int count = 0;
        int curNum = num[0];
        for (int i = 0; i < num.length; i++) {
            if (num[i] != curNum && i < num.length - 1) {
                q.add(new Record(curNum, count));
                count = 1;
                curNum = num[i];
            } else if (num[i] == curNum && i == num.length - 1) {
                count++;
                q.add(new Record(curNum, count));
                break;
            } else if (num[i] != curNum && i == num.length - 1) {
                q.add(new Record(curNum, count));
                q.add(new Record(num[i], 1));
                break;
            } else count++;
        }

        result.add(new ArrayList<Integer>());
        while (q.peek() != null) {
            Record r = q.poll();
            int curSize = result.size();
            for (int i = 1; i < r.count + 1; i++) {
                for (int j = 0; j < curSize; j++) {
                    ArrayList<Integer> arr = new ArrayList<Integer>(result.get(j));
                    for (int k = 0; k < i; k++) arr.add(r.value);
                    result.add(arr);
                }
            }
        }

        return result;
    }

    private int[] mergeSort(int[] num, int start, int end) {
        if (end - start + 1 < 2) return new int[]{num[start]};
        int mid = (start + end) / 2;
        int[] left = mergeSort(num, start, mid);
        int[] right = mergeSort(num, mid + 1, end);
        int i = 0;
        int j = 0;
        int[] arr = new int[end - start + 1];
        while (i < left.length || j < right.length) {
            if (i == left.length) {
                while (j < right.length) arr[i + j] = right[j++];
                break;
            }
            if (j == right.length) {
                while (i < left.length) arr[i + j] = left[i++];
                break;
            }
            if (left[i] <= right[j]) arr[i + j] = left[i++];
            else arr[i + j] = right[j++];
        }
        return arr;
    }

    class Record {
        private int value;
        private int count;

        public Record(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    class RecordComparator implements Comparator<Record> {
        @Override
        public int compare(Record x, Record y) {
            if (x.value < y.value) return -1;
            else if (x.value > y.value) return 1;
            else return 0;
        }
    }
}

