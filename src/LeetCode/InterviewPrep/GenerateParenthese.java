package LeetCode.InterviewPrep;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthese {
	public List<String> generateParenthesis(int n) {
		char ans[] = new char[n * 2];
		List<String> l = new ArrayList<String>();
		util(ans, 0, 0, 0, n, l);
		System.out.println(l);
		return l;

	}

	public void util(char ans[], int openCount, int closeCount, int currentidx, int n, List<String> s) {
		if (currentidx == ans.length) {
			if (openCount == closeCount) {
				s.add(String.valueOf(ans));
			}
			return;

		}
		ans[currentidx] = '(';
		util(ans, openCount + 1, closeCount, currentidx + 1, n, s);
		if (openCount > closeCount) {
			ans[currentidx] = ')';
			util(ans, openCount, closeCount + 1, currentidx + 1, n, s);
		}

	}

	public static void main(String[] args) {
		GenerateParenthese g = new GenerateParenthese();
		g.generateParenthesis(4);

	}
}
