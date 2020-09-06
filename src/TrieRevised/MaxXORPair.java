package TrieRevised;

public class MaxXORPair {
	static class Node {
		int data;
		Node left=null;
		Node right=null;
		public Node(int data) {
					this.data = data;
		}
		@Override
		public String toString() {
			return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
		}
		
	}
	static class XorTrie{
		Node root;

		public XorTrie() {
			this.root = new Node(-1000);
		}
		
		public void insert(int n) {
			Node temp=root;
			for(int i=31;i>=0;i--) {
				int bit=(n>>i)&1;
				if(bit==0) {
					if(temp.left==null) {
						temp.left=new Node(0);
					}
					temp=temp.left;
				}else {
					if(temp.right==null) {
						temp.right=new Node(1);
					}
					temp=temp.right;
				}
			}
		}
		
		int max_xor_with_otherNumber(int value) {
			int curAns=0;
			Node temp=root;
			for(int i=31;i>=0;i--) {
				int bit=(value>>i)&1;
				
				if(bit==0) {
					if(temp.right!=null) {
						temp=temp.right;
						curAns+=(1<<i);
					}
					else {
						temp=temp.left;
					}
				}else {
					if(temp.left!=null) {
						temp=temp.left;
						curAns+=(1<<i);
					}
					else {
						temp=temp.right;
					}
				}
			}
			return curAns;
			
		}
		int max_XOR_pair(int ips[],int n) {
			int max=0;
			for(int ip:ips ) {
				insert(ip);
				int max_xor_pairAns=max_xor_with_otherNumber(ip);
				System.out.println(max_xor_pairAns);
				max=Math.max(max, max_xor_pairAns);
				
			}
			
			System.out.println(max);
			return max;
		}
		int max_XOR_SubArray(int ips[],int n) {
			int cumulativeXOR[]=new int[ips.length];
			cumulativeXOR[0]=ips[0];
			for(int i=1;i<ips.length;i++) {
				cumulativeXOR[i]=cumulativeXOR[i-1]^ips[i];
			}
			int max=0;
			for(int x:cumulativeXOR ) {
				insert(x);
				int max_xor_pairAns=max_xor_with_otherNumber(x);
				System.out.println(max_xor_pairAns);
				max=Math.max(max, max_xor_pairAns);
				
			}
			
			System.out.println(max);
			return max;
		}
		
		
	}
	
	
	public static void main(String[] args) {
		int arr[]= {3,10,5,25,2,8};
		XorTrie xor=new XorTrie();
		xor.max_XOR_pair(arr, arr.length);
		System.out.println();
		System.out.println();
		xor.max_XOR_SubArray(arr, arr.length);
	}
}
