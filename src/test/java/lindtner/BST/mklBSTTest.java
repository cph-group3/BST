package lindtner.BST;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class mklBSTTest
{

	@Test
	public void getAndPut()
	{
		mklBST bst = new mklBST();
		bst.put("Betason", new Address("betaland123"));
		bst.put("Christensen", new Address("christland123"));
		bst.put("Andersen", new Address("lalaland123"));
		bst.put("APMoller", new Address("mollerland123"));
		String actual = bst.get("APMoller").toString();
		String expected = "mollerland123";
		assertEquals(expected, actual);
	}

	@Test
	public void containsKey() {
		mklBST bst = new mklBST();
		bst.put("Betason", new Address("betaland123"));
		boolean expected = true;
		boolean actual = bst.containsKey("Betason");
		assertEquals(expected, actual);
	}


	@Test
	public void showKeysUnbalancedRight() {
		mklBST bst = new mklBST();
		bst.put("Betason", new Address("betaland123"));
		bst.put("Christensen", new Address("christland123"));
		bst.put("Andersen", new Address("lalaland123"));
		bst.put("APMoller", new Address("mollerland123"));
		ArrayList<String> expected = new ArrayList<>();
		expected.add("Andersen");
		expected.add("APMoller");
		expected.add("Betason");
		expected.add("Christensen");
		List<String> result = bst.listOfKeys();
		//System.out.println(bst.returnKeys());
		assertEquals(expected, result); // figure out how to represent properly
	}

	@Test
	public void removeNullUnderneath()
	{
		mklBST bst = new mklBST();
		bst.put("Betason", new Address("betaland123"));
		bst.put("Christensen", new Address("christland123"));
		bst.put("Andersen", new Address("lalaland123"));
		bst.put("APMoller", new Address("mollerland123"));
		boolean result = bst.removeNode("APMoller");
		boolean expected = true;
		assertEquals(expected, result);
		//Node result = new Node("APMoller", new Address("mollerland123"));
		//assertEquals(expected, result);
		//assertNull(bst.get("APMoller"));
	}
/*
	@Test
	public void showKeys() {
		mklBST bst = new mklBST();
		bst.put("Betason", new Address("betaland123"));
		bst.put("Christensen", new Address("christland123"));
		bst.put("Andersen", new Address("lalaland123"));
		bst.put("APMoller", new Address("mollerland123"));
		bst.put("AAbsen", new Address("absenland123"));
		//Collection<String> keys = bst.showKeys();
		System.out.println(bst.showKeys());
	}

	@Test
	public void showKeysUnbalancedLeft() {
		mklBST bst = new mklBST();
		bst.put("Betason", new Address("betaland123"));
		bst.put("Christensen", new Address("christland123"));
		bst.put("Andersen", new Address("lalaland123"));
		bst.put("AAbsen", new Address("absenland123"));
		System.out.println(bst.showKeys());
	}


	@Test
	public void showKeysList() {
		mklBST bst = new mklBST();
		bst.put("Betason", new Address("betaland123"));
		bst.put("Christensen", new Address("christland123"));
		bst.put("Andersen", new Address("lalaland123"));
		bst.put("AAbsen", new Address("absenland123"));
		//Collection<String> keys = bst.showKeys();
		System.out.println(bst.returnKeys());
	} */
}