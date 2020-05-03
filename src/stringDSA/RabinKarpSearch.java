package stringDSA;

public class RabinKarpSearch {
//	o((n-m+1)*m)
	public static void simplerabinKarpSearch(String text, String pattern) {
		int patternHash = 0;
		int textHash = 0;
		for (int i = 0; i < pattern.length(); i++) {
			patternHash += (int) pattern.charAt(i);
			textHash += (int) text.charAt(i);
		}
		
		for (int i = 0; i < text.length() - pattern.length()+1; i++) {
			if (i != 0) {
				textHash = textHash - (int)text.charAt(i-1) +(int)text.charAt(i + pattern.length()-1);
			}
			if (textHash == patternHash) {
				for (int j = 0; j < pattern.length(); j++) {
					if (text.charAt(j + i) != pattern.charAt(j)) {
						break;
					}
					if (j == pattern.length() - 1) {
						System.out.println(i);
					}
				}
			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		simplerabinKarpSearch("aabaacaadaabaaba","aaba");
	}

}
