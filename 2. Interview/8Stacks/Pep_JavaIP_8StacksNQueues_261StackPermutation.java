package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class Pep_JavaIP_8StacksNQueues_261StackPermutation {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int[] output_arr = new int[arr.length];
		for (int i = 0; i < n; i++) {
			output_arr[i] = scn.nextInt();
		}

		// make a stack
		Stack<Integer> st = new Stack<>();
		int i = 0;
		int j = 0;
		while (i != arr.length) {
			int top = output_arr[j];
			while (arr[i] != top && i != arr.length) {
				st.push(arr[i]);
				i++;
			}
			j++;
			i++;

			while (st.isEmpty() == false) {
				int ele = st.pop();
				if (output_arr[j] != ele) {
					st.push(ele);
					break;
				}else {
					j++;
				}
				
			}
		}
		if(st.isEmpty() && i==arr.length)
			System.out.println("Yes");
		else {
			System.out.println("Not Possible");
		}

	}

}

/*
3
1 2 3
3 1 2
-------------------
Not Possible


3
1 2 3
2 1 3
-------------------
Yes

6
10 54 55 20 30 40
55 54 10 20 40 30
-------------------
Yes

Source: https://www.geeksforgeeks.org/stack-permutations-check-if-an-array-is-stack-permutation-of-other/*/
