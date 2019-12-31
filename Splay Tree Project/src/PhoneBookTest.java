import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * Henry Arvans
 * harvans5@brandeis.edu
 * 3/28/2019
 * This JUnit tests the functionality of the phonebook class 
 * Tests all of its methods, insert, delete, search, and toString
 * Also indireclty tests the functionality of the methods in splay node such as 
 * right and left rotation, splay and inOrder traversal
 * @author henryarvans
 *
 */

class PhoneBookTest {

	@Test
	public void insertTest() {
		PhoneBook p = new PhoneBook();
		FullName henry = new FullName("Henry", "Arvans");
		FullName charlie = new FullName("Charlie", "Smith");
		FullName olivia = new FullName("Olivia", "Tmith");
		PhoneNumber num1 = new PhoneNumber("6313672127");
		PhoneNumber num2 = new PhoneNumber("5166142789");
		PhoneNumber num3 = new PhoneNumber("7813456721");
		
		p.insert(henry, num1);
		p.insert(charlie, num2);
		p.insert(olivia, num3);
		
		assertEquals(henry.toString() + ":" + num1.toString() + "\n" + charlie.toString() + ":" + num2.toString() + "\n" + olivia.toString() + ":" + num3.toString() + "\n", p.toString());
		
	}
	
	@Test
	public void deleteTest(){
		PhoneBook p = new PhoneBook();
		FullName henry = new FullName("Henry", "Arvans");
		FullName charlie = new FullName("Charlie", "Smith");
		FullName olivia = new FullName("Olivia", "Tmith");
		PhoneNumber num1 = new PhoneNumber("6313672127");
		PhoneNumber num2 = new PhoneNumber("5166142789");
		PhoneNumber num3 = new PhoneNumber("7813456721");
		
		FullName test = new FullName("Bob", "Smith");
		
		p.insert(henry, num1);
		p.insert(charlie, num2);
		p.insert(olivia, num3);
		
		assertEquals(henry.toString() + ":" + num1.toString() + "\n" + charlie.toString() + ":" + num2.toString() + "\n" + olivia.toString() + ":" + num3.toString() + "\n", p.toString());
		p.delete(henry);
		assertEquals(charlie.toString() + ":" + num2.toString() + "\n" + olivia.toString() + ":" + num3.toString() + "\n", p.toString());
		p.delete(test);
		assertEquals(charlie.toString() + ":" + num2.toString() + "\n" + olivia.toString() + ":" + num3.toString() + "\n", p.toString());
	}
	
	@Test
	public void searchTest(){
		PhoneBook p = new PhoneBook();
		FullName henry = new FullName("Henry", "Arvans");
		FullName charlie = new FullName("Charlie", "Smith");
		FullName olivia = new FullName("Olivia", "Tmith");
		PhoneNumber num1 = new PhoneNumber("6313672127");
		PhoneNumber num2 = new PhoneNumber("5166142789");
		PhoneNumber num3 = new PhoneNumber("7813456721");
		
		FullName test = new FullName("Bob", "Smith");
		
		p.insert(henry, num1);
		p.insert(charlie, num2);
		p.insert(olivia, num3);
		
		assertEquals(num2,p.search(charlie));
		assertEquals(num1, p.search(henry));
		
		assertEquals(num2, p.search(test));
	}
	
	@Test
	public void phonebookTest(){
		PhoneBook p = new PhoneBook();
		FullName charlie = new FullName("Charlie", "Smith");
		FullName  abigal = new FullName("Abigal", "Smith");
		FullName  gordon = new FullName("Gordon", "Smith");
		FullName  dana = new FullName("Dana", "Smith");
		FullName  bob = new FullName("Bob", "Smith");
		FullName  frankie = new FullName("Frankie", "Smith");
		FullName  harold = new FullName("Harold", "Smith");
		FullName  engelbert = new FullName("Engelbert", "Smith");
		PhoneNumber numC = new PhoneNumber("5555555555");
		PhoneNumber numA = new PhoneNumber("5555555556");
		PhoneNumber numG = new PhoneNumber("5555555557");
		PhoneNumber numD = new PhoneNumber("5555555558");
		PhoneNumber numB = new PhoneNumber("5555555559");
		PhoneNumber numF = new PhoneNumber("5555555560");
		PhoneNumber numH = new PhoneNumber("5555555561");
		PhoneNumber numE = new PhoneNumber("5555555562");
		
		p.insert(charlie, numC);
		assertEquals(charlie.toString() + ":" + numC.toString() + "\n", p.toString());
		p.insert(abigal, numA);
		assertEquals(abigal.toString() + ":" + numA.toString() + "\n" + charlie.toString() + ":" + numC.toString() + "\n", p.toString());
		p.insert(gordon, numG);
		assertEquals(abigal.toString() + ":" + numA.toString() + "\n" + charlie.toString() + ":" + numC.toString() + "\n" + gordon.toString() + ":" + numG.toString() + "\n", p.toString());
		p.insert(dana, numD);
		assertEquals(abigal.toString() + ":" + numA.toString() + "\n" + charlie.toString() + ":" + numC.toString() + "\n"+ dana.toString() + ":" + numD.toString() + "\n" + gordon.toString() + ":" + numG.toString() + "\n", p.toString());
		p.insert(bob, numB);
		assertEquals(abigal.toString() + ":" + numA.toString() + "\n"+ bob.toString() + ":" + numB.toString() + "\n" + charlie.toString() + ":" + numC.toString() + "\n"+ dana.toString() + ":" + numD.toString() + "\n" + gordon.toString() + ":" + numG.toString() + "\n", p.toString());
		p.insert(frankie, numF);
		assertEquals(abigal.toString() + ":" + numA.toString() + "\n"+ bob.toString() + ":" + numB.toString() + "\n" + charlie.toString() + ":" + numC.toString() + "\n"+ dana.toString() + ":" + numD.toString() + "\n"+ frankie.toString() + ":" + numF.toString() + "\n" + gordon.toString() + ":" + numG.toString() + "\n", p.toString());
		p.insert(harold, numH);
		assertEquals(abigal.toString() + ":" + numA.toString() + "\n"+ bob.toString() + ":" + numB.toString() + "\n" + charlie.toString() + ":" + numC.toString() + "\n"+ dana.toString() + ":" + numD.toString() + "\n"+ frankie.toString() + ":" + numF.toString() + "\n" + gordon.toString() + ":" + numG.toString() + "\n" + harold.toString() + ":" + numH.toString() + "\n", p.toString());
		p.insert(engelbert, numE);
		assertEquals(abigal.toString() + ":" + numA.toString() + "\n"+ bob.toString() + ":" + numB.toString() + "\n" + charlie.toString() + ":" + numC.toString() + "\n"+ dana.toString() + ":" + numD.toString() + "\n" + engelbert.toString() + ":" + numE.toString() + "\n"+ frankie.toString() + ":" + numF.toString() + "\n" + gordon.toString() + ":" + numG.toString() + "\n" + harold.toString() + ":" + numH.toString() + "\n", p.toString());
		assertEquals(numA, p.search(abigal));
		p.search(abigal);
		assertEquals(abigal.toString() + ":" + numA.toString() + "\n"+ bob.toString() + ":" + numB.toString() + "\n" + charlie.toString() + ":" + numC.toString() + "\n"+ dana.toString() + ":" + numD.toString() + "\n" + engelbert.toString() + ":" + numE.toString() + "\n"+ frankie.toString() + ":" + numF.toString() + "\n" + gordon.toString() + ":" + numG.toString() + "\n" + harold.toString() + ":" + numH.toString() + "\n", p.toString());
		p.delete(frankie);
		assertEquals(abigal.toString() + ":" + numA.toString() + "\n"+ bob.toString() + ":" + numB.toString() + "\n" + charlie.toString() + ":" + numC.toString() + "\n"+ dana.toString() + ":" + numD.toString() + "\n" + engelbert.toString() + ":" + numE.toString() + "\n" + gordon.toString() + ":" + numG.toString() + "\n" + harold.toString() + ":" + numH.toString() + "\n", p.toString());
	}
	
	
}
