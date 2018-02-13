package lindtner.hashMap;

import com.sun.org.apache.xml.internal.security.utils.UnsyncBufferedOutputStream;

import java.util.*;

//todo: refactor method, make index method, make remove method

public class MklHashMap<K, V> implements Map<K, V>
{
	private static final int START_CAPACITY = 10;
	private static final double LOAD_FACTOR = 0.75;
	private int capacity, available;
	private Pair<K, V>[] array;

	public MklHashMap(int capacity) {
		this.capacity = capacity;
		array = (Pair<K, V>[]) new Pair[capacity];
	}

	public static class Pair<K, V> {
		private final K key;
		private V value;
		private final int hash;

		public Pair(K key, V value, int hash) {
			this.key = key;
			this.value = value;
			this.hash = hash;
		}

		public K getKey()
		{
			return this.key;
		}

		public V getValue()
		{
			return this.value;
		}

		public V setValue(V value) {
			V old = this.value;
			this.value = value;
			return old;
		}
	}

	@Override public int size()
	{
		return available;
	}

	@Override public boolean isEmpty()
	{
		if(available == 0)
			return true;
		return false;
	}

	@Override public boolean containsKey(Object o)
	{
		int solutionIndex = Math.abs(o.hashCode()) % array.length;
		int counter = 0;
		while(counter++ < array.length) {
			if(array[solutionIndex] != null) {
				Pair candidate = array[solutionIndex];
				//use equals here instead?
				if (candidate.key == o && candidate.hash == solutionIndex)
					return true;
			}
			solutionIndex = (solutionIndex < array.length - 1) ? solutionIndex + 1 : 0;
		}
		return false;

	}

	@Override public boolean containsValue(Object o)
	{
		return false;
	}

	//this is important to learn
	public int findIndex(String key) {
		int hashCode = key.hashCode() % array.length;
		throw new UnsupportedOperationException();
	}

	@Override public V get(Object o)
	{
		int searchHash = o.hashCode();
		int searchIndex = Math.abs(searchHash) % array.length;
		int currentIndex = searchIndex;
		int counter = 0;
		Pair<K, V> current = array[searchIndex];

		if(current == null)
			return null;
		//V value = current.value;
		while(counter++ < array.length) //handle collision
		{
			if(array[currentIndex] != null) {
				Pair<K, V> compare = array[currentIndex];
				if(compare.hash == searchHash && current.key == compare.key)
					return compare.value;
			}
			currentIndex = (currentIndex < array.length-1) ? currentIndex + 1 : 0;
		}
		return null; //throwillegalstateexception

	}

	@Override public V put(K k, V v)
	{
		int hashCode = k.hashCode();
		int indexNumber = Math.abs(hashCode) % array.length;
		int counter = 0;
		int currentIndex = indexNumber;
		Pair<K ,V> insertPair = new Pair(k, v, hashCode);

		if(k == null)
			return null;
		while(counter++ < array.length) {
			if(array[currentIndex] == null) {
				array[currentIndex] = insertPair;
				available++;
				expand();
				return insertPair.value;
			}
			if(insertPair.hash == array[currentIndex].hash && (k.equals(array[currentIndex].key)))
			{
				V prevVal = array[currentIndex].value;
				array[counter].setValue(insertPair.value);
				//return prevVal.value() <-- why can't it ?
				return prevVal;
			}

			currentIndex = (currentIndex < array.length-1) ? currentIndex + 1 : 0;
		}
		//should never happend
		return null;
	}

	public void expand() {
		//need new modulos
		if(array.length * 0.75 < available)
			array = Arrays.copyOfRange(array, 0, array.length * 2);
	}

	@Override public V remove(Object o)
	{
		return null;
	}

	@Override public void putAll(Map<? extends K, ? extends V> map)
	{

	}

	@Override public void clear()
	{

	}

	@Override public Set<K> keySet()
	{
		return null;
	}

	@Override public Collection<V> values()
	{
		List<V> listOfValues = new ArrayList();
		for(int i = 0; i < array.length; i++) {
			if(array[i] != null)
				listOfValues.add(array[i].value);
		}
		return listOfValues;
	}

	@Override public Set<Entry<K, V>> entrySet()
	{
		return null;
	}

	//test methods
	public void printAll() {
		for(Pair p: array)
			System.out.println(p);
	}
}
