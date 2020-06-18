package Recursion;

public class Pito314 {
	void piToPI(String s, int i) {
		if (i == s.length() - 1) {
			return;
		}
		if (s.substring(i, 2) == "pi") {
			String temp = s;
			s = s.substring(0, i) + "3.14" + temp.substring(i + 2);
		}
		piToPI(s, i + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
