package Trees;

public class TreeHardProblems {
//	https://www.geeksforgeeks.org/minimum-time-to-burn-a-tree-starting-from-a-leaf-node/
	static class Distance {
		int val;

		public Distance(int d) {
			// TODO Auto-generated constructor stub
			val = d;
		}
	}

	static int result = 0;

	public static int burnTree(TreeNode root, int leaf) {
		burnTheTreeUtil(root, leaf, new Distance(-1));
		int res = result;
		result = 0;
		return res;
	}

	public static int burnTheTreeUtil(TreeNode root, int leaf, Distance dist) {
		if (root == null)
			return 0;
		if (root.data == leaf) {
			dist.val = 0;
			return 1;
		}
		Distance lDis = new Distance(-1);
		Distance rDis = new Distance(-1);
		int lHeight = burnTheTreeUtil(root.left, leaf, lDis);
		int rHeight = burnTheTreeUtil(root.left, leaf, lDis);
		if (lDis.val != -1) {
			dist.val = lDis.val + 1;
			result = Math.max(result, rHeight + dist.val);
		} else if (rDis.val != -1) {
			dist.val = rDis.val + 1;
			result = Math.max(result, lHeight + dist.val);
		}
		return Math.max(lHeight, rHeight) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
