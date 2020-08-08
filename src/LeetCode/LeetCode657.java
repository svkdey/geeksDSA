package LeetCode;

public class LeetCode657 {
	public static boolean solve(String moves) {
		int pos[]= {0,0};
		for(int i=0;i<moves.length();i++) {
			if("u".equalsIgnoreCase( moves.charAt(i)+"")) {
				pos[0]--;
			}
			else if("d".equalsIgnoreCase( moves.charAt(i)+"")) {
				pos[0]++;
			}
			else if("l".equalsIgnoreCase( moves.charAt(i)+"")) {
				pos[1]--;
			}
			else if("r".equalsIgnoreCase( moves.charAt(i)+"")) {
				pos[1]++;
			}
		}
		if(pos[0]==0&&pos[1]==0) {
			return true;
		}
		return false;
		

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("ll"));
	}

}
