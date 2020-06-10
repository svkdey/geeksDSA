package CrackingTheCodingInterView.ArraysAndString;

public class OneAway {
	public static boolean OneAwayImpl(String s1, String s2) {

		int temp[] = new int[256];
		for (int i = 0; i < s1.length(); i++) {
			temp[(int) s1.charAt(i)]++;
		}
		for (int i = 0; i < s2.length(); i++) {
			temp[(int) s2.charAt(i)]--;
		}
		int cout = 0;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != 0)
				cout++;
		}
		System.out.println(cout);
		return cout > 1 ? false : true;

	}

	public static void main(String[] args) {
		String a = "palee";
		String b = "pale";
		boolean isOneEdit1 = OneAwayImpl(a, b);
		System.out.println(a + ", " + b + ": " + isOneEdit1);

		String c = "pale";
		String d = "bake";
		boolean isOneEdit2 = OneAwayImpl(c, d);
		System.out.println(c + ", " + d + ": " + isOneEdit2);
	}
}
