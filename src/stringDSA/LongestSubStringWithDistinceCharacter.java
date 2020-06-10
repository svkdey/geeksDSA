package stringDSA;

import java.util.Arrays;

public class LongestSubStringWithDistinceCharacter {

	static void longestSubStringWithDistinceCharacter(String str) {
		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < str.length(); j++) {
				if (isVisited(str, i, j)) {
					result = Math.max(result, i - j + 1);
				}
			}
		}
		System.out.println(result);
	}

	static boolean isVisited(String str, int i, int j) {
		int[] visited = new int[256];
		for (int k = i; k <= j; k++) {
			if (visited[(int) str.charAt(k)] == 1) {
				return false;
			} else {
				visited[(int) str.charAt(k)] = 1;
			}
		}
		return true;
	}

	static int getDistictCount(String str, int i, int j) {
		int count = 0;
		int[] visited = new int[256];
		Arrays.fill(visited, -1);
		for (int k = i; k <= j; k++) {
			if (visited[(int) str.charAt(k)] == 1) {

			} else {
				visited[(int) str.charAt(k)] = 1;
				count++;
			}
		}
//		System.out.println(count);
		return count;
	}

	static void longestSubStringWithDistinceCharacterSolution2(String s) {
		int visited[] = new int[256];
		int maxValue = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				// calculation i->j distinct character. if character is not distinct break
				if (visited[(int) s.charAt(j)] == 1) {
					break;
				} else {
					maxValue = Math.max(maxValue, j - i + 1);
					visited[(int) s.charAt(j)]++;
				}
			}
			// remove 1st charater of that ith window
			visited[(int) s.charAt(i)] = 0;
		}
		System.out.println(maxValue);
	}

	static void longestSubStringWithDistinceCharacterSolution3(String str) {
		int result = 0;
		// visited array contains where last i th character appeared
		int[] visited = new int[256];
		Arrays.fill(visited, -1);
		int idxValue = 0;
		for (int j = 0; j < str.length(); j++) {
			// previously where j th character occured?
//			if apperaed then it will updated the value. else i will keep the last value
			idxValue = Math.max(idxValue, visited[(int) str.charAt(j)] + 1);
			System.out.println(idxValue);
			int maxEnd = j - idxValue + 1;
			result = Math.max(result, maxEnd);
			visited[(int) str.charAt(j)] = j;
		}
		System.out.println(result);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		longestSubStringWithDistinceCharacterSolution3("geeksforgeeks");
	}

}
