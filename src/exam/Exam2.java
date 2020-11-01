package exam;

import java.util.*;

public class Exam2 {

	public static long calculateTotalRegion(List<Integer> heights) {
		// Write your code here
		Collections.sort(heights);
		int sum = 0;
		int current = heights.get(0);
		int current_pos = 0;
		int i = 1;
		int count=0;
		while (i < heights.size()) {
			if (heights.get(i) > current) {
				sum+=i;
			} else {
				sum+=1;
				
			}i++;
		}
		sum += heights.size();
		return sum;
	}

	public static void main(String[] args) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		l.add(1);
		l.add(3);

		System.out.println(calculateTotalRegion(l));
	}
}
