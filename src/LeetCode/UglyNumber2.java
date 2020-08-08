package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class UglyNumber2 {

	class Table {
		boolean t[] = new boolean[1000000];
		ArrayList<Integer> list = new ArrayList<Integer>();

		public Table() {
			Arrays.fill(t, true);
			create();
		}

		public void create() {
			list.add(1);
			for (int i = 2; i < 1000000; i++) {
				if (t[i]) {
					int temp = i;
					if (isValid(temp)) {
						list.add(i);
//						for (int j = i; j < 1000000; j += i) {
//							t[j] = false;
//						}
					}
				}
			}

		}

		public boolean isValid(int temp) {
			while (temp > 0 && temp % 2 == 0) {
				temp = temp / 2;
			}
			while (temp > 0 && temp % 3 == 0) {
				temp = temp / 3;
			}
			while (temp > 0 && temp % 5 == 0) {
				temp = temp / 5;
			}
			if (temp > 1) {
				return false;
			} else {
				return true;
			}
		}

	}

	public int nthUglyNumber(int n) {
		Table tab = new Table();
		//System.out.println(tab.list);

		int ans = 1;
		int j = 0;
		//System.out.println(tab.isValid(10));
		for(int x:tab.list) {
			ans=x;
			j++;
			if(j==n) {
				break;
			}
		}
		System.out.println(ans);
		return ans;
		
	}

	public static void main(String[] args) {
		UglyNumber2 c = new UglyNumber2();
		c.nthUglyNumber(1690);
		
	}
}
