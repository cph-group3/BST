package lindtner.BST;

import java.util.ArrayList;
import java.util.List;

public class mklBST
{
		private Node root;
		private int size, rightSide, leftSide;

		//todo: make rotation until tree is balanced for remove
				//also: make removebalance *__*
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
			}
			return minv;
		}

		private String maxValue(Node root) {
			String maxv = root.key;
			while(root.right != null) {
				maxv = root.right.key;
				root = root.right;
			}
			return maxv;
		}

		public int showLeftSide() {
			if(root.left != null)
				return countHeight(root.left, 0);
			return 0;
		}

		public int showRightSide() {
			if(root.right != null)
				return countHeight(root.right, 0);
			return 0;
		}

		private int countHeight(Node root, int level) {
			if(root.left != null && root.right == null) {
				level += 1;
				int number = countHeight(root.left, level);
				return Math.max(number, level);
			}
			else if(root.right != null && root.left == null) {
				level += 1;
				int number = countHeight(root.right, level);
				return Math.max(number, level);
			} else if(root.right != null && root.left != null) {
				level += 1;
				int numberLeft = countHeight(root.left, level);
				int numberRight = countHeight(root.right, level);
				int maxCur = Math.max(numberLeft, numberRight);
				return Math.max(maxCur, level);
			} else
				return level+1;
		}

		//only left or right rotation
		public void balance() {
			//always overwrites first node
			this.root = balanceLeftOrRightRotation(root);
		}

		private Node balanceLeftOrRightRotation(Node root) {
			//left rotation
			int diff = showLeftSide() - showRightSide();
			if(diff < -1) {
				//leftside
				return leftSideRotation(root);
			}
			if(diff > 1) {
				//rightside
				return rightSideRotation(root);
			}
			return null;
		}

		private Node rightSideRotation(Node root) {
			Node tmp = root;
			Node newRoot = root.left;
			tmp.left = null;
			newRoot.right = tmp;
			return newRoot;
		}

		private Node leftSideRotation(Node root) {
			Node tmp = root;
			Node newRoot = root.right;
			tmp.right = null;
			newRoot.left = tmp;
			return newRoot;
		}

		private Node leftRightRotation(Node root) {
			Node currentHead = root.left.right; //d
			Node leftRightValue = root.left; //c
			leftRightValue.right = null; //set c's right to null
			currentHead.left = leftRightValue; //alligned
			//copies rightsideRotation
			root.left = null;
			currentHead.right = root;
			return currentHead;
			//set  a to main root and remove main root to the left
		}

		public void fixRightLeftRotation() {
			this.root = rightLeftRotation(root);
		}

		public void fixLeftRightRotation() {
			this.root = leftRightRotation(root);
		}

		private Node rightLeftRotation(Node root) {
			Node currentHead = root.right.left;
			Node rightValue = root.right;
			root.right = currentHead;
			currentHead.right = rightValue;
			rightValue.left = null; //created left rotation
			//make left rotation
			root.right = null;
			currentHead.left = root;
			return currentHead;

		}

		public void balanceTree() {
			int eval = showLeftSide() - showRightSide();
			if(eval < - 1) {
				if(eval < -1 && root.right != null && root.right.left != null) {
					fixRightLeftRotation();
				} else
					this.root = leftSideRotation(root);
			}
			if(eval > 1) {
				if(eval > 1 && root.left != null && root.left.right != null) {
					fixLeftRightRotation();
				} else
					this.root = rightSideRotation(root);
			}
		}

		public boolean isTreeEven() {
			return (showLeftSide() - showRightSide() <= 1 && showLeftSide()-showRightSide() >= -1);
		}

		public void helpTreeNode() {
			showTreeNode(root, 0);
		}

		public void showTreeNode(Node root, int level) {
			if(root == null)
				return;
			level++;
			System.out.println("level is: " + level + "\troot is:" + root.key);
			showTreeNode(root.left, level);
			//keyList.add(root.key);
			showTreeNode(root.right, level);
		}

		@Override
		public String toString() {
			return "string: " + root.key +"\nvalue: " + root.value;
		}



}
