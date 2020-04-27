package LinkedList;

public class CircularLinkListNode {
	int data;
	CircularLinkListNode next;
	public CircularLinkListNode() {
		// TODO Auto-generated constructor stub
		
	}
	public CircularLinkListNode(int data) {
		// TODO Auto-generated constructor stub
		this.data=data;
		this.next=null;
		
	}
	@Override
	public String toString() {
		return "CircularLinkListNode [data=" + data + ", next=" + next + "]";
	}
	
}
