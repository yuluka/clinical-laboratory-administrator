package dataStructures;

public class SimpleNode<T> implements Cloneable {
	
	private T value;
	private SimpleNode<T> next;
	
	public SimpleNode(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public SimpleNode<T> getNext() {
		return next;
	}

	public void setNext(SimpleNode<T> next) {
		this.next = next;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public SimpleNode<T> clone() {
		try {
			SimpleNode<T> aux = (SimpleNode<T>) super.clone();
			
			if(aux.next != null) {
				aux.next = next.clone();
			}
			
			return aux;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			
			return null;
		}
	}
}
