package Arrayproblems;

public class IpValidator {
	public static boolean isValidIP(String a) {
		// Write your code here7s

		String sarr[] = a.split("\\.");
		int countOfDot = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == '.') {
				countOfDot++;
			}
		}
		if (countOfDot != 3) {
			return false;
		}
		if (sarr.length != 4) {
			return false;
		}
		for (String s : sarr) {
			if (s.length() > 3 || s.length() < 1)
				return false;

			if (s.length() != 1 && s.charAt(0) == '0')
				return false;
			try {
				int val = Integer.parseInt(s);
				if (val < 0 || val > 255)
					return false;
			} catch (NumberFormatException e) {
				return false;
			}

		}
		return true;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(isValidIP("222.111.111.111"));
//		System.out.println(isValidIP("5555..555"));
//		System.out.println(isValidIP("0000.0000.0000.0000"));
//		System.out.println(isValidIP("1.2.3.04"));
//		System.out.println(isValidIP("1.2.3.4"));
//		System.out.println(isValidIP("..."));
		
		

	}

}
