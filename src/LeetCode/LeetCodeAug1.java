package LeetCode;

public class LeetCodeAug1 {
	public static boolean detectCapitalUse(String word) {
		char ltrs[] = word.toCharArray();
		boolean firstLetter = Character.isUpperCase(ltrs[0]);
		boolean secondLetter = false;

		if (ltrs.length == 1) {
			return true;
		} else {
			secondLetter = Character.isUpperCase(ltrs[1]);
		}

		System.out.println(firstLetter + "  -- " + secondLetter);
		if (firstLetter == false && secondLetter == true) {
			return false;
		}
		for (int i = 2; i < ltrs.length; i++) {
			if (secondLetter != Character.isUpperCase(ltrs[i])) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(detectCapitalUse("mL"));
	}
}
