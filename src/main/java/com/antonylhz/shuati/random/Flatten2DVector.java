package com.antonylhz.shuati.random;

import java.util.Iterator;

/*
 * Implement an iterator to flatten a 2d vector.
	For example,
	Given 2d vector =
	[
	  [1,2],
	  [3],
	  [4,5,6]
	]
	By calling next repeatedly until hasNext returns false, 
	the order of elements returned by next should be: [1,2,3,4,5,6].
 */


class Iterator2D<E> implements Iterator<E>{
	private E[][] matrix;
	private int i, j;
	public Iterator2D(E[][] matrix) {
		this.matrix = matrix;
		i = 0;
		j = 0;
	}
	
	@Override
	public boolean hasNext() {
		while(i < matrix.length && j >= matrix[i].length) {
			i++;
			j = 0;
		}
		return i < matrix.length;
	}

	@Override
	public E next() {
		return matrix[i][j++];
	}

	@Override
	public void remove() {
		// unimplemented
	}
}

public class Flatten2DVector {
	public static void main(String[] args) {
		Integer[][] matrix = new Integer[3][];
		matrix[0] = new Integer[] {
			1, 2
		};
		matrix[1] = new Integer[] {
			3
		};
		matrix[2] = new Integer[] {
			4, 5, 6
		};
		Iterator2D<Integer> it = new Iterator2D<Integer>(matrix);
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
