package dataStructures;

public class Queue<T> {
	
	private QueueNode<T> front;
	private QueueNode<T> back;
	
	public Queue() {
	
	}
	
	public void enqueue(QueueNode<T> newNode) {
		if(front == null) {
			front = newNode;
			back = newNode;
			front.setNext(back);
			front.setPrevious(back);
			back.setNext(front);
			back.setPrevious(front);
		} else {
			back.setNext(newNode);
			newNode.setPrevious(back);
			newNode.setNext(front);
			back = newNode;
			
			front.setPrevious(back);
		}
	}
	
	public QueueNode<T> dequeue() {
		QueueNode<T> node = front;
		
		if(front == null) {
			//Lanzar excepción
		} else {
			back.setNext(front.getNext());
			front.getNext().setPrevious(back);
			
			front = front.getNext();
		}
		
		return node;
	}
	
	public QueueNode<T> front() {
		if(front == null) {
			//Lanzar excepción
		}

		return front;
	}
	
	public boolean isEmpty() {
		if(front == null) {
			return true;
		} else {
			return false;
		}
	}
	
}
