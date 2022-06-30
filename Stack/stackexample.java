// 스택 구현 단, Generic을 이용하라

// Generic을 이용하면 코드의 재사용성이 높아짐
// 보통 Generic에서 T는 type을 의미함

// 스택이 비어 있을 때 예외처리 
import java.util.EmptyStackException;

// stack 구현 push(), pop(), peek(), Isempty()
// 중첩 클래스
// 중첩 클래스를 사용하는 이유: 클래스들의 논리적인 그룹을 나타낼 때 쓴다.

class stack <T>{
	//노드의 구성 요소 data, next
	class node<T>{
		// 데이터 값을 저장하기 위한 변수
		private T data;
		
		private node<T> next;
		
		// 생성자, push()에서 값이 들어오면 data 값을 입력하기 위함
		public node(T data) {
			this.data = data;
		}
	}
	
	private node<T> top;
	
	public T pop() {
		// 저장된 데이터가 없을 경우 예외 처리
		if (top == null) {
			throw new EmptyStackException();
		}
		T item = top.data;
		top = top.next;
		
		return item;
	}
	
	public void push(T item)
	{
		node<T> t = new node<T>(item);
		// top은 t를 가리킨다.
		t.next = top;
		top = t;
	}
	
	public T peek() 
	{	
		if (top == null)
		{
			throw new EmptyStackException();
		}
		
		return top.data;
	}
	
	public boolean Isempty() {
		if(top == null) {
			return true;
		}
		
		return false;
	}
}

public class stackexample {

	public static void main(String[] args) {
		stack<Integer> s = new stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.Isempty());
		System.out.println(s.pop());
		System.out.println(s.Isempty());
	}

}
