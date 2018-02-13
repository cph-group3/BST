package lindtner.BST;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Node
{
	String key;
	Address value;
	Node left;
	Node right;
	//Node parent;

	Node( String key, Address value ) {
		this.key = key;
		this.value = value;
	}

	public Address get(Object key)
	{
		String reqItem = key.toString();
		switch( Integer.signum(reqItem.compareToIgnoreCase(this.key))) {
			case -1:
				//go left
				if(left == null)
					return null;
				return left.get(key);
			case 0:
				if(this.key.equals(key)) {
					return value;
				}
			case 1:
				if(right == null)
					return null;
				return right.get(key);
		}
		//wrong exception
		throw new IllegalStateException("This should not happend wops");
	}
/*
	public boolean remove(String key, Node parent) {
		int result = Integer.signum(key.compareToIgnoreCase(this.key));
		if(result < 0) {
			if(left != null)
				return remove(key, this);
			else
				return false;
		}
		if(this.key.compareTo(key) < 0) {
			if(right != null)
				return remove(key, this);
			else
				return false;
		}
		if(key.compareTo(this.key) == 0) {
			if(left != null && right != null) {

			}

			if(parent.left == this) {
				parent.left = (left != null) ? left : right;
			}
			if(parent.right == this) {
				parent.right = (right != null) ? right : left;
			}
			return true;
		}
		System.out.println("fck");
		return false;
	} */

	public String minValue() {
		return " ";
	}

	public String returnKey() {
		return (left != null ? left.returnKey() : " ") + (key) + (right != null ? right.returnKey() : " ");
	}

		/*	if(left != null && right != null) {
			return left.returnKey() + key + " " + right.returnKey();
		}

		if(left == null & right != null) {
			return key + " " + right.returnKey();
		}

		if(left != null && right == null) {
			return left.returnKey() + key + " " ;
		}

		if(left == null && right == null) {
			return key + " ";
		}
		return "";
		//return "madeitHere";

	}*/

	@Override
	public String toString() {
		return "key," + key;
	}

		/*}

	} */
}
