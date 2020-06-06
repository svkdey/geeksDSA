package Algorithms.DynamicProblems;

public class SumOfSubstring {
	static int sum=0;
	public static void SumOfSubstringImpl(String s,int n,int start,String subStr) {
		
		if(subStr!="") {
			System.out.println(subStr);
			sum+=Integer.parseInt(subStr);

		}
		for(int i=start;i<n;i++ ) {
			subStr=subStr+s.charAt(i);
			SumOfSubstringImpl(s, n, i+1, subStr);
//			subStr=subStr.substring(0, subStr.length()-1);
		}
		
	}
	public static void main(String[] args) {
		SumOfSubstringImpl("1234", 4, 0, "");
		System.out.println(sum);
	}

}
