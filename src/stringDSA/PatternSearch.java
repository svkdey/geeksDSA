package stringDSA;

public class PatternSearch {
//	naive approach (O(n-m+1)*(o(m))
	public static void patternSearch(String txt, String ptr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < txt.length() - ptr.length() + 1; i++) {
			for (int j = 0; j < ptr.length(); j++) {
				if (txt.charAt(i + j) != ptr.charAt(j)) {
					break;
				}
				if (j == ptr.length()-1 ) {
					System.out.println(i);
				}
			}

		}
	}
//	o(n) modified naive
	public static void patternSearchIfNoCharacterIsRepeated(String txt, String ptr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < txt.length() - ptr.length()+1;) {
			int j;
			for (j = 0; j < ptr.length(); j++) {
				if (txt.charAt(i + j) != ptr.charAt(j)) {
					break;
				}
			}
			if (j == ptr.length()) {
				System.out.println(i);
				i = i + ptr.length();

			} else if (j == 0) {
				i++;
			} else {
				i = i + j;
			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		patternSearch("ABCEABCDABCEABCD", "ABCD");
	}

}
