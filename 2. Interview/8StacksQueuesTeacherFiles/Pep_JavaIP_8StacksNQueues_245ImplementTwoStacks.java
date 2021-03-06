package Stacks;
import java.util.Scanner;

public class Pep_JavaIP_8StacksNQueues_245ImplementTwoStacks {
/**Implement two stacks efficiently in one array */
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Stack st = new Stack(scn.nextInt(), scn.nextInt());

		do {
			int choice = scn.nextInt();
			switch (choice) {
			case 1:
				st.pushInStack1(scn.nextInt());
				break;
			case 2:
				st.pushInStack2(scn.nextInt());
				break;
			case 3:
				System.out.println(st.popInStack1());
				break;
			case 4:
				System.out.println(st.popInStack2());
				break;
			case 5:
				st.displayStack1();
				break;
			case 6:
				st.displayStack2();
				break;
			default:
				return;
			}
		} while (true);

	}

	static class Stack {
		int[] data;
		int top1;
		int top2;
		int size2;
		int size1;

		public Stack(int size1, int size2) {
			this.size1 = size1;
			this.size2 = size2;
			data = new int[size1 + size2];
			this.top1 = -1;
			this.top2 = data.length;
		}

		// These functions have to been written to solve this problem.
		// --------------------------------------------

		public void pushInStack1(int value) {
			//stack 2 is full
			//stack 1 is full
			if (top1 == top2 - 1) {
				System.out.println("Stack Overflow");
				return;
			}

			top1++;
			data[top1] = value;

		}

		public void pushInStack2(int value) {
			// stack1 is full
			//stack 2 is full
			if (top2 == top1 + 1) {
				System.out.println("Stack Overflow");
				return;
			}

			top2--;
			data[top2] = value;

		}

		public int popInStack1() {

			if (top1 == -1) {
				// System.out.println("Stack Underflow");
				return -1;
			}
			int rv = data[top1];
			top1--;
			return rv;
		}

		public int popInStack2() {
			if (top2 == data.length) {
				//System.out.println("Stack Underflow");
				return -1;
			}

			int rv = data[top2];
			top2++;
			return rv;
		}

		public void displayStack1() {
			int temp = top1;

			while (temp >= 0) {
				System.out.print(data[temp] + ", ");
				temp--;
			}
			System.out.println(".");
		}

		public void displayStack2() {
			int temp = top2;

			while (temp < data.length) {
				System.out.print(data[temp] + ", ");
				temp++;
			}
			System.out.println(".");
		}
		//---------------------------------------

	}
}

/*Test Cases: 
3
3
1 2
1 4
2 6
2 8
5
3
3
3
6
4
4
6
7
---------------
4, 2, .
4
2
-1
8, 6, .
8
6


4
4
1 2
1 4
1 6
1 8
2 6
2 8
2 10
5
3
3
6
4
4
6
7
------------------
8, 6, 4, 2, .
8
6
10, 8, 6, .
10
8

4
4
1 2
1 4
1 6
1 8
2 6
2 8
2 10
2 12
2 14
2 16
5
3
3
6
4
4
6
7
--------------------
Stack Overflow
Stack Overflow
8, 6, 4, 2, .
8
6
12, 10, 8, 6, .
12
10



Source: https://www.geeksforgeeks.org/implement-two-stacks-in-an-array/

*/