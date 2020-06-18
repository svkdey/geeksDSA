package LinkedList;

import java.util.HashSet;

public class LinkedListMain {

	// naive solution
	public static void findMiddlesol1(LinkedListNode head, int len) {

		LinkedListNode cur = head;
		if (len == 1 || head == null)
			System.out.println(-1);
		else {
			for (int i = 1; i < len / 2; i++) {
				cur = cur.next;
			}
			System.out.println(cur.data);
		}
	}

	// best solution
	public static void findMiddlesol2(LinkedListNode head, int len) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		if (len == 1)
			System.out.println(-1);
		else {
			while (fast != null && fast.next != null && fast.next.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			}
			System.out.println(slow.data);
		}
	}

//	naive solution

	// find node len-n+1
	public static void NthNodeFromLast(LinkedListNode head, int len, int n) {
		if (len < n)
			System.out.println(-1);
		else {
			int i = 1;
			LinkedListNode slow = head;
			while (i < len - n + 1) {

				slow = slow.next;
				i++;
			}
			System.out.println(slow.data);
		}
	}

	// best
	public static LinkedListNode NthNodeFromLastSol2(LinkedListNode head, int n) {
		/*
		 * idea is make 1st pointer n position ahead take 2nd pointer at 1st position
		 * loop until 1st pointer reaches null and 2nd pointer will reach the
		 * NthPosition form last
		 */

		LinkedListNode pt2 = head;
		int i = 0;
		while (i < n) {
			if (pt2 == null) {
				System.out.println(-1);
				return null;
			}
			pt2 = pt2.next;
			i++;
		}

		LinkedListNode pt1 = head;
		while (pt2 != null) {
			pt2 = pt2.next;
			pt1 = pt1.next;
		}
		return pt1;

	}

	public static LinkedListNode reverseIterative(LinkedListNode head) {
		if (head == null)
			return head;
		LinkedListNode temp = null;
		LinkedListNode current = head;
		while (current != null) {
			LinkedListNode next = current.next;
			current.next = temp;
			temp = current;
			current = next;
		}
		// equivalent for loop

		/*
		 * for(LinkedListNode cur=head;cur!=null;cur=cur.next){
		 * 
		 * }
		 */

		return temp;
	}

	public static LinkedListNode reverseRecursive(LinkedListNode head) {
		/*
		 * a,b,c,d,e head=a-> recursive(b,c,d,e) it outputs a>b<c<d<e
		 * rev_tail=head.next; head.next=null; rev_tail.next=head; head=rev_head;
		 * 
		 */
		if (head == null || head.next == null)
			return head;
		LinkedListNode rev_head = reverseIterative(head.next);
		LinkedListNode rev_tail = head.next;
		head.next = null;
		rev_tail.next = head;
		head = rev_head;
		return head;

	}

	public static LinkedListNode reverseRecursive1(LinkedListNode current, LinkedListNode prev) {
		/*
		 * a,b,c,d,e head= recursive(a,b,c,d,)e it outputs a<b<c<d>e
		 * 
		 * 
		 */
		if (current == null) {
			return prev;
		} else {
			LinkedListNode next = current.next;
			current.next = prev;
			prev = current;

			return reverseRecursive1(next, prev);
		}
	}

	public static boolean loopDetech(LinkedListNode head) {
		// this approach takes o(n) extra auxuliary space
		// considering no repeatation of element

		HashSet<Integer> l = new HashSet<>();
		LinkedListNode node = head;
		while (node != null) {
			if (l.contains(node.data)) {
				return true;
			} else {
				l.add(node.data);
			}
			node = node.next;
		}
		return false;

	}

	public static boolean loopDetech2(LinkedListNode head) {

		LinkedListNode dummyNode = new LinkedListNode(-1111);
		LinkedListNode ptr1 = head;

		while (ptr1 != null) {
			if (ptr1.next == dummyNode) {
				return true;
			} else {
				LinkedListNode ptr = ptr1.next;
				ptr1.next = dummyNode;
				ptr1 = ptr;
			}
		}
		return false;

	}

	public static boolean floydCycleDetection(LinkedListNode head) {
		if (head == null)
			return false;
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		while (fast.next != null && fast.next.next != null) {

			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;

	}

	public static LinkedListNode floydCycleDetectionAndDeletionOfloop(LinkedListNode head) {
		if (head == null)
			return head;
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		int flag = 0;
		while (fast.next != null && fast.next.next != null) {

			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			slow = head;
			while (slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}
			fast.next = null;
		}
		return head;

	}

	public static void deleteFromRandomPtr(LinkedListNode ref) {
//note u cant have last node's ref as value
		ref.data = ref.next.data;
		ref.next = ref.next.next;

	}

	// method 1
	public static LinkedListNode segrigateOddAndEven(LinkedListNode head) {
		// note u cant have last node's ref as value
		LinkedListNode evenStart = null;
		LinkedListNode evenEnd = null;
		LinkedListNode oddStart = null;
		LinkedListNode oddEnd = null;
		LinkedListNode currentNode = head;

		while (currentNode != null) {
			int element = currentNode.data;

			if (element % 2 == 0) {

				if (evenStart == null) {
					evenStart = currentNode;
					evenEnd = evenStart;
				} else {
					evenEnd.next = currentNode;
					evenEnd = evenEnd.next;
				}

			} else {

				if (oddStart == null) {
					oddStart = currentNode;
					oddEnd = oddStart;
				} else {
					oddEnd.next = currentNode;
					oddEnd = oddEnd.next;
				}
			}
			// Move head pointer one step in forward direction
			currentNode = currentNode.next;
		}

		if (oddStart == null || evenStart == null) {
			return head;
		}

		evenEnd.next = oddStart;
		oddEnd.next = null;
		head = evenStart;
		return head;
	}

	public static LinkedListNode swapNode(LinkedListNode head) {
		LinkedListNode current = head;
		while (current.next != null && current != null && current.next.next != null) {
			int temp = current.data;
			current.data = current.next.data;
			current.next.data = temp;
			current = current.next.next;
		}
		return head;
	}

	public static RandomNode cloneLLwithRandomPointer(RandomNode head) {

		// creating copy of nodes
		for (RandomNode current = head; current != null;) {
			RandomNode nxt = current.next;
			current.next = new RandomNode(current.value);
			current.next.next = nxt;
			current = nxt;
		}
		// making random connectn
		for (RandomNode current = head; current != null; current = current.next.next) {
			current.next.random = (current.random != null) ? current.random.next : null;
			
		}

		// taking new random nodes only and completing the list
		head = head.next;
		RandomNode cur = head;

		while (cur != null ) {
			cur.next = cur.next!=null?cur.next.next:cur.next;
			cur = cur.next;
		}
		return head;

	}
	static RandomNode clone(RandomNode start)  
	{  
		RandomNode curr = start, temp = null;  
	  
	    // insert additional node after  
	    // every node of original list  
	    while (curr != null)  
	    {  
	        temp = curr.next;  
	  
	        // Inserting node  
	        curr.next = new RandomNode(curr.value);  
	        curr.next.next = temp;  
	        curr = temp;  
	    }  
	    curr = start;  
	  
	    // adjust the random pointers of the  
	    // newly added nodes  
	    while (curr != null)  
	    {  
	        if(curr.next != null)  
	            curr.next.random = (curr.random != null) 
	                      ? curr.random.next : curr.random;  
	  
	        // move to the next newly added node by  
	        // skipping an original node  
	        curr = (curr.next != null) ? curr.next.next  
	                                        : curr.next;  
	    }  
	  
	    RandomNode original = start, copy = start.next;  
	  
	    // save the start of copied linked list  
	    temp = copy;  
	  
	    // now separate the original list and copied list  
	    while (original != null && copy != null)  
	    {  
	        original.next = (original.next != null)?  
	                    original.next.next : original.next;  
	  
	        copy.next = (copy.next != null) ? copy.next.next  
	                                            : copy.next;  
	        original = original.next;  
	        copy = copy.next;  
	    }  
	    return temp;  
	}

	static boolean isPalindrome(LinkedListNode head) {
		// Your code here
		if (head == null || head.next == null)
			return false;
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		while (fast != null && fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if(fast!=null) {
			slow=slow.next;
		}
		LinkedListNode revHead = reverseRecursive1(slow, null);
		System.out.println(revHead);
		fast = head;

		while (revHead != null && fast != null) {
			if (fast.data != revHead.data) {
				return false;
			}
			revHead = revHead.next;
			fast = slow.next;
		}
		return true;
	}

	int countNodesinLoop(LinkedListNode head) {
		// Add your code here.
		LinkedListNode prev = head;
		LinkedListNode nextnode = head;
		int flag = 1;
		if (head == null)
			return 0;
		LinkedListNode mettingPtn = null;
		while (nextnode != null && nextnode.next != null) {
			nextnode = nextnode.next.next;
			prev = prev.next;
			if (prev == nextnode) {
				flag = 0;
				mettingPtn = prev;
				break;
			}
		}

		if (flag == 0) {
			int count = 1;
			nextnode = nextnode.next;
			while (nextnode != mettingPtn) {
				nextnode = nextnode.next;
				count++;

			}
			return count;

		} else {
			return 0;
		}
	}
	static LinkedListNode swapkthnode(LinkedListNode head, int num, int k){
        if(k>num) return head;
		if(k==1||k==num) {
			LinkedListNode first=head;
			LinkedListNode last=head;
			while(last.next!=null) {
				last=last.next;
			}
			int temp=last.data;
			last.data=first.data;
			first.data=temp;
		}else {
			LinkedListNode pt2 = head;
			int i = 0;
			while (i < k) {
				if (pt2 == null) {
					break;
				}
				pt2 = pt2.next;
				i++;
			} 
			LinkedListNode pt1 = head;
			while (pt2 != null) {
				pt2 = pt2.next;
				pt1 = pt1.next;
			}
			pt2=head;
			while(k>1) {
				pt2=pt2.next;
				k--;
			}
			LinkedListNode kthNodeFromFirst=pt2;
			LinkedListNode kthnodefromLast=pt1;
			int temp=kthnodefromLast.data;
			kthnodefromLast.data=kthNodeFromFirst.data;
			kthNodeFromFirst.data=temp;
		} 
		
		return head;
		
    }

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.insertBegin(1);
		l.insertBegin(2);
		l.insertBegin(3);
		l.addLast(50);
//		l.addLast(20);
		LinkedList l1 = new LinkedList();
		l1.insertBegin(1);
		LinkedList l2 = new LinkedList();
		l2.insertBegin(1);
		l2.insertBegin(2);
		LinkedList l3 = new LinkedList();
		l3.insertBegin(1);
		l3.insertBegin(1);
		LinkedList l4 = new LinkedList();
		l4.insertBegin(1);
		l4.insertBegin(2);
		l4.insertBegin(1);
		LinkedList l5 = new LinkedList();
		l5.insertBegin(1);
		l5.insertBegin(2);
		l5.insertBegin(3);
		l5.insertBegin(4);
		l5.insertBegin(5);
		
		
		System.out.println(l.head);
		System.out.println(swapkthnode(l.head,l.length,1));

//		LinkedListNode anotherNode = NthNodeFromLastSol2(l.head, 2);
//		LinkedListNode lastNode = l.lastNode();
//		System.out.println(anotherNode);
//		lastNode.next=anotherNode;
//		System.out.println(l.head);
//		System.out.println(cloneLLwithRandomPointer(l.head));

//		System.out.println(l);

	}

}

/*
 * discussion:
 * 
 *
 * 
 * 
 * 
 * 
 * 
 * 
 */