package LinkedList;

public class LinkedList {
	LinkedListNode head;
	LinkedListNode tail;
	int length;

	public LinkedList() {
		super();
		this.head = null;
		this.tail = null;
		this.length = 0;
	}

	public void tranverse() {
		LinkedListNode currentNode = this.head;
		if (currentNode == null) {
			throw new Error("Linked list instantiated but does not have value");
		}
		while (currentNode != null) {
			System.out.println(currentNode.toString());
			currentNode = currentNode.next;
		}
	}

	public void push(int value) {
		LinkedListNode newNode = new LinkedListNode(value);
		if (this.head == null) {
			this.head = this.tail = newNode;
		} else {
			this.tail.next = newNode;
			this.tail = newNode;
		}
		this.length++;
	}

	@Override
	public String toString() {
		System.out.println("LinkedList [head=" + head + ", tail=" + tail + ", length=" + length + "]");
		return "LinkedList [head=" + head + ", tail=" + tail + ", length=" + length + "]";
	}

	public void shift(int value) {
		LinkedListNode newNode = new LinkedListNode(value);
		if (this.head == null) {
			this.head = this.tail = newNode;
		} else {
			newNode.next = this.head;
			this.head = newNode;
		}
		this.length++;

	}

	public void unshift() {
		if (this.length == 0)
			throw new Error("list doesnt exist");
		else {
			this.head = this.head.next;
		}
		this.length--;

	}

	public void pop() {
		if (this.length == 0)
			throw new Error("list doesnt exist");
		else {
			LinkedListNode currentNode = this.getNodeByPos(this.length - 1);
			currentNode.next = currentNode.next.next;
			this.tail = currentNode;
			this.length--;
		}
	}

	public void insertInNthPos(int pos, int value) {
		if (pos == 0) {
			this.shift(value);
		} else if (pos == this.length) {
			this.push(value);
		} else {
			LinkedListNode node = this.getNodeByPos(pos - 1);
			LinkedListNode nodeToBeInsert = new LinkedListNode(value);
			nodeToBeInsert.next = node.next;
			node.next = nodeToBeInsert;
			this.length++;
		}
	}

	public void removeInNthPos(int pos) {
		if (pos == 0) {
			this.unshift();
		} else if (pos == this.length) {
			this.pop();
		} else {
			LinkedListNode node = this.getNodeByPos(pos - 1);
			node.next = node.next.next;
			this.length--;
		}

	}

	public LinkedListNode getNodeByPos(int pos) {
		LinkedListNode currentNode = this.head;
		if (pos > this.length)
			throw new Error("position is greter than linkedList length");
		for (int i = 1; i < pos; i++) {
			currentNode = currentNode.next;
		}
		return currentNode;
	}

//	----------------------------------------------------------------------------------
	public static void traverse(LinkedListNode node) {
		LinkedListNode currentNode = node;
		if (currentNode == null) {
			throw new Error("Linked list instantiated but does not have value");
		}
		while (currentNode != null) {
			System.out.println(currentNode.value);
			currentNode = currentNode.next;
		}
	}

//	-----------------------------------------------------------------------------------
	public static LinkedListNode rotateList(LinkedListNode list) {
//		list.toString();
		if (list != null) {
			LinkedListNode tempNode = null;
			LinkedListNode currentNode = list;
//			LinkedListNode temp = currentNode.next;
			while (currentNode != null) {
				LinkedListNode temp = currentNode.next;
				currentNode.toString();
				currentNode.next = tempNode;
				tempNode = currentNode;
				currentNode = temp;
			}
			return tempNode;

		}
		return list;
	}

	public static int searchNode(LinkedListNode head, int value) {
		if (head != null) {
			LinkedListNode currentNode = head;

			while (currentNode != null) {
				if (currentNode.value == value) {
					return currentNode.value;
				}
				currentNode = currentNode.next;
			}

		}
		return -1;

	}
}
