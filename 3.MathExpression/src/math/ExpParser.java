package math;




/**
 * 
 * Mathematical expression parsing methods. 
 *
 */
public class ExpParser {
	/***********************************************************\
	*					Exception strings						*
	\***********************************************************/
	public final static String EXP_ILLEGAL_DIGIT = "Illigal after digt";
	public final static String EXP_ILLEGAL_CHAR = "illigal character after operator";
	public final static String EXP_CHAR_ERROR = "Character error";
	public final static String EXP_UNKNOW_CHAR = "Unknown character";
	
	
	
	
	
	/***********************************************************\
	*						Operators members					*
	\***********************************************************/
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
	
	
	
	
	
	/***********************************************************\
	*					Expression string						*
	\***********************************************************/
	public enum CHAR_TYPE {
	    DIGIT, OPER, SPACE, UNKNOWN
	}

	/**
	 * Get expression character type.
	 * @param chr - expression character.
	 * @return character type.
	 */
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
	
	
	/**
	 * Get the expression without spaces after checking correctness. 
	 * @param expression - mathematical expression.
	 * @return expression string.
	 * @throws Exception
	 */
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
						throw new Exception(EXP_ILLEGAL_DIGIT);
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
						throw new Exception(EXP_ILLEGAL_CHAR);
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
							throw new Exception(EXP_CHAR_ERROR);
						}
					}
					else if(!isSpace(chr)){
						throw new Exception(EXP_CHAR_ERROR);
					}
				}	break;
				
				default:{
					throw new Exception(EXP_UNKNOW_CHAR);
				}
			}
		}
		return(expr_str);
	}
}
