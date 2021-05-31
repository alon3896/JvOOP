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
 *
 */
public class Expression {
	//private String text;
	private final String REG_EXP = "[\\+|\\-|\\*|\\/|:]";
	
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
	
	private String expression;
	public Expression(String text) throws Exception {
		this.expression = new Parser().getExpression(text.toCharArray());
	}
	
	ArrayList<String> numbers;
	ArrayList<String> operators;
	private void CalcMultDiv()
	{
		ArrayList<String> numbers_new = new ArrayList<String>();
		ArrayList<String> operators_new = new ArrayList<String>();
		
		Iterator<String> num_itr = this.numbers.iterator();
		Iterator<String> oper_itr = this.operators.iterator();
		String num_last = num_itr.next();
		while (num_itr.hasNext()) {
			   String num_curr = num_itr.next();
			   String oper = oper_itr.next();
			   switch(oper) {
			   case "*":
				   num_last = Float.toString(Float.parseFloat(num_last) * Float.parseFloat(num_curr));
				   break;
			   case "/":
				   num_last = Float.toString(Float.parseFloat(num_last) / Float.parseFloat(num_curr));
				   break;
			   default:
				   numbers_new.add(num_last);
				   operators_new.add(oper);
				   num_last = num_curr;
			   }
		}
		numbers_new.add(num_last);
		
		this.numbers = numbers_new;
		this.operators = operators_new;
		return;
	}

	private String CalcSummation() throws Exception
	{
		Iterator<String> num_itr = this.numbers.iterator();
		Iterator<String> oper_itr = this.operators.iterator();
		
		String num_last = num_itr.next();
		while (num_itr.hasNext()) {
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
				   throw new Exception("Illegal operator"); 
			   }
		}

		this.numbers = null;
		this.operators = null;
		
		return(num_last);
	}

	public String Calculate() throws Exception
	{
		String result;
		
		this.numbers = getNumbers(this.expression);	
		this.operators = getOperators(this.expression);
		
		if(this.numbers.get(0).isEmpty()) {
			this.numbers.remove(0);
			if(Parser.isSigne(this.operators.get(0).charAt(0))) {
				this.operators.remove(0);
				String num = this.numbers.get(0);
				this.numbers.set(0, Float.toString(0-Float.parseFloat(num)));
			}
		}
		if(numbers.size() != operators.size()+1) {
			throw new Exception("No match between numbers and operators");
		}
		CalcMultDiv();
		result = CalcSummation();
		
		return(result);
	}
}
