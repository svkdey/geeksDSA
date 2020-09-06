package LeetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class LeetCode752 {
	public static int openLock(String[] deadends, String target) {
		Set<String> dead = new HashSet<>();
		Set<String> v = new HashSet<>();
		for (String s : deadends)
			dead.add(s);
		if (dead.contains(target))
			return -1;
		if (dead.contains("0000"))
			return -1;
		if ("0000".equals(target))
			return 0;
		Queue<String> q = new LinkedList<String>();

		q.add("0000");
		int h = 0;
		while (!q.isEmpty()) {

			int n = q.size();
			for (int k = 0; k < n; k++) {
				String str = q.remove();

				if (str.equals(target)) {
					return h + 1;
				}
				// generate 1 up and one Down string
				for (int i = 0; i < str.length(); i++) {
					char c = str.charAt(i);
					String up = str.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + str.substring(i + 1);
					String down = str.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + str.substring(i + 1);
					if (!dead.contains(up) && !v.contains(up)) {
						q.add(up);
						v.add(up);
					}
					if (!dead.contains(down) && !v.contains(down)) {
						q.add(down);
						v.add(down);
					}
				}
			}
			h++;
		}
		return -1;
	}

	public static void main(String[] args) {
		String deadends[] = { "0201", "0101", "0102", "1212", "2002" }, target = "0202";
		System.out.println(openLock(deadends, target));
	}
}
