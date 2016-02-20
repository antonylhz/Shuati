package com.antonylhz.shuati.random;

import java.util.Arrays;
import java.util.Comparator;

/**
 * AirBnB phone
 * 
 * Given an array of numbers A = [x1, x2, ..., xn] and T = Round(x1+x2+... +xn). 
	We want to find a way to round each element in A 
	such that after rounding we get a new array B = [y1, y2, ...., yn] 
	such that y1+y2+...+yn = T where  yi = Floor(xi) or Ceil(xi), ceiling or floor of xi.
	We also want to minimize sum |x_i-y_i|
 * 
 * @author antonylhz
 *
 */

public class RoundArray {
	public static void main(String[] args) {
		Double[] arr = new Double[] {
				2.8, 1.9, 3.7, 4.6, 5.5, 6.4, 7.3, 8.2, 9.1
		};
		int T = 0;
		for(double num : arr) {
			T += (int)Math.round(num);
		}
		System.out.println(T);
		Arrays.sort(arr, new Comparator<Double>() {
			@Override
			public int compare(Double d1, Double d2) {
				return (d1-Math.floor(d1)) - (d2-Math.floor(d2)) >= 0.0 ? 1: -1;
			}
		});
		System.out.println(Arrays.toString(arr));
		int[] B = new int[arr.length];
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			B[i] = (int)Math.floor(arr[i]);
			sum += B[i];
		}
		T -= sum;
		for(int i=0; i<T; i++) {
			B[B.length-1-i]++;
		}
		System.out.println(Arrays.toString(B));
		sum = 0;
		for(int num : B) sum += num;
		System.out.println(sum);
	}
}
