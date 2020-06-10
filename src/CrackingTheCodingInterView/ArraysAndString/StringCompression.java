package CrackingTheCodingInterView.ArraysAndString;
//1.6
public class StringCompression {
	
	//o(n) solution
	static void StringCompressionImpl(String s) {
		if(s.length()==1) {System.out.println(s);return;};
		int idx1 = 0;
		int idx2 = 1;
		int count = 1;
		String result = "";

		while (idx1 < s.length() && idx2 < s.length()) {
			while (idx1 < s.length() && idx2 < s.length() && (s.charAt(idx1) == s.charAt(idx2))) {
				idx2++;
				count++;
			}
			result += s.charAt(idx1) + Integer.toString(count);
			count = 1;
			idx1 = idx2;
			idx2++;

		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringCompressionImpl("bbbcccDDDee");
	}

}
