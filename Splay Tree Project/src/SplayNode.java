/**
 * Henry Arvans
 * This class is for splay nodes with fields for its data and key and also pointers 
 * to a parent, left and right child. Splay is a type of self adjusting binary tree which tries to keep 
 * insertion, deletion and search to an amoritized run time of O(log(n)) by always splaying nodes that are 
 * inserted, deleted, or searched for to the root of the tree so that it would be very unlikely to get an issue of 
 * a totally off balanced tree causing a linear time operation. The data types for these nodes are for the phone number as the data stored in the 
 * node and the key as the name of the person with the smallest being a and largest being z for sorting 
 * @author henryarvans
 *
 * @param <KeyType> field type for the node which holds the persons first and last name and is the key for that node
 * @param <DataType> field type for the node which holds the persons phone number and is the data for that node
 */
public class SplayNode<KeyType extends Comparable<KeyType>, DataType> {
	private DataType data;
	private KeyType key;
	private SplayNode<KeyType, DataType> parent;
	private SplayNode<KeyType, DataType> leftChild;
	private SplayNode<KeyType, DataType> rightChild;
	/**
	 * Constructor for a node in the splay tree 
	 * Creates a node with value types of key and data passed in 
	 * and sets left and right child to null and parent to null
	 * @param key, name of the person for a node
	 * @param data, phone number associated with that person
	 */
	public SplayNode(KeyType key, DataType data) {
		this.data = data;
		this.key = key;
		this.leftChild = null;
		this.rightChild = null;
		this.parent = null;

	}
	/**
	 * Returns the data field for a node
	 * Constant time operation O(1)
	 * @return the data for a node
	 */
	public DataType getData() {
		return data;
	}
	/**
	 * The search method traverses through the binary tree and once it finds the correct value it 
	 * splays that value to the root of the tree, and if the value isnt found it takes the closest value
	 * to the one searched for and splays that node instead
	 * Search has an amoritized run time of O(log(n)) depending on the height of the tree 
	 * @param value, key type for the node you are searching for
	 * @return the new root of the tree after search
	 */
	public SplayNode<KeyType, DataType> search(KeyType value) {
		if(key.equals(value)) {
			this.splay();
			return this;
		} 
		if(value.compareTo(this.key) < 0) {
			if(this.leftChild == null) {
				this.splay();
				return this;
			}
			return this.leftChild.search(value);
		} else {
			if(this.rightChild == null) {
				this.splay();
				return this;
			}
			return this.rightChild.search(value);
		}
	}
	/**
	 * Traverses through the tree and checks to see if the key you are searching for is in that tree
	 * and returns true or false accordingly 
	 * Run time is amoritized run time O(log(n)) depending on the height of the tree
	 * @param key that you are checking if it is in the tree
	 * @return wether or not the key you are searching for is in the tree
	 */
	public boolean contains(KeyType key) {
	    if(this.key.compareTo(key) == 0) {
	    	return true;
	    }
	    if(this.key.compareTo(key) > 0) {
	    	if(this.leftChild != null) {
	    		this.leftChild.contains(key);
	    	}
	    }
	    if(this.key.compareTo(key) < 0) {
	    	if(this.rightChild != null) {
	    		this.rightChild.contains(key);
	    	}
	    }
	    return false;
	}
	/**
	 * Takes in a node as a param and then traverses the tree until it finds where it should be inserted properly 
	 * and then splays the inserted node to the root of the tree
	 * Run time of this method is amortized O(log(n)) with a call to splay which is O(h) 
	 * @param newNode that is trying to be inserted to the tree
	 * @return the new root of the tree
	 */
	public SplayNode<KeyType, DataType> insert(SplayNode<KeyType, DataType> newNode) {
		SplayNode <KeyType, DataType> current = this;
		SplayNode<KeyType, DataType> x = null;
		if(this.contains(newNode.key)) {
			current = search(newNode.key);
			current.data = newNode.data;
			return current;
		}
		while(current != null) {
			x = current;
			if(newNode.key.compareTo(current.key) < 0) {
				current = current.leftChild;
			} else {
				current = current.rightChild;
			}
		}
		newNode.parent = x;
		if(x != null) {
			if(x.key.compareTo(newNode.key) > 0) {
				x.leftChild = newNode;
			} else {
				x.rightChild = newNode;
			}
		}
		newNode.splay();
		return newNode;
	}
	/**
	 * This method utilizes the search method and searches for the element that is trying to be 
	 * deleted it then checks if the value set to search is the value that is trying to be deleted 
	 * since search may not find it and return the next closest value if the one you are trying to delete isnt found
	 * if the value you are trying to delete was found then you check if the tree has a left subtree 
	 * if it doesnt then you would just set the right subtrees parent equal to null otherwise 
	 * you traverse the left subtree finding the largest value in it and splay that value to the top of the left subtree 
	 * and then connect the right subtrees parent as the right child of the left subtree
	 * Method has a run time of amoritized O(log(n)) with a call to splay which is O(h)
	 * @param oldVal, key for the value trying to be deleted
	 * @return the new root of the tree
	 */
	public SplayNode<KeyType, DataType> delete(KeyType oldVal) {
		SplayNode<KeyType, DataType> temp = search(oldVal);
		SplayNode<KeyType, DataType> left = temp.leftChild;
		SplayNode<KeyType, DataType> right = temp.rightChild;
		if(temp.key.equals(oldVal)) {
			if(left == null) {
				right.parent = null;
				return right;
			} else {
				left.parent = null;
				SplayNode<KeyType, DataType> maxLeft = left;
				while(maxLeft.rightChild != null){
					maxLeft = left.rightChild;
				}
				maxLeft.splay();
				if(right != null) {
					right.parent = maxLeft;
					maxLeft.rightChild = right;
				}
				return maxLeft; 
			}
		}
		return temp;
	}

	/**
	 * This method will keep calling to left and right rotation until the node being splayed 
	 * is the root of the tree 
	 * The run time for this method is O(h) because it depends on the height of the tree 
	 */
	private void splay() {
		while(this.parent != null) {
			if(this.parent.leftChild == this) {
				this.parent.rightRotation();
			} else {
				this.parent.leftRotation();
			}
		}
	}
	/**
	 * This method calls to the inOrder traversal method and passes the root and the string result
	 * and also passes true for boolean value because inside the inOrder traversal it should be working for both 
	 * this toString and treeString so inOrder needs to know which type of string should be returned
	 * Constant time with a call to inOrder which is linear O(n)
	 * @return the string created for toString
	 */
	public String toString() {
		String result = "";
		SplayNode<KeyType, DataType> root = findRoot();
		result =root.inOrder(result, true);
		return result;
	}
	/**
	 * This method calls to inOrder traversal and passes false so inOrder knows 
	 * which type of string it should be creating with the inOrder traversal
	 * Constant time with a call to inOrder which is linear O(n)
	 * @return the string created for treeString
	 */
	public String treeString() {
		String result = "";
		SplayNode<KeyType, DataType> root = findRoot();
		result = root.inOrder(result, false);
		return result;
	}
	/**
	 * This method traverses the tree using inOrder and does so recursivly
	 * Based on which type of string the client is trying to print has two different types of 
	 * traversal based on the boolean passed in from the toString methods
	 * Has an O(h) run time with h being the trees height
	 * @param result string that needs to be created
	 * @param type, boolean that determines which string to return 
	 * @return string for either tree or string
	 */
	public String inOrder(String result, boolean type) {
			if(type == false) {
				result = result + "(";
			}
			if(this.leftChild != null) {
				result = this.leftChild.inOrder(result,type);
			}
			if(type == true) {
				result = result + key.toString() + ":" + data.toString() + "\n";
			} else {
				result = result + key.toString();
			}
			if(this.rightChild != null) {
				result = this.rightChild.inOrder(result,type);
			}
			if(type == false) {
				result = result + ")";
			}
			return result;
	}
	
	/**
	 * This method is just used to traverse up the tree and find the root of the tree
	 * and returns the root used for the toString methods
	 * Run time of this method is O(h) depending on the height of the tree
	 * @return the root
	 */
	public SplayNode<KeyType, DataType> findRoot(){
		SplayNode <KeyType, DataType> root = this;
		while(this.parent!= null) {
			 root = this.parent;
		}
		return root;
	}
	/**
	 * This method is called on by splay and preforms a right rotation
	 * and is called by the parent of the node that you are trying to splay 
	 * to that position 
	 * This operation is constant time O(1)
	 */
	public void rightRotation() {
		SplayNode<KeyType, DataType> temp = this.leftChild;
		this.leftChild = temp.rightChild;
		if(temp.rightChild != null) {
			temp.rightChild.parent = this;
		}
		temp.parent = this.parent;
		if(this.parent == null) {
			
		}else if(this == this.parent.rightChild) {
			this.parent.rightChild = temp;
		} else {
			this.parent.leftChild = temp;
		}
		temp.rightChild = this;
		this.parent = temp;
	}
	/**
	 * This method is called on by splay and preforms a left rotation
	 * and is called by the parent of the node that you are trying to splay 
	 * to that position 
	 * This operation is constant time O(1)
	 */
	public void leftRotation() {
		SplayNode<KeyType, DataType> temp = this.rightChild;
		this.rightChild = temp.leftChild;
		if(temp.leftChild != null) {
			temp.leftChild.parent = this;
		}
		temp.parent = this.parent;
		if(this.parent == null) {

		}else if(this == this.parent.leftChild) {
			this.parent.leftChild = temp;
		} else {
			this.parent.rightChild = temp;
		}
		temp.leftChild = this;
		this.parent = temp;
	}
}

