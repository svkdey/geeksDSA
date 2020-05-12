package Trees;

public class BTSproblems {
	public static int findFloor(TreeNode root, int val) {
		if (root == null) {
			return -1;
		}
		int floor = -1;
		while (root != null) {
			if (root.data == val) {
				return root.data;
			}
			if (root.data > val) {
				root = root.left;
			} else {
				floor = root.data;
				root = root.right;
			}

		}
		return floor;
	}

	public static int findCiel(TreeNode root, int val) {
		if (root == null) {
			return -1;
		}
		int ciel = -1;
		while (root != null) {
			if (root.data == val) {
				return root.data;
			}
			if (root.data > val) {
				ciel = root.data;
				root = root.left;

			} else {
				root = root.right;
			}

		}
		return ciel;
	}
}
