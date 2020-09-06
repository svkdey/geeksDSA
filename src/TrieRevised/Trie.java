package TrieRevised;

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
		}
		temp.isEnd=true;
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
