package LeetCode.InterviewPrep;

import java.util.HashMap;

class Trie {
    class Node{
        char data;
        HashMap<Character,Node> children=new HashMap<Character,Node>();
        boolean isEnd=false;
        public Node(char d){
            data=d;
        }
    }
    /** Initialize your data structure here. */
    Node head=null;
    public Trie() {
        head=new Node('\0');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node current=head;
        for(char c:word.toCharArray()) {
        	if(current.children.containsKey(c)){
        		current=current.children.get(c);
        	}else {
        		current.children.put(c, new Node(c));
        		current=current.children.get(c);
        	}
        }
        current.isEnd=true;
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	 Node current=head;
         for(char c:word.toCharArray()) {
         	if(current.children.containsKey(c)){
         		current=current.children.get(c);
         	}else {
         		return false;
         	}
         }
         return current.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	Node current=head;
        for(char c:prefix.toCharArray()) {
        	if(current.children.containsKey(c)){
        		current=current.children.get(c);
        	}else {
        		return false;
        	}
        }
        return true;
    }
}