package CrackingTheCodingInterView.ArraysAndString;

public class IsRotated {
	static boolean isRotated(String s1, String s2) {
		String s2s2 = s2 + s2;
		if (s2s2.contains(s1)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "waterbottle";
		String s2 = "erbottlewal";
		System.out.println(isRotated(s1, s2));
	}

}
