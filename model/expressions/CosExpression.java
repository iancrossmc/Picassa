package model.expressions;

import java.util.Map;

import model.RGBColor;
import model.util.ColorCombinations;

public class CosExpression extends ParenExpression {

	public CosExpression() {
		super("cos");
		setOperandNumber(1);
	}

	@Override
	public RGBColor evaluate(Map<String, RGBColor> varMap) {
		return ColorCombinations.cos(getOperand(0).evaluate(varMap));
	}

	public static class Factory extends AbstractFactory {

		@Override
		public boolean isThisType(String commandName) {
			return commandName.equals("cos");
		}

		@Override
		public ParenExpression createInstance() {
			return new CosExpression();
		}
	}
}
