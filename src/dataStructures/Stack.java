package dataStructures;

public class Stack<T> {
	
	private StackNode<T> top;
	private int size;

	public Stack() {
		this.size = 0;
	}
	
	public void push(StackNode<T> newNode) {
		if(top == null) {
			top = newNode;
		} else {
			newNode.setNext(top);
			top = newNode;
		}
		
		++size;
	}
	
	public void push(T newNodeValue) {
		StackNode<T> newNode = new StackNode<>(newNodeValue);
		
		push(newNode);
	}
	
	public StackNode<T> pop() {
		StackNode<T> node = null;
		
		if(top == null) {
			System.out.println("Conjunto vacío");
			return null;
		} else {
			node = top;
			top = top.getNext();
		}
		
		--size;
		
		return node;
	}
	
	public StackNode<T> top() {
		if(top == null) {
			return null;
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
	
	public boolean contains(T elementSearched) {
		if(top == null) {
			return false;
		}
		
		StackNode<T> current = top;
		
		for (int i = 0; i < size; i++) {
			if(current.getValue().equals(elementSearched)) {
				return true;
			}
		}
		
		return false;
	}
}
