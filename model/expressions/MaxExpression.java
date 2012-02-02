package model.expressions;

import java.util.Map;

import model.RGBColor;
import model.util.ColorCombinations;

public class MaxExpression extends ParenExpression {

	public MaxExpression() {
		super("max");
		setOperandNumber(-1);
	}

	@Override
	public RGBColor evaluate(Map<String, RGBColor> varMap) {
		RGBColor maxColor = new RGBColor();
		for (int i = 0; i < getOperandList().size(); i++) {
			maxColor = ColorCombinations.maximum(maxColor, getOperand(i)
					.evaluate(varMap));
		}
		return maxColor;
	}

	public static class Factory extends ParenExpression.AbstractFactory{
		
		@Override
		public boolean isThisType(String commandName) {
			return commandName.equals("max");
		}

		@Override
		public ParenExpression createInstance() {
			return new MaxExpression();
		}
	}
}
