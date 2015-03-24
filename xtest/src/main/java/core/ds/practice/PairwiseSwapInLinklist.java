package core.ds.practice;

/*class Node {
 int data;
 Node node;

 public Node(int data, Node node) {
 this.data = data;
 this.node = node;
 }
 }
 */
public class PairwiseSwapInLinklist {

	public static void main(String[] args) {
		// 1,2,3,4,5,6,7
		Node header = null;
		int i = 7;
		while (i > 0) {
			header = add(header, i);
			i--;
		}
		print(header);
		header = swap(header);
		System.out.println();
		print(header);
	}

	static Node swap(Node header) {
		if (header == null || header.next == null)
			return header;
		Node temp1 = header;
		header=temp1.next;
		do {
			Node temp2 = temp1.next;
			temp1.next = temp2.next;
			temp2.next = temp1;
			temp1 = temp1.next;
		}while(temp1 != null && temp1.next != null);
		return header;
	}

	static Node add(Node header, int data) {
		Node temp = new Node(data, header);
		return temp;
	}

	static void print(Node header) {
		Node temp = header;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
}
