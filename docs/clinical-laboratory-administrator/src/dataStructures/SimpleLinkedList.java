package dataStructures;

public class SimpleLinkedList<T> implements Cloneable {
	
	private SimpleNode<T> head;
	private int size;

	public SimpleLinkedList() {
		this.size = 0;
	}
	
	public void add(SimpleNode<T> node) {
		if(head == null) {
			head = node;
		} else {
			node.setNext(head);
			head = node;
		}
		
		++size;
	}
	
	public T get(int i) {
		SimpleNode<T> node = head;
		
		for (int j = 0; j < i; j++) {
			node = node.getNext();
		}
		
		return node.getValue();
	}
	
	public SimpleNode<T> getNode(int i) {
		SimpleNode<T> node = head;
		
		for (int j = 0; j < i; j++) {
			node = node.getNext();
		}
		
		return node;
	}
	
	public void delete(int i) {
		if(i == 0) {
			head = head.getNext();
		} else {
			SimpleNode<T> node = getNode(i-1);
			
			node.setNext(node.getNext().getNext());			
		}
		
		--size;
	}
	
	public int size() {
		return this.size;
	}
	
	public String printList() {
		return printList(head, "");
	}
	
	public String printList(SimpleNode<T> current, String info) {
		if(current == null) {
			return info;
		}
		
		return printList(current.getNext(), info+current.getValue());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public SimpleLinkedList<T> clone() {
		try {
			SimpleLinkedList<T> aux = (SimpleLinkedList<T>) super.clone();
			aux.head = head.clone();
			
			return aux;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			
			return null;
		}
	}	
	
}
