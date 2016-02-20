package com.antonylhz.shuati.random;
import java.util.*;
class HMNode<K, V> {
	K key;
	V val;
	HMNode<K, V> next;
	public HMNode(K key, V val) {
		this.key = key;
		this.val = val;
	}
}

public class MyHashMap<K, V> {
	private static final int CAPACITY = 17;
	private HMNode<K, V>[] table;
	@SuppressWarnings("unchecked")
	public MyHashMap() {
		table = (HMNode<K, V>[])new HMNode[CAPACITY];
	}
	public void put(K key, V val) {
		int hashcode = key.hashCode() % CAPACITY;
		if(hashcode<0) hashcode += CAPACITY;
		HMNode<K, V> node = new HMNode<>(key, val);
		if(table[hashcode]==null) table[hashcode] = node;
		else {
			HMNode<K, V> n = table[hashcode];
			while(n.next!=null) n = n.next;
			n.next = node;
		}
	}
	public V get(K key) {
		int hashcode = Objects.hashCode(key) % CAPACITY;
		if(hashcode < 0) hashcode += CAPACITY;
		HMNode<K, V> node = table[hashcode];
		if(node==null) return null;
		while(!node.key.equals(key) && node.next!=null) node = node.next;
		return node==null?null:node.val;
	}
	
	public static void main(String[] args) {
		MyHashMap<String, String> map = new MyHashMap<>();
		map.put("Sylvia", "Li");
		map.put("Scarlett", "Liu");
		System.out.println(map.get("Sylvia"));
	}
}
