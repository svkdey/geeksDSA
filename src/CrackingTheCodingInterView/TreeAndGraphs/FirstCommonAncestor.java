package CrackingTheCodingInterView.TreeAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;

import Trees.TreeNode;

public class FirstCommonAncestor {
	private static void rootToleafSumDFS(TreeNode root, int t,int paths[], int pathLen,ArrayList<Integer> ans) {
		if (root == null)
			return;

		if (root.data==t) {
			paths[pathLen++] = root.data;
			for(int i=0;i<pathLen;i++) {
				ans.add(paths[i]);
			}
			return;
		}
		paths[pathLen++] = root.data;
		rootToleafSumDFS(root.left,t, paths, pathLen,ans);
		rootToleafSumDFS(root.right,t, paths, pathLen,ans);
		return;
	}
	public static void solve(TreeNode root,int x,int y) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		int paths[]=new int[10000];int pathLen=0;
		rootToleafSumDFS(root,x, paths, pathLen, list1);
		Arrays.fill(paths, 0);pathLen=0;
		rootToleafSumDFS(root,y, paths, pathLen, list2);
		
		for(int i=0;i<list1.size()-1&&i<list2.size()-1;i++) {
			if(list1.get(i+1)!=list1.get(i+1)) {
				System.out.println(list1.get(i));
				break;
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
