// 정렬되어 있지 않은 LinkedList의 중복값을 제거하시오 (단, 별도의 버퍼를 사용하지 않음)

// 자료구조나 알고리즘을 짤 때 넓게 보고 넓게 생각하자.
// 오늘의 반성: 숲을 보고나면 나무도 봐야 한다는 사실을 잊지 말자.

// 강의에서는 if문을 최소화하고 if문이나 while문의 조건을 설정함으로써 if문의 빈도를 낮췄다.
// 이에 맞춰서 코드를 수정해 볼 것!
class LinkedListStructure3 {
	Node head;

	static class Node {
		Node next = null;
		int data;
	}

	// 이 생성자는 헤더에 메모리 할당을 하기 위한 생성자(link의 기본 생성자), 노드를 추가할 땐 append() 안에서 new
	// Node(); (노드의 기본 생성자)를 사용
	LinkedListStructure3() {
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
	// 해시를 사용하지 않고 중복되는 숫자를 제거하는 메소드

	void delete_duplication()

// 알고리즘 생각해 보기, 해시를 사용하지 않는다면 중복되는 숫자를 어떻게 제거할 것인가?
// 시간이 많이 걸리지만 임의의 노드의 값을 저장하여 노드를 순회하며 데이터 값을 비교하고 같은 데이터 값을 가지고 있는 노드는 제거한다.

	{
		// 기준 노드
		Node stan = head.next;

		// 순차적으로 비교 당하고 있는 노드
		Node cur = stan;

		// 기준 노드가 말단 노드가 되면 안 됨 (while의 조건)
		while (stan.next != null) {
			// 헤드와 모든 노드의 값 비교 -> 그 다음 노드의 값과 다른 노드들의 값 비교 ... 마지막 - 1 번째 노드의 값과 마지막 노드의 값
			// 비교, 값 비교 끝

			// 일반적인 노드의 값 비교해서 일치하면 삭제
			// cur이 null 값이라면 stan.next의 위치 이동 시킨다.
			// cur은 마지막 노드까지 돌아야 한다. 마지막 노드까지 돌았으면 cur의 위치를 바꾼다. 
			while (cur.next != null) {
				if (stan.data == cur.next.data) {
					cur.next = cur.next.next;
				}
				// 데이터가 일치하지 않더라도 비교 당하고 있는 노드의 위치는 바뀌어야 함
				// if - else 꼭...
				else {					
					cur = cur.next;
				}
			}
			// stan 자리 재배치
			stan = stan.next;
			// cur도 자리 재배치 필요함
			cur = stan;
		}
	}
}

public class SinglyLinkedList_duplication_deletion3 {

	public static void main(String[] args) {
		LinkedListStructure3 wh = new LinkedListStructure3();
		wh.append(1);
		wh.append(2);
		wh.append(3);
		wh.append(4);
		wh.append(2);
		wh.append(3);
		wh.append(4);
		wh.append(5);
		wh.append(6);
		wh.append(2);
		wh.retrieve();
		wh.delete_duplication();
		wh.retrieve();
	}

}
