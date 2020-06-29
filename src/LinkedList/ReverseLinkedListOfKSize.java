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
		
		if(current!=null) {
			head.next=reverseLinkedListOfKSize(current, k);
			}
		return head=temp;
	}
	static LinkedListNode rotate(LinkedListNode head, int k) {
        // add code here.
		LinkedListNode tail=head;
		LinkedListNode cur=head;
        while(tail.next!=null){
            tail=tail.next;
        }
        LinkedListNode temp=null;
        while(k>0){
            temp=cur;
            cur=cur.next;
            temp.next=null;
            tail.next=temp;
            tail=tail.next;
            k--;
        }
        return cur;
    }
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		// TODO Auto-generated method stub
		l.insertBegin(1);
		int [] arr= {2,3,4,5,6,7,8};
		for(int i:arr) {
			l.addLast(i);
		}
		System.out.println(l.head);
		System.out.println(rotate(l.head,4));
	}

}
