package com.antonylhz.shuati.random;

import java.util.*;

import com.antonylhz.shuati.random.IterableList.LIterator;

/**
 * Problem Description:

	Given two 1d vectors, implement an iterator to return their elements alternately.

	For example, given two 1d vectors:
	
	v1 = [1, 2]
	v2 = [3, 4, 5, 6] 
	By calling next repeatedly until hasNext returns false, 
	the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
	
	Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
	
	Follow up: 如果这些iterator都有hasPrevious(), previous()方法，意思就是后退一步，你的class也应该有这两个方法，来后退一步
	
 * @author antonylhz
 *
 */

class IterableList<T> implements Iterable<T>{
	private List<T> data;
	public IterableList(List<T> data) {
		this.data = data;
	}
	public LIterator iterator() {
		return new LIterator();
	}
	class LIterator implements Iterator<T> {
		private int index;
		public LIterator() {
			index = 0;
		}
		@Override
		public boolean hasNext() {
			return index < data.size();
		}

		@Override
		public T next() {
			return data.get(index++);
		}
		
		public boolean hasPrevious() {
			return index > 0;
		}
		
		public T previous() {
			return data.get(--index);
		}
	}
}

public class ZigzagIterable2DList<T> implements Iterable<T>{
	
	private List<IterableList<T>> data;
	
	public ZigzagIterable2DList(List<IterableList<T>> data) {
		this.data = data;
	}

	@Override
	public LListIterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class LListIterator<T> implements Iterator<T> {

		private int[] idx, ts;
		private int timer, tsize;
		
		public LListIterator() {
			idx = new int[data.size()];
			ts = new int[data.size()];
			timer  = 0;
		}
		
		private int curIndex() {
			return 0;
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);list.add(2);list.add(3);list.add(4);
		IterableList<Integer> it = new IterableList<>(list);
		LIterator itr = it.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		while(itr.hasPrevious()) {
			System.out.println(itr.previous());
		}
	}

}
