import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * Henry Arvans
 * harvans5@brandeis.edu
 * 3/28/2019
 * This JUnit is used for testing the splay node class and runs multiple tests. 
 * Tests included testing the insert, delete, contains, get data, search, toString and treeString.
 * Also indirectly tests the functionality of splay and left and right rotation and inOrder traversal 
 * @author henryarvans
 *
 */
class SplayNodeTest {

	@Test
	void getDataTest() {
		FullName henryName = new FullName("Henry", "Arvans");
		PhoneNumber num1 = new PhoneNumber(1031103127);
		SplayNode<FullName, PhoneNumber> henry= new SplayNode<FullName, PhoneNumber>(henryName,num1);
		SplayNode<FullName, PhoneNumber> root = henry;
		assertEquals(num1, root.getData());
	}

	@Test
	void searchTest() {
		FullName henryName = new FullName("Henry", "Arvans");
		FullName testName = new FullName("Nathan", "Wilnai");
		FullName testName3 = new FullName("Charlie", "Smith");
		FullName testName2 = new FullName("Bob", "Tmith");
		PhoneNumber num1 = new PhoneNumber(1031103127);
		PhoneNumber num2 = new PhoneNumber(1516713604);
		PhoneNumber num3 = new PhoneNumber(1033345689);
		SplayNode<FullName, PhoneNumber> henry= new SplayNode<FullName, PhoneNumber>(henryName,num1);
		SplayNode<FullName, PhoneNumber> nathan = new SplayNode<FullName, PhoneNumber>(testName,num2);
		SplayNode<FullName, PhoneNumber> charlie = new SplayNode<FullName, PhoneNumber>(testName3,num3);
		SplayNode<FullName, PhoneNumber> root = nathan;
		root = root.insert(henry);
		root = root.insert(charlie);
		root = root.search(testName);
		assertEquals(num2,root.getData());
		root = root.search(testName2);
		assertEquals(num3,root.getData());
	}

	@Test
	void containsTest() {
		FullName henryName = new FullName("Henry", "Arvans");
		FullName testName = new FullName("Nathan", "Wilnai");
		FullName testName2 = new FullName("Bob", "Smith");
		PhoneNumber num1 = new PhoneNumber(1031103127);
		PhoneNumber num2 = new PhoneNumber(1516713604);
		SplayNode<FullName, PhoneNumber> henry= new SplayNode<FullName, PhoneNumber>(henryName,num1);
		SplayNode<FullName, PhoneNumber> nathan = new SplayNode<FullName, PhoneNumber>(testName,num2);
		SplayNode<FullName, PhoneNumber> root = nathan;
		root = root.insert(henry);
		assertEquals(true, root.contains(henryName));
		assertEquals(false, root.contains(testName2));
	}

	@Test
	void insertTest() {
		FullName henryName = new FullName("Henry", "Arvans");
		FullName testName = new FullName("Nathan", "Wilnai");
		PhoneNumber num1 = new PhoneNumber(1031103127);
		PhoneNumber num2 = new PhoneNumber(1516713604);
		SplayNode<FullName, PhoneNumber> henry= new SplayNode<FullName, PhoneNumber>(henryName,num1);
		SplayNode<FullName, PhoneNumber> nathan = new SplayNode<FullName, PhoneNumber>(testName,num2);
		SplayNode<FullName, PhoneNumber> root = nathan;
		assertEquals(henry, root.insert(henry));
	}

	@Test
	void deleteTest() {
		FullName henryName = new FullName("Henry", "Arvans");
		FullName nathanName = new FullName("Nathan", "Wilnai");
		PhoneNumber num1 = new PhoneNumber(1031103127);
		PhoneNumber num2 = new PhoneNumber(1516713604);
		SplayNode<FullName, PhoneNumber> henry= new SplayNode<FullName, PhoneNumber>(henryName,num1);
		SplayNode<FullName, PhoneNumber> nathan = new SplayNode<FullName, PhoneNumber>(nathanName,num2);
		SplayNode<FullName, PhoneNumber> root = henry;
		root = root.insert(nathan);
		assertEquals(nathan, root.delete(henryName));
		root.delete(henryName);
	}

	@Test
	void toStringTest() {
		FullName henryName = new FullName("Henry", "Arvans");
		FullName nathanName = new FullName("Nathan", "Wilnai");
		PhoneNumber num1 = new PhoneNumber(1031103127);
		PhoneNumber num2 = new PhoneNumber(1516713604);
		SplayNode<FullName, PhoneNumber> henry= new SplayNode<FullName, PhoneNumber>(henryName,num1);
		SplayNode<FullName, PhoneNumber> nathan = new SplayNode<FullName, PhoneNumber>(nathanName,num2);
		SplayNode<FullName, PhoneNumber> root = henry;
		root = root.insert(nathan);
		assertEquals(henryName.toString() + ":" + num1.toString() + "\n" +nathanName.toString() + ":" + num2.toString() + "\n", root.toString());
		root = root.delete(henryName);
		assertEquals(nathanName.toString() + ":" + num2.toString() + "\n", root.toString());
	}

	@Test
	void treeStringTest() {
		FullName henry = new FullName("Henry", "Arvans");
		FullName charlie = new FullName("Charlie", "Smith");
		FullName olivia = new FullName("Olivia", "Tmith");
		PhoneNumber num1 = new PhoneNumber("6313672127");
		PhoneNumber num2 = new PhoneNumber("5167136049");
		PhoneNumber num3 = new PhoneNumber("4568907342");
		SplayNode<FullName, PhoneNumber> h = new SplayNode<FullName, PhoneNumber>(henry, num1);
		SplayNode<FullName, PhoneNumber> c = new SplayNode<FullName, PhoneNumber>(charlie, num2);
		SplayNode<FullName, PhoneNumber> o = new SplayNode<FullName, PhoneNumber>(olivia, num3);
		SplayNode<FullName, PhoneNumber> root = h;
		root = root.insert(c);
		assertEquals("((Arvans, Henry)Smith, Charlie)", root.treeString());
		root = root.insert(o);
		assertEquals("(((Arvans, Henry)Smith, Charlie)Tmith, Olivia)", root.treeString());
		root = root.search(charlie);
		assertEquals("((Arvans, Henry)Smith, Charlie(Tmith, Olivia))", root.treeString());
		root = root.delete(henry);
		assertEquals("(Smith, Charlie(Tmith, Olivia))", root.treeString());
	}

}
