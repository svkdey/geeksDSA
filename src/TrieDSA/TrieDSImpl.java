package TrieDSA;

public class TrieDSImpl {
	public static void insert(TrieNode root, String key) {
		TrieNode current = root;
		for (int i = 0; i < key.length(); i++) {
			int idxOfithChar = key.charAt(i) - 'a';

			if (current.child[idxOfithChar] == null) {
				current.child[idxOfithChar] = new TrieNode();
			}
			current = current.child[idxOfithChar];
		}
		current.isEnd = true;
	}

	public static boolean search(TrieNode root, String key) {
		TrieNode curNode = root;

		for (int i = 0; i < key.length(); i++) {
			int idxOf_iThKey = key.charAt(i) - 'a';

			if (curNode.child[idxOf_iThKey] == null) {
				return false;
			}
			curNode = curNode.child[idxOf_iThKey];
		}

		return curNode.isEnd;
	}

	public static void delete(TrieNode root, String key) {
		deleteUtil(root, key, 0);
	}

	private static TrieNode deleteUtil(TrieNode root, String key, int i) {
		if (root == null)
			return null;

		// for i==key.length()
		if (i == key.length()) {
			if (root.isEnd == true) {
				root.isEnd = false;
			}

			// if last node return null else return node;
			if (isEmpty(root)) {
				root = null;
			}
			return root;
		}

		// else

		int idx = key.charAt(i) - 'a';
		//recusive call for next character
		root.child[idx] = deleteUtil(root.child[idx] , key, i + 1);
		// if all the child is null then root will be set as null
		if (isEmpty(root) && root.isEnd == false) {
			root = null;
		}

		return root;
	}

	private static boolean isEmpty(TrieNode root) {

		for (int i = 0; i < 26; i++) {
			if (root.child[i] != null) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		TrieNode root = new TrieNode();
		insert(root, "abc");
		System.out.println(search(root, "acc"));
		String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their", "hero", "heroplane" };

		int n = keys.length;
// Construct trie 
		for (int i = 0; i < n; i++)
			insert(root, keys[i]);
		
		System.out.println(search(root, "there"));
		System.out.println(search(root, "therei"));
		System.out.println(search(root, "a"));
		System.out.println(search(root, "any"));
		delete(root, "any");
		System.out.println(search(root, "any"));
		delete(root, "hero");
		System.out.println(search(root, "heroplane"));

	}

}
