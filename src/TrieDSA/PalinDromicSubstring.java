package TrieDSA;

import java.util.ArrayList;
import java.util.Arrays;

public class PalinDromicSubstring {
	private static boolean isPalidrome(String str, int start, int pos) {
		int s = start, e = pos;
		while (e > s) {
			if (str.charAt(s) != str.charAt(e)) {
				return false;
			}
			s++;
			e--;
		}

		return true;
	}

	static class TrieNode {
		TrieNode children[] = new TrieNode[26];
		boolean isLeaf;
		int id;
		ArrayList<Integer> list = null;

		public TrieNode() {
			this.list = new ArrayList<Integer>();
		}

		@Override
		public String toString() {
			return "TrieNode [children=" + Arrays.toString(children) + ", isLeaf=" + isLeaf + ", id=" + id + ", list="
					+ list + "]";
		}

	}

	private static void insert(TrieNode root, int id, String key) {
		TrieNode current = root;
		for (int i = key.length() - 1; i >= 0; i--) {
			int idx = key.charAt(i) - 'a';
//			System.out.println(idx);
			if (current.children[idx] == null) {
				current.children[idx] = new TrieNode();
			}
			if (isPalidrome(key, 0, i)) {
				current.list.add(i);
			}
			current = current.children[idx];
		}

		current.id = id;
		current.list.add(id);
		current.isLeaf = true;
	}

	private static void search(TrieNode root, int id, String key, ArrayList<ArrayList<Integer>> list) {
		TrieNode current = root;
		for (int i = 0; i < key.length(); i++) {
			int idx = key.charAt(i) - 'a';
			if (current.id >= 0 && current.id != id && isPalidrome(key, i, key.length() - 1)) {
				ArrayList<Integer> l = new ArrayList<Integer>();
				l.add(id);
				l.add(current.id);
				list.add(l);
			}
			if (current.children[idx] == null) {
				return;
			}

			current = current.children[idx];
		}

		for (int i : current.list) {
			if (i == id) {
				continue;
			}
			ArrayList<Integer> l = new ArrayList<Integer>();
			l.add(id);
			l.add(current.id);
			list.add(l);
		}
	}

	public static boolean isPalidormicPair(String s[]) {
		TrieNode root = new TrieNode();

		for (int i = 0; i < s.length; i++) {
			insert(root, i, s[i]);
		}
		System.out.println(root);
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < s.length; i++) {
			search(root, i, s[i], list);
		}
		System.out.println(list);
		return list.size() > 0 ? true : false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s[] = { "abcd", "efgh", "ii", "kl", "mnop" };
//		int count=0;
		isPalidormicPair(s);
		;
	}

}
