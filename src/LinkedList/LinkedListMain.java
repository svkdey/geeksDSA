package LinkedList;

public class LinkedListMain {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list.push(10);
		list.push(20);
		list.push(230);
		list.shift(1);
		list.shift(2);

//		list.toString();
//		list.removeInNthPos(2);
		list.toString();
//		LinkedListNode node = LinkedList.rotateList(list.head);
//		LinkedList.traverse(node);
		System.out.println(LinkedList.searchNode(list.head, 230));

	}

}



/*	discussion:
 * 
 *
 * 
 * 
 * 
 * 
 * 
 * 
 * */