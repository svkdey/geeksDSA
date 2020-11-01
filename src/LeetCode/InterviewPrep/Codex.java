package LeetCode.InterviewPrep;

import java.util.Arrays;

public class Codex {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	public class Codec {

	    // Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
	        String str="";
	        serializeUtil(root,str);
	        System.out.println(str);
	        return str;
	    }
	    public void serializeUtil(TreeNode root,String helper) {
	        if(root==null) {
	            helper+="@";
	            return;
	        }
	        helper+=(root.val)+"#";
	         System.out.println(helper);
	        serializeUtil(root.left,helper);
	        serializeUtil(root.right,helper);
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	        String arr[]=data.split("#");
	        idx=0; 
	          System.out.println(Arrays.toString(arr));
	        return deserializeUtil(arr,0,arr.length-1);
	    }
	    int idx=0;
	     public TreeNode deserializeUtil(String[] data,int str,int end) {
	        return null;
	    }
	    
	    
	    
	}

}
