package CrackingTheCodingInterView.ArraysAndString;
//1.1
public class isUnique {
	
	//with space
	static boolean isUniqueImpl(String s) {
		boolean[] visited=new boolean[256];
		for(int i=0;i<s.length();i++) {
			if(visited[(int)s.charAt(i)]) {
				return false;
			}
			else {
				visited[(int)s.charAt(i)]=true;
			}
		}
		return true;
	}
	
	//with out space
	
	
	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			System.out.println(word + ": " + isUniqueImpl(word));
		}
	}	
}
