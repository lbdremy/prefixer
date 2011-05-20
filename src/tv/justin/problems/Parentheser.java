package tv.justin.problems;

public class Parentheser {
	
	private String expressionParenthese;
	private int index = 0;
	private StringBuffer expression;
	public Parentheser(String expression){
		this.expression = new StringBuffer(expression);
	}
	private String putParentheses(){
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
					}else{
						newExpression.append(token);
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
				}else{
					newExpression.append(" ").append(token);
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

	public String getExpressionParenthese() {
		expressionParenthese = putParentheses();
		return expressionParenthese;
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
