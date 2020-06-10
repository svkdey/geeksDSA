package stringDSA;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class StringDSAMain {
	public static boolean isAnagram(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;

		int[] count = new int[256];
		for (int i = 0; i < str1.length(); i++) {
			count[(int) str1.charAt(i)]++;
		}
		for (int i = 0; i < str2.length(); i++) {
			count[(int) str2.charAt(i)]--;
		}

		for (int i : count) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean leftRepeatingCharacter(String str1) {
		//algo : for 1st time occurance make it count+1;and keep checking if any character is of occrance 1 before. if found return the character
		int[] count = new int[256];
		for (int i = 0; i < str1.length(); i++) {
			if (count[(int) str1.charAt(i)] != 1) {
				count[(int) str1.charAt(i)]++;
			} else {
				System.out.println(str1.charAt(i));
				return true;
			}

		}

		return false;
	}

	public static boolean leftRepeatingCharacterThatDoesNotReapeat(String str1) {
		//algo :count frequency of each character store it LinkedHashmap() . 
		//traverser the hashmap again and find hm.getValue()==1 
		
		//search for again count[i]>=0 
		LinkedHashMap<Character, Integer> hm = new LinkedHashMap<>();
		for (int i = 0; i < str1.length(); i++) {
			if (hm.containsKey(str1.charAt(i))) {
				hm.put(str1.charAt(i), hm.get(str1.charAt(i)) + 1);
			} else {
				hm.put(str1.charAt(i), 1);
			}
		}
		System.out.println(hm);
		for (Entry<Character, Integer> e : hm.entrySet()) {
			if (e.getValue() == 1) {
				System.out.println(e.getKey());
				return true;
			}
		}
		return false;
	}

	public static int leftRepeatingCharacterThatDoesNotReapeatSolTwo(String str1) {
		//algo : for 1st time occurance assign it i ,when it appears again -2 
		
		//search for again count[i]>=0 
		
		int[] count = new int[256];
		Arrays.fill(count, -1);
		int result = Integer.MIN_VALUE;
		
		for (int i = 0; i < str1.length(); i++) {
			if (count[(int) str1.charAt(i)] == -1) {
				count[(int) str1.charAt(i)] = i;
			} else {
				count[(int) str1.charAt(i)] = -2;
			}
		}
		System.out.println(count);
		for (int i = 0; i < 256; i++) {
			if (count[i] >= 0) {
				result = Math.min(result, count[i]);
			}
		}

		return result;

	}

	static void rotateStringNTimes(String s,int n) {
//		System.out.println(s.substring(n)+s.substring(0,n));
		
		//alogo :subString(length-n)+subString(0,n);
		System.out.println(s.substring(s.length()-n)+s.substring(0,s.length()-n));
		
	}
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
//		System.out.println(isAnagram("geeks", "kegse"));
//		System.out.println(leftRepeatingCharacterThatDoesNotReapeat("feggs"));
		String s="abcabc";
		String s1="abd";
//		System.out.println(s.contains(s1));
		rotateStringNTimes("AMAZON", 2);
		
	}

}
