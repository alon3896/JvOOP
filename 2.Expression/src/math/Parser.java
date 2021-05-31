package math;

//import math.Expression.CHAR_TYPE;

public class Parser {
	
	public enum CHAR_TYPE {
	    DIGIT, OPER, SPACE, UNKNOWN
	}
	
	private static final char[] OPERATORS = {'+','-','*','/'};
	
	public static boolean isSigne(char chr) {
		return ((chr == '-') || (chr == '+'));
	}
	
	public static boolean isNum(char chr) {
		return (((chr >= '0') && (chr <= '9')) || ('.'==chr));
	}
	
	public static boolean isSpace(char chr) {
		return(' ' == chr);
	}
	
	public static boolean isOperator(char chr) {
		boolean is_operator = false;
		
		for(char opr:OPERATORS) {
			if(opr==chr) {
				is_operator = true;
				break;
			}
		}
		return(is_operator);
	}
	
	
	private static CHAR_TYPE getType(char chr)	{
		CHAR_TYPE chr_type = CHAR_TYPE.UNKNOWN;
		if(isNum(chr)) {
			chr_type = CHAR_TYPE.DIGIT;
		}else if(isSpace(chr)) {
			chr_type = CHAR_TYPE.SPACE;
		}
		else if(isOperator(chr)) {
			chr_type = CHAR_TYPE.OPER;
		}
		return(chr_type);
	}
	
	
	//private CHAR_TYPE curr_type = CHAR_TYPE.UNKNOWN;
	public String getExpression(char[] expression) throws Exception {
		String expr_str = "";
		CHAR_TYPE last_type = CHAR_TYPE.UNKNOWN;
		CHAR_TYPE next_type = CHAR_TYPE.UNKNOWN;
		for(char chr:expression)
		{
			switch(last_type)
			{
				case UNKNOWN:		
				case DIGIT:{
					if(isNum(chr)) {
						expr_str += chr;
						last_type = getType(chr);
						next_type = CHAR_TYPE.OPER;
					} else if (isOperator(chr)){
						expr_str += chr;
						last_type = getType(chr);
						next_type = CHAR_TYPE.DIGIT;						
					} else if(isSpace(chr)) {
						last_type = getType(chr);
					} else {
						throw new Exception("Illigal after digt");
					}
				}	break;
				
				case OPER:{
					if(isNum(chr)) {
						expr_str += chr;
						last_type = getType(chr);
						next_type = CHAR_TYPE.DIGIT;
					} else if(isSpace(chr)) {
						next_type = CHAR_TYPE.DIGIT;
					} else {
						throw new Exception("illigal character after operator");
					}
				}	break;
					
				case SPACE:{
					last_type = getType(chr);
					if(last_type == next_type) {
						expr_str += chr;
						if(CHAR_TYPE.DIGIT == next_type) {
							next_type = CHAR_TYPE.OPER; 
						} else if(CHAR_TYPE.OPER == next_type) {
							next_type = CHAR_TYPE.DIGIT; 
						} else {
							throw new Exception("Character error");
						}
					}
					else if(!isSpace(chr)){
						throw new Exception("Character error");
					}
				}	break;
				
				default:{
					throw new Exception("Unknown character");
				}
			}
		}
		return(expr_str);
	}
}
