package LeetCode;

public class LeetCode1315 {
	public static class TreeNode {
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

	public static int sumEvenGrandparent(TreeNode root) {
		return sumEvenGrandparentHelper(root, null, null);
	}
	
	public static int sumEvenGrandparentHelper(TreeNode current,TreeNode parent,TreeNode grandParent) {
		int sum=0;
		if(current==null) return 0;
		if(grandParent!=null && grandParent.val%2==0) {
//			System.out.println(g);
			sum+=grandParent.val;
		}
		int left=sumEvenGrandparentHelper(current.left, current, parent);
		int right=sumEvenGrandparentHelper(current.right, current, parent);
		sum+=left+right;
		return sum;
		
	}
	
	
}
