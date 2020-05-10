package StackDSA;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Data.StackData;
import Data.StackDataw;

public class EasyStackProblems {
	public static String removeConsecutiveDuplicates(String str) {
		// Your code here
		Deque<Character> dq = new LinkedList<Character>();
		dq.addFirst(str.charAt(0));
		for (int i = 1; i < str.length(); i++) {
			char s = str.charAt(i);
//            System.out.println(dq.peekLast()==s);
			if (dq.peekLast() != s) {
				dq.addLast(s);
			}

		}
		// System.out.println("dq>>>"+dq);
		str = "";
		while (!dq.isEmpty()) {
			str += dq.removeFirst();
		}
		return str;
	}

	public static String removePair(String str) {
		// your code here
		Deque<Character> dq = new LinkedList<Character>();
		dq.addFirst(str.charAt(0));
		for (int i = 1; i < str.length(); i++) {
			char s = str.charAt(i);
//	            System.out.println(dq.peekLast()==s);
			if (!dq.isEmpty() && dq.peekLast() == s) {
				dq.removeLast();
			} else {
				dq.addLast(s);
			}

		}
		// System.out.println("dq>>>"+dq);
		str = "";
		while (!dq.isEmpty()) {
			str += dq.removeFirst();
		}
		return str;
	}
		//nice prblm
	public static Stack<Integer> deleteMid(Stack<Integer> s, int sizeOfStack, int current) {
		// Your code here
		//		int temp = 0;
		//recursively pull out the element and put it in call stack
		if(s.isEmpty()||sizeOfStack==current)
		{
			return s;
		}
		int x=s.pop();
		
		Stack<Integer> temp=deleteMid(s,sizeOfStack,current+1);
		//add all element again except current
		if(current!=sizeOfStack/2)
		{
		temp.push(x);
		}
		return temp;
	}
	public static Stack<Integer> sortTheStack(Stack<Integer> s)
	{
		//add code here.
		Stack<Integer> stack=new Stack<Integer>();
		if(!s.isEmpty()) {
			stack.push(s.pop());
		}
		while(!s.isEmpty()) {
			sortStack(stack,s.pop());
		}
		return stack;
		
		
	}
	public static void sortStack(Stack<Integer> s,int number){
		System.out.println("--->"+s +" "+number);
		Stack<Integer> q=new Stack<Integer>();
		if(number>s.peek()) {
			s.push(number);
		}else {
			while(!s.isEmpty()&& number<s.peek()) {
				q.push(s.pop());
			}
			s.push(number);
			while(!q.isEmpty()) {
				s.push(q.pop());
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(StackDataw.getStackData());
		Stack<Integer> s = StackDataw.getStackData();
//		deleteMid(s, 5, 0);
		System.out.println(sortTheStack(s));
	}

}
