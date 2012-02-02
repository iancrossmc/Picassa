package model.expressions;

import java.util.Map;

import model.RGBColor;

public class IfExpression extends ParenExpression {

	public IfExpression() {
		super("if");
		setOperandNumber(3);
	}

	@Override
	public RGBColor evaluate(Map<String, RGBColor> varMap) {
		RGBColor condition = getOperand(0).evaluate(varMap);
		double conditionValue = condition.getRed()+condition.getGreen()+condition.getBlue();
		if (conditionValue>0)
			return getOperand(1).evaluate(varMap);
		return getOperand(2).evaluate(varMap);
	}
	
	public static class Factory extends ParenExpression.AbstractFactory{
		
		@Override
		public boolean isThisType(String commandName) {
			return commandName.equals("if");
		}

		@Override
		public ParenExpression createInstance() {
			return new IfExpression();
		}
	}

}
