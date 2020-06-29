package CrackingTheCodingInterView.LinkedList;



 class ListNode {
	int data;
	int id;
	ListNode next;
	ListNode prev;

	public ListNode() {
		// TODO Auto-generated constructor stub
	}

	public ListNode(int id,int data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.id=id;
		this.next = null;
		this.prev=null;
	}

	@Override
	public String toString() {
		return "ListNode [data=" + data + ", next=" + next + ", prev=" + prev + "]";
	}
	
}
