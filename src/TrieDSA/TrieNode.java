package TrieDSA;

import java.util.Arrays;

public class TrieNode {
	TrieNode child[] = new TrieNode[26];
	boolean isEnd;

	public TrieNode() {
	}

	@Override
	public String toString() {
		return "TrieNode [child=" + Arrays.toString(child) + ", isEnd=" + isEnd + "]";
	}
	
}
