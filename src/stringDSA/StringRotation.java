package stringDSA;

public class StringRotation {
	public static boolean isRotated(String s1,String s2) {
		// TODO Auto-generated method stub
		String newStr=s1.concat(s1);
		return newStr.indexOf(s2)>=0;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isRotated("AAB","BAA" ));
	}

}
