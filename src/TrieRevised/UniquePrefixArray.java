package TrieRevised;

public class UniquePrefixArray{

	public static void solve(TrieNode root, String word) {
		TrieNode temp = root;
		int i = 0;
		for (char letter : word.toCharArray()) {
			if (temp.children.size() == 1) {
				break;
			}	
			i++;
			temp = temp.children.get(letter);

		}
		System.out.println(word.substring(0, i));
	}

	public static void main(String[] args) {
		String arr[] = { "cobra", "dog", "dove", "duck" };
		Trie t = new Trie();
		for (String s : arr) {
			t.insert(s);
		}
	
		for (String s : arr) {
			solve(t.root, s);
		}
	}
}
