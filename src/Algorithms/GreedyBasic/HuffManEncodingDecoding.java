package Algorithms.GreedyBasic;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffManEncodingDecoding {
	static class HoffManNode {
		char ch;
		int cost;
		HoffManNode left, right;

		@Override
		public String toString() {
			return "HoffManNode [ch=" + ch + ", cost=" + cost + ", left=" + left + ", right=" + right + "]";
		}

		public HoffManNode(char ch, int cost) {
			super();
			this.ch = ch;
			this.cost = cost;

		}

	}
	static HashMap<Character, String> result = new HashMap<Character, String>();
	public static HoffManNode huffmanEncoder(String str) {
		// step 1 .count frequency
		LinkedHashMap<Character, Integer> hm = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (hm.containsKey(c)) {
				hm.put(c, hm.get(c) + 1);
			} else {
				hm.put(c, 1);
			}
		}
		// add into priority queue
		Comparator<HoffManNode> rule = (a, b) -> {
			return a.cost - b.cost;
		};
		PriorityQueue<HoffManNode> pq = new PriorityQueue<HoffManNode>(rule);
		for (Map.Entry<Character, Integer> x : hm.entrySet()) {
			pq.add(new HoffManNode(x.getKey(), x.getValue()));
		}

		// build Hoffnam tree;

		while (pq.size() > 1) {
			HoffManNode a = pq.poll();
			HoffManNode b = pq.poll();

			HoffManNode newNode = new HoffManNode('\0', a.cost + b.cost);
			newNode.left = a;
			newNode.right = b;
			pq.add(newNode);

		}
		// last step . retrieve the last node
		// traverse and add 0 to right node 1 to left node
		HoffManNode root = pq.remove();
		

		for (Map.Entry<Character, Integer> x : hm.entrySet()) {
			String s = "";
			preDFS(root, x.getKey(), s,result);

		}
		System.out.println(result);
		return root;
	}

	static void preDFS(HoffManNode root, char c, String s,HashMap<Character, String> result) {
		if (root == null)
			return;
		// node logic
		if (root.ch == c) {
			result.put(c, s);
			return;
		}
		
		preDFS(root.left, c, s+"0",result);
		preDFS(root.right, c, s+"1",result);
		return;
	}
	
	public static String huffManDecoder(HoffManNode root,String encoded) {
		String decoded="";
		HoffManNode curr=root;
		
		for(int i=0;i<encoded.length();i++) {
			if(encoded.charAt(i)=='0') {
				curr=curr.left;
			}else {
				curr=curr.right;
			}
			
			//when reach null .add the character, and set node again
			if(curr.left==null&&curr.right==null) {
				decoded+=curr.ch;
				curr=root;
			}
		}
		return decoded;
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="geeksforgeeks";
		HoffManNode root=huffmanEncoder(s);
		String encodedStr="";
		for(int i=0;i<s.length();i++) {
			encodedStr+=result.get(s.charAt(i));		
		}
		
		System.out.println(encodedStr);
		
		System.out.println(huffManDecoder(root,encodedStr));
	}

}
