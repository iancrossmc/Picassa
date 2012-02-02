package model.expressions;

import java.util.List;
import java.util.Map;

import model.RGBColor;


public class NumExpression extends Expression {
	private RGBColor myValue;
	
	private NumExpression(){}
	
	public NumExpression(double value) {
		myValue = new RGBColor(value);
	}
	
	@Override
	public RGBColor evaluate (Map<String, RGBColor> varMap) {
		return myValue;
	}
	
	@Override
	public String toString() {
		return ""+myValue;
	}

}
