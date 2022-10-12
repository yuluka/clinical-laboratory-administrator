package dataStructures;

public class Queue<T> {
	
	private QueueNode<T> front;
	private QueueNode<T> back;
	private int size;
	
	public Queue() {
		size = 0;
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
		
		++size;
	}
	
	public void enqueue(T newNodeValue) {
		QueueNode<T> newNode = new QueueNode<>(newNodeValue);
		enqueue(newNode);
	}
	
	public QueueNode<T> dequeue() {
		QueueNode<T> node = front;
		
		if(front == null) {
			return null;
		} else if(front == back) {
			front = null;
			back = null;
		} else {
			back.setNext(front.getNext());
			front.getNext().setPrevious(back);
			
			front = front.getNext();
		}
		
		--size;
		
		return node;
	}
	
	public QueueNode<T> front() {
		if(front == null) {
			return null;
		}

		return front;
	}
	
	public QueueNode<T> back() {
		if(front == null) {
			return null;
		}

		return back;
	}
	
	public boolean isEmpty() {
		if(front == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean contains(T elementSearched) {
		if(front == null) {
			return false;
		}
		
		QueueNode<T> current = front;
		
		for (int i = 0; i < size; i++) {
			if(current.getValue().equals(elementSearched)) {
				return true;
			} else if(current.getValue().equals(back.getValue())) {
				return false;
			}
		}
		
		return false;
	}

	public int size() {
		return size;
	}
}
