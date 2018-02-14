package lindtner.BST;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class mklBSTTest
{

	@Before
	public void mklBSTTest() {
		mklBST bst = new mklBST();
	}

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

	@Test
	public void moveTree() {
		mklBST bst = new mklBST();
		bst.put("f", new Address("f123"));
		bst.put("e", new Address("e123"));
		bst.put("b", new Address("b123"));
		bst.put("c", new Address("c123"));
		bst.put("d", new Address("d123"));
		int result = bst.showLeftSide();
		System.out.println("result: " + result);
	}

	@Test
	public void testTreeCountTwoNotes()
	{
		mklBST bst = new mklBST();
		bst.put("e", new Address("e123"));
		bst.put("b", new Address("b123"));
		bst.put("a", new Address("a123"));
		bst.put("c", new Address("c123"));
		bst.put("d", new Address("d123"));
		bst.put("j", new Address("j123"));
		System.out.println("result rightside: " + bst.showRightSide());
		System.out.println("result leftside: " + bst.showLeftSide());
	}

	@Test
	public void testTreeNodesRotationLeft() {
		mklBST bst = new mklBST();
		bst.put("b", new Address("a123"));
		bst.put("a", new Address("b123"));
		bst.put("f", new Address("c123"));
		bst.put("g", new Address("d123"));
		bst.helpTreeNode();
		bst.balanceTree();
		//bst.balance();
		System.out.println("------");
		bst.helpTreeNode();
	}

	@Test
	public void testTreeNodesRotationRight() {
		mklBST bst = new mklBST();
		bst.put("d", new Address("a123"));
		bst.put("c", new Address("b123"));
		bst.put("b", new Address("b123"));
		bst.helpTreeNode();
		bst.balanceTree();
		//bst.balance();
		System.out.println("------");
		bst.helpTreeNode();
	}

	@Test
	public void testTreeLeftRightRotation() {
		mklBST bst = new mklBST();
		bst.put("e", new Address("e123"));
		bst.put("c", new Address("c123"));
		bst.put("d", new Address("d123"));
		bst.helpTreeNode();
		System.out.println("-----");
		bst.balanceTree();
		bst.helpTreeNode();
	}

	@Test
	public void testTreeRightLeftRotation() {
		mklBST bst = new mklBST();
		bst.put("a", new Address("e123"));
		bst.put("d", new Address("c123"));
		bst.put("c", new Address("d123"));
		bst.helpTreeNode();
		System.out.println("----");
		bst.balanceTree();
		bst.helpTreeNode();
	}

	@Test
	public void testTreeRotations() {
		mklBST bst = new mklBST();
		bst.put("b", new Address("b123"));
		bst.put("d", new Address("c123"));
		bst.put("c", new Address("d123"));
		bst.put("a", new Address("a123"));
		bst.put("e", new Address("a123"));
		bst.put("f", new Address("a123"));
		System.out.println(bst.isTreeEven());
		bst.helpTreeNode();
		System.out.println("----");
		bst.fixRightLeftRotation();
		bst.helpTreeNode();
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