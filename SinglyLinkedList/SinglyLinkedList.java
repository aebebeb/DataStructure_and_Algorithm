// Java에 포인터가 없는 이유
// https://sorjfkrh5078.tistory.com/278

class Node {
		int data;
		Node next = null;

		Node(int d) {
			this.data = d;
		}
		
		// 노드 추가
		void append (int d) {
			// 마지막 노드 메모리 할당
			Node end = new Node(d);
			
			// 기존에 있던 맨 마지막 노드가 새로 만든 노드를 가리키도록 만듦
			Node n = this;
			while (n.next != null) {
				n = n.next;
			}
			n.next = end;
		}
		
		// 노드 삭제 -> 인수에 들어온 값과 일치하는 값을 가지고 있는 노드를 삭제함
		void delete (int d) {
			Node n = this; // 현재 노드(HEAD)를 가리킴
//			System.out.println(this.data);
			while (n.next != null) {
				if (n.next.data == d) {
					n.next = n.next.next;
				}
				else {
					n = n.next;
				}
			}
		}
		
		void retrieve() {
			Node n = this;
			while (n.next != null) {
				System.out.print(n.data + "->"); //println은 줄바꿈을 하고, print는 줄바꿈을 하지 않음
				n = n.next;
			}
				System.out.println(n.data);
		}
	}

public class SinglyLinkedList {
	
	public static void main(String[] args) {
		
		Node head = new Node(1);
		head.append(2);
		head.append(3);
		head.append(4);
		head.retrieve();
		head.delete(3);
		head.retrieve();
	}

}
