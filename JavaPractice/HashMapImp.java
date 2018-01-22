package JavaPractice;

class HashMapImp {
	private static int size = 16;
	private Entry[] table = new Entry[size];
	static class Entry<K,V>{
		String key;
		String value;
		Entry<K,V> next;
		Entry(String key, String value){
			this.key = key;
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public String getKey() {
			return key;
		}
	}
	
	public void put(String k, String v){
		int index_cal = k.hashCode() % size;
		
	}
	
	public Entry get(String k){
		return table[0];
	}
	
}
