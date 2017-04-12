package java8.ex01;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

/**
 * Exemple Test
 */
public class Exemple_Test {
	
	@Test
	public void testQuiEchoue() {
		fail();
	}
	
	@Test
	public void testAdditionner() {
		Addition addition = new Addition();
		
		int result = addition.additionner(10, 20);
		
		Assert.assertTrue(result == 30);
	}

  
}
