import lindtner.hashMap.MklHashMap;
import org.junit.Test;

import static org.junit.Assert.*;

public class MklHashMapTest
{
	@Test
	public void get()
	{
		MklHashMap<String, Integer> hashMap = new MklHashMap(4);
		hashMap.put("Donald", 2);
		int result = hashMap.get("Donald");
		int expected = 2;
		assertEquals(expected, result); //check normal get
		hashMap.put("Jensen", 3);

	}

	@Test
	public void putResult()
	{
		MklHashMap<String, Integer> hashMap = new MklHashMap(4);
		hashMap.put("Donald", 2);
		int result = hashMap.put("Donald", 3);
		int expected = 3;
		assertEquals(expected, result);
	}

	@Test
	public void containsKey()
	{
		MklHashMap<Integer, Integer> hashMap = new MklHashMap<>(4);
		hashMap.put(1,1);
		hashMap.put(2, 1);
		boolean result = hashMap.containsKey(1);
		boolean expected = true;
		assertEquals(expected, result); //check true
		boolean resultNegative = hashMap.containsKey(3);
		boolean expectedNegative = false;
		assertEquals(expectedNegative, resultNegative);
	}

/*
	@Test
	public void isEmpty()
	{
	}


	@Test
	public void containsValue()
	{
	}



	@Test
	public void put()
	{
	}

	@Test
	public void expand()
	{
	}*/
}