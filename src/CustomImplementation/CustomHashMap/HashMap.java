package CustomHashMap;

public class HashMap<K, V> {

	private Entry<K, V>[] entryTable;
	private int initialCapacity = 16;
	
	@SuppressWarnings("unchecked")
	public HashMap(){
		entryTable = new Entry[initialCapacity];
	}
	
	@SuppressWarnings("unchecked")
	public HashMap(int initialCap){
		this.initialCapacity = initialCap;
		entryTable = new Entry[initialCapacity];
	}
	
	public void put(K key, V value) {
		if(key == null){
			throw new RuntimeException("null key not accepted");
		}
		
		int hashValue = hashValue(key);
		
		Entry<K, V> entry = new Entry<K, V>(key, value, null);
		
		if(entryTable[hashValue] == null){
			entryTable[hashValue] = entry;
		} else {
			Entry<K, V> prev = null;
			Entry<K, V> curr = entryTable[hashValue];
			while(curr != null){
				if(curr.k.equals(key)){
					if (prev == null) {
						entry.next = curr.next;
						entryTable[hashValue] = entry;
					} else {
						entry.next = curr.next;
						prev.next = entry;
					}
				}
				prev = curr;
				curr = curr.next;
			}
			prev.next = entry;
		}
	}
	
	public V get(K key){
		if(key == null){
			return null;
		}
		
		int hashValue = hashValue(key);
		
		if(entryTable[hashValue] == null){
			return null;
		} else {
			Entry<K, V> temp = entryTable[hashValue];
			while(temp != null){
				if(temp.k.equals(key)){
					return temp.v;
				}
				temp = temp.next;
			}
		}
		return null;
	}
	
	public boolean remove(K key){
		
		if(key == null){
			return false;
		}
		
		int hashValue = hashValue(key);
		if(entryTable[hashValue] == null){
			return false;
		} else {
			Entry<K, V> prev = null;
			Entry<K, V> curr = entryTable[hashValue];
			while(curr != null){
				if(curr.k.equals(key)){
					if(prev == null){
						entryTable[hashValue] = entryTable[hashValue].next;
						return true;
					} else {
						prev.next = curr.next;
						return true;
					}
				}
				prev = curr;
				curr = curr.next;
			}
			return false;
		}
	}
	
	public boolean containsKey(K key){
		
		int hashValue = hashValue(key);
		
		if(entryTable[hashValue] == null){
			return false;
		} else{
			Entry<K, V>entry = entryTable[hashValue];
			while(entry != null){
				if(entry.k.equals(key)){
					return true;
				}
				entry = entry.next;
			}
		}
		return false;
	}
	
	public int size(){
		int count = 0;
		
		for(int i = 0; i < entryTable.length; i++){
			if(entryTable[i] != null){
				int tempCount = 0;
				for(Entry<K, V> entry = entryTable[i]; entry.next != null; entry = entry.next){
					
					tempCount++;
				}
				
				count += tempCount;
				count++;
			}
		}
		
		return count;
	}
	
	private int hashValue(K key){
		return Math.abs(key.hashCode()) % initialCapacity;
	}
	
	private static class Entry<K, V>{
		private K k;
		private V v;
		private Entry<K, V> next;
		
		
		public Entry(K k, V v, Entry<K, V>next){
			this.k = k;
			this.v = v;
			this.next = next;
		}
	}
}
