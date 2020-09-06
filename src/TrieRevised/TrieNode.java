package TrieRevised;

import java.util.HashMap;

public class TrieNode {
	char data;
	HashMap<Character, TrieNode> children;
	boolean isEnd;

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
