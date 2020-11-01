package LeetCode.InterviewPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountofSmallerNumbersAfterSelf {
	class Node{
		Node left,right;
		int leftCount,value;
		public Node(int value) {
			this.value=value;
		}
	}
	public List<Integer> countSmaller(int[] nums) {
		Node root=null;
		int[] ans=new int[nums.length];
		for(int i=nums.length-1;i>=0;i--) {
			 root = insert(root, nums[i],ans,0, i);
		}
		List<Integer> l=new ArrayList<Integer>();
		
		for(int x:ans) l.add(x);
		System.out.println(Arrays.toString(ans));
		return l;
	}

	public Node insert(Node node,int val,int result[],int sum,int i) {
			if(node==null) {
				result[i]=sum;
				return new Node(val);
			}
			if(val>node.value) {
				sum+=node.leftCount+1;
				node.right=insert(node.right, val, result, sum, i);
			}else {
				node.left=insert(node.left, val, result, sum, i);
				node.leftCount+=1;
			}
			return node;
	}

	public static void main(String[] args) {
		CountofSmallerNumbersAfterSelf s = new CountofSmallerNumbersAfterSelf();
		int arr[] = { 5, 2, 6, 3 };

		
		s.countSmaller(arr);
	}
	
}
