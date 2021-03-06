package interview.binaryTree;

import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BinaryTrees_338ConnectNextRightLevelOrder {
	private static class Node {
		int data;
		Node left;
		Node right;
		Node nextRight;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";

		str += node.left == null ? "." : node.left.data;
		str += " <= " + node.data + " => ";
		str += node.right == null ? "." : node.right.data;
		str += "[" + (node.nextRight != null ? node.nextRight.data : "null") + "]";

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		// creation using the level order, seeing it like a heap
		// -1 says there is no node
		Node[] nodes = new Node[arr.length];
		for (int i = 0; i < nodes.length; i++) {
			if (arr[i] != -1) {
				nodes[i] = new Node(arr[i], null, null);

				if (i > 0) {
					int pi = (i - 1) / 2;

					if (i == 2 * pi + 1) {
						nodes[pi].left = nodes[i];
					} else {
						nodes[pi].right = nodes[i];
					}
				}
			}
		}
		Node root = nodes[0];
		// display(root);

		setNextRight(root);
		display(root);
	}

	static Node prev;
	private static void setNextRight(Node node) {
		LinkedList<Node> queue = new LinkedList<>();
		
		queue.add(node);
		queue.add(null);
		while(queue.size() > 0){
			while(queue.getFirst() != null){
				Node rem = queue.removeFirst();
				
				rem.nextRight = queue.getFirst();						
				
				if(rem.left != null){
					queue.addLast(rem.left);
				}
				
				if(rem.right != null){
					queue.addLast(rem.right);
				}
			}
			
			if(queue.size() > 1){
				queue.addLast(queue.removeFirst());
			} else {
				queue.removeFirst();
			}
		}
	}
}


/* Test case 1 
12 
1 2 3 4 5 6 7 8 9 10 11 12 
2 <= 1 => 3[null]
4 <= 2 => 5[3]
8 <= 4 => 9[5]
. <= 8 => .[9]
. <= 9 => .[10]
10 <= 5 => 11[6]
. <= 10 => .[11]
. <= 11 => .[12]
6 <= 3 => 7[null]
12 <= 6 => .[7]
. <= 12 => .[null]
. <= 7 => .[null]
*/

/* Test case 2 
12 
1 2 3 -1 4 5 -1 -1 -1 6 7 8
2 <= 1 => 3[null]
. <= 2 => 4[3]
6 <= 4 => 7[5]
. <= 6 => .[7]
. <= 7 => .[8]
5 <= 3 => .[null]
8 <= 5 => .[null]
. <= 8 => .[null]
*/
