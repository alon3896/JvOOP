package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.Assert;





/**
 * 
 * Mathematical expression.
 * Calculate simple mathematical expression including +,-,/,*
 * Without parenthesis.  
 *
 */
public class Expression {
	/***********************************************************\
	*					Exception strings						*
	\***********************************************************/
	public static final String EXP_ILLEGAL_OPR = "Illegal operator";
	public static final String EXP_ILLEGAL_EXPRESSION = "Illegal expression";
	public static final String EXP_UNMATCHED_NUM_OPERATORS = "No match between numbers and operators";
	
	
	
	
	
	/***********************************************************\
	*						Private members						*
	\***********************************************************/
	// Regular expression Operators search string;
	private final String REG_EXP = "[\\+|\\-|\\*|\\/|:]";
	/**
	 * Get the numbers of a mathematical expression
	 * @param expression - mathematical expression
	 * @return array of strings containing the expression numbers.
	 */
	private ArrayList<String> getNumbers(String expression){
		ArrayList<String> numbers = new ArrayList<String>(Arrays.asList(expression.split(REG_EXP)));
		return(numbers);
	}
		
	/**
	 * Get the mathematical expression operators list.  
	 * @param expression
	 * @return list of operators.
	 */
	private ArrayList<String> getOperators(String expression) {
		//	Operators find matcher.
		Pattern pattern = Pattern.compile(REG_EXP);
        Matcher matcher = pattern.matcher(expression);
        
        //	Operators list creator.
        ArrayList<String> listMatches = new ArrayList<String>();
        while(matcher.find()) {
            listMatches.add(matcher.group());
        }
        return(listMatches);
	}
	
	
	
	
	
	/***********************************************************\
	*						Constructor							*
	\***********************************************************/
	/**
	 * Constructor.
	 * @param expression text.
	 */
	// Expression after removal of spaces.
	private String expression;
	public Expression(String text) throws Exception {
		this.expression = new ExpParser().getExpression(text.toCharArray());
	}
	
	
	
	
	/***********************************************************\
	*					Expression calculation					*
	\***********************************************************/
	/**
	 * Calculate multiplication and division operators.
	 */
	ArrayList<String> numbers;		//	list of numbers extracted from the expression.
	ArrayList<String> operators;	//	list of operators extracted from the expression.
	private void CalcMultDiv()
	{
		//New lists of numbers and operators after multiplication.
		ArrayList<String> numbers_new = new ArrayList<String>();
		ArrayList<String> operators_new = new ArrayList<String>();
		
		//	Iterate threw the lists.
		Iterator<String> num_itr = this.numbers.iterator();
		Iterator<String> oper_itr = this.operators.iterator();
		
		//	Keep last number.
		String num_last = num_itr.next();
		while (num_itr.hasNext()) {
			// Current number and operator.
			String num_curr = num_itr.next();
			String oper = oper_itr.next();
			switch(oper) {
				case "*":
					num_last = Float.toString(Float.parseFloat(num_last) * Float.parseFloat(num_curr));
					break;
				case "/":
					num_last = Float.toString(Float.parseFloat(num_last) / Float.parseFloat(num_curr));
					break;
					
				//	Not an operator to calculate - add calculated result and operator.
				default:
					numbers_new.add(num_last);
					operators_new.add(oper);
					num_last = num_curr;
			}
		}
		//Add last result.
		numbers_new.add(num_last);
		
		//	Update the numbers and operators list.
		this.numbers = numbers_new;
		this.operators = operators_new;
		return;
	}

	/**
	 * Calculate summation of all addition and subtraction operators.
	 * This member is called after multiplication is done.
	 * @throws Exception
	 * @return string containing the summation result. 
	 */
	private String CalcSummation() throws Exception
	{
		//	Iterate threw list of numbers and operators.
		Iterator<String> num_itr = this.numbers.iterator();
		Iterator<String> oper_itr = this.operators.iterator();
		
		//	Keep last number.
		String num_last = num_itr.next();
		while (num_itr.hasNext()) {
			// Current number and operator.
			String num_curr = num_itr.next();
			String oper = oper_itr.next();
			switch(oper) {
				case "+":
					num_last = Float.toString(Float.parseFloat(num_last) + Float.parseFloat(num_curr));
					break;
				case "-":
					num_last = Float.toString(Float.parseFloat(num_last) - Float.parseFloat(num_curr));
					break;
				default:
					throw new Exception(EXP_ILLEGAL_OPR); 
			}
		}

		//	Update the numbers and operators list.
		this.numbers = null;
		this.operators = null;
		
		//	Return summation result.
		return(num_last);
	}

	
	/**
	 * Calculate the expression result.
	 * @return
	 * @throws Exception
	 */
	public String Calculate() throws Exception
	{
		String result;
		
		//	Get numbers and operators list.
		this.numbers = getNumbers(this.expression);	
		this.operators = getOperators(this.expression);
		
		//	In case expression starts with an operator first number is empty string.
		if(this.numbers.get(0).isEmpty()) {
			//this.numbers.remove(0);
			//	Check it is a '+/-' sign
			if(ExpParser.isSigne(this.operators.get(0).charAt(0))) {
				//this.operators.remove(0);
				//String num = this.numbers.get(0);
				//this.numbers.set(0, Float.toString(0-Float.parseFloat(num)));
				this.numbers.set(0, Float.toString(0));
			}else {
				throw new Exception(EXP_ILLEGAL_EXPRESSION);
			}
		}
		if(numbers.size() != operators.size()+1) {
			throw new Exception(EXP_UNMATCHED_NUM_OPERATORS);
		}
		CalcMultDiv();
		result = CalcSummation();
		
		return(result);
	}
}
