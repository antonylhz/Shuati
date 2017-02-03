package com.antonylhz.shuati.random;

import java.util.*;

import com.antonylhz.shuati.random.IterableList.CachedListIterator;

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
    private CachedListIterator iterator = null;

	IterableList(List<T> data) {
		this.data = data;
	}

	public CachedListIterator iterator() {
        if (iterator == null) {
            iterator = new CachedListIterator();
        }
        return iterator;
	}

	class CachedListIterator implements Iterator<T> {
		private int lastRet;

		CachedListIterator() {
            lastRet = -1;
		}

		@Override
		public boolean hasNext() {
			return lastRet + 1 < data.size();
		}

		@Override
		public T next() {
			return data.get(++lastRet);
		}

		boolean hasPrevious() {
			return lastRet > 0;
		}

		T previous() {
			return data.get(--lastRet);
		}
	}

}

public class ZigzagIterable2DList<T> implements Iterable<T>{
	
	private List<IterableList<T>> data;

    public ZigzagIterable2DList() {
        this.data = new ArrayList<>();
    }

	public ZigzagIterable2DList(List<List<T>> listOfLists) {
        this();
        if (listOfLists != null && listOfLists.size() > 0) {
            for (int i = 0; i < listOfLists.size(); i++) {
                data.add(new IterableList<T>(listOfLists.get(i)));
            }
        }
    }

	@Override
	public LListIterator iterator() {
		return new LListIterator();
	}
	
    class LListIterator implements Iterator<T> {

        private int index = -1;                         // Lastly returned list index; Initially at -1
        private IterableList<T>.CachedListIterator prev = null, next = null;     // Cache found positions from hasXXX() methods
        private boolean isNextPrepared = false;
        private boolean isPrevPrepared = false;

        LListIterator() {}
		
		@Override
		public boolean hasNext() {
            if (index >= 0) prev = data.get(index).iterator();
            for (int i = 0; i < data.size() - 1; i++) {     // Consider at most these many rows
                index = (index + 1) % data.size();
                if (data.get(index).iterator().hasNext()) {
                    next = data.get(index).iterator();
                    isNextPrepared = true;
                    return true;
                }
            }
            return false;
		}

		@Override
		public T next() {
            if (!isNextPrepared || isPrevPrepared) {
                throw new IllegalStateException();
            } else {
                isNextPrepared = false;
            }
            if (next == null) {  // This can happen either nothing next, or hasNext() is not called
                return null;
            } else {
                return next.next();
            }
		}

        public boolean hasPrevious() {
            if (index >= 0) next = data.get(index).iterator();
            for (int i = 0; i < data.size() - 1; i++) {  // Consider at most these many rows
                index = (index - 1 + data.size()) % data.size();
                if (data.get(index).iterator().hasPrevious()) {
                    prev = data.get(index).iterator();
                    isPrevPrepared = true;
                    return true;
                }
            }
            return false;
        }

        public T previous() {
            if (isNextPrepared || !isPrevPrepared) {
                throw new IllegalStateException();
            } else {
                isPrevPrepared = false;
            }
            if (prev == null) {
                return null;
            } else {
                return prev.previous();
            }
        }
		
	}

}
