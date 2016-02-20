package com.antonylhz.shuati.hackerrank;

import java.util.*;

public class SpecialArray {

    static HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
	
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. 
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0; i<T; i++) {
            int N = in.nextInt(), pSum = in.nextInt();
            int[] arr = new int[N];
            Arrays.fill(arr, 1);
            System.out.println(getSpecialSum(arr, pSum));
        }
        in.close();
        */
    	int[] arr = new int[6];
    	//Arrays.fill(arr, 1);
        //System.out.println(getSpecialSum(arr, 10));
    	Arrays.fill(arr, 1);
        System.out.println(getSpecialSum(arr, 5));
    }
    
    static int getSpecialSum(int[] arr, int pSum) {
    	boolean full = false;
    	int N = arr.length;
    	if(pSum<5||pSum>10) {
    		if(cache.containsKey(N)) {
    			return cache.get(N);
    		}
    		full = true;
        }
    	
        int result = 0, last2 = -1;
    	
        int temp = 0;
        for(int i=0; i<5; i++) {
            temp += arr[i];
        }
        boolean valid = temp!=pSum;
        if(valid) {
            for(int i=5; i<arr.length; i++) {
                temp += arr[i] - arr[i-5];
                if(temp==pSum) {
                    valid = false;
                }
            }
        }
        if(valid) {
            result = sum(find(arr), result);
        }
    	
        for(int i=0; i<arr.length; i++) {
            if(arr[i]==2) {
                last2 = i;
            }
        }
        full &= last2<0;
        for(int i=last2+1; i<arr.length; i++) {
            arr[i] = 2;
            result = sum(getSpecialSum(arr, pSum), result);
            arr[i] = 1;
        }
        
        if(full) cache.put(arr.length, result);
        return result;
    }
    
    static int sum(int num1, int num2) {
        long result = num1 + num2;
        if(result > 1e9 + 7) {
            result %= (1e9 + 7);
        }
        return (int)result;
    }
    
    static int find(int[] arr) {
        int sum = 0;
        int i = 0;
        while(i < arr.length) {
            sum = sum + arr[i];
            i = i + arr[i];
        }
        return sum;
    }
    
}