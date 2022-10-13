package dataStructures;

public class Hashtable<K,V> {

	//Uses an object Map to make easier the implementation of the couples of key and value.
	private SimpleLinkedList<Map<K,V>> table;

	public Hashtable() {
		this.table = new SimpleLinkedList<>();
	}
	
	public void insert(K key, V value) {
		if(contains(key)) {
			replaceValue(key,value);
		}
		
		Map<K,V> newMap = new Map<K,V>(key,value);
		table.add(new SimpleNode<Map<K,V>>(newMap));
	}
	
	public void replaceValue(K key,V value) {
		int i = searchIndex(key);
		
		table.get(i).setValue(value);
	}
		
	public Map<K,V> search(K key) {
		if(searchIndex(key) < 0) {
			return null;
		}
		
		return table.get(searchIndex(key));
	}
	
	public int searchIndex(K key) {
		int index = -1;
		
		for(int i = 0; i < table.size(); i++) {
			if(table.get(i).getKey().equals(key)) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	public boolean contains(K key) {
		if(searchIndex(key) < 0) {
			return false;
		}
		
		return true;
	}
	
	public void delete(K key) {
		int i = searchIndex(key);
		
		if(i < 0) {
			return;
		}
		
		table.delete(i);
	}
	
	public void delete(Map<K, V> element) {
		delete(element.getKey());
	}
	
	public int size() {
		return table.size();
	}
}
