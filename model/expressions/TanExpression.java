package model.expressions;

import java.util.Map;

import model.RGBColor;
import model.util.ColorCombinations;

public class TanExpression extends ParenExpression {

	public TanExpression() {
		super("tan");
		setOperandNumber(1);
	}

	@Override
	public RGBColor evaluate(Map<String, RGBColor> varMap) {
		return ColorCombinations.tangent(getOperand(0).evaluate(varMap));
	}

	public static class Factory extends AbstractFactory {

		@Override
		public boolean isThisType(String commandName) {
			return commandName.equals("tan");
		}

		@Override
		public ParenExpression createInstance() {
			return new TanExpression();
		}
	}
}
