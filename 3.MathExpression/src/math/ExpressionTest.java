package math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;





class ExpressionTest {

	
	
	
	/***********************************************************\
	*						Test Methods						*
	\***********************************************************/
	
	/**
	 * Expression calculation test.
	 * @param expression
	 * @param exp_result
	 */
	private void ExpressionCalcTest(String expression, String exp_result)
	{
		try {
			String result = new Expression(expression).Calculate();
			assertEquals(exp_result,result);
			System.out.println(expression + "=" + exp_result);
		}catch(Exception e) {
			fail("test faile" + e.getMessage());
		}
		return;
	}

	/**
	 * Error capture test.
	 * @param expression
	 */
	private void ExpressionErrorTest(String expression)
	{
		try {
			String result = new Expression(expression).Calculate();
			fail("Error not captured! ("+result+")");
		}catch(Exception e) {
			System.out.println("Error captured " + expression);
		}
		return;
	}

	
	

	
	/***********************************************************\
	*					Development Tests						*
	\***********************************************************/
	/**
	 * Test the text parser.
	 */
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


	/**
	 * Test the expression calculator.
	 */
	@Test
	void testCalculator() {
		ExpressionCalcTest("3.123 - 2.3 * 0.45 + 1","3.0879998");
		ExpressionCalcTest("+2*2", "4.0");
		ExpressionCalcTest("3.123 - 2.3 * 0.45 + 1","3.0879998");

		ExpressionCalcTest("1+2*2", "5.0");
		ExpressionCalcTest("3*3+2*2", "13.0");
		ExpressionCalcTest("- 3.75 + 0.25 / 0.5 * 17.25", "4.875");
		ExpressionCalcTest("- 17", "-17.0");
		ExpressionCalcTest("100.12345", "100.12345");
	}
	
	/**
	 * Test expression error capture.
	 */
	@Test
	void testErrors() {

		ExpressionErrorTest("- - 15 * 3");
		ExpressionErrorTest("1 2");
		ExpressionErrorTest("1+2*");
	}

	
	
	
	
	/***********************************************************\
	*					Acceptance Tests						*
	\***********************************************************/
	@Test
	void testAcceptance() {
		ExpressionCalcTest("3.123 - 2.3 * 0.45 + 1", "3.0879998");
		ExpressionCalcTest("- 3.75 + 0.25 / 0.5 * 17.25", "4.875");
		ExpressionCalcTest("- 17", "-17.0");
		ExpressionCalcTest("100.12345", "100.12345");
		
		ExpressionErrorTest("- - 15 * 3");
		ExpressionErrorTest("3.2.2.4 + 22");
		ExpressionErrorTest("22 + 33 +");
		ExpressionErrorTest("22 33 / 44");
		ExpressionErrorTest("22 + + 33");
		ExpressionErrorTest("22 / 33 + 342e2");
	}
}
