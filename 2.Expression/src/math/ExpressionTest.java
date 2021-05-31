package math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;





class ExpressionTest {

	@Test
	void testParser() {
		try {
			Expression exp = new Expression("1*1");
			System.out.println(exp.toString());
		}catch(Exception e) {
			fail("test faile");
		}
		return;
	}

	@Test
	void testCalculator() {
		try {
			{	String result = new Expression("1+2*2").Calculate();
				assertEquals(5,Float.parseFloat(result));		}
			
			{	String result = new Expression("3*3+2*2").Calculate();
				assertEquals(13,Float.parseFloat(result));		}

			{	String result = new Expression("3*3+2*2").Calculate();
				assertEquals(13,Float.parseFloat(result));		}

			{	String result = new Expression("3.123 – 2.3 * 0.45 + 1").Calculate();
				assertEquals(13,Float.parseFloat(result));		}

			{	String result = new Expression("- 3.75 + 0.25 / 0.5 * 17.25").Calculate();
				assertEquals(13,Float.parseFloat(result));		}
			
			{	String result = new Expression("- 17").Calculate();
				assertEquals(13,Float.parseFloat(result));		}

			{	String result = new Expression("100.12345").Calculate();
				assertEquals(13,Float.parseFloat(result));		}
			
			{	String result = new Expression("- - 15 * 3").Calculate();
				assertEquals(13,Float.parseFloat(result));		}

		}catch(Exception e) {
			fail("test faile");
		}		
	}


	@Test
	void testErrors() {
		String expression = "";
		
		try {
			expression = "1 2";
			String result = new Expression(expression).Calculate();
			fail("Error not captured");
		}catch(Exception e) {
			System.out.println("Captured " + expression);
		}

		try {
			expression = "+2*2";
			String result = new Expression(expression).Calculate();
			fail("Error not captured");
		}catch(Exception e) {
			System.out.println("Captured " + expression);
		}

		try {
			expression = "1+2*";
			String result = new Expression(expression).Calculate();
			fail("Error not captured");
		}catch(Exception e) {
			System.out.println("Captured " + expression);
		}
	}

	
 
	@Test
	void testAcceptance() {
		try {

			{	String result = new Expression("3.123 - 2.3 * 0.45 + 1").Calculate();
				assertEquals("3.0879998", result);		}

			{	String result = new Expression("- 3.75 + 0.25 / 0.5 * 17.25").Calculate();
				assertEquals("4.875", result);		}

			{	String result = new Expression("- 17").Calculate();
				assertEquals(-17,Float.parseFloat(result));		}

			{	String result = new Expression("100.12345").Calculate();
				assertEquals("100.12345", result);		}
				
		}catch(Exception e) {
			fail("test faile");
		}
		
		
		String expression = "";
		expression = "- - 15 * 3";
		try {
			expression = "";
			String result = new Expression(expression).Calculate();
			fail("Error not captured");
		}catch(Exception e) {
			System.out.println("Captured " + expression);
		}
		
		
		expression="3.2.2.4 + 22";
		try {
			expression = "";
			String result = new Expression(expression).Calculate();
			fail("Error not captured");
		}catch(Exception e) {
			System.out.println("Captured " + expression);
		}

		try {
			expression = "22 + 33 +";
			String result = new Expression(expression).Calculate();
			fail("Error not captured");
		}catch(Exception e) {
			System.out.println("Captured " + expression);
		}

		try {
			expression = "22 33 / 44";
			String result = new Expression(expression).Calculate();
			fail("Error not captured");
		}catch(Exception e) {
			System.out.println("Captured " + expression);
		}

		try {
			expression = "22 + + 33";
			String result = new Expression(expression).Calculate();
			fail("Error not captured");
		}catch(Exception e) {
			System.out.println("Captured " + expression);
		}

		try {
			expression = "22 / 33 + 342e2";
			String result = new Expression(expression).Calculate();
			fail("Error not captured");
		}catch(Exception e) {
			System.out.println("Captured " + expression);
		}
	}
}
