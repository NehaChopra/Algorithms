package designPattern.HashMapImplementation;

import java.util.ArrayList;
import java.util.List;

public class HashMap {
	
	private List<EntryKey> entryKeys;
	
	static class EntryKey{
		public Object key;
		public Object value;
		
		public EntryKey(Object key, Object value) {
			this.key = key;
			this.value = value;
		}
	}
	
	public HashMap() {
		entryKeys = new ArrayList<EntryKey>();
	}
	
	public void put(Object key, Object value) {
		EntryKey obj = new EntryKey(key, value);
		for(int index=0; index<entryKeys.size(); index++) {
			Object preKey = entryKeys.get(index).key;
			
			if(preKey.equals(key)) {
				entryKeys.remove(index);
			}
		}
		entryKeys.add(obj);
	}
	
	public Object get(Object key) {
		for(int index=0; index<entryKeys.size(); index++) {
			Object preKey = entryKeys.get(index).key;
			
			if(preKey.equals(key)) {
				return entryKeys.get(index).value;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("3", "3");
		map.put("4", "4");
		
		System.out.println(map.get("4"));
		System.out.println(map.get("3"));
	}
}
