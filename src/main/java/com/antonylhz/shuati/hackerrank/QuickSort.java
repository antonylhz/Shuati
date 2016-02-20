package com.antonylhz.shuati.hackerrank;

import java.util.*;

public class QuickSort {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if(N<2) return;
        
        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = in.nextInt();
        
        //In place quick sort
        partition(arr, 0, N-1);
    }
    
	/* Lomuto Partitioning. start and end inclusive */
    static void partition(int[] arr, int start, int end) {
        if(end<=start) return;
        int i=start, pivot = arr[end];
        while(i<end&&arr[i]<pivot) i++;
        if(i==end) {
            print(arr);
            partition(arr, start, end-1);
        } else {
            int j = i+1;
            while(j<end) {
                while(j<end&&arr[j]>pivot) j++;
                if(j<end) {
                    swap(arr, i++, j);
                }
            }
            swap(arr, i, end);
            print(arr);
            partition(arr, start, i-1);
            partition(arr, i+1, end);
        }
    }
    
    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
    
    static void print(int[] arr) {
        for(int num : arr) System.out.print(num + " ");
        System.out.println();
    }
}
