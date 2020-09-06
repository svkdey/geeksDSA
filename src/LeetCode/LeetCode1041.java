package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1041 {
	class Position {
		int position;
		int angle = 0;
		boolean isMoved360 = false;

		@Override
		public String toString() {
			return "Position [position=" + position + ", angle=" + angle + "]";
		}

		public Position(int position, int angle) {
			super();
			this.position = position;
			if (Math.abs(angle) == 360) {
				this.angle = 0;
				isMoved360 = true;
			} else {
				this.angle = angle;
			}
		}

	}

	public boolean isRobotBounded(String instructions) {
		int dir[][] = { { 1, 0 },{ 0, 1 } ,{ 0, -1 }, { -1, 0 }};
		int start[] = { 0, 0 };
		int d = 0;
		for (char c : instructions.toCharArray()) {
			if(c=='L') {
				
				d=(d+1)%4;
			}
			if(c=='R') {
				d=(d+3)%4;
			}else {
				start[0]+=dir[d][0];
				start[1]+=dir[d][1];
			}
		}
		
		return start[0]==0&&start[1]==0||d>0;
	}
}
