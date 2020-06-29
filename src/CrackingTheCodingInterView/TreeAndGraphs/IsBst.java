package CrackingTheCodingInterView.TreeAndGraphs;

public class IsBst {
	public static boolean solve(Trees.TreeNode treeNode) {
		if (treeNode == null)
			return true;
		boolean lVal = treeNode.left != null ? treeNode.data>treeNode.left.data : true;
		boolean rVal = treeNode.right != null ? treeNode.data<treeNode.right.data : true;

		return (lVal&&rVal) && solve(treeNode.left) && solve(treeNode.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solve(Data.TreeData.getBinarySearchPropertyTree()));
	}

}
