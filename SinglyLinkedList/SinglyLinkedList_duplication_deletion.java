// 정렬되어 있지 않은 LinkedList의 중복값을 제거하시오 (단, 별도의 버퍼를 사용하지 않음)

// 자료구조나 알고리즘을 짤 때 넓게 보고 넓게 생각하자.
// 오늘의 반성: 숲을 보고나면 나무도 봐야 한다는 사실을 잊지 말자.
 
class link {
	Node head;

	static class Node {
		Node next = null;
		int data;
	}

	// 이 생성자는 헤더에 메모리 할당을 하기 위한 생성자(link의 기본 생성자), 노드를 추가할 땐 append() 안에서 new
	// Node(); (노드의 기본 생성자)를 사용
	link() {
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

	void delete_duplication(int num) {
		Node n = head;
		
		// 말단 노드까지 중복값을 제거할 것이기 때문에 그에 맞는 조건문과 반복문 사용해야 함
		while (n.next != null) { //n이 말단 노드일 때 while문 종료
			// n이 말단 노드가 아닐 때
			if(n.next.data == num) {
				n.next = n.next.next;
			}
			
			// n이 말단 노드 앞의 노드일 때
			else if (n.next.next == null && n.next.data == num) {
				n.next = null;
			}
			// 인수와 노드의 값이 일치하지 않을 때 <조건문 작성할 땐 정신을 바짝 차리자...> 
			else {
				n = n.next;
			}
		}
	}

}

public class SinglyLinkedList_duplication_deletion {

	public static void main(String[] args) {
		link wh = new link();
		wh.append(1);
		wh.append(2);
		wh.append(3);
		wh.append(4);
		wh.append(2);
		wh.append(3);
		wh.append(1);
		wh.append(1);
		wh.append(2);
		wh.retrieve();
		wh.delete_duplication(2);
		wh.retrieve();
	}

}
