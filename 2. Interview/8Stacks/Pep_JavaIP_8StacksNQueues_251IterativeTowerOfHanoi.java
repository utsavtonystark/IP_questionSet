package Stacks;

import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_8StacksNQueues_251IterativeTowerOfHanoi {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofDisks = scn.nextInt();
		tohiterative('A', 'B', 'C', noofDisks);
	}

	private static class tohHelper {
		char s;
		char d;
		char h;
		boolean selfdone;
		boolean leftdone;
		boolean rightdone;
		int noofdisks;

		public tohHelper(char s, char d, char h, boolean selfdone, boolean leftdone, boolean rightdone, int noofdisks) {
			this.s = s;
			this.d = d;
			this.h = h;
			this.selfdone = selfdone;
			this.leftdone = leftdone;
			this.rightdone = rightdone;
			this.noofdisks = noofdisks;
		}
	}

	private static void tohiterative(char s, char d, char h, int noofDisks) {
		LinkedList<tohHelper> stack = new LinkedList<>();
		tohHelper root = new tohHelper(s, d, h, false, false, false, noofDisks);
		stack.addFirst(root);
		while (stack.isEmpty() == false) {
			tohHelper pop = stack.getFirst();
			if (pop.leftdone == false && pop.noofdisks != 0) {
				// swap d and h and add to the stack
				pop.leftdone = true;
				tohHelper newtoh = new tohHelper(pop.s, pop.h, pop.d, false, false, false, pop.noofdisks - 1);
				stack.addFirst(newtoh);

			} else if (pop.selfdone == false) {
				if (pop.noofdisks != 0) {
					System.out.println("Move " + pop.noofdisks + " from " + pop.s + " to " + pop.d);
				} else {
					stack.removeFirst();
				}
				pop.selfdone = true;
			} else if (pop.rightdone == false && pop.noofdisks != 0) {
				// swap s and h and add to the stack
				// remove pop
				pop.rightdone = true;
				tohHelper newtoh = new tohHelper(pop.h, pop.d, pop.s, false, false, false, pop.noofdisks - 1);
				stack.addFirst(newtoh);
			} else {
				stack.removeFirst();
			}
		}
	}

}

/*
Test Cases:
3
---------------------------
Move 1 from A to B
Move 2 from A to C
Move 1 from B to C
Move 3 from A to B
Move 1 from C to A
Move 2 from C to B
Move 1 from A to B

4
-------------------------
Move 1 from A to C
Move 2 from A to B
Move 1 from C to B
Move 3 from A to C
Move 1 from B to A
Move 2 from B to C
Move 1 from A to C
Move 4 from A to B
Move 1 from C to B
Move 2 from C to A
Move 1 from B to A
Move 3 from C to B
Move 1 from A to C
Move 2 from A to B
Move 1 from C to B


5
----------------------------
Move 1 from A to B
Move 2 from A to C
Move 1 from B to C
Move 3 from A to B
Move 1 from C to A
Move 2 from C to B
Move 1 from A to B
Move 4 from A to C
Move 1 from B to C
Move 2 from B to A
Move 1 from C to A
Move 3 from B to C
Move 1 from A to B
Move 2 from A to C
Move 1 from B to C
Move 5 from A to B
Move 1 from C to A
Move 2 from C to B
Move 1 from A to B
Move 3 from C to A
Move 1 from B to C
Move 2 from B to A
Move 1 from C to A
Move 4 from C to B
Move 1 from A to B
Move 2 from A to C
Move 1 from B to C
Move 3 from A to B
Move 1 from C to A
Move 2 from C to B
Move 1 from A to B

Source: https://www.geeksforgeeks.org/iterative-tower-of-hanoi/



*/