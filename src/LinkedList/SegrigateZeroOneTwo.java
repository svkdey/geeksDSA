package LinkedList;

public class SegrigateZeroOneTwo {
	static LinkedListNode segregate(LinkedListNode node)
    {
        // add your code here
        int i=0;
        LinkedListNode head=null;
        LinkedListNode tail=null;
        while(i<=2){
        	LinkedListNode current=node;
            while(current!=null){
                if(current.data==i){
                    if(head==null){
                       head=new LinkedListNode(i);
                       tail=head;
                    }else{
                        tail.next=new LinkedListNode(i);
                        tail=tail.next;
                    }
                }
                current=current.next;
            }
            i++;
        }
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l=new LinkedList();
		l.addLast(0);
		l.addLast(01);
		l.addLast(02);
		l.addLast(02);
		l.addLast(01);
		l.addLast(0);
		l.addLast(02);
		l.addLast(01);
		l.addLast(01);
		l.addLast(0);
		System.out.println(l.head);
		System.out.println(segregate(l.head));
	}

}
