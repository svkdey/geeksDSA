package StackDSA;

import java.util.Arrays;

public class TwoStackByOneArray {
	int size;
	int top1, top2;
	int arr[];

	// Constructor
	public TwoStackByOneArray(int n) {
		arr = new int[n];
		size = n;
		top1 = -1;
		top2 = size;
	}

	void push1(int x)
    {
        // There is at least one empty space for
        // new element
        if (top1 < top2 - 1)
        {
            top1++;
            arr[top1] = x;
        }
        else
        {
            System.out.println("Stack Overflow");
            System.exit(1);
        }
    }

    // Method to push an element x to stack2
    void push2(int x)
    {
        // There is at least one empty space for
        // new element
        if (top1 < top2 -1)
        {
            top2--;
            arr[top2] = x;
        }
        else
        {
            System.out.println("Stack Overflow");
            System.exit(1);
        }
    }

    // Method to pop an element from first stack
    int pop1()
    {
        if (top1 >= 0)
        {
            int x = arr[top1];
            top1--;
            return x;
        }
        else
        {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return 0;
    }

    // Method to pop an element from second stack
    int pop2()
    {
        if(top2 < size)
        {
            int x =arr[top2];
            top2++;
            return x;
        }
        else
        {
            System.out.println("Stack Underflow");
            System.exit(1);

        }
        return 0;
    }

	public boolean isEmpty1() {
		return this.top1 == -1;
	}

	public boolean isEmpty2() {
		return this.top2 == this.size;
	}

	public int peek1() {
		return this.arr[top1];

	}

	public int peek2() {
		return this.arr[top2];
	}

	public int stackSize1() {
		return top1 + 1;
	}

	public int stackSize2() {
		return this.size - top2;
	}

	@Override
	public String toString() {
		return "TwoStackByOneArray [arr=" + Arrays.toString(arr) + ", top1=" + top1 + ", top2=" + top2 + ", size="
				+ size + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoStackByOneArray ts = new TwoStackByOneArray(10);

		ts.push1(20);
		ts.push1(10);
		ts.push1(30);
		ts.push1(40);
		ts.push1(50);
		ts.push1(100);
		ts.push1(80);
		ts.push2(300);
		ts.push2(400);
		ts.push2(600);

//		System.out.println(ts.pop1());
		ts.push2(250);
		ts.push2(230);
//		ts.push2(1000);
		System.out.println(ts.stackSize1());
		System.out.println(ts.stackSize2());
		System.out.println(ts);
	}

}
