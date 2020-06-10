package CrackingTheCodingInterView.ArraysAndString;
//1.3
public class URLify {
	static void URLifyImpl(String s,int len) {
		s=s.trim();
		String[] arr=s.split(" ");
		String result="";
		for(int i=0;i<arr.length-1;i++) {
			result+=arr[i]+"%20";
			
		}
		result+=arr[arr.length-1];
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		String s="Mr Jose smith  ";
		URLifyImpl(s, s.length());
	}

}
