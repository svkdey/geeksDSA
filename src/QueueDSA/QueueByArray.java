package QueueDSA;

import java.util.Arrays;

public class QueueByArray {
	int queue[]=null;
	int front=-1;
	int rear=-1;
	int size=0;
	public QueueByArray(int size) {
		this.size=size;
		queue=new int[size];
		// TODO Auto-generated constructor stub
	}
	void push(int data) {
		if(rear==size) {
			System.out.println("queue is full");
		}else if(rear==-1) {
			front++;
			rear++;
			queue[rear]=data;
		}else {
			rear++;
			queue[rear]=data;
		}
	}
	int pop() {
		if(rear==-1) {
			System.out.println("stack is empty");
			return -1;
		}else {
			int temp=queue[front];
			front++;
			if(front>rear) {
				front=-1;
				rear=-1;
			}
			return temp;
		}
		
	}
	int seek() {
		if(front==-1) {
			System.out.println("stack is empty");
			return -1;
			
		}else {
			return queue[front];
		}
	}
	boolean isEmpty() {
		return rear==-1;
	}
	int size() {
		return rear+1;
	}
	
	@Override
	public String toString() {
		return "QueueByArray [queue=" + Arrays.toString(queue) + ", front=" + front + ", rear=" + rear + ", size="
				+ size + "]";
	}
	public static void main(String[] args) {
		QueueByArray q=new QueueByArray(5);
		q.push(10);
//		q.pop();
		q.push(100);
		System.out.println(q);
		System.out.println(q.size());
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
//		System.out.println(q.size());
//	
//		
//		System.out.println(q.pop());
//		q.push(100);
//		q.push(200);
//		while(!q.isEmpty()) {
//			System.out.println(q.pop());
//		}
//		System.out.println(q);
//		
	}
}
