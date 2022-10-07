package dataStructures;

public class Stack<T> {
	
	private StackNode<T> top;

	public Stack() {
		
	}
	
	public void push(StackNode<T> newNode) {
		if(top == null) {
			top = newNode;
		} else {
			newNode.setNext(top);
			top = newNode;
		}
	}
	
	public StackNode<T> pop() {
		StackNode<T> node = null;
		
		if(top == null) {
			//Lanzar excepción
			System.out.println("Conjunto vacío");
		} else {
			node = top;
			top = top.getNext();
		}
		
		return node;
	}
	
	public StackNode<T> top() {
		if(top == null) {
			//Lanzar excepción
		}
		
		return top;
	}
	
	public boolean isEmpty() {
		if(top == null) {
			return true;
		} else {
			return false;
		}
	}
}
