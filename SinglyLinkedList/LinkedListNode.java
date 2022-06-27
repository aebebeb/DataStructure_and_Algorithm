// SinglyLinkedList에서는 헤더가 링크드 리스트의 대표이면서 첫 번째 값이기 때문에 어떤 오브젝트가 헤더를 가리키고 있을 때 문제가 발생함
// 이 코드에서는 header를 데이터가 아닌 링크드 리스트의 시작만을 알려 주기 위한 것으로 사용함

class LinkedList {
	// 헤더를 멤버 변수로 선언함
	Node header;

	static class Node {
		int data;
		Node next = null;
	}
		
	LinkedList () {
		// 헤더가 다음 노드를 가리키게 만들기 위한 메모리를 할당해 주기 위한 생성자
		header = new Node();
	}
		
		// 노드 추가
		void append(int d) {
			Node end = new Node();
			//일단 데이터 넣고
			end.data = d;
			//헤더를 가리키기 위한 참조 (reference)
			Node n = header;
			while (n.next != null) {
				n = n.next;
			}
			n.next = end;
		}
		
		void delete(int d) {
			Node n = header;
			while (n.next != null) {
				if (n.next.data == d) {
					n.next = n.next.next;
				} else {
					n = n.next;
				}
			}
		}
		
		void retrieve() {
			Node n = header.next;
			while (n.next != null) {
				System.out.print(n.data + "->"); // println은 줄바꿈을 하고, print는 줄바꿈을 하지 않음
				n = n.next;
			}
			System.out.println(n.data);
		}
		
	}

public class LinkedListNode {

	public static void main(String[] args) {

		LinkedList ll = new LinkedList();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.retrieve();
		ll.delete(2);
		ll.retrieve();
	}

}
