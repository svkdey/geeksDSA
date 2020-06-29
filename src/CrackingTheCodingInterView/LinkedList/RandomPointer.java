package CrackingTheCodingInterView.LinkedList;

//deep copy the nodes
public class RandomPointer {
	static class RandomNode {
		int value;
		RandomNode next;
		RandomNode random;

		public RandomNode() {
			super();
			// TODO Auto-generated constructor stub
		}

		public RandomNode(int value) {
			super();
			this.value = value;
		}

		@Override
		public String toString() {
			return "RandomNode [value=" + value + ", next=" + next + ", random=" + random + "]";
		}

	}

	public static RandomNode solve(RandomNode head) {
		RandomNode current = head;

		while (current != null) {
			RandomNode temp = new RandomNode(current.value);
			temp.next = current.next;
			current.next = temp;
			current = temp.next;

		}
		current = head;
		while (current != null) {
			if (current.random != null) {
				current.next.random = current.random.next;
			} else {
				current.next.random = null;
			}
			current = current.next.next;
		}
		current = head;
		RandomNode f = current.next;
		RandomNode res = f;
		while (current != null && current.next != null) {
			current.next = current.next.next;
			if (current != null) {
				if (f.next == null)
					break;
				f.next = f.next.next;
				f = f.next;
				current = current.next;
			} else {
				f.next = null;
			}
		}
		current.next = null;

		return res;
	}

	public static void main(String[] args) {
		RandomNode a = new RandomNode(10);
		RandomNode b = new RandomNode(20);
		RandomNode c = new RandomNode(30);
		RandomNode d = new RandomNode(40);
		RandomNode e = new RandomNode(50);
		RandomNode f = new RandomNode(60);
		a.next = b;
		a.random = d;
		b.next = c;
		b.random = e;
		c.next = d;
		c.random = a;
		d.next = e;
		d.random = null;
		e.next = f;
		e.random = b;
//		System.out.println(a);
		solve(a);

	}
}
