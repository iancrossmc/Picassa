package model.expressions;

import java.util.Map;

import model.RGBColor;
import model.util.ColorCombinations;

public class ATanExpression extends ParenExpression {

	public ATanExpression() {
		super("atan");
		setOperandNumber(1);
	}

	@Override
	public RGBColor evaluate(Map<String, RGBColor> varMap) {
		return ColorCombinations.arcTangent(getOperand(0).evaluate(varMap));
	}

	public static class Factory extends AbstractFactory {

		@Override
		public boolean isThisType(String commandName) {
			return commandName.equals("atan");
		}

		@Override
		public ParenExpression createInstance() {
			return new ATanExpression();
		}
	}
}
