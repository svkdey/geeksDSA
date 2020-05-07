package QueueDSA;

import java.util.LinkedList;
import java.util.Queue;

public class Contains5or6 {
	static void giveAllKnumbersWith5or6(int k) {
		Queue<String> q=new LinkedList<>();
		q.add("5");
		q.add("6");
		for(int i=0;i<k;i++) {
			String s=q.remove();
			System.out.println(Integer.parseInt(s));
			q.add(s+"5");
			q.add(s+"6");
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		
		giveAllKnumbersWith5or6(10);
	}

}
