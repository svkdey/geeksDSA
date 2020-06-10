package CrackingTheCodingInterView.ArraysAndString;
//1.2
public class CheckPermutation {
	// same as anagram
	static boolean checkPermutation(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		int temp[] = new int[256];
		for (int i = 0; i < s1.length(); i++) {
			temp[(int) s1.charAt(i)]++;
		}
		for (int i = 0; i < s2.length(); i++) {
			temp[(int) s2.charAt(i)]--;
		}
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean anagram = checkPermutation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + anagram);
		}

	}

}
