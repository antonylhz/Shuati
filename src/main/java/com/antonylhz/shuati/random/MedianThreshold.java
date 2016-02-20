package com.antonylhz.shuati.random;

/** 
 * Given a sorted array of integers. 
 * Find the median of the items that greater than or equal to an threashold.
 * int find_median( int[] array, int threashold)
 * For example:
 * array = [ 1, 2, 3, 4, 5, 6, 7, 8, 9]
 * threashold = 5
 * return median = 7
 * 
 * @author antonylhz
 *
 */

public class MedianThreshold {
	public static void main(String[] args) {
		int[] array = new int[] {
				1, 2, 3, 4, 5, 7, 8, 9
		};
		System.out.println(findMedian(array, 5));
	}
	
	private static double findMedian(int[] array, int threshold) {
		int start = findGreaterEqual(array, threshold);
		if(start > array.length - 1) {
			return -1;
		} else {
			int length = array.length - start, mid = (start+array.length-1)/2;
			if((length&1) > 0) { //odd
				return array[mid];
			} else { //even
				return (array[mid] + array[mid+1]) / 2.0;
			}
		}
	}
	
	/**
	 * @param array
	 * @param threashold
	 * @return the index of the first item that is great than or equal to 'threshold'
	 * 
	 * Solution: binary search
	 */
	private static int findGreaterEqual(int[] array, int threshold) {
		int i = 0, j = array.length - 1;
		while(i <= j) {
			int m = (i + j) / 2;
			if(array[m] == threshold) {
				while(m>=1 && array[m-1]==threshold) {
					m--;
				}
				return m;
			} else if(array[m] < threshold) {
				i = m+1;
			} else {
				j = m-1;
			}
		}
		return i; // This happens when threshold is not in array
	}
}
