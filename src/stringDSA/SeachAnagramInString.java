package stringDSA;

import java.util.Arrays;

public class SeachAnagramInString {
	// naive solution
	// o(n-m+1)*o(m)
	public static boolean seachAnagramInString(String str1, String str2) {
		// TODO Auto-generated method stub
		for (int i = 0; i < (str1.length()-str2.length()+1); i++) {
			String partOfString = str1.substring(i, i + str2.length());
			if (StringDSAMain.isAnagram(partOfString, str2)) {
				return true;
			}
		}
		return false;
	}
	//best solution
	public static boolean seachAnagramInStringSolutionTwo(String text, String pttr) {
		//check occurance array in each window
		int counText[]=new int[256];
		int counPttr[]=new int[256];
		for(int i=0;i<pttr.length();i++) {
			counText[text.charAt(i)]++;
			counPttr[pttr.charAt(i)]++;
		}
		for (int i = pttr.length(); i < (text.length()-pttr.length()+1); i++) {
			
			if (Arrays.equals(counText,counPttr)) {
				return true;
			}
			counText[text.charAt(i)]++;
			counText[text.charAt(i-pttr.length())]--;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(seachAnagramInStringSolutionTwo("geeksforgeeks", "ekes"));
	}

}
