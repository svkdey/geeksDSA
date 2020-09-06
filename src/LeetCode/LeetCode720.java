package LeetCode;

import java.util.HashMap;
import java.util.LinkedHashMap;

import TrieRevised.TrieNode;

public class LeetCode720 {

public class TrieNode {
	char data;
	HashMap<Character, TrieNode> children;
	boolean isEnd;
	String word;

	public TrieNode(char data) {
		super();
		this.data = data;
		children=new HashMap<Character, TrieNode>();
		this.isEnd = false;
	}

	@Override
	public String toString() {
		return "TrieNode [data=" + data + ", children=" + children + ", isEnd=" + isEnd + "]";
	}
}

	public class Trie {
		TrieNode root;

		public Trie() {
			super();
			this.root = new TrieNode('\0');
		}
		
		
		public void insert(String word) {
			TrieNode temp=root;
			for(char letter:word.toCharArray()) {
				if(!temp.children.containsKey(letter)) {
					temp.children.put(letter, new TrieNode(letter));
				}
				 temp=temp.children.get(letter);
				 temp.isEnd=false;
			}
			
			temp.word=word;
		}
		public boolean find(String word) {
			TrieNode temp=root;
			for(char letter:word.toCharArray()) {
				if(!temp.children.containsKey(letter)) {
					return false;
				}
				 temp=temp.children.get(letter);
			}
			return temp.isEnd;
		}
		
	}
//	public String longestWord(String[] words) {
//       
//    
//	}
}
