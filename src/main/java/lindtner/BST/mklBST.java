package lindtner.BST;

import java.util.ArrayList;
import java.util.List;

public class mklBST
{
		private Node root;
		private int size, rightSide, leftSide;

		public boolean containsKey( Object key ) {
			return root.get(key) != null;
		}

		public Address get( String key ) {
			return root.get(key);
		}

		public void put( String key, Address value ) {
			if (root == null)
				root = new Node(key, value);
			else
				insert(key, value, root);
		}

		public int size() {
			return size;
		}

		private void insert( String key, Address value, Node node ) {
			switch ( Integer.signum( key.compareToIgnoreCase( node.key ) ) ) {
				case -1:
					if ( node.left == null ) {
						node.left = new Node( key, value );
					} else {
						insert( key, value, node.left );
						size++;					}
					break;
				case 0:
					node.value = value;
					break;
				case 1:
					if ( node.right == null ) {
						node.right = new Node( key, value );
					} else {
						insert( key, value, node.right );
						size++;
					}
					break;
			}
		}

		public List<String> listOfKeys() {
			List<String> keyList = new ArrayList<>();
			listOfKeys(keyList, root);
			return keyList;
		}

		private void listOfKeys(List<String> keyList, Node root) {
			if(root == null)
				return;
			listOfKeys(keyList, root.left);
			keyList.add(root.key);
			listOfKeys(keyList, root.right);
		}

		public boolean removeNode(String key) {
			return (deleteNode(key,root) != null) ? true : false;
		}

		//fix return root ?
		private Node deleteNode(String key, Node root) {
			if(root == null)
				return null;
			if(key.compareToIgnoreCase(root.key) < 0) {
				root.left = deleteNode(key, root.left);
			} else if(key.compareToIgnoreCase(root.key) > 0) {
				root.right  = deleteNode(key, root.right);
			} else {
				if(root.left == null) {
					return root.right;
				}
				else if(root.right == null)
					return root.left;
				root.key = minValue(root.right);
				root.right = deleteNode(root.key, root.right);
			}
			//returns root value
			return root;
		}

		private String minValue(Node root) {
			String minv = root.key;
			while(root.left != null) {
				minv = root.left.key;
				root = root.left;
				leftSide++;
			}
			return minv;
		}

		private String maxValue(Node root) {
			String maxv = root.key;
			while(root.right != null) {
				maxv = root.right.key;
				root = root.right;
				rightSide++;
			}
			return maxv;
		}

		public boolean balanceTree() {
		}



		@Override
		public String toString() {
			return "string: " + root.key +"\nvalue: " + root.value;
		}

}
