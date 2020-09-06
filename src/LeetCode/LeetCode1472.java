package LeetCode;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class LeetCode1472 {
	class BrowserHistory {
		LinkedHashMap<Integer, String> list = new LinkedHashMap<>();
		int max = 0;
		int presentPage = 0;

		public BrowserHistory(String homepage) {
			list = new LinkedHashMap<>();
			presentPage++;
			list.put(presentPage, homepage);
			max = presentPage;
		}

		public void visit(String url) {
			presentPage++;
			list.put(presentPage, url);
			max = presentPage;
		}

		public String back(int steps) {

			presentPage = Math.max(presentPage - steps, 1);
			String ans = list.get(presentPage);

			return ans;

		}

		public String forward(int steps) {

			presentPage = Math.min(presentPage + steps, max);
			String ans = list.get(presentPage);

			return ans;
		}
	}
}
