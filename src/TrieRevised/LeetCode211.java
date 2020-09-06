package TrieRevised;

import java.util.HashMap;

public class LeetCode211 {
	class WordDictionary {

		class Trie {
			class Node {
				char data;
				HashMap<Character, Node> children;
				boolean isEnd;

				public Node(char data) {
					super();
					this.data = data;
					this.children = new HashMap<Character, Node>();
					this.isEnd = false;
				}

			}

			Node root;

			public Trie() {
				root = new Node('\0');
			}

			/** Inserts a word into the trie. **/
			public void insert(String word) {
				Node temp = root;
				for (char c : word.toCharArray()) {
					if (!temp.children.containsKey(c)) {
						temp.children.put(c, new Node(c));
					}
					temp = temp.children.get(c);
				}
				temp.isEnd = true;
			}

			/** Returns if the word is in the trie. */
			public boolean search(String word, int start, Node node) {
				Node temp = node;
				for (int i = start; i < word.length(); i++) {
					char c = word.charAt(i);
					if (c == '.') {
						if (temp.children.size() > 0) {
							for (char x : temp.children.keySet()) {
								if (search(word, i + 1, temp.children.get(x))) {
									return true;
								}
							}
						}
					} else if (!temp.children.containsKey(c)) {
						return false;
					}
					temp = temp.children.get(c);
				}
				return temp.isEnd;
			}

			public boolean startsWith(String prefix) {
				Node temp = root;
				for (char c : prefix.toCharArray()) {
					if (!temp.children.containsKey(c)) {
						return false;
					}
					temp = temp.children.get(c);
				}
				return true;
			}
		}

		Trie t;

		public WordDictionary() {
			t = new Trie();
		}

		public void addWord(String word) {
			t.insert(word);
		}

		public boolean search(String word) {
			return t.search(word, 0, t.root);
		}
	}
}
