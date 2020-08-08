package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1041 {
	class Position {
		int position;
		int angle = 0;
		boolean isMoved360=false;

		@Override
		public String toString() {
			return "Position [position=" + position + ", angle=" + angle + "]";
		}

		public Position(int position, int angle) {
			super();
			this.position = position;
			if (Math.abs(angle) == 360) {
				this.angle = 0;
				isMoved360=true;
			} else {
				this.angle = angle;
			}
		}

	}

	public boolean isRobotBounded(String instructions) {
		char a[] = instructions.toCharArray();
		Position start = new Position(0, 0);
		Queue<Position> q=new LinkedList<LeetCode1041.Position>();
		q.add(start);
		for(char c:a) {
			Position p=q.remove();
			if(c=='G') {
				q.add(new Position(p.position+1, p.angle+0));
			}else if(c=='R') {
				q.add(new Position(p.position, p.angle-90));
			}
			else if(c=='L') {
				q.add(new Position(p.position, p.angle+90));
			}
		}
		Position end=q.remove();
		if(end.angle==start.angle) {
			if(end.position==start.position) {
				return end.isMoved360;
			}
			return false;
		}else {
			return true;
		}
		
	}
}
