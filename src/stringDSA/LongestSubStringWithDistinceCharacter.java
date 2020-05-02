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
	static int getDistictCount(String str,int i,int j) {
		int count=0;
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
	static void longestSubStringWithDistinceCharacterSolution2(String str) {
		int result = 0;
		int[] visited = new int[str.length()];
		for(int i=1;i<str.length();i++) {
			visited[i]=getDistictCount(str,0,i);
			result=Math.max(result, visited[i]);
		}
		System.out.println(result);

	}

	static void longestSubStringWithDistinceCharacterSolution3(String str) {
		int result = 0;
		int[] visited = new int[256];
		Arrays.fill(visited, -1);
		int idxValue=0;
		for(int j=0;j<str.length();j++) {
			idxValue=Math.max(idxValue, visited[(int)str.charAt(j)]+1);
			int maxEnd=j-idxValue+1;
			result=Math.max(result, maxEnd);
			visited[(int)str.charAt(j)]=j;
		}
		System.out.println(result);

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		longestSubStringWithDistinceCharacterSolution3("ABCACABCD");
	}

}
