package LeetCode;

public class LeetCode478 {
	class Solution {
		double r = 0;
		double x = 0;
		double y = 0;

		public Solution(double radius, double x_center, double y_center) {
			r = radius;
			x = x_center;
			y = y_center;
		}

		public double[] randPoint() {
			double len = Math.sqrt(Math.random()) * r; // Math.random generates number near to 1. so best in to take
														
			double angle = Math.random() * 2 * Math.PI; // sqrt to make it small

			return new double[] { x + (len * Math.cos(angle)), y + (len * Math.sin(angle)) };

		}
	}

}
