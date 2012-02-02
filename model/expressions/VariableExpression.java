package model.expressions;

import java.util.List;
import java.util.Map;

import model.Parser;
import model.ParserException;
import model.RGBColor;

public class VariableExpression extends Expression {
	private String myVariable;
	
	public VariableExpression(String variable) {
		myVariable = variable;
	}
	
	@Override
	public String toString() {
		return myVariable;
	}
	
	@Override
	public RGBColor evaluate (Map<String,RGBColor> varMap){
	if(varMap.containsKey(myVariable)){
		return varMap.get(myVariable);
	}
	throw new ParserException("Variable not recognized");
	}

}
