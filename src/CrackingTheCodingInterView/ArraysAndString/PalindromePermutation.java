package CrackingTheCodingInterView.ArraysAndString;

public class PalindromePermutation {
	public static boolean areIsomorphic(String s1, String s2) {
		// Your code here
		if (s1.length() != s2.length())
			return false;

		int arr[] = new int[256];
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			arr[(int) c]++;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				String s = "" + (char) i;
				if (!s2.contains(s)) {
					return false;
				}
			}
		}
		return true;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(areIsomorphic("xyz", "aab"));
	}

}
