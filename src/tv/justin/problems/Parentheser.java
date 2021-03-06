package tv.justin.problems;

public class Parentheser {
	
	private int index = 0;
	private StringBuffer expression;
	
	private static Parentheser singleton= null;
	
	private Parentheser(){}
	
	public static Parentheser getInstance(){
		if(singleton == null){
			singleton = new Parentheser();
		}
		return singleton;
	}
	
	public String putParentheses(String expression){
			this.expression = new StringBuffer(expression);
			int lenght = expression.length();
			char token ;
			int numberOperant = 0;
			StringBuffer newExpression = new StringBuffer();
			while(index < lenght){
					token = expression.charAt(index);
					if(isOperator(token)){
						newExpression.append("(").append(token); 
						index++;
						newExpression.append(nestedParentheses());
						numberOperant++;
					}else if(!isSpace(token)){
						while(index < lenght && !isSpace(token) && !isOperator(token)){
							newExpression.append(token);
							index++;
							if(index < lenght){
								token = expression.charAt(index);
							}
						}
						numberOperant++;
					}
					
					if(numberOperant == 2){
							newExpression.append(")");
							numberOperant=1;
					}
					index++;
			}
			return newExpression.toString();
	}
		
	private StringBuffer nestedParentheses(){
		int lenght = expression.length();
		char token ;
		int numberOperant = 0;
		StringBuffer newExpression = new StringBuffer();
		while(index < lenght){
				token = expression.charAt(index);
				if(isOperator(token)){
					newExpression.append("(").append(token); 
					index++;
					newExpression.append(nestedParentheses());
					numberOperant++;
				}else if(!isSpace(token)){
					newExpression.append(" ");
					while(index < lenght && !isSpace(token) && !isOperator(token)){
						newExpression.append(token);
						index++;
						if(index < lenght){
							token = expression.charAt(index);
						}
					}
					numberOperant++;
				}
				
				if(numberOperant == 2){
						newExpression.append(")");
						return newExpression;
				}
				index++;
		}
		return newExpression;
	}

	
	private static boolean isSpace(char operator){
		if(operator == ' '){
			return true;
		}
		return false;
	}
	
	private static boolean isOperator(char operator){
		if(isOperatorStrong(operator)||isOperatorWeak(operator)){
			return true;
		}
		return false;
	}
	
	private static boolean isOperatorStrong(char operator){
		if(operator == '*' || operator == '/' ){
			return true;
		}
		return false;
	}
	
	private static boolean isOperatorWeak(char operator){
		if(operator == '+' || operator == '-' ){
			return true;
		}
		return false;
	}
	
}
