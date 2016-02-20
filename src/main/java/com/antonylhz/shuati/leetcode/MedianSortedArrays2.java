package com.antonylhz.shuati.leetcode;

public class MedianSortedArrays2 {
    private int[] nums1, nums2;
    private int len1, len2;
    private boolean even;
    
    public static void main(String args[]) {
		MedianSortedArrays2 msa = new MedianSortedArrays2();
		int A[] = new int[] {1};
		int B[] = new int[] {2,3,4};
		System.out.println(msa.findMedianSortedArrays(A, B));
	}
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.len1 = nums1.length;
        this.len2 = nums2.length;
        this.even = ((len1+len2)%2==0);
        if(len1==0&&len2==0) return 0;
        if(len1==0) return findMedianSortedArrays(nums2, len2/2);
        if(len2==0) return findMedianSortedArrays(nums1, len1/2);
        return findMedianSortedArrays(0, 0);
    }
    
    private double findMedianSortedArrays(int s1, int s2) {
        int diff = len1+len2-2*s1-2*s2;
        if(diff<0) {
        	return ((double)nums1[len1-1]+nums2[len2-1])/2;
        } else if(diff==0) {
        	if(s1==len1) return ((double)nums1[len1-1]+nums2[s2])/2;
        	if(s2==len2) return ((double)nums2[len2-1]+nums1[s1])/2;
            if(s1==0) return ((double)nums2[s2-1]+Math.min(nums1[s1], nums2[s2]))/2;
            if(s2==0) return ((double)nums1[s1-1]+Math.min(nums1[s1], nums2[s2]))/2;
            return ((double)Math.max(nums1[s1-1], nums2[s2-1]) + Math.min(nums1[s1], nums2[s2]))/2;
        } else if(diff==1) {
        	if(s1==len1) return nums2[s2];
        	if(s2==len2) return nums1[s1];
        	return Math.min(nums1[s1], nums2[s2]);
        } else if(s1==len1) {
        	return findMedianSortedArrays(nums2, (len2-len1)/2);
        } else if(s2==len2) {
        	return findMedianSortedArrays(nums1, (len1-len2)/2);
        }
        
        int rm = diff/4;
        int t1 = s1+(rm>0?rm-1:0), t2 = s2+(rm>0?rm-1:0);
        
        if(t1>=len1) t1 = len1-1;
        if(t2>=len2) t2 = len2-1;
        
        if(nums1[t1]<nums2[t2]) return findMedianSortedArrays(t1+1, s2);
        else if(nums1[t1]>nums2[t2]) return findMedianSortedArrays(s1, t2+1);
        else {
        	if(diff==2) return nums1[t1];
        	return findMedianSortedArrays(t1+1, t2+1); //next iteration either diff==0 or diff==1
        }
    }
    
    private double findMedianSortedArrays(int[] nums, int target) {
        return even?
                ((double)(nums[target])+(nums[target-1]))/2:
                (double)(nums[target]);
    }
}
