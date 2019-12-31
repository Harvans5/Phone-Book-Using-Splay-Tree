/**
 * Henry Arvans
 * This class better manages the splay tree, and calls to the methods of splaynode class 
 * for insertion, deletion, searching and the toString method
 * @author henryarvans
 */
public class PhoneBook{
    private SplayNode<FullName, PhoneNumber> root;
    public PhoneBook(){
    	
    }
    /**
     * This method creates a new node and then calls to the insert method in SplayNode class to 
     * properly insert the node into the tree this method is constant time O(1) with a 
     * call to insert which is amoritized O(log(n)) 
     * @param name, of the person that is being added to the tree
     * @param num, phone number of the person trying to be added to the tree
     */
    public void insert(FullName name, PhoneNumber num){
    	SplayNode <FullName, PhoneNumber> newNode = new SplayNode<FullName, PhoneNumber>(name,num); 
    	if(root == null) {
    		root = new SplayNode<FullName, PhoneNumber>(name,num);
    	} else {
    		root = root.insert(newNode);
    	}
    }
    /**
     * This method calls to the delete method and passes through the key
     * for the node that you want deleted 
     * Run time is constant time O(1) with a call to delete which is amortized O(log(n))
     * @param name, key of the node trying to be deleted
     */
    public void delete(FullName name){
    	root = root.delete(name);
    }
    /**
     * This method calls to the search method in the splay node class and passes 
     * through the key of the node you want to delete 
     * Run time is constant time O(1) with a call to search which is amoritized O(log(n))
     * @param name, key for the node that is being searched for
     * @return the phone number of the new root of the tree
     */
    public PhoneNumber search(FullName name){
    	root = root.search(name);
    	return root.getData();
    }
    /**
     * This method simply calls to the toString method in splay node and returns it
     * Run time is constant time O(1) with a call to toString which uses inOrder traversal 
     * which is O(n)
     */
    public String toString(){
    	return root.toString();
    }
}

