package Hashing;
//vvi problem
public class MiniMumWindowLength {
	public static String solve(String str, String pat) {
		if (pat.length() > str.length()) {
			return null;
		}
		int hash_str[] = new int[256];
		int hash_pat[] = new int[256];
//hashing of pattern
		for (int i = 0; i < pat.length(); i++) {
			hash_pat[(int) pat.charAt(i)]++;

		}
		//start of pointer
		
		//start_index====start of matching of pattern
		int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;
		int count = 0;
		
		for (int j = 0; j < str.length(); j++) {
			// count occurrence of characters of string
			hash_str[str.charAt(j)]++;

			// If string's char matches with pattern's char
			// then increment count
			if (hash_pat[str.charAt(j)] != 0 && hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)]) {
				count++;
				}

			// if all the characters are matched
			if (count == pat.length()) {
				// Try to minimize the window i.e., check if
				// any character is occurring more no. of times
				// than its occurrence in pattern, if yes
				// then remove it from starting and also remove
				// the useless characters.
				
				//shrinking left hand side domain
				while (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)] || hash_pat[str.charAt(start)] == 0) {

					if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)]) {
						hash_str[str.charAt(start)]--;
					}
					start++;
				}

				// update window size
				int len_window = j - start + 1;
				if (min_len > len_window) {
					min_len = len_window;
					start_index = start;
				}
			}
		}

		// If no window found
		if (start_index == -1) {
			System.out.println("No such window exists");
			return "";
		}

		// Return substring starting from start_index
		// and length min_len
		return str.substring(start_index, start_index + min_len);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abbbdcabcbccc";
		String pat = "abc";
		System.out.println(solve(str, pat));
	}

}
