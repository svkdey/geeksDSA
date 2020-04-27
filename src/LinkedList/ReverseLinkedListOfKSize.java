package LinkedList;

public class ReverseLinkedListOfKSize {
	public static LinkedListNode reverseLinkedListOfKSize(LinkedListNode head,int k) {
		if(head==null) return head;
		LinkedListNode current=head;
		int i=0;
		LinkedListNode temp=null;
		while(current!=null&&i<k) {
			LinkedListNode nxt=current.next;
			current.next=temp;
			temp=current;
			current=nxt;
			i++;
		}
//		if(curre)
//		System.out.println("temp"+"---->"+temp);
//		System.out.println("currrent"+"---->"+current);
		if(current!=null) {
			head.next=reverseLinkedListOfKSize(current, k);
			}
		return head=temp;
	}
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		// TODO Auto-generated method stub
		l.insertBegin(1);
		l.insertBegin(2);
		l.insertBegin(3);
		l.addLast(50);
		l.addLast(100);
		System.out.println(l);
		System.out.println(reverseLinkedListOfKSize(l.head, 4));
	}

}
