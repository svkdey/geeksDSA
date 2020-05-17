package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class DesignDStoFindKthSmallest {
	TreeSet<Integer> ts = null;

	public DesignDStoFindKthSmallest() {
		// TODO Auto-generated constructor stub
		ts = new TreeSet<Integer>();
	}

	public void insert(int a) {
		// TODO Auto-generated method stub
		ts.add(a);
	}

	public boolean search(int a) {
		return ts.contains(a);
	}

	public int kthElement(int k) {
		List<Integer> list = new ArrayList<Integer>(ts);
//		System.out.println(ts+ " ");
		return list.get(k - 1);
	}

	public boolean delete(int k) {
		if (ts.contains(k)) {
			return ts.remove(k);
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 2, 5, 11, 10, 12 };
		DesignDStoFindKthSmallest ds = new DesignDStoFindKthSmallest();
		for (int i : arr) {
			ds.insert(i);
		}
		System.out.println(ds.kthElement(3));

	}

}
