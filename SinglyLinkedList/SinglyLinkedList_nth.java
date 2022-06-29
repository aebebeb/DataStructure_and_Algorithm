// 단방향 LinkedList의 끝에서 k번째 노드를 찾는 알고리즘을 구현하시오.

class LinkedListStructure4 {
	Node head;

	static class Node {
		Node next = null;
		int data;
	}

	LinkedListStructure4() {
		head = new Node();
	}

	// 맨 마지막 부분에 노드 삽입
	void append(int d) {
		Node cur = new Node();
		cur.data = d;
		Node n = head;
		while (n.next != null) {
			n = n.next;
		}
		n.next = cur;
	}

	void delete(int d) {
		Node n = head.next;
		while (n.next.data == d) {
			n = n.next;
		}
		n.next = n.next.next;
	}

	void retrieve() {
		Node n = head.next;
		while (n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.println(n.data);
	}
	
	//linked list의 길이를 구하는 메소드 (헤드 포함)
	int length() {
		Node cur = head;
		int count = 0;
		
		while (cur.next !=null) {
			// 현재 노드 카운트
			++count;
			// 다음 노드로 넘어가기
			cur = cur.next;
		}
		
		return count;
	}
	
	// linked list의 k번째 노드의 값을 반환하는 함수
	// i는 간선 갯수!
	int find(int n) {
		
		Node cur = head;
		// i는 지나온 간선의 번호
		for (int i = 0; i < this.length() - (n - 1) ; ++i)
		{
			cur = cur.next;
		}
		
		return cur.data;
	}
}

public class SinglyLinkedList_nth {

	public static void main(String[] args) {
		LinkedListStructure4 wh = new LinkedListStructure4();
		wh.append(1);
		wh.append(2);
		wh.append(3);
		wh.append(4);
		wh.append(5);
		wh.append(6);
		wh.append(7);
		wh.append(8);
		wh.append(9);
		wh.retrieve();
		System.out.println(wh.length());
		System.out.println(wh.find(1));
	}

}


// 반성: 변수 하나하나가 무엇을 의미하는지 생각하며 코드를 작성하자.