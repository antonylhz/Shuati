public class NumArray {

    private int[] arr, bit;

    public NumArray(int[] nums) {
        arr = new int[nums.length];
        bit = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }
    }

    void update(int i, int val) {
        val -= arr[i];
        if (val != 0) {
            for (int index = i + 1; index < bit.length; index += index & (-index)) {
                bit[index] += val;
            }
        }
        arr[i] += val;
    }

    private int getSum(int i) {
        int sum = 0;
        for (int index = i + 1; index > 0; index -= index & (-index)) {
            sum += bit[index];
        }
        return sum;
    }

    public int sumRange(int i, int j) {
        if (i == 0) return getSum(j);
        return getSum(j) - getSum(i - 1);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);